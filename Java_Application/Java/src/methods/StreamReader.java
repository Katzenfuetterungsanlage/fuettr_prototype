/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package methods;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

/**
 *
 * @author Florian
 */

public class StreamReader
{
    
    private String text;

    public StreamReader(String text)
    {
        this.text = text; 
        
       einlesen();                
    }
    
    private void einlesen()
    {
        try (final BufferedReader reader = new BufferedReader( //fasst in blöcke zusammen
                        new InputStreamReader(new FileInputStream("D:\\Schule\\Diplomarbeit\\Git\\fuettr_prototype\\Java_Application\\Java\\src\\data\\test.txt"),"utf8"))) //in doInBackground kann nur auf final Objekte zugegriffen werden - file2
        {
            text = reader.readLine();
        }
        catch (Exception ex)
        {
            ex.printStackTrace();
        }
    }

    public String getText()
    {
        return text;
    }

    
}
