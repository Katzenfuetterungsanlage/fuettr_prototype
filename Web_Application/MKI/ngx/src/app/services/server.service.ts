import { Injectable, ViewContainerRef, ComponentFactoryResolver, isDevMode } from '@angular/core';
import { Http, Response, RequestOptions, Headers } from '@angular/http';

import 'rxjs/add/operator/toPromise';
import {Subject} from 'rxjs/Rx';

import { ModalLoginComponent, IModalLoginConfig } from '../modal-login.component';
import { User, IUser, IUserLogin } from '../models/user';



@Injectable()
export class ServerService {

  private _serverUrl: string;
  private _authResponse: ILoginResponse;
  private _loginHtlidSubject: Subject<string> = new Subject();


  constructor (private http: Http, private componentFactoryResolver: ComponentFactoryResolver) {
    this._authResponse = { htlid: undefined, remoteToken: '', accessToken: '' };

    // ng serve      --> development mode, server running on same host
    // npm run build --> production mode, server can run on any host and supports loading ngx app
    this._serverUrl = isDevMode() ? 'http://localhost:8080' : '';
  }

  public subscribe (listener: (htlid: string) => void) {
    this._loginHtlidSubject.subscribe(listener);
  }


  public get serverUrl (): string {
    return this._serverUrl;
  }

  public reset (htlid?: string, remoteToken?: string, accessToken?: string) {
    this._authResponse = { htlid: htlid, remoteToken: remoteToken, accessToken: accessToken };
    this._loginHtlidSubject.next(this._authResponse.htlid);
  }


  public httpGet (url: string, viewContainerRef: ViewContainerRef, options?: RequestOptions): Promise<Response> {
    return new Promise<Response>( (resolve, reject) => {
      this.authenticate(viewContainerRef).then( accessToken => {
        this.performHttpGet(url, accessToken, options).then( response => {
          resolve(response);
          return;
        }).catch( err1 => {
          if (!(err1 instanceof Response) || (<Response>err1).status !== 401) {
            reject(err1);
            return;
          }
          this.authenticate(viewContainerRef, true).then( accessToken2 => {
            this.performHttpGet(url, accessToken2, options).then( response => {
              resolve(response);
              return;
            }).catch( err2 => reject(err2) );
          }).catch( err3 => reject(err3) );
        });
      }).catch(err4 => reject(err4) );
    });
  }

  public httpPost (url: string, data: Object, viewContainerRef: ViewContainerRef, options?: RequestOptions): Promise<Response> {
    return new Promise<Response>( (resolve, reject) => {
      this.authenticate(viewContainerRef).then( accessToken => {
        this.performHttpPost(url, data, accessToken, options).then( response => {
          resolve(response);
          return;
        }).catch( err1 => {
          if (!(err1 instanceof Response) || (<Response>err1).status !== 401) {
            reject(err1);
            return;
          }
          this.authenticate(viewContainerRef, true).then( accessToken2 => {
            this.performHttpPost(url, data, accessToken2, options).then( response => {
              resolve(response);
              return;
            }).catch( err2 => reject(err2) );
          }).catch( err3 => reject(err3) );
        });
      }).catch(err4 => reject(err4) );
    });
  }

  public authenticate (viewContainerRef: ViewContainerRef, refreshAcessToken?: boolean): Promise<string> {
    return new Promise<string>( (resolve, reject) => {

      if (this._authResponse && this._authResponse.accessToken && refreshAcessToken) {
        this._authResponse.accessToken = undefined;
      }

      const accessToken: string = this._authResponse && this._authResponse.accessToken;
      if (accessToken && typeof(accessToken) === 'string' && accessToken.length > 0) {
        resolve(accessToken);
        return;
      }

      const remoteToken = this._authResponse && this._authResponse.remoteToken;
      if (remoteToken && typeof(remoteToken) === 'string' && remoteToken.length > 0) {
        const headers = new Headers({
          'Content-Type': 'application/json',
          'Authorization': 'Bearer ' + remoteToken
        });
        const optionsPost = new RequestOptions({ headers: headers });
        this.http.post(this._serverUrl + '/auth', { htlid: this._authResponse.htlid }, optionsPost).toPromise().then( response => {
          const res: ILoginResponse = response.json();
          if (res && res.htlid === this._authResponse.htlid &&
              typeof(res.accessToken) === 'string' && res.accessToken.length > 0) {
            this._authResponse.accessToken = res.accessToken;
            resolve(res.accessToken);
          } else {
            reject(new Error('invalid server response on post /auth'));
          }
        }).catch( err => {
          if (err instanceof Response) {
            if ((<Response>err).status === 401) {
              this._authResponse.remoteToken = undefined;
              const config: IModalLoginConfig = { 
                      title: 'Passwort erforderlich', 
                      htlid: this._authResponse && this._authResponse.htlid,
                      loginButtonText: 'Weiter'
                    };
              this.login(viewContainerRef, config).then( accessToken2 => {
                resolve(accessToken2);
              }).catch( err2 => {
                reject(err2);
              })
            }
          }
        });
        return;
      }

      const config: IModalLoginConfig = { 
        title: 'Anmeldung erforderlich', 
        htlid: this._authResponse && this._authResponse.htlid,
        loginButtonText: 'Anmelden'
      };
      this.login(viewContainerRef, config).then( accessToken3 => {
        resolve(accessToken3);
      }).catch( err => reject(err) );

    });
  }

  public login (viewContainerRef: ViewContainerRef, config?: IModalLoginConfig, loginData?: IUserLogin): Promise<string> {
    let promise: Promise<IUserLogin>;
    if (loginData) {
      if (typeof(loginData.htlid) !== 'string' || loginData.htlid.length < 1) {
        return Promise.reject(new Error('invalid argument loginData (htlid)'));
      }
      if (config && config.htlid && config.htlid !== loginData.htlid) {
        return Promise.reject(new Error('invalid argument loginData (wrong htlid)'));
      }
      if (typeof(loginData.password) === 'string' && loginData.password.length > 0) {
        promise = Promise.resolve(loginData);
      }
    }
    if (!promise) {
      promise = this.performModalLoginDialog(viewContainerRef, config);
    }

    return new Promise<string>( (resolve, reject) => {
      promise.then( userLogin => {
        if (!userLogin || !userLogin.htlid) {
          reject(new Error('Login cancelled by user'));
          return;
        }
        const headersPost = new Headers({ 'Content-Type': 'application/json' });
        const optionsPost = new RequestOptions({ headers: headersPost });
        this.http.post(this._serverUrl + '/login', userLogin, optionsPost).toPromise().then( responsePost => {
          const res: ILoginResponse = responsePost.json();
          if (res && res.htlid === userLogin.htlid &&
              typeof(res.accessToken) === 'string' && res.accessToken.length > 0 &&
              typeof(res.remoteToken) === 'string' && res.remoteToken.length > 0) {
            this._authResponse = responsePost.json();
            this._loginHtlidSubject.next(this._authResponse && this._authResponse.htlid);
            resolve(this._authResponse.accessToken);
          } else {
            this._authResponse.accessToken = undefined;
            this._authResponse.remoteToken = undefined;
            this._loginHtlidSubject.next(this._authResponse && this._authResponse.htlid);
            reject(new Error('invalid login response'));
          }
        }).catch( err => reject(err) );
      }).catch ( err => reject(err) );
    });
  }

  // public getLoginUser (viewContainerRef: ViewContainerRef, accessToken?: string): Promise<User> {
  //   return new Promise<User>( (resolve, reject) => {
  //     this.performHttpGet('/data/user', accessToken).then( response => {
  //       const result: IUser = response.json() as IUser;
  //       resolve(new User(result));
  //     }).catch( err => reject(err) );
  //   });
  // }


  private performHttpGet (url: string, accessToken?: string, options?: RequestOptions): Promise<Response> {
    if (!url) {
      return Promise.reject(new Error('invalid arguments'));
    }
    const headers = new Headers({
      'Content-Type': 'application/json',
    });
    if (typeof(accessToken) === 'string' && accessToken.length > 0) {
      headers.append('Authorization', 'Bearer ' + accessToken);
    }
    options = new RequestOptions({ headers: headers });
    return this.http.get(this._serverUrl + url, options).toPromise();
  }

  private performHttpPost (url: string, body: any, accessToken?: string, options?: RequestOptions): Promise<Response> {
    if (!url || !body) {
      return Promise.reject(new Error('invalid arguments'));
    }
    const headers = new Headers({
      'Content-Type': 'application/json',
    });
    if (typeof(accessToken) === 'string' && accessToken.length > 0) {
      headers.append('Authorization', 'Bearer ' + accessToken);
    }
    options = new RequestOptions({ headers: headers });
    return this.http.post(this._serverUrl + url, body, options).toPromise();
  }

  private performModalLoginDialog (viewContainerRef: ViewContainerRef, config?: IModalLoginConfig): Promise<IUserLogin> {
    const factory = this.componentFactoryResolver.resolveComponentFactory(ModalLoginComponent);
    const modalLoginRef = viewContainerRef.createComponent(factory);
    modalLoginRef.changeDetectorRef.detectChanges();
    const modalLoginComponent: ModalLoginComponent = (<any>modalLoginRef)._component;
    if (!config) {
      config = {};
    }
    config.htlid = config.htlid || this._authResponse && this._authResponse.htlid;
    config.title = config.title || 'Authorisierung';
    return new Promise<IUserLogin>( (resolve, reject) => {
      modalLoginComponent.show(config).then ( (result) => {
        const index = viewContainerRef.indexOf(<any>modalLoginRef);
        viewContainerRef.remove(index);
        resolve(result);
      }).catch ( err => {
        const index = viewContainerRef.indexOf(<any>modalLoginRef);
        viewContainerRef.remove(index);
        reject(err);
      });
    });
  }

}


interface ILoginResponse {
  htlid: string;
  remoteToken: string;
  accessToken: string;
}


