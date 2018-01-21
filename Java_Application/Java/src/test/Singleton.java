/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import com.pi4j.io.gpio.GpioController;
import com.pi4j.io.gpio.GpioFactory;
import com.pi4j.io.gpio.GpioPinDigitalInput;
import com.pi4j.io.gpio.PinPullResistance;
import com.pi4j.io.gpio.RaspiPin;

/**
 *
 * @author Florian
 */
public class Singleton
{
  final GpioController gpio;
  final GpioPinDigitalInput pin01;

  private static Singleton instance = null;

  protected Singleton()
  {
    gpio = GpioFactory.getInstance();
    // sensor2: conveyor belt - feed bag -> GPIO_01
    pin01 = gpio.provisionDigitalInputPin(RaspiPin.GPIO_01, PinPullResistance.PULL_DOWN);
    pin01.setShutdownOptions(true);
  }

  public static Singleton getInstance()
  {
    if (instance == null)
    {
      instance = new Singleton();
    }
    return instance;
  }

  public void sout()
  {
    System.out.println("it is working i guess");
  }
  
  public void showPinState()
  {
    System.out.println("PinState: " + pin01.getName() + "=" + pin01.getState());
  }
  
  public void ControllerShowdown ()
  {
    gpio.shutdown();
  }
}
