import { Component, OnInit } from '@angular/core';
import { HttpgetService } from './httpget.service';
import { HttpputService } from './httpput.service';

import * as itf from './interfaces';

@Component({
  selector: 'app-feed',
  templateUrl: './feed.component.html',
})
export class FeedComponent implements OnInit {

  private time1: string;
  private time2: string;
  private time3: string;
  private time4: string;
  private check1: boolean;
  private check2: boolean;
  private check3: boolean;
  private check4: boolean;
  private times: itf.Times;

  constructor(private httpgetService: HttpgetService, private httpputService: HttpputService) { }

  ngOnInit(): void {
    this.httpgetService.getTimes().then(res => {
      this.time1 = res.time1;
      this.time2 = res.time2;
      this.time3 = res.time3;
      this.time4 = res.time4;
      this.check1 = res.time1_active;
      this.check2 = res.time2_active;
      this.check3 = res.time3_active;
      this.check4 = res.time4_active;
    });
  }

  cancel(): void {
    this.httpgetService.getTimes().then(res => {
      this.time1 = res.time1;
      this.time2 = res.time2;
      this.time3 = res.time3;
      this.time4 = res.time4;
      this.check1 = res.time1_active;
      this.check2 = res.time2_active;
      this.check3 = res.time3_active;
      this.check4 = res.time4_active;
    });
  }

  save(): void {
    this.times.time1 = this.time1;
    this.times.time2 = this.time2;
    this.times.time3 = this.time3;
    this.times.time4 = this.time4;

    this.times.time1_active = this.check1;
    this.times.time2_active = this.check2;
    this.times.time3_active = this.check3;
    this.times.time4_active = this.check4;

    this.httpputService.putTimes(this.times);
  }
}

