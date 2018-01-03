/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import com.pi4j.io.gpio.*;
import com.pi4j.io.gpio.event.GpioPinDigitalStateChangeEvent;
import com.pi4j.io.gpio.event.GpioPinListenerDigital;
import java.util.concurrent.TimeUnit;

/**
 *
 * @author Florian
 */
public class Pi4Java_gpioListener
{
    public static void main(String[] args) throws InterruptedException
    {
        System.out.println("Start");
        
        //create gpio Controller
        final GpioController gpio = GpioFactory.getInstance();
        
        //set gpio pin #02 as in input with its internal pull down resistor enabled
        final GpioPinDigitalInput pin = gpio.provisionDigitalInputPin(RaspiPin.GPIO_02,PinPullResistance.PULL_DOWN);
        
        //set shutdown state for this pin
        pin.setShutdownOptions(true);
        
        //create and register gpio listener
        pin.addListener(new GpioPinListenerDigital() {
            @Override
            public void handleGpioPinDigitalStateChangeEvent(GpioPinDigitalStateChangeEvent event)
            {
                // display pin state on console
                System.out.println("PinState: " + event.getPin() + "=" + event.getState());
            }
            
        });
        
        System.out.println("Listerner working");
        
        //keep running until user aborts (CTRL-C)
//        while (true)
//        {
//            TimeUnit.MILLISECONDS.sleep(500);
//        }
        
        // stop all GPIO activity/threads by shutting down the GPIO controller
        // forcefully shutdown all threads and tasks
        gpio.shutdown();
    }
}
