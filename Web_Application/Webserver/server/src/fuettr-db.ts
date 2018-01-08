import { log } from './main';
import * as mongodb from 'mongodb';

export class FuettrDB {
  public static async createInstance(socket = 'localhost:27017'): Promise<FuettrDB> {
    if (FuettrDB._instance) {
      throw Error('instance already created');
    }
    const instance = new FuettrDB();
    await instance.start();
    FuettrDB._instance = instance;
    return FuettrDB._instance;
  }

  private static _instance: FuettrDB;

  public static get Instance(): FuettrDB {
    if (!FuettrDB._instance) {
      throw new Error('instance not created yet');
    }
    return FuettrDB._instance;
  }

  private _data: mongodb.Collection;

  private constructor() {}

  public async getTimes(): Promise<string> {
    const Times = await this._data.find({ identifier: 'Times' }).toArray();
    return Times[0];
  }

  public async getStatus(): Promise<string> {
    const Status = await this._data.find({ identifier: 'Status' }).toArray();
    return Status[0];
  }

  public async getInfo(): Promise<string> {
    const Info = await this._data.find({ identifier: 'Info' }).toArray();
    return Info[0];
  }

  public async getPositions(): Promise<string> {
    const Positions = await this._data.find({ identifier: 'Hardware' }).toArray();
    return Positions[0];
  }

  public async putTimes(times: Object) {
    this._data.updateOne({ identifier: 'Times' }, { $set: times });
  }

  private async start() {
    const url = 'mongodb://localhost:27017/katzenfuetterungsanlage';
    try {
      const dbServer = await mongodb.MongoClient.connect(url);
      log.info('Database connected.');
      const dbFuettr = dbServer.db('katzenfuetterungsanlage');
      const collData = await dbFuettr.collection('data');
      this._data = collData;
    } catch (err) {
      log.warn(err);
      throw err;
    }
  }
}
