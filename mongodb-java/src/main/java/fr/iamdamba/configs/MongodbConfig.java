package fr.iamdamba.configs;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoDatabase;

public class MongodbConfig {
  private static MongoDatabase db;

  public static MongoDatabase connectToClient(String uri) {
    try {
      MongoClient client = MongoClients.create(uri);
      db = client.getDatabase("java_test");
      System.out.println("Successfully connected to MongoDB");

      return db;
    } catch (Exception e) {
      System.err.println(e.getMessage());
      return null;
    }

  }
}
