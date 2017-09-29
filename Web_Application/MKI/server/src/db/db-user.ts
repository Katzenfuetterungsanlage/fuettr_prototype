import * as mongoose from 'mongoose';

import { Database } from './core/database';
import { Collection } from './core/collection';
import { MongooseDatabase } from './core/mongoose-database';
import { MongooseCollection } from './core/mongoose-collection';
import { User } from './document/user';
import { IUser, IUserDocument, userSchema } from './schema/user-schema';
import * as password from '../password';


export class DbUser extends MongooseCollection<IUser, User, IUserDocument > {

  public static createInstance (db: Database): DbUser {
    if (this._instance) {
      throw new Error('instance already created');
    }
    if (db instanceof MongooseDatabase) {
      this._instance = new this(db);
      return this._instance;
    } else {
      throw new Error('db not a MongooseDatabase');
    }
  }

  public static get Instance() {
    if (!this._instance) {
      this._instance = new this();
      Object.seal(this._instance);
      Object.seal(this._instance.constructor);
    }
    return this._instance;
  }

  public static createUser (user: IUser): Promise<User> {
    return this._instance.create(user);
  }

  public static deleteUser (user: User): Promise<boolean> {
    return this._instance.delete(user);
  }

  private static _instance: DbUser;

  // **************************************************************************

  private _cache: { [ htlid: string ]: User };

  private constructor (db?: MongooseDatabase) {
    super('user', userSchema, db);
    this._cache = {};
  }


  public create (item: IUser): Promise<User> {
    if (item.password && !password.isHashed(item.password)) {
      item.password = password.generate(item.password);
    }
    return super.create(item, 'htlid=' + item.htlid);
  }

  public delete (item: User): Promise<boolean> {
    const user = this._cache[item.htlid];
    if (user) {
      delete this._cache[item.htlid];
    }
    return super.delete(user);
  }

  public findUserByHtlId(htlid: string): Promise<User> {
    return new Promise( (resolve, reject) => {
      this._model.find({ htlid: htlid }).then(documents => {
        if (!Array.isArray(documents) || documents.length === 0) {
          resolve(undefined);
        } else if (documents.length > 1) {
          reject(new Error('More than one document for unique htlid ' + htlid));
        } else {
          const u = new User(<IUserDocument>documents[0]);
          this._cache[u.htlid] = u;
          return u;
        }
      }).catch(err => reject(err) )
    });
  }


  public getCachedUser (htlid: string) {
    return this._cache[htlid];
  }

  public clearCache (): void {
    this._cache = {};
  }


  public getCachedDocuments (): { [ htlid: string]: User } {
    return this._cache;
  }

  public login (htlid: string, socket: string): Promise<User> {
    const cachedUser = this._cache[htlid];
    return new Promise<User>( (resolve, reject) => {
      const promise: Promise<User>  = cachedUser ? Promise.resolve(cachedUser) : this.findUserByHtlId(htlid);
      promise.then( user => {
        user.login = { at: Date.now(), socket: socket };
        user.logout = undefined;
        user.save().then ( saved => {
          resolve(user);
        }).catch( err => reject(err) );
      });
    });
  }

  public logout (htlid: string, socket: string): Promise<User> {
    const cachedUser = this._cache[htlid];
    return new Promise<User>( (resolve, reject) => {
      const promise: Promise<User>  = cachedUser ? Promise.resolve(cachedUser) : this.findUserByHtlId(htlid);
      promise.then( user => {
        user.logout = { at: Date.now(), socket: socket };
        user.login = undefined;
        user.save().then ( saved => {
          resolve(user);
        }).catch( err => reject(err) );
      });
    });
  }

  public findByHtlid (htlid: string): Promise<User> {
    return new Promise<User>( (resolve, reject) => {
      super.find({ htlid: htlid}).then( users => {
        if (!Array.isArray(users) || users.length < 1) {
          resolve(undefined);
        } else if (users.length > 1) {
          reject(new Error('More than one user found with htlid ' + htlid));
        } else {
          resolve(users[0]);
        }
      }).catch( err => reject(err));
    });
  }


  protected createDocument (document: IUserDocument): User {
    const user = new User(document, this._journal);
    this._cache[user.htlid] = user;
    return user;
  }

  protected defaultJournalPrefix (document: User): string {
    return 'htlid=' + document.htlid;
  }

  protected preSave ( next: (err?: mongoose.NativeError) => void) {
    if ((<any>this)._doc) {
      const doc = <IUserDocument>(<any>this)._doc;
      if (!doc.createdAt) {
        doc.createdAt = Date.now();
      }
    }
    next();
  }

}
