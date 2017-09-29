import { Component, OnInit, ViewContainerRef } from '@angular/core';
import { Http, RequestOptions, Headers } from '@angular/http';

import { UserService } from './services/user.service';
import { ServerService } from './services/server.service';

@Component({
  selector: 'app-profil',
  template: `
    <div class="container">
      <h1>{{title}}</h1>
      <h2>Hello {{name}}</h2>
      <button class="but-default" (click)="onLogout()">Logout</button>
      <button class="but-default" (click)="onGetTime()">Show time on server</button>
    </div>
    <div class="messages" style="padding-top:10px">
      <alert *ngIf="serverTime" type="success">
        <p>Server-Time: {{serverTime}}</p>
      </alert>
      <alert *ngIf="serverError" type="danger">
        <p>Error: {{serverError}}</p>
      </alert>
    </div>
  `,
  styles: ['']
})
export class ProfilComponent implements OnInit {
  public title = 'profil works!';
  public name = '?';
  public serverTime: string;
  public serverError: string;

  constructor (private viewContainerRef: ViewContainerRef,
               private userService: UserService, private serverService: ServerService, private http: Http) {}

  ngOnInit(): void {
    const user = this.userService.getLoginUser();
    if (user) {
      this.name = (user.firstname ? user.firstname + ' ' : '') + user.surname + ' (' + user.htlid + ')';
    } else {
      console.log(new Error('No Login user available'));
    }
  }

  public onLogout () {
    console.log('Logout');
    this.userService.logout(this.viewContainerRef).then ( () => {
      console.log('Logged out');
    }).catch( error => {
      console.log(error);
      this.serverError = 'Logout fails';
      setTimeout( () => { this.serverError = undefined; }, 3000);
    });
  }


  public onGetTime () {
    this.serverService.httpGet('/data/time', this.viewContainerRef).then( response => {
      this.serverTime = response.json().time;
      setTimeout( () => { this.serverTime = undefined; }, 3000);
    }).catch( err => {
      console.log(err);
      this.serverError = 'getting server time fails';
      setTimeout( () => { this.serverError = undefined; }, 3000);
    });
  }

}
