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

/**
 *
 * @author Florian
 */
public class MongodbTest2
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
            
            MongoCollection<Document> collection = database.getCollection("test"); 
            collection.drop();
            
            //Create Document and insert it into the collection
// =============================================================================
//            {
//                "name" : "MongoDB",
//                "type" : "database",
//                "count" : 1,
//                "versions": [ "v3.2", "v3.0", "v2.6" ],
//                "info" : { x : 203, y : 102 }
//            }

            Document doc = new Document("name", "MongoDB")
                .append("type", "database")
                .append("count", 1)
                .append("versions", Arrays.asList("v3.2", "v3.0", "v2.6"))
                .append("info", new Document("x", 203).append("y", 102));

            collection.insertOne(doc);
            
            Document timeDoc = new Document ("name", "Times")
                    .append("time1", "12:20")
                    .append("time2", "15:40");
            collection.insertOne(timeDoc);
//==============================================================================
        
            System.out.println(collection.count()); //number of documents

            //Read from a Collection
// =============================================================================
              // MongoDB Tutorial
//            FindIterable<Document> cursor = collection.find();
//            
//            int i = 1;
//            
//            while(cursor.hasNext())
//            {
//                System.out.println(cursor.next());
//                i++;
//            }

            // Stackoverflow: https://stackoverflow.com/questions/45333966/java-insert-value-to-array-in-mongodb 
            // read one more time from MongoDB
            doc = collection.find(eq("name", "MongoDB")).first();
            
            System.out.println(doc.toJson());
            
            Document timeDoc2 = new Document (collection.find(eq("name", "Times")).first());
            
            System.out.println(timeDoc2.toJson());
            
// =============================================================================

            // Update a Document
// =============================================================================         
            collection.updateOne(eq("name", "Times"), combine(set("time1", "12:40"), set("time2", "16:00")/*, currentDate("lastModified")*/));
            
            timeDoc = new Document (collection.find(eq("name", "Times")).first());
            
            System.out.println(timeDoc.toJson());
// =============================================================================
            
            mongodb.close();
        
        }
        catch (Exception ex)
        {
            ex.printStackTrace();
        }
    }
    
}
