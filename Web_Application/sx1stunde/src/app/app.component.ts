import { Component } from '@angular/core';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  private title = 'app';
  private y = 27;
  private showImage = false;
  private time: string;
  private intervalID: any;
  private w = 1;
  private bob: string;

  constructor () {
    this.title = 'my first app' + this.y;
    this.showImage = true;
    this.changeImage();

    // setTimeout( () => {
    //   this.y = 100
    //   this.showImage = true;
    //   this.check();
    // }, 5000);

    // setTimeout(this.check.bind(this), 7000);

    this.intervalID = setInterval( () => {
      this.w++;
    }, 100)
  }

  private check () {
    this.showImage = this.y > 80;
  }

  public changeImage () {
  setInterval(() => {
this.bob = '../assets/Bob1.jpg';
setTimeout(() => {
  this.bob = '../assets/Bob2.jpg';
}, 250)
  }, 500);
}

}
