import { Component, Inject } from '@angular/core';
import { DOCUMENT } from '@angular/common';
import { AppComponent } from './app.component';

@Component({
  selector: 'app-error404',
  templateUrl: './error404.component.html'
})
export class Error404Component {
  private url: string;

  constructor(
    @Inject(DOCUMENT) private document: Document,
    private app: AppComponent
  ) {
    this.url = this.document.location.href;
    app.lic();
  }
}
