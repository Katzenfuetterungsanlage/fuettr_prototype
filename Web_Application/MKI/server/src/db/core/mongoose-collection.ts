import * as mongodb from 'mongodb';
import * as mongoose from 'mongoose';

import * as debugsx from 'debug-sx';

import { Dbms } from './dbms';
import { MongooseDbms } from './mongoose-dbms';
import { MongooseDatabase } from './mongoose-database';
import { Document } from './document';
import { Collection } from './collection';
import { MongooseDocument } from './mongoose-document';


export abstract class MongooseCollection<T, D extends Document<T>, MD extends mongoose.Document> extends Collection<T, D> {
  protected _model: mongoose.Model<MD>;
  protected _schema: mongoose.Schema;

  constructor(name: string, schema: mongoose.Schema, db?: MongooseDatabase) {
    super(name);
    schema.pre('init', this.preInit);
    schema.pre('save', this.preSave);
    schema.pre('validate', this.preValidate);
    schema.pre('remove', this.preRemove);
    schema.post('init', this.postInit);
    schema.post('save', this.postSave);
    schema.post('validate', this.postValidate);
    schema.post('remove', this.postRemove);
    this._schema = schema;
    // this._model = mongoose.model<D>(name, schema);
    if (!db) {
      db = MongooseDbms.Instance.getDatabase();
      if (!db) {
        throw new Error('No database connected');
      }
    }
    this._model = db.model<MD>(name, schema);
  }

  public findAll(): Promise<D []> {
    return this.find({});
  }

  public find (conditions: Object): Promise<D []> {
    return new Promise( (resolve, reject) => {
      this._model.find(conditions).then(documents => {
        const rv: D [] = [];
        for (const d of documents) {
          rv.push(this.createDocument(d));
        }
        resolve(rv);
      }).catch( err => reject(err) );
    });
  }


  public create (item: T, journalMessage?: string): Promise<D> {
    return new Promise<D>( (resolve, reject) => {
      const startedAt = Date.now();
      this.journalCreate(journalMessage, startedAt);
      this._model.create(item).then( (d) => {
        const document = this.createDocument(d);
        this.journalDone(document, startedAt, true);
        resolve(document);
      }).catch( err => {
        this.journalCreateErr(journalMessage, err, startedAt);
        reject(err);
      });
    });
  }


  public delete(item: D): Promise<boolean> {
    return new Promise<boolean>( (resolve, reject) => {
      const startedAt = Date.now();
      this.journalDelete(item, startedAt);
      this._model.remove({ _id: item.id}).then( res => {
        const result: mongodb.DeleteWriteOpResultObject = <any>res;
        if (!result || !result.result) {
          reject('invalid response from mongodb');
        } else if (result.result.ok && result.result.n === 1) {
           this.journalDone(item, startedAt, true);
           resolve(true);
         } else {
          throw new Error('mongodb cannot delete document:' +
                          ' ok=' + result.result.ok + ', n=' + result.result.n);
         }
      }).catch( err => {
        this.journalErr(item, err, startedAt);
        reject(err);
      });
    });
  }

  public clearCache (): void {
    throw new Error('no cache implemented');
  }

  public refreshCache (): Promise<{[ id: string]: D}> {
    return Promise.reject(new Error('no cache refresh implemented'));
  }

  public getCachedDocuments (): { [ id: string]: D } {
    throw new Error('no cache implemented');
  }

  protected abstract createDocument (document: mongoose.Document): D;


  protected preInit ( next: (err?: mongoose.NativeError) => void) { next(); }
  protected preValidate ( next: (err?: mongoose.NativeError) => void) { next(); }
  protected preSave ( next: (err?: mongoose.NativeError) => void) { next(); }
  protected preRemove ( next: (err?: mongoose.NativeError) => void) { next(); }
  protected postInit (doc: mongoose.Document): void {}
  protected postSave (doc: mongoose.Document): void {}
  protected postValidate (doc: mongoose.Document): void {}
  protected postRemove (doc: mongoose.Document): void {}



  private toObjectId(_id: string): mongoose.Types.ObjectId {
    return mongoose.Types.ObjectId.createFromHexString(_id);
  }
}
