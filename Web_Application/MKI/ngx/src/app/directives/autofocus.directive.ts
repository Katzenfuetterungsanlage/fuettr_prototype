import {Directive, ElementRef, Renderer, Input, OnInit, AfterViewInit} from '@angular/core';

@Directive({
  selector: '[appAutofocus]'
})
export class AutofocusDirective implements OnInit, AfterViewInit {

  private _autofocus;

  constructor (private el: ElementRef, private renderer: Renderer) {
    console.log('AutofocusDirective: constructor()');
  }

  ngOnInit () {
    console.log('AutofocusDirective: init()');
  }

  ngAfterViewInit () {
    console.log('AutofocusDirective: ngAfterViewInit()');
    this.renderer.invokeElementMethod(this.el.nativeElement, 'focus', []);
  }

  @Input() set autofocus (condition: boolean)
  {
    console.log('AutofocusDirective: autofocus = ' + condition);
    this._autofocus = condition !== false;
  }
}
