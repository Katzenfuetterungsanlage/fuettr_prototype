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
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.SwingWorker;
import methods.StreamReader;


/**
 *
 * @author Florian
 */
public class NaechsteZeitTest
{
    String zeit1,zeit2,zeit3,zeit4, uhrzeit, naechsteFuetterungUm, naechsteFuetterungIn, stringHilfe;
     
    String naechsteFuetterung; 
    
    long diffInMillies;

    public NaechsteZeitTest() throws ParseException
    {        
        StreamReader streamReader = new StreamReader(); 
        String string = streamReader.einlesen("D:\\Schule\\Diplomarbeit\\Git\\fuettr_prototype\\Java_Application\\Java\\src\\data\\testZeit.txt");
        
        //test
        System.out.format("%s %n",string);
        
        String[] token = string.split(";"); 
        zeit1 = token[0];
        zeit2 = token[1];
        zeit3 = token[2];
        zeit4 = token[3];    
        
        //test
        System.out.format("%s %n",zeit1);
        System.out.format("%s %n",zeit2);
        System.out.format("%s %n",zeit3);
        System.out.format("%s %n",zeit4);
        
        naechsteFuetterung();
        
        System.out.format("Nächste Fütterung: %s %n",naechsteFuetterungUm);
        
    }
    
    public static void main(String[] args) throws ParseException
    {
        new  NaechsteZeitTest();
    }
    
    private void naechsteFuetterung() throws ParseException
    {
        uhrzeit = String.format("%1$tH:%1$tM", new Date(System.currentTimeMillis()));
        
        System.out.format("Uhrzeit: %s%n",uhrzeit);
        
        Date date1 = null,date2 = null,date3 = null,date4 = null;
        Date dateUhrzeit = null, dateHilfe = null; 
        
        DateFormat format = new SimpleDateFormat("HH:mm", Locale.GERMANY);
        try
        {
            date1 = format.parse(zeit1);
            date2 = format.parse(zeit2);
            date3 = format.parse(zeit3);
            date4 = format.parse(zeit4);
            dateUhrzeit = format.parse(uhrzeit); 
        } catch (ParseException ex)
        {
            Logger.getLogger(ZeitenManagement.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        int letzteFuetterung = 4;
//        
//        long diffInMillies = dateUhrzeit.getTime() - date1.getTime();
//        
//        System.out.format("Differenz: %s %n",diffInMillies);
//        
//        String differenzZeit = String.format("%1$tH:%1$tM", new Date(diffInMillies));
//        
//        System.out.format("Differenz: %s %n",differenzZeit);
        
        switch(letzteFuetterung)
        {
            case 1:
                naechsteFuetterungUm = zeit2;
                diffInMillies = date2.getTime() - dateUhrzeit.getTime();
                System.out.format("Differenz: %s %n",diffInMillies);
                naechsteFuetterungIn = String.format("%1$tH:%1$tM", new Date(diffInMillies));
                System.out.format("Differenz: %s %n",naechsteFuetterungIn);
                break; 
                
            case 2:
                naechsteFuetterungUm = zeit3;
                diffInMillies = date3.getTime() - dateUhrzeit.getTime();
                System.out.format("Differenz: %s %n",diffInMillies);
                naechsteFuetterungIn = String.format("%1$tH:%1$tM", new Date(diffInMillies));
                System.out.format("Differenz: %s %n",naechsteFuetterungIn);
                break;
            
            case 3:
                naechsteFuetterungUm = zeit4;
                diffInMillies = date4.getTime() - dateUhrzeit.getTime();
                System.out.format("Differenz: %s %n",diffInMillies);
                naechsteFuetterungIn = String.format("%1$tH:%1$tM", new Date(diffInMillies));
                System.out.format("Differenz: %s %n",naechsteFuetterungIn);
                break;
            
            case 4:
                naechsteFuetterungUm = zeit1;
                diffInMillies = date1.getTime() - dateUhrzeit.getTime();
                System.out.format("Differenz: %s %n",diffInMillies); //mit Taschenrechner gerechnet richtig
                naechsteFuetterungIn = String.format("%1$tH:%1$tM", new Date(diffInMillies)); //eine Stunde zu viel, diffInMillies stimmen - mit TR kontrolliert
                System.out.format("Differenz: %s %n",naechsteFuetterungIn);
                break;
                
            default: 
                if (date1.before(dateUhrzeit) && date2.after(dateUhrzeit))
                {
                    naechsteFuetterungUm = zeit2; 
                    diffInMillies = date2.getTime() - dateUhrzeit.getTime();
                    System.out.format("Differenz: %s %n",diffInMillies);
                    naechsteFuetterungIn = String.format("%1$tH:%1$tM", new Date(diffInMillies));
                    System.out.format("Differenz: %s %n",naechsteFuetterungIn);
                }
                
                if (date2.before(dateUhrzeit) && date3.after(dateUhrzeit))
                {
                    naechsteFuetterungUm = zeit3;
                    diffInMillies = date3.getTime() - dateUhrzeit.getTime();
                    System.out.format("Differenz: %s %n",diffInMillies);
                    naechsteFuetterungIn = String.format("%1$tH:%1$tM", new Date(diffInMillies));
                    System.out.format("Differenz: %s %n",naechsteFuetterungIn);
                }
                    
                if (date3.before(dateUhrzeit) && date4.after(dateUhrzeit))
                {
                    naechsteFuetterungUm = zeit4;
                    diffInMillies =date4.getTime() - dateUhrzeit.getTime();
                    System.out.format("Differenz: %s %n",diffInMillies);
                    naechsteFuetterungIn = String.format("%1$tH:%1$tM", new Date(diffInMillies));
                    System.out.format("Differenz: %s %n",naechsteFuetterungIn);
                }
                    
                if (date4.before(dateUhrzeit) && date1.after(dateUhrzeit))
                {
                    naechsteFuetterungUm = zeit1;
                    diffInMillies = - date1.getTime() - dateUhrzeit.getTime();
                    System.out.format("Differenz: %s %n",diffInMillies);
                    naechsteFuetterungIn = String.format("%1$tH:%1$tM", new Date(diffInMillies));
                    System.out.format("Differenz: %s %n",naechsteFuetterungIn);
                }
        }
    }
}
