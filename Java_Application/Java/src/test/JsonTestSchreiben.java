/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import javax.json.Json;
import javax.json.JsonArrayBuilder;
import javax.json.JsonObject;
import javax.json.JsonObjectBuilder;
import methods.StreamWriter;

/**
 *
 * @author Florian
 */
public class JsonTestSchreiben
{
    
            
    public static void main(String[] args)
    {
             
        
        JsonObjectBuilder b = Json.createObjectBuilder();
        b.add("serialnumber", "0001 0002 0003 0004");
        b.add("internal", "Raspberry Pi 3");
        b.add("wlanState", "not implemented yet");
        JsonObject obj = b.build();
        
        JsonObjectBuilder x = Json.createObjectBuilder();
        
        JsonArrayBuilder value = Json.createArrayBuilder();
        value.add("Error");
        value.add("Error2");
        
        x.add("Errors", value);

        System.out.println(obj.toString());
        
        
        //String s = b.toString(); 
        
        StreamWriter writer = new StreamWriter(); 
        writer.schreiben("D:\\Schule\\Diplomarbeit\\Git\\fuettr_prototype\\Java_Application\\Java\\prj\\data\\test.json", obj.toString(), true);
    }
  
   
}
