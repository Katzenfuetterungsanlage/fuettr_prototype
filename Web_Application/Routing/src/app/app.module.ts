import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { ControlComponent } from './control.component';
import { HomeComponent } from './home.component';
import { FeedComponent } from './feed.component';
import { InfoComponent } from './info.component';
import { UpdateComponent } from './update.component'

@NgModule({
  declarations: [
    AppComponent,
    ControlComponent,
    HomeComponent,
    FeedComponent,
    InfoComponent,
    UpdateComponent
  ],
  imports: [BrowserModule, AppRoutingModule],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule {}
