import { Component, OnInit } from '@angular/core';
import { HttpgetService } from './httpget.service';

@Component({
  selector: 'app-position',
  templateUrl: './position.component.html',
})
export class PositionComponent implements OnInit {
  private motor1: string;
  private motor2: string;
  private sensor1: string;
  private sensor2: string;

  constructor(private httpgetService: HttpgetService) { }

  ngOnInit(): void {
    this.httpgetService.getPositions().then(res => {
      this.motor1 = res.motor1;
      this.motor2 = res.motor2;
      this.sensor1 = res.sensor1;
      this.sensor2 = res.sensor2;
    });
  }
}
