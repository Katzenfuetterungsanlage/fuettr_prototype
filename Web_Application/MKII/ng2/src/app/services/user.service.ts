import { Injectable, ViewContainerRef } from '@angular/core';

import 'rxjs/add/operator/toPromise';
import {Subject} from 'rxjs/Rx';

import { ServerService } from './server.service';
import { User, IUser, IUserLogin } from '../models/user';

@Injectable()
export class UserService {

  private _userSubject: Subject<User> = new Subject();
  private _user: User;

  constructor (private serverService: ServerService) {
    this.serverService.subscribe(this.changeLoginUser.bind(this));
  }

  public subscribe (listener: (User) => void ) {
    this._userSubject.subscribe(listener);
  }

  public getLoginUser (): User {
    return this._user;
  }

  public init (htlid: string, remoteToken: string) {
    this.serverService.reset(htlid, remoteToken);
  }

  public logout (viewContainerRef: ViewContainerRef): Promise<void> {
    if (!this._user) {
      return Promise.reject(new Error('No user logged in'));
    }
    return new Promise<void>( (resolve, reject) => {
      this.serverService.httpGet('/logout', viewContainerRef).then(response => {
        this._user = undefined;
        this._userSubject.next(undefined);
        this.serverService.reset();
      }).catch( err => reject(err) );
    });
  }

  public changeLoginUser (htlid: string) {
    this._user = undefined;
    if (!htlid) {
      this._userSubject.next(undefined);
    } else {
      this.serverService.httpGet('/data/user', undefined).then(response => {
        const result: IUser = response.json() as IUser;
        try {
          this._user = new User(result);
          this._userSubject.next(this._user)
        } catch (error) {
          this._userSubject.next(undefined);
          console.log(error)
        }
      }).catch(error => {
        this._userSubject.next(undefined);
        console.log(error)
      })
    }
  }

  private handleError (err: any, reject: Function) {
    // debugger;
    console.log(err);
    let errMsg = '?';
    if (err instanceof Response) {
      const status = (err as Response).status;
      errMsg = status === 0 ? 'cannot connect server' : 'HTTP-Status ' + status;
    } else {
      errMsg = '?';
    }
    reject(new Error('login() fails (' + errMsg + ')'));
  }

}


