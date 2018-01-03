/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calc;

// Controller
import com.pi4j.io.gpio.GpioController;
import com.pi4j.io.gpio.GpioFactory;
import com.pi4j.io.gpio.GpioPinDigitalOutput;
import com.pi4j.io.gpio.PinState;
import com.pi4j.io.gpio.RaspiPin;

//Listener
import com.pi4j.io.gpio.*;
import com.pi4j.io.gpio.event.GpioPinDigitalStateChangeEvent;
import com.pi4j.io.gpio.event.GpioPinListenerDigital;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author Florian
 */

/*
    Notification:
    sensor1: bowl
        GPIO_00
    sensor2: conveyor belt - feed bag
        GPIO_01
    engine1: bowl
        Transistor_1.1 GPIO_02
        Transistor_1.2 GPIO_03
        Transistor_1.3 GPIO_04
        Transistor_1.4 GPIO_05
    engine2: conveyor belt - feed bag
        Transistor_2.1 GPIO_06
        Transistor_2.2 GPIO_07
        Transistor_2.3 GPIO_08
        Transistor_2.4 GPIO_09

    1-4 -> clockwise
    2-3 -> counterclockwise

    transistor is active when voltage is supplied => pin state = high
    sensor return high when the object is in front of it
*/

public class FeedingCycle
{
    // 1. check if a feed bag is available
    
    // 2. check the position of the bowl
    
    // 3. move bowl to the filling location
    
    // 4. check the position of the bowl again
    
    // 5. check position of the feed  bag -> wrong position -> move conveyor belt
    
    // 6. move conveyor belt until the next feed bag reaches the sensor = filling the bowl
    
    // 7. move bowl to the feeding location
    
    public void feed ()
    {
        // bowl  
        int bowlIndex = 1;
        // number of usages
        int bowlUsageIndex = 0;
        
        final GpioController gpio = GpioFactory.getInstance();
        
        // sensor2: conveyor belt - feed bag -> GPIO_01
        final GpioPinDigitalInput pin01 = gpio.provisionDigitalInputPin(RaspiPin.GPIO_01,PinPullResistance.PULL_DOWN);
        pin01.setShutdownOptions(true);
        
        // sensor1: bowl -> GPIO_00
        final GpioPinDigitalInput pin00 = gpio.provisionDigitalInputPin(RaspiPin.GPIO_00,PinPullResistance.PULL_DOWN);
        pin00.setShutdownOptions(true);
        
        // engine1: bowl -> Transistor_1.1 -> GPIO_02
        final GpioPinDigitalOutput pin02 = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_02  ,PinState.HIGH);
        pin02.setShutdownOptions(true, PinState.LOW);
        
        // engine1: bowl -> Transistor_1.2 -> GPIO_03
        final GpioPinDigitalOutput pin03 = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_03  ,PinState.HIGH);
        pin03.setShutdownOptions(true, PinState.LOW);
        
        // engine1: bowl -> Transistor_1.3 -> GPIO_04
        final GpioPinDigitalOutput pin04 = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_04  ,PinState.HIGH);
        pin04.setShutdownOptions(true, PinState.LOW);
        
        // engine1: bowl -> Transistor_1.4 -> GPIO_05
        final GpioPinDigitalOutput pin05 = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_05  ,PinState.HIGH);
        pin05.setShutdownOptions(true, PinState.LOW);
        
        // engine2: conveyor belt - feed bag -> Transistor_2.1 -> GPIO_06
        final GpioPinDigitalOutput pin06 = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_06  ,PinState.HIGH);
        pin06.setShutdownOptions(true, PinState.LOW);
        
        // engine2: conveyor belt - feed bag -> Transistor_2.2 -> GPIO_07
        final GpioPinDigitalOutput pin07 = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_07  ,PinState.HIGH);
        pin07.setShutdownOptions(true, PinState.LOW);
        
        // engine2: conveyor belt - feed bag -> Transistor_2.3 -> GPIO_08
        final GpioPinDigitalOutput pin08 = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_08  ,PinState.HIGH);
        pin08.setShutdownOptions(true, PinState.LOW);
        
        // engine2: conveyor belt - feed bag -> Transistor_2.4 -> GPIO_09
        final GpioPinDigitalOutput pin09 = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_09  ,PinState.HIGH);
        pin09.setShutdownOptions(true, PinState.LOW);
        
        // 1. check if a feed bag is available
        if (pin01.getState() == PinState.HIGH)
        {
            String str = pin01.getPin() + "=" + pin01.getState(); 
            Logger.getLogger(str).log(Level.FINE, str);
            
            // 2. check the position of the bowl
            if (pin00.getState() != PinState.HIGH)
            {
                // 3. move bowl to the filling location
                pin02.high();
                pin05.high();
                
                // position reached
                if (pin00.getState() == PinState.HIGH)
                {
                    pin02.low();
                    pin05.low();
                }     
            }
            
            // 4. check the position of the bowl again
            if (pin00.getState() == PinState.HIGH)
            {
                // 5. check position of the feed  bag -> wrong position -> move conveyor belt
                // should be in position - according to the first check
                
                if (bowlUsageIndex <= 4)
                {
                    // 6. move conveyor belt until the next feed bag reaches the sensor = filling the bowl
                    pin06.high();
                    pin09.high();
                    
                    // position reached
                    if (pin01.getState() == PinState.HIGH)
                    {
                        pin06.low();
                        pin09.low();
                    }  
                    
                    // +1 to the number of usages
                    bowlUsageIndex++;
                }
                else
                {
                    pin06.high();
                    pin09.high();
                    
                    // position reached
                    if (pin01.getState() == PinState.HIGH)
                    {
                        pin06.low();
                        pin09.low();
                    }
                    
                    // use the next bowl
                    bowlIndex++;
                    // new bowl, number of usages = 0
                    bowlUsageIndex = 0;
                }
            }
            else
            {
                // Sollte nie vorkommen
            }            
        }
        else
        {
            Logger.getLogger("No feeding bag left!").log(Level.SEVERE, "No feeding bag left!");
        }
    }
}
