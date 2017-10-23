import { Component, OnInit } from '@angular/core';
import { UpdateService } from './update.service';
import { Http } from '@angular/http';


@Component({
  selector: 'app-update',
  templateUrl: './update.component.html',
})
export class UpdateComponent implements OnInit {

  private message: string;
  private show = false;
  private test: string;

  constructor(private updateService: UpdateService) { }

  update() {
    this.test = 'Works net';
    this.updateService.getUpdate();
  }

  ngOnInit() {
    this.message = 'Checking for updates...';
    setTimeout(() => {
      this.message = 'Update found';
      this.show = true;
    }, 2550);
  }
}
