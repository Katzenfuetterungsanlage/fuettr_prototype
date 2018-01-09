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

/**
 *
 * @author Florian
 */
public class Pi4Java_test_hand_pin_over
{
    private static void testCycle (GpioPinDigitalOutput pin01)
    {
        System.out.println("gpio2: " + pin01.getPin() + " is " + pin01.getState());
    }
    
    
    public static void main(String[] args)
    {
        final GpioController gpio = GpioFactory.getInstance();
        final GpioPinDigitalOutput pin01 = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_01,"myLED",PinState.HIGH);
        pin01.setShutdownOptions(true, PinState.LOW);
        
        pin01.high();
        
        testCycle(pin01);
        
    }
        
}


