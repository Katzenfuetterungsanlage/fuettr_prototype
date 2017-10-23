import { Injectable } from '@angular/core';
import { Http } from '@angular/http';

@Injectable()
export class UpdateService {

  constructor(private http: Http) { }

  getUpdate() {
    return this.http.get('/getUpdate');
  }

}
