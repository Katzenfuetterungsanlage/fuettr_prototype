/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;
import java.net.UnknownHostException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author User
 */
public class CollCountTest {

    private MongoClient mongodb;
    private final DB database;
    private final DBCollection collTimes;
    private final DBCollection collUser;

    public CollCountTest() {
        try {
            mongodb = new MongoClient();
        } catch (UnknownHostException ex) {
            Logger.getLogger(CollCountTest.class.getName()).log(Level.SEVERE, null, ex);
        }
        database = mongodb.getDB("fuettr");
        collTimes = database.getCollection("data_times");
        collUser = database.getCollection("data_user");

        System.out.println(collUser.count());
        collUser.insert(new BasicDBObject("identifier", "User").append("user_name", "cat").append("user_password", "1234"));

    }

    public static void main(String[] args) {
        new CollCountTest();
    }

}
