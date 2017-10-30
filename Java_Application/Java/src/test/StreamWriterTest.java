/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;

/**
 *
 * @author Florian
 */
public class StreamWriterTest
{   
    public static void main(String[] args)
    {
         try ( final BufferedWriter writer = 
                new BufferedWriter(
                     new OutputStreamWriter(  //wird verwendet um eine Codierung wählen zu können1
                        new FileOutputStream("D:\\Schule\\Diplomarbeit\\Git\\fuettr_prototype\\Java_Application\\Java\\src\\data\\test.txt"), "utf8"));) 
            // "AutoCloseable". Wird automatisch geschlossen wenn es in den runden Klammern steht. Wird von allen Streams unterstützt
        {
            writer.write(String.format("Zeit1%n"));
            writer.write(String.format("Zeit2%n"));
            writer.write(String.format("Zeit3%n"));
            writer.write(String.format("Zeit4%n"));
            System.out.println("It is working!");
        }
        catch (Exception ex)
        {
            ex.printStackTrace();
        }               
    }
                   
}
