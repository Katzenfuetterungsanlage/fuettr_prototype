import { NgModule } from '@angular/core';
import { HttpModule } from '@angular/http';
import { FormsModule } from '@angular/forms';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { ControlComponent } from './control.component';
import { FeedComponent } from './feed.component';
import { HomeComponent } from './home.component';
import { InfoComponent } from './info.component';
import { TimesService } from './times.service';
import { UpdateComponent } from './update.component';
import { UpdateService } from './update.service';

@NgModule({
  declarations: [
    AppComponent,
    ControlComponent,
    HomeComponent,
    FeedComponent,
    InfoComponent,
    UpdateComponent
  ],
  imports: [BrowserModule, AppRoutingModule, HttpModule, FormsModule],
  providers: [TimesService, UpdateService],
  bootstrap: [AppComponent]
})
export class AppModule { }
