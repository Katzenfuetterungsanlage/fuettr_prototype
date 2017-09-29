import * as mongoose from 'mongoose';

import { Document } from './document';
import { Journal } from './journal';


export abstract class MongooseDocument<T, D extends mongoose.Document> extends Document<T> {

  protected _document: D;

  constructor (document: D, journal?: Journal) {
    super(journal);
    this._document = document;
  }

  public get id (): string {
    return this._document._id;
  }

  public isModified (): boolean {
    return this._document.isModified();
  }

  public save (): Promise<boolean> {
    if (!this._document.isModified()) {
      return Promise.resolve(false);
    } else {
      let savedAt = (<any>this._document).savedAt;
      if (!savedAt) {
        savedAt = Date.now();
      }
      this.journalSave(savedAt);
      return new Promise( (resolve, reject) => {
        this._document.save().then( result => {
          this.journalDone(savedAt);
          resolve(true);
        }).catch( err => {
          this.journalErr(err, savedAt);
          reject(err);
        });
      });
    }
  }

  protected setStringAttribute (name: string, value: string) {
    const oldValue = this._document.get(name);
    if (oldValue !== value) {
      this._document.set(name, value);
      this.journalSet(name, oldValue, value);
    }
  }


}
