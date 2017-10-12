import {
  Injectable
} from '@angular/core'
import {
  Http,
  Response
} from '@angular/http';

import 'rxjs/add/operator/toPromise';

@Injectable()
export class BobDerBaumeisterService {

  private _x: number;

  constructor(private http: Http) {}

  public progress(): number {
    const err = new MyError('test', 100);
    console.log(err);
    this.http.get('http://localhost:8080/info').toPromise()
      .then(response => {
        console.log('Super')
      })
      .catch(error => {
        if (error instanceof Error) {
          console.log(error);
        } else {
          console.log('?');
        }
      });
    return 0;
  }

  public getUser(): Promise < IUser > {
    return new Promise((resolve, reject) => {
      this.http.get('http://localhost:8080/user').toPromise()
        .then(response => {
          resolve(response.json() as IUser);
        })
        .catch(error => {
          if (error instanceof Error) {
            console.log(error);
          } else {
            console.log('?');
          }
          reject(new Error('getUser failed'));
        });
    });
  }

  public get x(): number {
    return this._x;
  }

  public set x(value: number) {
    this._x = value;
  }



}

class MyError extends Error {
  constructor(message: string, private x: number) {
    super(message);
  }

  public toString(): string {
    return this.message + ', x=' + this.x;
  }
}

export interface IUser {
  name: string;
}
