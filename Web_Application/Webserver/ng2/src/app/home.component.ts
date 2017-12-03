import { Component, OnInit } from '@angular/core';
import { HttpgetService } from './httpget.service';
import { HttpputService } from './httpput.service';
import { AppComponent } from './app.component';
import * as itf from './interfaces';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html'
})
export class HomeComponent implements OnInit {
  private warning_messages: itf.Warning[];
  private error_messages: itf.Error[];
  private last_time: string;
  private next_time: string;
  private next_time_in: string;
  private machine_state: string;

  private time1: string;
  private time2: string;
  private time3: string;
  private time4: string;

  private time1_show = false;
  private time2_show = false;
  private time3_show = false;
  private time4_show = false;

  public constructor(
    private httpgetService: HttpgetService,
    private httpputService: HttpputService,
    private app: AppComponent
  ) {}

  ngOnInit(): void {
    this.callMeMaybe();

    setInterval(() => {
      this.callMeMaybe();
    }, 30000);
    this.app.navShow = false;
  }

  callMeMaybe(): void {
    this.httpgetService.getWarnings().then(res => {
      this.warning_messages = res.warnings;
    });

    this.httpgetService.getErrors().then(res => {
      this.error_messages = res.errors;
    });

    this.httpgetService.getTimes().then(res => {
      this.time1 = res.time1;
      this.time2 = res.time2;
      this.time3 = res.time3;
      this.time4 = res.time4;
      this.time1_show = res.time1_active;
      this.time2_show = res.time2_active;
      this.time3_show = res.time3_active;
      this.time4_show = res.time4_active;
    });

    this.httpgetService.getStatus().then(res => {
      this.last_time = res.last_time;
      this.next_time = res.next_time;
      this.next_time_in = res.next_time_in;
      this.machine_state = res.machine_state;
    });
  }

  ackwarn(warning: itf.Warning) {
    const id: itf.AckWarn = { id: warning.id };
    this.httpputService.ackErr(id).subscribe();
  }

  ackerr(error: itf.Error) {
    const id: itf.AckErr = { id: error.id };
    this.httpputService.ackErr(id).subscribe();
  }
}
