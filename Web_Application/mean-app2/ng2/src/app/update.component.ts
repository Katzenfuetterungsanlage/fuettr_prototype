import { Component, OnInit } from '@angular/core';
import { UpdateService } from './update.service';

@Component({
  selector: 'app-update',
  templateUrl: './update.component.html',
})
export class UpdateComponent implements OnInit {

  private message: string;
  private show = false;

  constructor(private updateService: UpdateService) { }

  update() {
    this.updateService.getUpdate();
  }

  ngOnInit() {
    this.message = 'Checking for updates...';
    setTimeout(() => {
      this.message = 'Update found';
      this.show = true;
    }, 5000);
  }
}
