import { Component, OnInit } from '@angular/core';

import { UpdateService } from './update.service';
import { HttpgetService } from './httpget.service';
import { AppComponent } from './app.component';

@Component({
  selector: 'app-info',
  templateUrl: './info.component.html'
})
export class InfoComponent implements OnInit {
  serialnumber: string;
  processor: string;
  wlanstate: string;
  ipadress: string;
  version: string;

  constructor(
    private updateService: UpdateService,
    private httpgetService: HttpgetService,
    private app: AppComponent
  ) {}

  ngOnInit() {
    this.updateService.getVersion().then(lVersion => {
      this.version = lVersion.version.toString();
    });

    this.httpgetService.getInfo().then(res => {
      this.serialnumber = res.serialnumber;
      this.processor = res.internal;
      this.wlanstate = res.wlanState;
    });

    this.httpgetService.getIp().then(res => {
      this.ipadress = res.ip;
    });
    this.app.lic();
  }
}
