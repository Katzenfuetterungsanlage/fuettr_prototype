/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package methods;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Florian
 */
public final class LoggerAndStreamWriter
{
    public static void logAndWrite (String message, String level)
    {
        StreamWriter writer = new StreamWriter();
        
        switch(level)
        {
            case "severe":
                Logger.getLogger(message).log(Level.SEVERE, message);
                writer.schreiben("D:\\Schule\\Diplomarbeit\\Git\\fuettr_prototype\\Java_Application\\Java\\src\\data\\testLogSevere.txt", message, false);
                break; 
                
            case "warning":
                Logger.getLogger(message).log(Level.WARNING, message);
                break;
                
            case "info":
                Logger.getLogger(message).log(Level.INFO, message);
                break;
                
            case "config":
                Logger.getLogger(message).log(Level.CONFIG, message);
                break;
                
            case "fine":
                Logger.getLogger(message).log(Level.FINE, message);
                break;
                
            case "finer":
                Logger.getLogger(message).log(Level.FINER, message);
                break;
                
            case "finest":
                Logger.getLogger(message).log(Level.FINEST, message);
                break;
        }
    }
    
    public static void main(String[] args)
    {
        logAndWrite("test-test","severe");
    }
}
