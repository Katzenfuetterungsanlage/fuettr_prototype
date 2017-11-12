import { Injectable } from '@angular/core';
import { Http, Response } from '@angular/http';
import * as itf from './interfaces';

import 'rxjs/add/operator/toPromise';

@Injectable()
export class HttpgetService {

  private api = '/api/schiebihnreinhard?q=';

  constructor(private http: Http) { }

  getWarning(): Promise<itf.Warnings> {
    return this.http.get(this.api + 'warnings')
      .toPromise()
      .then(response => response.json() as itf.Warnings)
      .catch(this.handleError);
  }

  getError(): Promise<itf.Errors> {
    return this.http.get(this.api + 'errors')
      .toPromise()
      .then(response => response.json() as itf.Errors)
      .catch(this.handleError);
  }

  getTimes(): Promise<itf.Times> {
    return this.http.get(this.api + 'times')
      .toPromise()
      .then(response => response.json() as itf.Times)
      .catch(this.handleError);
  }

  private handleError(error: any): Promise<any> {
    console.error('An error occurred', error);
    return Promise.reject(error.message || error);
  }
}
