/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package methods;

/**
 *
 * @author Florian
 */
public class StreamReaderShow
{
    private String text; 

    public StreamReaderShow() 
            throws Exception
    {
        einlesen();
        System.out.format("%s",text);
        
    }
    
    private void einlesen()
            throws Exception
    {
        StreamReader einlesen = new StreamReader(text);
        text = einlesen.getText(); 
    }
    
    public static void main(String[] args) 
            throws Exception
    {
        new StreamReaderShow();
    }
    
}
