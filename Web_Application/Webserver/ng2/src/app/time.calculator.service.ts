import { Injectable } from '@angular/core';

@Injectable()
export class TimeCalculator {

    toMinutes(time: string): number {
        let timeHours = parseInt(time[0], 10) * 10;
        timeHours = timeHours + parseInt(time[1], 10);
        let timeMinutes = parseInt(time[3], 10) * 10;
        timeMinutes = timeMinutes + parseInt(time[4], 10);
        return timeHours * 60 + timeMinutes;
    }

    isValid(time: string): boolean {
        let timeHours = parseInt(time[0], 10) * 10;
        timeHours = timeHours + parseInt(time[1], 10);
        let timeMinutes = parseInt(time[3], 10) * 10;
        timeMinutes = timeMinutes + parseInt(time[4], 10);
        if (timeHours < 23) {
            if (timeMinutes < 59) {
                return true;
            }
        }
        return false;
    }
}
