import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppComponent } from './app.component';
import * as spinner from 'ng2-spin-kit/app/spinners';

@NgModule({
  declarations: [
    AppComponent, spinner.WaveComponent
  ],
  imports: [
    BrowserModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
