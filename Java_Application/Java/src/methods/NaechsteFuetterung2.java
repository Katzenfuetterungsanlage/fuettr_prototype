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
public class NaechsteFuetterung2
{
    public String naechsteFuetterung(int letzteFuetterung, String zeit1, String zeit2, String zeit3, String zeit4)
    {
        Date date1 = null,date2 = null,date3 = null,date4 = null;
        
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
        
        switch(letzteFuetterung)
        {
            case 1:
                if (date2.after(date1) && date2.before(date3) && date2.before(date4))
                    return zeit2; 
                if (date3.after(date1) && date3.before(date2) && date3.before(date4))
                    return zeit3; 
                if (date4.after(date1) && date4.before(date2) && date4.before(date3))
                    return zeit4; 
                break; 
                
            case 2:
                if (date1.after(date2) && date1.before(date3) && date1.before(date4))
                    return zeit1; 
                if (date3.after(date2) && date3.before(date1) && date3.before(date4))
                    return zeit3; 
                if (date4.after(date2) && date4.before(date1) && date4.before(date3))
                    return zeit4;
                break;
            
            case 3:
                if (date1.after(date3) && date1.before(date2) && date1.before(date4))
                    return zeit1; 
                if (date2.after(date3) && date2.before(date1) && date2.before(date4))
                    return zeit2; 
                if (date4.after(date3) && date4.before(date1) && date4.before(date2))
                    return zeit4;
                break;
            
            case 4:
                if (date1.after(date4) && date1.before(date2) && date2.before(date3))
                    return zeit1; 
                if (date2.after(date4) && date2.before(date1) && date3.before(date3))
                    return zeit2; 
                if (date3.after(date4) && date3.before(date1) && date4.before(date2))
                    return zeit3;
                break;
                
            default: 
                if (date1.before(date2) && date1.before(date3) && date1.before(date4))
                    return zeit1;
                if (date2.before(date1) && date2.before(date3) && date2.before(date4))
                    return zeit2;
                if (date3.before(date1) && date3.before(date2) && date2.before(date4))
                    return zeit3;
                if (date4.before(date1) && date4.before(date2) && date4.before(date3))
                    return zeit4;
        }
        return null;
    }
}
