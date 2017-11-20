import { Injectable } from '@angular/core';
import { Http, Headers } from '@angular/http';

import 'rxjs/Rx';

import * as itf from './interfaces';

@Injectable()
export class HttpputService {
  private api = '/api/putMeHere?q=';
  private headers = new Headers({ 'Content-Type': 'application/json' });

  constructor(private http: Http) { }

  putTimes(times) {
    return this.http.put(this.api + 'times', JSON.stringify(times), { headers: this.headers });
  }

  ackErr(data) {
    return this.http.put(this.api + 'ackErr', JSON.stringify(data), { headers: this.headers });
  }

  ackWarn(data) {
    return this.http.put(this.api + 'ackWarn', JSON.stringify(data), { headers: this.headers });
  }

}
