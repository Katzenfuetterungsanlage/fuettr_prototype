import 'rxjs/add/operator/filter';
import 'rxjs/add/operator/map';
import 'rxjs/add/operator/mergeMap';

import { Component, OnInit } from '@angular/core';
import { Router, NavigationEnd, ActivatedRoute } from '@angular/router';
import { Title } from '@angular/platform-browser';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html'
})
export class AppComponent implements OnInit {
  private Time: string;
  private intervalID: any;
  private promise: Promise<number>;
  private promiseResult: string;
  private cat = false;
  private lick = 0;

  public constructor(
    private router: Router,
    private activatedRoute: ActivatedRoute,
    private titleService: Title
  ) {
    this.intervalID = setInterval(this.refreshTime.bind(this), 100);
  }

  private refreshTime() {
    this.Time = new Date().toLocaleTimeString();
  }
  ngOnInit() {
    this.router.events
      .filter(event => event instanceof NavigationEnd)
      .map(() => this.activatedRoute)
      .map(route => {
        while (route.firstChild) {
          route = route.firstChild;
          return route;
        }
      })
      .filter(route => route.outlet === 'primary')
      .mergeMap(route => route.data)
      .subscribe(event => this.titleService.setTitle(event['title']));
  }

  click() {
    this.lick++;
    if (this.lick === 69) {
      this.cat = true;
    }
  }

  lic() {
    this.lick = 0;
  }

  back() {
    this.cat = false;
    this.lick = 0;
  }
}
