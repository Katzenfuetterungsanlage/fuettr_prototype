import { Journal } from './journal';

export abstract class Document<T> {

  protected _journal: Journal;

  constructor (journal: Journal) {
    this._journal = journal;
  }

  public abstract get id (): string;
  public abstract toObject(): T;
  public abstract save (): Promise<boolean>;
  public abstract isModified (): boolean;

  protected journalSet (attributeName: string, oldValue: any, newValue: any) {
    if (this._journal && this._journal.set.enabled) {
      if (typeof(oldValue) === 'object' || typeof(newValue) === 'object') {
        this._journal.set('%s, %s: %o -> %o', this.defaultJournalPrefix(), attributeName, oldValue, newValue);
      } else {
        this._journal.set('%s, %s: %s -> %s', this.defaultJournalPrefix(), attributeName, oldValue, newValue);
      }
    }
  }

  protected journalSave (startedAt?: number) {
    if (this._journal && this._journal.save.enabled) {
      if (startedAt) {
        this._journal.save('%s: startedAt=%s', this.defaultJournalPrefix(), startedAt);
      } else {
        this._journal.save('%s', this.defaultJournalPrefix());
      }
    }
  }

  protected journalDone (startedAt?: number, prefix?: string) {
    if (this._journal && this._journal.done.enabled) {
      if (startedAt) {
        this._journal.done('%s: startedAt=%s', this.defaultJournalPrefix(), startedAt);
      } else {
        this._journal.done('%s', this.defaultJournalPrefix());
      }
    }
  }

  protected journalErr (err: any, savedAt?: number, prefix?: string) {
    if (this._journal && this._journal.err.enabled) {
      if (savedAt) {
        this._journal.err('%s: savedAt=%s\n%e', this.defaultJournalPrefix(), savedAt, err);
      } else {
        this._journal.err('%s\n%e', this.defaultJournalPrefix(), err);
      }
    }
  }

  protected defaultJournalPrefix (): string {
    return 'id=' + this.id;
  }


}
