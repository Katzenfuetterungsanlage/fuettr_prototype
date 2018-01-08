/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import com.mongodb.*;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import static com.mongodb.client.model.Filters.eq;
import static com.mongodb.client.model.Updates.combine;
import static com.mongodb.client.model.Updates.currentDate;
import static com.mongodb.client.model.Updates.set;
import java.util.Arrays;
import org.bson.Document;
import static com.mongodb.client.model.Filters.eq;
import static com.mongodb.client.model.Updates.combine;
import java.io.StringReader;
import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonReader;

/**
 *
 * @author Florian
 */
public class MongodbCreateDocument
{

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)
    {
        try
        {
            MongoClient mongodb = new MongoClient();
            MongoDatabase database = mongodb.getDatabase("katzenfuetterungsanlage");
            
            MongoCollection<Document> collection = database.getCollection("data"); 
            //collection.drop();
            
            //Create Document and insert it into the collection
// =============================================================================            
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
            
            Document userDoc = new Document ("identifier", "User")
                    .append("user_name", "katze")
                    .append("user_password", "1234");
            
            collection.insertOne(userDoc);
            
            Document infoDoc = new Document ("identifier", "Info")
                    .append("serialnumber", "0001 0002 0003 0004")
                    .append("internal", "Raspberry Pi 3 Model B")
                    .append("version", "1.1 beta")
                    .append("wlan_state", "not connected");
            
            collection.insertOne(infoDoc);
            
            Document hardwareDoc = new Document ("identifier", "Hardware")
                    .append("sensor1", "true")
                    .append("sensor2", "false")
                    .append("engine1", "moving")
                    .append("engine2", "not moving");
            
            collection.insertOne(hardwareDoc);           
//==============================================================================
        
            System.out.println(collection.count()); //number of documents

            //Read from a Collection
// =============================================================================
            // read one more time from MongoDB
            timeDoc = collection.find(eq("identifier", "Times")).first();
            
            System.out.println(timeDoc.toJson());
            
            userDoc = collection.find(eq("identifier", "User")).first();
            
            System.out.println(userDoc.toJson());
            
            infoDoc = collection.find(eq("identifier", "Info")).first();
            
            System.out.println(infoDoc.toJson());
            
            hardwareDoc = collection.find(eq("identifier", "Hardware")).first();
            
            System.out.println(hardwareDoc.toJson());
// =============================================================================
            
            // Document to JsonObject 
// =============================================================================    
            String test = infoDoc.toJson();
            
            JsonReader jsonReader = Json.createReader(new StringReader(test));
            JsonObject object = jsonReader.readObject();
            jsonReader.close();
            
            System.out.println("JsonObject: " + object);
            
            System.out.println("interner Prozessor  : " + object.getString("internal"));
            
// =============================================================================
            
            mongodb.close();
        
        }
        catch (Exception ex)
        {
            ex.printStackTrace();
        }
    }
    
}
