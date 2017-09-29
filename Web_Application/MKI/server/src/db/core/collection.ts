
import * as debugsx from 'debug-sx';
import { Database } from './database';
import { Document } from './document';
import { Journal } from './journal';


export abstract class Collection<T, D extends Document<T>> {
  protected _journal: Journal;

  constructor(name: string) {
    this._journal = new Journal(name);
  }

  public abstract create(item: T): Promise<D>;
  public abstract delete(item: D): Promise<boolean>;
  public abstract findAll (): Promise<D[]>;
  public abstract find (conditions: Object): Promise<D []>;

  public abstract clearCache (): void;
  public abstract getCachedDocuments (): { [ key: string]: D };


  protected journalCreate (message: string, startedAt?: number) {
    if (this._journal && this._journal.create.enabled) {
      if (startedAt) {
        this._journal.delete('%s: startedAt=%s', message, startedAt);
      } else {
        this._journal.create(message);
      }
    }
  }

  protected journalDelete (document: D, startedAt?: number, printToObject?: boolean) {
    if (this._journal && this._journal.set.enabled) {
      if (startedAt && printToObject) {
        this._journal.delete('%s: startedAt=%s\n%o', this.defaultJournalPrefix(document), startedAt, document.toObject());
      } else if (startedAt) {
        this._journal.delete('%s: startedAt=%s', this.defaultJournalPrefix(document), startedAt);
      } else {
        this._journal.delete('%s', this.defaultJournalPrefix(document));
      }
    }
  }

  protected journalDone (document: D, startedAt?: number, printToObject?: boolean) {
    if (this._journal && this._journal.done.enabled) {
      if (startedAt && printToObject) {
        this._journal.done('%s: startedAt=%s\n%o', this.defaultJournalPrefix(document), startedAt, document.toObject());
      } else if (startedAt) {
        this._journal.done('%s: startedAt=%s', this.defaultJournalPrefix(document), startedAt);
      } else {
        this._journal.done('%s', this.defaultJournalPrefix(document));
      }
    }
  }

  protected journalErr (document: D, err: any, startedAt?: number) {
    if (this._journal && this._journal.err.enabled) {
      if (startedAt) {
        this._journal.err('%s: startedAt=%s\n%e', this.defaultJournalPrefix(document), startedAt, err);
      } else {
        this._journal.err('%s\n%e', this.defaultJournalPrefix(document), err);
      }
    }
  }

  protected journalCreateErr (message: string, err: any, startedAt?: number) {
    if (this._journal && this._journal.err.enabled) {
      if (message && startedAt) {
        this._journal.err('%s: startedAt=%s\n%e', message, startedAt, err);
      } else if (startedAt) {
        this._journal.err('startedAt=%s\n%e', startedAt, err);
      } else if (message) {
        this._journal.err('%s\n%e', message, err);
      } else {
        this._journal.err('%e', err);
      }
    }
  }

  protected defaultJournalPrefix (document: D): string {
    return 'id=' + document.id;
  }

}
