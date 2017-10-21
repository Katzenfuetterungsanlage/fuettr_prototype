import { Component } from '@angular/core';
import { UpdateService } from './update.service';

@Component({
  selector: 'app-update',
  templateUrl: './update.component.html',
})
export class UpdateComponent {

  private message: string;
  private show = false;

  constructor(private updateService: UpdateService) { }

  update() {
    this.updateService.getUpdate();
  }

  checkUpdate() {
    this.message = 'Checking for updates...';
    setTimeout(() => {
      this.message = 'Update found';
      this.show = true;
    }, 5000);
  }
}
