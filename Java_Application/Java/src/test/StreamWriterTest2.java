/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test; 

import methods.StreamWriter;

/**
 *
 * @author Florian
 */
public class StreamWriterTest2
{
    public static void main(String[] args)
    {
        String pfad = "test.txt"; 
        String string, zeit1 = "zeit1", zeit2 = "zeit2", zeit3 = "zeit3", zeit4 = "zeit4";
        
        int zahl = 100000;
        String stringZahl;
        
        stringZahl = Integer.toString(zahl); //Zahl in String umwandeln
        
        //zahl = Integer.parseInt(stringZahl); String in Zahl umwandeln
        
        string = zeit1 + ";" + zeit2 + ";" + zeit3 + ";" + zeit4;
        
        StreamWriter streamwriter = new StreamWriter(); 
        
        streamwriter.schreiben(pfad,string/*,zeit2,zeit3,stringZahl*/,true); 
        
    }
}
