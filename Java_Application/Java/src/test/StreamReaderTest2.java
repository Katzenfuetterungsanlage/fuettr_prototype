/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import methods.StreamReader;

/**
 *
 * @author Florian
 */
public class StreamReaderTest2
{
    public static void main(String[] args)
    {
        String pfad = "D:\\\\Schule\\\\Diplomarbeit\\\\Git\\\\fuettr_prototype\\\\Java_Application\\\\Java\\\\src\\\\data\\\\test.txt"; 
        String string, zeit1 = "zeit1", zeit2 = "zeit2", zeit3 = "zeit3", zeit4 = "zeit4";
        
        int zahl = 100000;
        String stringZahl;
        
        stringZahl = Integer.toString(zahl); //Zahl in String umwandeln
        
        //zahl = Integer.parseInt(stringZahl); String in Zahl umwandeln
        
        StreamReader streamreader = new StreamReader(); 
        
        string = streamreader.einlesen(pfad); 
        
        System.out.format("%s %n",string);
        
        String[] token = string.split(";"); 
        zeit1 = token[0];
        zeit2 = token[1];
        zeit3 = token[2];
        zeit4 = token[3];    
        
        System.out.format("%s %n",zeit1);
        System.out.format("%s %n",zeit2);
        System.out.format("%s %n",zeit3);
        System.out.format("%s %n",zeit4);
    }
}
