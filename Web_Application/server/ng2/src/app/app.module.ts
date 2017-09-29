import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { HttpModule } from '@angular/http'

import { AppComponent } from './app.component';
import { TestComponent } from './test.component';

import { BobDerBaumeisterService } from './bob-der-baumeister.service';

@NgModule({
  declarations: [
    AppComponent, TestComponent
  ],
  imports: [
    BrowserModule, HttpModule
  ],
  providers: [BobDerBaumeisterService],
  bootstrap: [AppComponent]
})
export class AppModule { }
