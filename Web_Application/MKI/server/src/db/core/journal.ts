import * as debug from 'debug';
import * as debugsx from 'debug-sx';


export class Journal {

  private _name: string;
  private _save:   debug.IDebugger;
  private _delete: debug.IDebugger;
  private _err:    debug.IDebugger;
  private _done:   debug.IDebugger;
  private _create: debug.IDebugger;
  private _set:    debug.IDebugger;

  constructor(name: string) {
    this._name = name;
    this._create = debugsx('journal:' + name + 's::NEW');
    this._set    = debugsx('journal:' + name + 's::SET');
    this._save   = debugsx('journal:' + name + 's::SAVE');
    this._done   = debugsx('journal:' + name + 's::DONE');
    this._err    = debugsx('journal:' + name + 's::ERR');
    this._delete = debugsx('journal:' + name + 's::DEL');
  }

  public get save (): debug.IDebugger {
    return this._save;
  }

  public get delete (): debug.IDebugger {
    return this._delete;
  }

  public get err (): debug.IDebugger {
    return this._err;
  }

  public get done (): debug.IDebugger {
    return this._done;
  }

  public get create (): debug.IDebugger {
    return this._create;
  }

  public get set (): debug.IDebugger {
    return this._set;
  }

}
