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
    public String naechsteFuetterung(int letzteFuetterung, String zeiten)
    {
        Date date1 = null,date2 = null,date3 = null,date4 = null, dateUhrzeit = null;
        String naechsteFuetterungUm = null, naechsteFuetterungIn = null; 
        
        long diffInMillis;
        
        String d = String.format("%1$tH:%1$tM", new Date(System.currentTimeMillis()));
        
       //Test
       //System.out.format("%n %s %n",dateUhrzeit);
        
        String[] token = zeiten.split(";"); 
            String zeit1 = token[0];
            String zeit2 = token[1];
            String zeit3 = token[2];
            String zeit4 = token[3]; 
            String b1 = token[4];
            String b2 = token[5];
            String b3 = token[6];
            String b4 = token[7];
        
        DateFormat format = new SimpleDateFormat("HH:mm", Locale.GERMANY);
        try
        {
            date1 = format.parse(zeit1);
            date2 = format.parse(zeit2);
            date3 = format.parse(zeit3);
            date4 = format.parse(zeit4);
            dateUhrzeit = format.parse(d); 
        } catch (ParseException ex)
        {
            Logger.getLogger(NaechsteFuetterung.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        MilliZuStundenUndMinuten milliZuStdUndMin = new MilliZuStundenUndMinuten();
        
        
        
        switch(letzteFuetterung)
        {
            case 1:
                naechsteFuetterungUm = zeit2;
                diffInMillis = date2.getTime() - dateUhrzeit.getTime();
                //Test
//                System.out.format("Differenz: %s %n",diffInMillis);
//                naechsteFuetterungIn = String.format("%1$tH:%1$tM", new Date(diffInMillis));
                naechsteFuetterungIn = milliZuStdUndMin.rechnen(diffInMillis);
                //Test
//                System.out.format("Differenz: %s %n",naechsteFuetterungIn);
                break; 
                
            case 2:
                naechsteFuetterungUm = zeit3;
                diffInMillis = date3.getTime() - dateUhrzeit.getTime();
                //Test
//                System.out.format("Differenz: %s %n",diffInMillis);
//                naechsteFuetterungIn = String.format("%1$tH:%1$tM", new Date(diffInMillis));
                naechsteFuetterungIn = milliZuStdUndMin.rechnen(diffInMillis);
                //Test
//                System.out.format("Differenz: %s %n",naechsteFuetterungIn);
                break;
            
            case 3:
                naechsteFuetterungUm = zeit4;
                diffInMillis =date4.getTime() - dateUhrzeit.getTime();
                //Test
//                System.out.format("Differenz: %s %n",diffInMillis);
//                naechsteFuetterungIn = String.format("%1$tH:%1$tM", new Date(diffInMillis));
                naechsteFuetterungIn = milliZuStdUndMin.rechnen(diffInMillis);
                //Test
//                System.out.format("Differenz: %s %n",naechsteFuetterungIn);
                break;
            
            case 4:
                naechsteFuetterungUm = zeit1;
                diffInMillis = - date1.getTime() - dateUhrzeit.getTime();
                //Test
//                System.out.format("Differenz: %s %n",diffInMillis);
//                naechsteFuetterungIn = String.format("%1$tH:%1$tM", new Date(diffInMillis));
                naechsteFuetterungIn = milliZuStdUndMin.rechnen(diffInMillis);
                //Test
//                System.out.format("Differenz: %s %n",naechsteFuetterungIn);
                break;
                
            default: 
                if (date1.before(dateUhrzeit) && date2.after(dateUhrzeit))
                {
                    naechsteFuetterungUm = zeit2; 
                    diffInMillis = date2.getTime() - dateUhrzeit.getTime();
                    //Test
//                    System.out.format("Differenz: %s %n",diffInMillis);
//                    naechsteFuetterungIn = String.format("%1$tH:%1$tM", new Date(diffInMillis));
                    naechsteFuetterungIn = milliZuStdUndMin.rechnen(diffInMillis);
                    //Test
//                    System.out.format("Differenz: %s %n",naechsteFuetterungIn);
                }
                
                if (date2.before(dateUhrzeit) && date3.after(dateUhrzeit))
                {
                    naechsteFuetterungUm = zeit3;
                    diffInMillis = date3.getTime() - dateUhrzeit.getTime();
                    //Test
//                    System.out.format("Differenz: %s %n",diffInMillis);
//                    naechsteFuetterungIn = String.format("%1$tH:%1$tM", new Date(diffInMillis));
                    naechsteFuetterungIn = milliZuStdUndMin.rechnen(diffInMillis);
                    //Test
//                    System.out.format("Differenz: %s %n",naechsteFuetterungIn);
                }
                    
                if (date3.before(dateUhrzeit) && date4.after(dateUhrzeit))
                {
                    naechsteFuetterungUm = zeit4;
                    diffInMillis =date4.getTime() - dateUhrzeit.getTime();
                    //Test
//                    System.out.format("Differenz: %s %n",diffInMillis);
//                    naechsteFuetterungIn = String.format("%1$tH:%1$tM", new Date(diffInMillis));
                    naechsteFuetterungIn = milliZuStdUndMin.rechnen(diffInMillis);
                    //Test
//                    System.out.format("Differenz: %s %n",naechsteFuetterungIn);
                }
                    
                if (date4.before(dateUhrzeit) && date1.after(dateUhrzeit))
                {
                    naechsteFuetterungUm = zeit1;
                    diffInMillis = - date1.getTime() - dateUhrzeit.getTime();
                    //Test
//                    System.out.format("Differenz: %s %n",diffInMillis);
//                    naechsteFuetterungIn = String.format("%1$tH:%1$tM", new Date(diffInMillis));
                    naechsteFuetterungIn = milliZuStdUndMin.rechnen(diffInMillis);
                    //Test
//                    System.out.format("Differenz: %s %n",naechsteFuetterungIn);
                }
                break; 
        }
        
        String rueckgabewert = naechsteFuetterungUm + ";" + naechsteFuetterungIn;
        
        //Test
        //System.out.format("Nächste Fütterung in und um: %s und %s%n",naechsteFuetterungIn,naechsteFuetterungUm);
        
        return rueckgabewert;
    }
}
