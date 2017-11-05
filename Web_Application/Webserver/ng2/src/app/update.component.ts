import { Component, OnInit } from '@angular/core';
import { UpdateService } from './update.service';
import { Http } from '@angular/http';
import { Version } from './version';


@Component({
  selector: 'app-update',
  templateUrl: './update.component.html',
})
export class UpdateComponent implements OnInit {

  private show = false;
  private show2 = false;
  private progress = false;
  private updater: string;
  private message: string;
  private newVersion: string;
  private version: Version;
  private lVersion: Version;
  private t1: number;
  private t2: number;
  private t: number;

  constructor(private updateService: UpdateService) { }

  update() {
    this.message = '';
    this.show = false;
    this.show2 = true;
    this.progress = true;
    this.updater = 'in progress...';
    this.updateService.getUpdate();
    setInterval(() => {
      if (this.updateService.getVersion() === undefined) {
        this.progress = false;
        this.message = 'rebooting... please reload the page.';
      }
    }, 1000);
  }

  shutdown() {
    this.updateService.shutdown();
  }

  async refresh() {
    this.message = 'Checking for updates...';
    this.t1 = await this.time1();

    this.updateService.checkUpdate().then((version) => {
      this.version = version;
      this.updateService.getVersion().then((lVersion) => {
        this.lVersion = lVersion;
        if (this.version.version !== this.lVersion.version) {
          this.t2 = new Date().getMilliseconds();
          this.t = this.t2 - this.t1;
          this.message = 'Update found in ' + this.t + 'ms:';
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

  async ngOnInit() {
    this.message = 'Checking for updates...';
    this.t1 = await this.time1();

    this.updateService.checkUpdate().then((version) => {
      this.version = version;
      this.updateService.getVersion().then((lVersion) => {
        this.lVersion = lVersion;
        if (this.version.version !== this.lVersion.version) {
          this.t2 = new Date().getMilliseconds();
          this.t = this.t2 - this.t1;
          this.message = 'Update found in' + this.t + 'ms:';
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

  async time1(): Promise<number> {
    const t = new Date().getMilliseconds();
    return t;
  }
}

