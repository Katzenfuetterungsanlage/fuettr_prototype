import { NgModule } from '@angular/core';
import { HttpModule } from '@angular/http';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { ControlComponent } from './control.component';
import { FeedComponent } from './feed.component';
import { HomeComponent } from './home.component';
import { InfoComponent } from './info.component';
import { TimesService } from './times.service';
import { UpdateComponent } from './update.component';

@NgModule({
  declarations: [
    AppComponent,
    ControlComponent,
    HomeComponent,
    FeedComponent,
    InfoComponent,
    UpdateComponent
  ],
  imports: [BrowserModule, AppRoutingModule, HttpModule],
  providers: [TimesService],
  bootstrap: [AppComponent]
})
export class AppModule { }
