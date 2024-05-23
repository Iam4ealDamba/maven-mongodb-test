package fr.iamdamba;

import java.util.ArrayList;
import java.util.List;

import org.bson.BsonValue;
import org.bson.Document;
import org.bson.conversions.Bson;
import org.bson.types.ObjectId;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.Updates;
import com.mongodb.client.result.DeleteResult;
import com.mongodb.client.result.InsertManyResult;
import com.mongodb.client.result.InsertOneResult;
import com.mongodb.client.result.UpdateResult;

import fr.iamdamba.configs.MongodbConfig;
import fr.iamdamba.models.User;

public class Main {
    public static void main(String[] args) {
        MongoDatabase db = MongodbConfig.connectToClient("mongodb://localhost:2717");
        MongoCollection<Document> collection = db.getCollection("users");

        // Create many Users
        // List<User> users = new ArrayList<User>();
        // for (int i = 0; i < 5; i++) {
        // User user = new User("John Doe " + i, "xZS8H@example.com", "1234560_" + i);
        // users.add(user);
        // }

        // // Insert many Users in document list
        // List<Document> documents = new ArrayList<Document>();
        // for (User user : users) {
        // Document doc = new Document();
        // doc.append("_id", new ObjectId().toHexString());
        // doc.append("name", user.getName());
        // doc.append("email", user.getEmail());
        // doc.append("password", user.getPassword());
        // documents.add(doc);
        // }

        // // Insert users in collection
        // InsertManyResult result = collection.insertMany(documents);
        // System.out.println(result.getInsertedIds());

        // Fetch users from collection
        List<User> users = new ArrayList<User>();
        List<Document> doc_list = collection.find().into(new ArrayList<Document>());
        for (Document document : doc_list) {
            User user = new User(document.get("name").toString(), document.get("email").toString(),
                    document.get("password").toString(), document.get("_id").toString());
            users.add(user);
        }
        System.out.println(users.toString());

        // Update a user
        // User userToUpdate = users.get(0).setName("John Doe I");

        // Bson filter = Filters.eq("_id", userToUpdate.getObjectID());
        // Bson update = Updates.combine(Updates.set("name", userToUpdate.getName()));
        // UpdateResult result = collection.updateOne(filter, update);
        // System.out.println(result.getModifiedCount());

        // Delete a user
        // User userToDelete = users.get(0);
        // Bson filter = Filters.eq("_id", userToDelete.getObjectID());
        // DeleteResult result = collection.deleteOne(filter);
        // System.out.println(result.getDeletedCount());
        // System.out.println("Done");

    }
}