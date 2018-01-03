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
import java.util.Arrays;
import org.bson.Document;



/**
 *
 * @author Florian
 */
public class Mongodb
{
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
//==============================================================================
        
            System.out.println(collection.count()); //number of documents

            //Read from a Collection
// =============================================================================
            FindIterable<Document> cursor = collection.find();
            
            int i = 1;
            
            while(cursor.hasNext())
            {
                System.out.println(cursor.next());
                i++;
            }
            
// =============================================================================

            mongodb.close();
        
        }
        catch (Exception ex)
        {
            ex.printStackTrace();
        }
    }
}

//Block<Document> printBlock = new Block<Document>() 
//            {
//                @Override
//                public void apply(final Document document) 
//                {
//                System.out.println(document.toJson());
//                }
//            };
//
//            collection.find().forEach(printBlock);