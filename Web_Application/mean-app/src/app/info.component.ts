import { Component } from '@angular/core';

@Component({
  selector: 'app-info',
  templateUrl: './info.component.html'
})
export class InfoComponent {
  serialnumber = '#000000';
  processor = 'Raspberry Pi 3 Model B';
  wlanstate = '@TODO';
  ipadress = '@TODO';
  version = '0.0.1';
}
