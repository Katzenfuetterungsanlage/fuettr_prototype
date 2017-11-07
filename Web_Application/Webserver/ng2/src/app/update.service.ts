import { Injectable } from '@angular/core';
import { Http, Response } from '@angular/http';
import { Version } from './version';

import 'rxjs/add/operator/toPromise';

@Injectable()
export class UpdateService {
  private getUrl = 'api/getUpdate';
  private checkUrl = 'https://raw.githubusercontent.com/Katzenfuetterungsanlage/fuettr_prototype/master/version.json';
  private lVersionUrl = 'api/version';
  private shutdownUrl = 'api/shutdown';

  constructor(private http: Http) { }

  async getUpdate(): Promise<void> {
    return this.http.get(this.getUrl)
      .toPromise()
      .then(response => response.json())
      .catch(this.handleError);
  }

  shutdown(): Promise<void> {
    return this.http.get(this.shutdownUrl)
      .toPromise()
      .then(response => response.json())
      .catch(this.handleError);
  }

  checkUpdate(): Promise<Version> {
    return this.http.get(this.checkUrl)
      .toPromise()
      .then(response => response.json() as Version)
      .catch(this.handleError);
  }

  getVersion(): Promise<Version> {
    return this.http.get(this.lVersionUrl)
      .toPromise()
      .then(response => response.json() as Version)
      .catch(this.handleError);
  }

  stillThere(): Promise<any> {
    return this.http.get(this.lVersionUrl).toPromise();
  }

  private handleError(error: any): Promise<any> {
    console.error('An error occurred', error);
    return Promise.reject(error.message || error);
  }
}

