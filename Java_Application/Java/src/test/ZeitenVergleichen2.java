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
import java.util.concurrent.TimeUnit;
import methods.DatumPlusEinTag;

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
        
        //date1 + 1 Tag
        long millis = date1.getTime();
        millis = millis + (24*1000*3600);
        Date date1und1Tag = new Date(millis);
        System.out.format("date1 + 1 Tag: %s %n",date1und1Tag);
        
        //dateUhrzeit + 1 Tag
        millis = dateUhrzeit.getTime();
        millis = millis + (24*1000*3600);
        Date dateUhrzeitund1Tag = new Date(millis);
        System.out.format("dateUhrzeit + 1 Tag: %s %n",dateUhrzeitund1Tag);
        
        //eigene Methode Test
        DatumPlusEinTag datumPlusEinTag = new DatumPlusEinTag();
        Date testDateUhrzeitPlus = datumPlusEinTag.rechnen(dateUhrzeit);
        System.out.format("dateUhrzeit + 1 Tag eigene Methode: %s %n",testDateUhrzeitPlus);
        
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
        
        if (date1.compareTo(dateUhrzeit) > 0)
            {
            System.out.println(".compareTo: date1 ist nach der aktuellen Uhrzeit");
        }
        else
        {
            System.out.println(".compareTo: date1 vor der aktuelle uhrzeit");
        }
        
        if(dateUhrzeit.after(date1) == true && dateUhrzeit.before(date2))
        {
            System.out.println("die aktuelle Uhrzeit ist zwischen date1 und date2");
        }
        else
        {
            System.out.println("die aktuelle Uhrzeit ist nicht zwischen date1 und date2");
        }
        
        if(dateUhrzeitund1Tag.after(date4) == true && dateUhrzeitund1Tag.before(date1und1Tag))
        {
            System.out.println("die aktuelle Uhrzeit ist zwischen date4 und date1");
        }
        else
        {
            System.out.println("die aktuelle Uhrzeit ist nicht zwischen date4 und date1");
        }
        
          if(datumPlusEinTag.rechnen(dateUhrzeit).after(date4) == true && datumPlusEinTag.rechnen(dateUhrzeit).before(datumPlusEinTag.rechnen(date1)))
        {
            System.out.println("die aktuelle Uhrzeit ist zwischen date4 und date1");
        }
        else
        {
            System.out.println("die aktuelle Uhrzeit ist nicht zwischen date4 und date1");
        }
        
    }
  
            
}
