import {
  Component,
  OnInit,
  trigger,
  state,
  animate,
  transition,
  style
} from '@angular/core';
import { HttpgetService } from './httpget.service';
import { HttpputService } from './httpput.service';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { TimeCalculator } from './time.calculator.service';
import { AppComponent } from './app.component';

import * as itf from './interfaces';

@Component({
  selector: 'app-feed',
  templateUrl: './feed.component.html',
  animations: [
    trigger('SaveAnimation', [
      state('false', style({ 'margin-left': '-126px' })),
      state('true', style({ 'margin-left': '0' })),
      transition('* => *', animate('300ms'))
    ])
  ]
})
export class FeedComponent implements OnInit {
  private submit = false;
  private saved = true;
  private failed = false;
  private savedstate = false;
  private time1: string;
  private time2: string;
  private time3: string;
  private time4: string;
  private check1: boolean;
  private check2: boolean;
  private check3: boolean;
  private check4: boolean;
  private doppelpoint1: boolean;
  private doppelpoint2: boolean;
  private doppelpoint3: boolean;
  private doppelpoint4: boolean;

  private time1Minutes: number;
  private time1Valid = false;
  private time2Minutes: number;
  private time2ValidMin = false;
  private time2Valid = false;
  private time3Minutes: number;
  private time3ValidMin = false;
  private time3Valid = false;
  private time4Minutes: number;
  private time4ValidMin = false;
  private time4Valid = false;

  constructor(
    private httpgetService: HttpgetService,
    private httpputService: HttpputService,
    private timeCalculator: TimeCalculator,
    private app: AppComponent
  ) {}

  onKey(): void {
    this.doppelpoint();

    this.time1Minutes = this.timeCalculator.toMinutes(this.time1);
    this.time2Minutes = this.timeCalculator.toMinutes(this.time2);
    this.time3Minutes = this.timeCalculator.toMinutes(this.time3);
    this.time4Minutes = this.timeCalculator.toMinutes(this.time4);

    this.time1Valid = this.timeCalculator.isValid(this.time1);

    if (this.time1Minutes === null) {
      this.time2ValidMin = true;
    } else {
      this.time2ValidMin = this.time2Minutes > this.time1Minutes;
    }
    this.time2Valid = this.timeCalculator.isValid(this.time2);

    if (this.time2Minutes === null) {
      this.time3ValidMin = true;
    } else {
      this.time3ValidMin = this.time3Minutes > this.time2Minutes;
    }
    this.time3Valid = this.timeCalculator.isValid(this.time3);

    if (this.time3Minutes === null) {
      this.time4ValidMin = true;
    } else {
      this.time4ValidMin = this.time4Minutes > this.time3Minutes;
    }
    this.time4Valid = this.timeCalculator.isValid(this.time4);
  }

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

      this.onKey();
      this.app.lic();
      this.app.navShow = false;
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
    const value = {
      time1: this.time1,
      time2: this.time2,
      time3: this.time3,
      time4: this.time4,
      time1_active: this.check1,
      time2_active: this.check2,
      time3_active: this.check3,
      time4_active: this.check4
    };

    this.httpputService
      .putTimes(value)
      .then(res => {
        this.time1 = res.time1;
        this.time2 = res.time2;
        this.time3 = res.time3;
        this.time4 = res.time4;
        this.check1 = res.time1_active;
        this.check2 = res.time2_active;
        this.check3 = res.time3_active;
        this.check4 = res.time4_active;
        this.savedstate = true;
        setTimeout(() => {
          this.savedstate = false;
        }, 1500);
      })
      .catch(() => {
        this.failed = true;
        setTimeout(() => {
          this.failed = false;
        }, 1500);
      });
  }

  doppelpoint(): void {
    if (this.time1.length === 3) {
      this.doppelpoint1 = true;
    }
    if (this.time1.length === 2) {
      if (!this.doppelpoint1) {
        this.time1 += ':';
        this.doppelpoint1 = true;
      }
    }
    if (this.time1.length === 1) {
      this.doppelpoint1 = false;
    }
    if (this.time2.length === 3) {
      this.doppelpoint2 = true;
    }
    if (this.time2.length === 2) {
      if (!this.doppelpoint2) {
        this.time2 += ':';
        this.doppelpoint2 = true;
      }
    }
    if (this.time2.length === 1) {
      this.doppelpoint2 = false;
    }
    if (this.time3.length === 3) {
      this.doppelpoint3 = true;
    }
    if (this.time3.length === 2) {
      if (!this.doppelpoint3) {
        this.time3 += ':';
        this.doppelpoint3 = true;
      }
    }
    if (this.time3.length === 1) {
      this.doppelpoint3 = false;
    }
    if (this.time4.length === 3) {
      this.doppelpoint4 = true;
    }
    if (this.time4.length === 2) {
      if (!this.doppelpoint4) {
        this.time4 += ':';
        this.doppelpoint4 = true;
      }
    }
    if (this.time4.length === 1) {
      this.doppelpoint4 = false;
    }
  }
}
