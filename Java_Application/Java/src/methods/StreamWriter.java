/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package methods;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;

/**
 *
 * @author Florian
 */

public class StreamWriter
{
    public void schreiben(String pfad, String zeit1, String zeit2, String zeit3, String zeit4)
    {
        try (final BufferedWriter writer = 
            new BufferedWriter(
            new OutputStreamWriter(  //wird verwendet um eine Codierung wählen zu können1
            new FileOutputStream(pfad), "utf8"));) 
            // "AutoCloseable". Wird automatisch geschlossen wenn es in den runden Klammern steht. Wird von allen Streams unterstützt
        {
            writer.write(String.format(zeit1 + "%n"));
            writer.write(String.format(zeit2 + "%n"));
            writer.write(String.format(zeit3 + "%n"));
            writer.write(String.format(zeit4 + "%n"));
            System.out.println("It is working!");
        }
        catch (Exception ex)
        {
            ex.printStackTrace();
        }  
    }

}
