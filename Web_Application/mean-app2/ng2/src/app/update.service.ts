import { Injectable } from '@angular/core';
import { Http } from '@angular/http';

@Injectable()
export class UpdateService {
  private Url = 'api/getUpdate';  // URL to web api

  constructor(private http: Http) { }

  getUpdate(): Promise<any> {
    return this.http.get(this.Url)
      .toPromise()
      .then(response => response.json())
      .catch(this.handleError);
  }

  private handleError(error: any): Promise<any> {
    console.error('An error occurred', error);
    return Promise.reject(error.message || error);
  }
}
