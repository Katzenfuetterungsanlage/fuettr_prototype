import { NgModule } from '@angular/core';
import { HttpModule } from '@angular/http';
import { FormsModule } from '@angular/forms';
import { BrowserModule } from '@angular/platform-browser';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { NgbModule } from '@ng-bootstrap/ng-bootstrap';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { PositionComponent } from './position.component';
import { FeedComponent } from './feed.component';
import { HomeComponent } from './home.component';
import { InfoComponent } from './info.component';
import { UpdateComponent } from './update.component';
import { Error404Component } from './error404.component';

import { UpdateService } from './update.service';
import { HttpgetService } from './httpget.service';
import { HttpputService } from './httpput.service';
import { TimeCalculator } from './time.calculator.service';
import { CatComponent } from './cat/cat.component';

@NgModule({
  declarations: [
    AppComponent,
    PositionComponent,
    HomeComponent,
    FeedComponent,
    InfoComponent,
    UpdateComponent,
    Error404Component,
    CatComponent
  ],
  imports: [
    NgbModule.forRoot(),
    BrowserModule,
    AppRoutingModule,
    HttpModule,
    FormsModule,
    BrowserAnimationsModule
  ],
  providers: [UpdateService, HttpgetService, HttpputService, TimeCalculator],
  bootstrap: [AppComponent]
})
export class AppModule { }
