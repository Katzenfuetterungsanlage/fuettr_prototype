/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Florian
 */
public class AccessSingleton
{
  Singleton instance;
  
  public AccessSingleton()
  {
    instance = Singleton.getInstance();
    Singleton anotherInstance = new Singleton();
    
    instance.sout();
    anotherInstance.sout();
    
    int i;
    
    for (i=0;i<=20;i++)
    {
      instance.showPinState();
      try
      {
        TimeUnit.MILLISECONDS.sleep(500);
      } catch (InterruptedException ex)
      {
        Logger.getLogger(AccessSingleton.class.getName()).log(Level.SEVERE, null, ex);
      }
    }
  }
  
  public static void main(String[] args)
  {
    new AccessSingleton();
  }
          
}
