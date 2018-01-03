/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import com.pi4j.io.gpio.GpioController;
import com.pi4j.io.gpio.GpioFactory;
import com.pi4j.io.gpio.GpioPinDigitalOutput;
import com.pi4j.io.gpio.PinState;
import com.pi4j.io.gpio.RaspiPin;
import java.util.concurrent.TimeUnit;

/**
 *
 * @author Florian
 */
public class Pi4Java_gpioController
{
    public static void main(String[] args) throws InterruptedException
    {
        System.out.println("Start");
        
        // create gpio Controller
        final GpioController gpio = GpioFactory.getInstance();
        
        // set gpio pin #01 as an output and turn on
        final GpioPinDigitalOutput pin = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_01,"myLED",PinState.HIGH);
        
        // set shutdown state for this pin
        pin.setShutdownOptions(true, PinState.LOW);
        
        System.out.println("Pin still HIGH");
        
        TimeUnit.SECONDS.sleep(5);
        
        // turn off pin
        pin.low();
        
        System.out.println("Pin is LOW");
        
        pin.high(); // PinState High
        
        pin.toggle(); // Pinstate Low
        
        gpio.shutdown();
        
        System.out.println("Stop");
    }
}
