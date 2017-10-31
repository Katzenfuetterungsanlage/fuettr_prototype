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
public class ZeitenVergleichen
{
    public static void main(String[] args)
    {
        StreamReader streamReader = new StreamReader(); 
        String string = streamReader.einlesen("D:\\Schule\\Diplomarbeit\\Git\\fuettr_prototype\\Java_Application\\Java\\src\\data\\testZeit.txt");
        
        //test
        System.out.format("%s %n",string);
        
        String[] token = string.split(";"); 
        String zeit1 = token[0];
        String zeit2 = token[1];
        String zeit3 = token[2];
        String zeit4 = token[3];    
        
        //test
        System.out.format("%s %n",zeit1);
        System.out.format("%s %n",zeit2);
        System.out.format("%s %n",zeit3);
        System.out.format("%s %n",zeit4);
        
        if (zeit1.equals(zeit2))
        {
            System.out.println("Zeit1 = Zeit2");
        }
        else
        {
            System.out.println("Zeit1 != Zeit2");
        }
    }
            
}
