import { Injectable } from '@angular/core';
import { Http, Response } from '@angular/http';

import 'rxjs/add/operator/toPromise';

@Injectable()
export class HttpgetService {

  private warningUrl = 'http://localhost:666/warnings';

  constructor(private http: Http) { }

  getWarning(): Promise<string> {
    return this.http.get(this.warningUrl)
      .toPromise()
      .then(response => response.json() as string)
      .catch(this.handleError);
  }

  private handleError(error: any): Promise<any> {
    console.error('An error occurred', error);
    return Promise.reject(error.message || error);
  }
}
