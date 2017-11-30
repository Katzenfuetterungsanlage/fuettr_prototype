import { Component, OnInit } from '@angular/core';
import { HttpgetService } from './httpget.service';
import { HttpputService } from './httpput.service';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { CustomFormsModule } from 'ng2-validation';

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

  save(value): void {
    this.httpputService.putTimes(value).subscribe();
    console.log(value);
  }
}

