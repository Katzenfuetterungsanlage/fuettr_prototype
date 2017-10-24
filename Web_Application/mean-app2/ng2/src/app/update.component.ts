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

  constructor(private updateService: UpdateService) { }

  update() {
    this.updater = 'in progress...';
    this.updateService.getUpdate();
  }

  refresh() {
    this.message = 'Checking for updates...';

    this.updateService.checkUpdate().then((version) => {
      this.version = version;
      this.updateService.getVersion().then((lVersion) => {
        this.lVersion = lVersion;
        if (this.version.version !== this.lVersion.version) {
          this.message = 'Update found:';
          this.show = true;
          this.newVersion = this.version.version.toString();
        } else {
          this.message = 'Up do date';
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

    this.updateService.checkUpdate().then((version) => {
      this.version = version;
      this.updateService.getVersion().then((lVersion) => {
        this.lVersion = lVersion;
        if (this.version.version !== this.lVersion.version) {
          this.message = 'Update found:';
          this.show = true;
          this.newVersion = this.version.version.toString();
        } else {
          this.message = 'Up do date';
        }
      }).catch((err) => {
        alert(err);
      });
    }).catch((err) => {
      alert(err);
    });
  }
}

