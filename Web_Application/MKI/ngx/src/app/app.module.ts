import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { HttpModule } from '@angular/http';


import { AppComponent } from './app.component';
import { AppRoutingModule } from './app-routing.module';
import { ServerService } from './services/server.service';
import { UserService } from 'app/services/user.service';
import { LoginComponent } from './login.component';
import { ProfilComponent } from './profil.component';
import { ModalLoginComponent } from './modal-login.component';
import { AutofocusDirective } from './directives/autofocus.directive';

import { AlertModule, ModalModule } from 'ngx-bootstrap';


@NgModule({
  declarations: [
    AppComponent, LoginComponent, ProfilComponent,
    ModalLoginComponent, AutofocusDirective
  ],
  imports: [
    BrowserModule, FormsModule, HttpModule,
    ModalModule.forRoot(),
    AlertModule.forRoot(),
    AppRoutingModule
  ],
  entryComponents: [ ModalLoginComponent ],
  providers: [ ServerService, UserService ],
  bootstrap: [ AppComponent ]
})
export class AppModule { }
