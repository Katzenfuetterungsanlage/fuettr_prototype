#include "global.h"

#include <stdio.h>
#include <string.h>

#include <avr/io.h>
#include <avr/interrupt.h>
#include <util/delay.h>

#include "app.h"
#include "sys.h"

// defines
// ...


// declarations and definations

volatile struct App app;


// functions

void app_init (void)
{
  memset((void *)&app, 0, sizeof(app));
  
}


//--------------------------------------------------------

void app_main (void)
{
  DDRD = (1<<PD3);
  DDRB = (1<<PB3);
  // TCCR0A = 0b10100011;
  //TCCR0B = 0b00000010;
  TCCR2A = (1<<COM2A1) | (1<<COM2B1) | (1<<WGM21) | (1<<WGM20);
  TCCR2B = (1<<CS21);
  OCR2A = 0x5f;
  OCR2B = 0x5f;
  
}

//--------------------------------------------------------

void app_task_1ms (void) {}
void app_task_2ms (void) {}
void app_task_4ms (void) {}
void app_task_8ms (void) {}
void app_task_16ms (void) {}
void app_task_32ms (void) {}
void app_task_64ms (void) {}
void app_task_128ms (void) {}



