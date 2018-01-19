/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

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
  }
  
  public static void main(String[] args)
  {
    new AccessSingleton();
  }
          
}
