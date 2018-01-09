/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import static com.mongodb.client.model.Filters.eq;
import java.io.StringReader;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonReader;
import javax.swing.SwingWorker;
import org.bson.Document;
import static com.mongodb.client.model.Filters.eq;

/**
 *
 * @author Florian
 */
public class MongodbSwingWorker
{
    static String timeOfDay, time1, time2, time3, time4;
    static String time1_active_str, time2_active_str, time3_active_str, time4_active_str;
    static Boolean time1_active, time2_active, time3_active, time4_active;
    
    CountDownLatch latch = new CountDownLatch(1);
    

    public MongodbSwingWorker()
    {
        
  
//        try
//        {
//            latch.await();
//        }
//        catch (InterruptedException ex)
//        {
//            Logger.getLogger(MongodbSwingWorker.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        
        ImportTimesWorker importTimesWorker = new ImportTimesWorker();
        importTimesWorker.execute();
        
        //ConnectMongodbAndRead();
    }
        
    public static void main(String[] args)
    {
       new MongodbSwingWorker();
       
        System.out.println(time1);
    }
    
    
    
    
    
    
        
    private void ConnectMongodbAndRead ()
    {
       MongoClient mongodb = new MongoClient();
        MongoDatabase database = mongodb.getDatabase("katzenfuetterungsanlage");   
        MongoCollection<Document> collection = database.getCollection("data");
        
        System.out.println("verbunden");
        
        Document timeDoc = new Document ("identifier", "Times")
                    .append("time1", "12:20")
                    .append("time1_active", "true")
                    .append("time2", "15:40")
                    .append("time2_active", "true")
                    .append("time3", "15:40")
                    .append("time3_active", "true")
                    .append("time4", "15:40")
                    .append("time4_active", "true");
            
            collection.insertOne(timeDoc);          
        
        System.out.println(collection.count()); //number of documents
            
        
        
        Document doc = collection.find(eq("identifier", "Times")).first();      
        String strTimes = doc.toJson();
        
        System.out.println(strTimes);
        
        JsonReader jsonReader = Json.createReader(new StringReader(strTimes));
        JsonObject obj = jsonReader.readObject();
        jsonReader.close();
            
        strTimes = "imported doc: " + strTimes;
        Logger.getLogger(strTimes).log(Level.FINE, strTimes);
        System.out.println("strTimes: " + strTimes);
            
        time1 = obj.getString("time1");
        time2 = obj.getString("time2");
        time3 = obj.getString("time3");
        time4 = obj.getString("time4");
            
        time1_active_str = obj.getString("time1_active");
        time2_active_str = obj.getString("time2_active");
        time3_active_str = obj.getString("time3_active");
        time4_active_str = obj.getString("time4_active");
            
        time1_active = Boolean.valueOf(time1_active_str);
        time2_active = Boolean.valueOf(time2_active_str);
        time3_active = Boolean.valueOf(time3_active_str);
        time4_active = Boolean.valueOf(time4_active_str);
        
        System.out.println("time1: " + time1);
        System.out.println("time1_active: " + time1_active);  
    }
    
    
    // Import times from mongodb
    private class ImportTimesWorker extends SwingWorker<Object, String>
    {     
        // Connect to Database
        MongoClient mongodb = new MongoClient();
        MongoDatabase database = mongodb.getDatabase("katzenfuetterungsanlage");   
        MongoCollection<Document> collection = database.getCollection("data");

        String strTimes;

        @Override
        protected Object doInBackground() throws Exception
        {              
            latch.countDown();
            
            while (true)
            {
                Document doc = collection.find(eq("identifiert", "Times")).first();
                
                strTimes = doc.toJson();
                
                publish(strTimes);
            }
        }

        @Override
        protected void process(List<String> chunks)
        {
            JsonReader jsonReader = Json.createReader(new StringReader(strTimes));
            JsonObject obj = jsonReader.readObject();
            jsonReader.close();
            
            strTimes = "importet doc: " + strTimes;
            Logger.getLogger(strTimes).log(Level.FINE, strTimes);
            System.out.println("strTimes: " + strTimes);
            
            time1 = obj.getString("time1");
            time2 = obj.getString("time2");
            time3 = obj.getString("time3");
            time4 = obj.getString("time4");
            
            time1_active_str = obj.getString("time1_active");
            time2_active_str = obj.getString("time2_active");
            time3_active_str = obj.getString("time3_active");
            time4_active_str = obj.getString("time4_active");
            
            time1_active = Boolean.valueOf(time1_active_str);
            time2_active = Boolean.valueOf(time2_active_str);
            time3_active = Boolean.valueOf(time3_active_str);
            time4_active = Boolean.valueOf(time4_active_str);
        
            System.out.println("time1: " + time1);
            System.out.println("time1_active: " + time1_active); 
        }
        
    }
        
        
        
}

//public static void main(String[] args)
//    {
//        MongoClient mongodb = new MongoClient();
//        MongoDatabase database = mongodb.getDatabase("katzenfuetterungsanlage");   
//        MongoCollection<Document> collection = database.getCollection("data");
//        
//        System.out.println("verbunden");
//        
//        Document timeDoc = new Document ("identifier", "Times")
//                    .append("time1", "12:20")
//                    .append("time1_active", "true")
//                    .append("time2", "15:40")
//                    .append("time2_active", "true")
//                    .append("time3", "15:40")
//                    .append("time3_active", "true")
//                    .append("time4", "15:40")
//                    .append("time4_active", "true");
//            
//            collection.insertOne(timeDoc);          
//        
//        System.out.println(collection.count()); //number of documents
//            
//        
//        
//        Document doc = collection.find(eq("identifier", "Times")).first();      
//        String strTimes = doc.toJson();
//        
//        System.out.println(strTimes);
//        
//        JsonReader jsonReader = Json.createReader(new StringReader(strTimes));
//        JsonObject obj = jsonReader.readObject();
//        jsonReader.close();
//            
//        strTimes = "imported doc: " + strTimes;
//        Logger.getLogger(strTimes).log(Level.FINE, strTimes);
//        System.out.println("strTimes: " + strTimes);
//            
//        time1 = obj.getString("time1");
//        time2 = obj.getString("time2");
//        time3 = obj.getString("time3");
//        time4 = obj.getString("time4");
//            
//        time1_active_str = obj.getString("time1_active");
//        time2_active_str = obj.getString("time2_active");
//        time3_active_str = obj.getString("time3_active");
//        time4_active_str = obj.getString("time4_active");
//            
//        time1_active = Boolean.valueOf(time1_active_str);
//        time2_active = Boolean.valueOf(time2_active_str);
//        time3_active = Boolean.valueOf(time3_active_str);
//        time4_active = Boolean.valueOf(time4_active_str);
//        
//        System.out.println("time1: " + time1);
//        System.out.println("time1_active: " + time1_active);
//}

