import { Component, OnInit } from '@angular/core';

import { UpdateService } from './update.service';
import { Version } from './version';

@Component({
  selector: 'app-info',
  templateUrl: './info.component.html'
})
export class InfoComponent implements OnInit {
  serialnumber = '#000000';
  processor = 'Raspberry Pi 3 Model B';
  wlanstate = '@TODO';
  ipadress = '@TODO';
  version: string;

  constructor(private updateService: UpdateService) { }


  ngOnInit() {
    this.updateService.getVersion().then((lVersion) => {
      this.version = lVersion.version.toString();
    });
  }
}
