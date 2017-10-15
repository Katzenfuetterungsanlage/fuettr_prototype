import { Component } from '@angular/core';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html'
})
export class AppComponent {
  private Time: string;
  private intervalID: any;
  private promise: Promise<number>;
  private promiseResult: string;

  public constructor() {
    this.intervalID = setInterval(this.refreshTime.bind(this), 100);
  }

  private refreshTime() {
    this.Time = new Date().toLocaleTimeString();
    this.promise
      .then(n => {
        this.promiseResult = '' + n;
      })
      .catch(err => {
        this.promiseResult = err.message;
      });
  }
}
