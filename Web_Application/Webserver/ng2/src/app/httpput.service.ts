import { Injectable } from '@angular/core';
import { Http, Response, Headers, RequestOptions } from '@angular/http';

import { Observable } from 'rxjs/Rx';

import * as itf from './interfaces';

@Injectable()
export class HttpputService {
  private api = '/api/putMeHere?q=';
  private headers = new Headers({ 'Content-Type': 'application/json' });
  private options = new RequestOptions({ headers: this.headers });

  constructor(private http: Http) { }

  putTimes(times) {
    const body = JSON.stringify(times);
    return this.http.put(this.api + 'times', body, this.options);
  }

}
