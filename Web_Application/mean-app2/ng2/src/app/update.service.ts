import { Injectable } from '@angular/core';
import { Http } from '@angular/http';

@Injectable()
export class UpdateService {

  constructor(private http: Http) { }

  public getUpdate(): number {
    const err = new MyError('test', 100);
    console.log(err);
    this.http.get('http://localhost/api/getUpdate').toPromise()
      .then(response => {
        console.log('Update...');
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
}

class MyError extends Error {
  constructor(message: string, private x: number) {
    super(message);
  }

  public toString(): string {
    return this.message + ', x=' + this.x;
  }
}
