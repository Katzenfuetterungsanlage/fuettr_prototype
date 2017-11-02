import { Component, OnInit } from '@angular/core';
import { UpdateService } from './update.service';
import { Http } from '@angular/http';
import { Version } from './version';


@Component({
  selector: 'app-update',
  templateUrl: './update.component.html',
})
export class UpdateComponent implements OnInit {

  private message: string;
  private show = false;
  private updater: string;
  private version: Version;
  private lVersion: Version;
  private newVersion: string;
  private t1: number;
  private t2: number;
  private t: number;

  constructor(private updateService: UpdateService) { }

  update() {
    this.updater = 'in progress...';
    this.updateService.getUpdate();
  }

  shutdown() {
    this.updateService.shutdown();
  }

  refresh() {
    this.message = 'Checking for updates...';
    this.t1 = new Date().getMilliseconds();

    this.updateService.checkUpdate().then((version) => {
      this.version = version;
      this.updateService.getVersion().then((lVersion) => {
        this.lVersion = lVersion;
        if (this.version.version !== this.lVersion.version) {
          this.message = 'Update found:';
          this.show = true;
          this.newVersion = this.version.version.toString();
        } else {
          this.t2 = new Date().getMilliseconds();
          this.t = this.t2 - this.t1;

          this.message = 'Up to date in ' + this.t + 'ms';
        }
      }).catch((err) => {
        alert(err);
      });
    }).catch((err) => {
      alert(err);
    });
  }

  ngOnInit() {
    this.message = 'Checking for updates...';
    this.t1 = new Date().getMilliseconds();

    this.updateService.checkUpdate().then((version) => {
      this.version = version;
      this.updateService.getVersion().then((lVersion) => {
        this.lVersion = lVersion;
        if (this.version.version !== this.lVersion.version) {
          this.message = 'Update found:';
          this.show = true;
          this.newVersion = this.version.version.toString();
        } else {
          this.t2 = new Date().getMilliseconds();
          this.t = this.t2 - this.t1;

          this.message = 'Up to date in ' + this.t + 'ms';
        }
      }).catch((err) => {
        alert(err);
      });
    }).catch((err) => {
      alert(err);
    });
  }
}

