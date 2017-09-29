import { Component, Input, ViewChild, ElementRef } from '@angular/core';
import { ModalDirective } from 'ngx-bootstrap';

import { IUserLogin } from './models/user';


@Component({
  selector: 'app-modal-login',
  exportAs: 'ModalLoginComponent',
  template: `
    <div bsModal #childModal="bs-modal" class="modal fade bd-example-modal-lg" tabindex="-1" role="dialog"
         aria-labelledby="modalLoginLabel" aria-hidden="true">
      <div class="modal-dialog modal-sm">
        <div class="modal-content">
          <div class="modal-header">
            <h5 class="modal-title">{{title}}</h5>
            <button type="button" class="close" data-dismiss="modal" aria-label="Close" (click)="cancel($event)">
              <span aria-hidden="true">&times;</span>
            </button>
          </div>
          <div class="modal-body">
            <form class="form-signin" #loginForm="ngForm" (keydown)="keyDown($event)">
              <div class="form-group">
                <label class="sr-only" for="inputHtlid">HTL-ID</label>
                <input #inputHtlid id="input-htlid" class="form-control" type="Text" placeholder="HTL-ID"
                       required minlength="2" maxlength="24"
                       name="htlid" #name="ngModel" [(ngModel)]="htlid" [readonly]="!enableHtlid"/>
              </div>
              <div class="form-group">
                <div class="input-group">
                  <label class="sr-only" for="inputPassword">Password</label>
                  <input #inputPassword id="input-password" class="form-control" type="{{passwordInputType}}" placeholder="Password"
                         required name="password" #name="ngModel" [(ngModel)]="password" />
                  <span *ngIf="buttonEyeVisible" class="input-group-btn">
                    <button id="button-eye" class="btn btn-secondary" type="button" style="display: block;" (click)="togglePasswordShown()">
                      <i class="fa" [ngClass]="(passwordInputType==='Password')?'fa-eye':'fa-eye-slash'"></i>
                    </button>
                  </span>
                </div>
              </div>
            </form>
          </div>
          <div class="modal-footer">
            <button #loginButton type="button" class="btn btn-primary"
                   (click)="login(); false" [disabled]="!loginForm.form.valid">{{loginButtonText}}</button>
            <button type="button" class="btn btn-secondary" data-dismiss="modal" (click)="cancel($event); false">Abbrechen</button>
          </div>
        </div>
      </div>
    </div>
  `,
  styles: [ `
    .ng-valid[required], .ng-valid.required  {
      border-left: 5px solid green
    }
    .ng-invalid:not(form) {
      border-left: 5px solid red
    }
    .form-signin {
      max-width: 300px;
      padding: 0px;
      margin: 0 auto;
    }
    #input-htlid, #input-password, #button-eye, #button-eye-slash {
      border-radius: 0.25rem;
    }
  }
  `]
})

export class ModalLoginComponent  {
  @ViewChild('childModal') public childModal: ModalDirective;
  @ViewChild('inputHtlid') private _inputHtlid: ElementRef;
  @ViewChild('inputPassword') private _inputPassword: ElementRef;
  @ViewChild('loginButton') private _loginButton: ElementRef;

  public title: string;
  public htlid: string;
  public enableHtlid: boolean;
  public password: string;
  public checkbox: IModalLoginCheckbox;
  public loginButtonText: string;
  public passwordInputType = 'Password';
  public buttonEyeVisible: boolean;

  private _resolve: Function;
  private _reject: Function;
  private _isCancelled: boolean;

  constructor () {
  }

  public keyDown (event) {
    // check enter on keyboard
    if (event.keyCode === 13) {
      const el = this._loginButton && this._loginButton.nativeElement;
      if (el && !el.disabled) {
        this.login();
      }
    }
  }

  public togglePasswordShown() {
    console.log(this.passwordInputType);
    if (this.passwordInputType === 'Password') {
      this.passwordInputType = 'Text';
    } else {
      this.passwordInputType = 'Password';
    }
  }

  public show (config?: IModalLoginConfig): Promise<IUserLogin> {
    this.title = config.title || 'Authorize';
    this.htlid = config.htlid || '';
    this.password = '';
    this.checkbox = config.checkbox || { visible: false, selected: true, text: 'Stay loggined' };
    this.loginButtonText = config.loginButtonText || 'Login';
    this.buttonEyeVisible = config.buttonEyeVisible || true;
    this.enableHtlid = (this.htlid === '');

    return new Promise<any> ( (resolve, reject) => {
      this._resolve = resolve;
      this._reject = reject;
      this.childModal.show();

      // needed beacuse autofocus does not work in modal
      // see https://v4-alpha.getbootstrap.com/components/modal/#how-it-works
      this.childModal.onShown.subscribe(() => {
        if (this.enableHtlid) {
          this. _inputHtlid.nativeElement.focus();
        } else {
          this. _inputPassword.nativeElement.focus();
        }
      });

      // needed when user clicks escape
      this.childModal.onEsc = this.cancel.bind(this);

      // needed when user hides modal by clicking outside
      this.childModal.onHidden.subscribe( () => {

        if (!this._isCancelled) {
          this.cancel();
        }
      });
    });
  }

  public login () {
    this.childModal.hide();
    this._resolve( { htlid: this.htlid, password: this.password });
  }

  public cancel (e?) {
    this._isCancelled = true;
    this.childModal.hide();
    this.htlid = undefined;
    this.password = undefined;
    this._resolve( { htlid: this.htlid, password: this.password } );
  }

}


export class IModalLoginCheckbox {
  visible: boolean;
  selected: boolean;
  text: string;
}

export class IModalLoginConfig {
  title?: string;
  htlid?: string;
  loginButtonText?: string;
  checkbox?: IModalLoginCheckbox;
  buttonEyeVisible?: boolean;
}
