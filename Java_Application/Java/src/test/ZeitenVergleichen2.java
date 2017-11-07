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
import java.util.logging.Level;
import java.util.logging.Logger;
import methods.StreamReader;
import java.util.Date;
import java.util.Locale;

/**
 *
 * @author Florian
 */
public class ZeitenVergleichen2
{
    public static void main(String[] args)
    {
        Date date1 = null,date2 = null,date3 = null,date4 = null, dateUhrzeit = null;
        
        //Date uhrzeit = new Date(System.currentTimeMillis());
        String d = String.format("%1$tH:%1$tM", new Date(System.currentTimeMillis()));
        
        //System.out.println(uhrzeit);
        System.out.println(d);
        
        StreamReader streamReader = new StreamReader(); 
        String string = streamReader.einlesen("D:\\Schule\\Diplomarbeit\\Git\\fuettr_prototype\\Java_Application\\Java\\src\\data\\testZeit.txt",true);
        
        System.out.format("String s: %s %n",string);
        System.out.format("String d: %s %n",d);
        
        String[] token = string.split(";"); 
        String zeit1 = token[0];
        String zeit2 = token[1];
        String zeit3 = token[2];
        String zeit4 = token[3]; 
        
        DateFormat format = new SimpleDateFormat("HH:mm", Locale.GERMANY);
        try
        {
            date1 = format.parse(zeit1);
            date2 = format.parse(zeit2);
            date3 = format.parse(zeit3);
            date4 = format.parse(zeit4);
            dateUhrzeit = format.parse(d);
        } 
        catch (ParseException ex)
        {
            Logger.getLogger(ZeitenManagement.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        System.out.format("date1: %s %n",date1);
        System.out.format("dateUhrzeit: %s %n",dateUhrzeit);
        
        if(date1.after(dateUhrzeit) == true)
        {
            System.out.println("date1 ist nach der aktuellen Uhrzeit");
        }
        else
        {
            System.out.println("date1 vor der aktuelle uhrzeit");
        }
            
    }
  
            
}
