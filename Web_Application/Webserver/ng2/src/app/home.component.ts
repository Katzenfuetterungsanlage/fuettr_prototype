import { Component, OnInit } from '@angular/core';
import { HttpgetService } from './httpget.service';

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

  private time1_show = false;
  private time2_show = false;
  private time3_show = false;
  private time4_show = false;

  private warning = false;
  private danger = false;

  public constructor(private httpgetService: HttpgetService) {
    this.statusmessage = `Dummytext: Sunt enim minim cupidatat deserunt ullamco dolore eiusmod
      fugiat eu quis aliquip mollit labore. Aute fugiat fugiat veniam cupidatat minim est irure
      est ipsum. Duis exercitation qui quis proident ut exercitation. Ad labore sint ullamco est
      in proident labore consectetur ea et in nisi. Ullamco magna tempor ipsum occaecat do eu
      adipisicing. Cillum consequat mollit dolore proident commodo.`;
  }

  ngOnInit(): void {

    this.httpgetService.getWarning().then((res) => {
      if (res.warnings !== 'null') {
        this.warning_message = res.warnings;
        this.warning = true;
      }
    });

    this.httpgetService.getError().then((res) => {
      if (res.errors !== 'null') {
        this.error_message = res.errors;
        this.danger = true;
      }
    });

    this.httpgetService.getTimes().then((res) => {
      if (res.time1 !== '--:--') {
        this.time1 = res.time1;
        this.time1_show = true;
      }
      if (res.time2 !== '--:--') {
        this.time2 = res.time2;
        this.time2_show = true;
      }
      if (res.time3 !== '--:--') {
        this.time3 = res.time3;
        this.time3_show = true;
      }
      if (res.time4 !== '--:--') {
        this.time4 = res.time4;
        this.time4_show = true;
      }
    });
  }
}
