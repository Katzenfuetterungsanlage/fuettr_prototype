import { BobDerBaumeisterService, IUser } from './bob-der-baumeister.service';

import { Component } from '@angular/core';

@Component({
  // tslint:disable-next-line:component-selector
  selector : 'test',
  template: `
  <div>
    <p>Das ist TestComponent: Zeit: {{time}}</p>
    <p>Promise: {{promiseResult}}</p>
    <button (click)="handleButton()">Do it!</button>
    <p>User {{user?.name}}</p>
  </div>
  `
})
export class TestComponent {
public time: string;
private intervalID: any;
private promise: Promise<number>;
private promiseResult: string;
public user: IUser;

  public constructor (private bdbm: BobDerBaumeisterService) {
    // this.time = new Date().toLocaleTimeString();
    this.intervalID = setInterval( this.refreshTime.bind(this), 100);
    this.promise = this.doSomething();
  }

private refreshTime () {
  this.time = new Date().toLocaleTimeString();
  this.promise.then( n => {
  this.promiseResult = '' + n;
  }).catch( err => {
    this.promiseResult = err.message;
  });
}

private doSomething (): Promise<number> {
  // return Promise.reject(new Error('not implemented yet'));
  // return Promise.resolve(666);
return new Promise ( (resolve, reject ) => {
// reject(new Error('so nicht'));
resolve (100);
this.bdbm.x = 10;
});
}

public handleButton () {
    this.bdbm.getUser().then( (user) => {
      debugger;
      this.user = user;
    }).catch( (err) => {
      alert(err);
    });
  }

}
