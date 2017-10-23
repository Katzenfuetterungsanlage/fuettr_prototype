import { Injectable } from '@angular/core';
import { Http } from '@angular/http';

@Injectable()
export class UpdateService {

  constructor(private http: Http) { }

  getUpdate() {
    this.http.get('/api/getUpdate');
  }

}
