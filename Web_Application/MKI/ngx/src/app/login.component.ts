import { Component, ViewContainerRef, OnInit } from '@angular/core';
import { ServerService } from './services/server.service';

@Component({
  selector: 'app-login',
  template: `
  `,
})
export class LoginComponent implements OnInit {

  constructor (private viewContainerRef: ViewContainerRef,
               private serverService: ServerService
               ) {
  }

  public ngOnInit () {
    this.serverService.authenticate(this.viewContainerRef).then(accessToken => {
      console.log('Login succeeded');
    }).catch(err => {
      console.log(err);
      setTimeout(this.ngOnInit.bind(this), 100);
    })
  }



}
