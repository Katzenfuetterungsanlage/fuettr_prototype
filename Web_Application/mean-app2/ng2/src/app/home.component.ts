import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
})
export class HomeComponent implements OnInit {
  private statusmessage: string;
  private warning_message: string;
  private error_message: string;
  private promise: Promise<number>;
  private promiseResult: string;

  private time1: string;
  private time2: string;
  private time3: string;
  private time4: string;

  private warning = false;
  private danger = false;

  public constructor() {
    this.statusmessage = `Dummytext: Sunt enim minim cupidatat deserunt ullamco dolore eiusmod
      fugiat eu quis aliquip mollit labore. Aute fugiat fugiat veniam cupidatat minim est irure
      est ipsum. Duis exercitation qui quis proident ut exercitation. Ad labore sint ullamco est
      in proident labore consectetur ea et in nisi. Ullamco magna tempor ipsum occaecat do eu
      adipisicing. Cillum consequat mollit dolore proident commodo.`;
    this.error_message = `This is an errormessage with a very long text, so I can see, that it
      automatically breaks the line, if it is too long.`;
    this.warning_message = 'Some warnings may occure.';
  }

  ngOnInit(): void {
    this.time1 = '';
    this.time2 = '11:11';
    this.time3 = '12:12';
    this.time4 = '13:13';
  }
}
