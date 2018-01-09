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
public class Pi4Java_test
{
    public static void main(String[] args) throws InterruptedException
    {
        System.out.println("Start");
        
        final GpioController gpio = GpioFactory.getInstance();
        final GpioPinDigitalOutput pin01_1 = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_01,"myLED",PinState.HIGH);
        pin01_1.setShutdownOptions(true, PinState.LOW);
        
        System.out.println("gpio: Pin still HIGH");
        
        final GpioController gpio2 = GpioFactory.getInstance();
        final GpioPinDigitalOutput pin01_2 = gpio2.provisionDigitalOutputPin(RaspiPin.GPIO_01,"myLED",PinState.HIGH);
        pin01_2.setShutdownOptions(true, PinState.LOW);
        
        System.out.println("gpio2: " + pin01_2.getPin() + " is " + pin01_2.getState());
        
        TimeUnit.SECONDS.sleep(5);
        
        // turn off pin
        pin01_1.low();
        
        System.out.println("Pin is LOW");
        
        pin01_1.high(); // PinState High
        
        pin01_1.toggle(); // Pinstate Low
        
        gpio.shutdown();
        
        System.out.println("Stop");
    }
}
