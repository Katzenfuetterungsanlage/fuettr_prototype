import * as mongoose from 'mongoose';
import * as nconf from 'nconf';

import * as debugsx from 'debug-sx';
const debug: debugsx.ISimpleLogger = debugsx.createSimpleLogger('db:database');

export abstract class Database {

  public abstract close (): Promise<boolean>;
  public abstract isConnected (): boolean;
  public abstract getCollectionNames (): Promise<string []>;
  public abstract name (): string;

}
