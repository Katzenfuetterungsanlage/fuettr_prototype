/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package methods;

import gui.ZeitenManagement;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Florian
 */
public class NaechsteFuetterung
{
    public String naechsteFuetterung(int letzteFuetterung, String zeit1, String zeit2, String zeit3, String zeit4, String naechsteFuetterungUm, String naechsteFuetterungIn, String uhrzeit)
    {
        Date date1 = null,date2 = null,date3 = null,date4 = null, dateUhrzeit = null;
        
        long diffInMillies;
        
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
                diffInMillies =date4.getTime() - dateUhrzeit.getTime();
                System.out.format("Differenz: %s %n",diffInMillies);
                naechsteFuetterungIn = String.format("%1$tH:%1$tM", new Date(diffInMillies));
                System.out.format("Differenz: %s %n",naechsteFuetterungIn);
                break;
            
            case 4:
                naechsteFuetterungUm = zeit1;
                diffInMillies = - date1.getTime() - dateUhrzeit.getTime();
                System.out.format("Differenz: %s %n",diffInMillies);
                naechsteFuetterungIn = String.format("%1$tH:%1$tM", new Date(diffInMillies));
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
        return naechsteFuetterungUm + ";" + naechsteFuetterungIn;
    }
}
