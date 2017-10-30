/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

/**
 *
 * @author Florian
 */
public class StreamReaderTest
{
    private String text, text2, text3, text4;
    
    public StreamReaderTest()
    {
       einlesen();   
       
        System.out.format("%s%n",text);
        System.out.format("%s%n",text2);
        System.out.format("%s%n",text3);
        System.out.format("%s%n",text4);
    }
    
    private void einlesen()
    {
        try (final BufferedReader reader = new BufferedReader( //fasst in blöcke zusammen
                        new InputStreamReader(new FileInputStream("D:\\Schule\\Diplomarbeit\\Git\\fuettr_prototype\\Java_Application\\Java\\src\\data\\test.txt"),"utf8"))) //in doInBackground kann nur auf final Objekte zugegriffen werden - file2
        {
            text = reader.readLine();
            text2 = reader.readLine();
            text3 = reader.readLine();
            text4 = reader.readLine();
        }
        catch (Exception ex)
        {
            ex.printStackTrace();
        }
    }
    
    public static void main(String[] args)
    {
        new StreamReaderTest();
    }
}
