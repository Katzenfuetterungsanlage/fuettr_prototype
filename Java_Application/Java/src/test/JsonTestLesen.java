/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonReader;
import methods.JsonObjectReader;
import methods.StreamReader;

/**
 *
 * @author Florian
 */
public class JsonTestLesen
{
    public static void main(String[] args) throws FileNotFoundException
    {
        StreamReader reader = new StreamReader();
        String string = reader.einlesen("D:\\Schule\\Diplomarbeit\\Git\\fuettr_prototype\\Java_Application\\Java\\prj\\data\\test.json", false);
        
        System.out.format("String: %s\n\n",string);
        
//        InputStream fis = new FileInputStream("D:\\Schule\\Diplomarbeit\\Git\\fuettr_prototype\\Java_Application\\Java\\prj\\data\\test.json");
//
//        JsonReader jsonReader = Json.createReader(fis);
//        
//        JsonObject JsonObject = jsonReader.readObject();
//        
//        jsonReader.close();

        JsonObjectReader jsonObjectReader = new JsonObjectReader();
        JsonObject JsonObject = jsonObjectReader.read("D:\\Schule\\Diplomarbeit\\Git\\fuettr_prototype\\Java_Application\\Java\\prj\\data\\test.json");
     
        
        System.out.format("JSON: %s\n\n",JsonObject.toString());
        
        System.out.println("Seriennummer        : " + JsonObject.getString("serialnumber"));
        System.out.println("interner Prozessor  : " + JsonObject.getString("internal"));
        System.out.println("Wlan Status         : " + JsonObject.getString("wlanState"));
        
    }
}
