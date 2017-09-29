import * as mongoose from 'mongoose';

import { Database } from './database';

export class MongooseDatabase extends Database {

  private _name: string;
  private _conn: mongoose.Connection;

  public constructor () {
    super();
  }

  public get connection (): mongoose.Connection {
    return this._conn;
  }

  public connect (name: string, user?: string, password?: string): Promise<Database> {
    if (name.indexOf('/') < 0) {
      name = 'mongodb://localhost/' + name;
    } else if (!name.startsWith('mongodb://')) {
      name = 'mongodb://' + name;
    }

    return new Promise<Database>( (resolve, reject) => {
      const promise: Promise<mongoose.Connection> = <any>mongoose.createConnection(name, <any>{ useMongoClient: true}) ;
      promise.then( (conn) => {
        this._name = name;
        this._conn = conn;
        resolve(this);
      }).catch( err => { reject(err); });
    });
  }

  public close (): Promise<boolean> {
    if (!this.isConnected()) {
      return Promise.resolve(false);
    }
    const connection = this._conn;
    this._conn = undefined;
    return new Promise<boolean>( (resolve, reject) => {
      connection.close().then( result => {
        resolve(true);
      }).catch(err => reject(err) );
    });
  }

  public isConnected (): boolean {
    return this._conn && this._conn.readyState === 1;
  }

  public getCollectionNames (): Promise<string []> {
    if (!this.isConnected()) {
      throw new Error('Not connected');
    }
    return new Promise<string []>( (resolve, reject) => {
      this._conn.db.collections().then( result => {
        const rv: string [] = [];
        if (Array.isArray(result)) {
          for (const r of result) {
            rv.push(r.collectionName);
          }
        }
        resolve(rv) ;
      }).catch( err => reject(err) );
    });
  }

  public name (): string {
    if (!this.isConnected()) {
      throw new Error('Not connected');
    }
    return this._conn.db.databaseName;
  }


  public model<T extends mongoose.Document> (name: string, schema?: mongoose.Schema, collection?: string): mongoose.Model<T>;
  public model<T extends mongoose.Document, U extends mongoose.Model<T>> (name: string, schema?: mongoose.Schema, collection?: string): U {
    return this._conn.model.apply(this._conn, arguments);
  }
}
