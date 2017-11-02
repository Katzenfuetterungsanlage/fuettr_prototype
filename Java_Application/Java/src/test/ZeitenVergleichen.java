/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import gui.ZeitenManagement;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;
import methods.StreamReader;

/**
 *
 * @author Florian
 */
public class ZeitenVergleichen
{
    
    public static void main(String[] args)
    {
        Date date1 = null,date2 = null,date3 = null,date4 = null;
        
        StreamReader streamReader = new StreamReader(); 
        String string = streamReader.einlesen("D:\\Schule\\Diplomarbeit\\Git\\fuettr_prototype\\Java_Application\\Java\\src\\data\\testZeit.txt");
        
        //test
        System.out.format("%s %n",string);
        
        String[] token = string.split(";"); 
        String zeit1 = token[0];
        String zeit2 = token[1];
        String zeit3 = token[2];
        String zeit4 = token[3];    
        
        //test
        System.out.format("%s %n",zeit1);
        System.out.format("%s %n",zeit2);
        System.out.format("%s %n",zeit3);
        System.out.format("%s %n",zeit4);
        
        DateFormat format = new SimpleDateFormat("HH:mm", Locale.GERMANY);
        try
        {
            date1 = format.parse(zeit1);
            date2 = format.parse(zeit2);
            date3 = format.parse(zeit3);
            date4 = format.parse(zeit4);
        } catch (ParseException ex)
        {
            Logger.getLogger(ZeitenManagement.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        if (zeit1.equals(zeit2))
        {
            System.out.println("Zeit1 = Zeit2");
        }
        else
        {
            System.out.println("Zeit1 != Zeit2");
        }
        
        if (date1.before(date2) )
        {
            System.out.println("Zeit1 vor Zeit2");
        }
        else
        {
            System.out.println("Zeit1 !vor Zeit2");
        }
    }
            
}
