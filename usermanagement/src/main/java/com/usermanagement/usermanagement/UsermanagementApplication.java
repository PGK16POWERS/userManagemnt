package com.usermanagement.usermanagement;

import org.bson.Document;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.mongodb.ConnectionString;
import com.mongodb.MongoClientSettings;
import com.mongodb.MongoException;
import com.mongodb.ServerApi;
import com.mongodb.ServerApiVersion;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

@SpringBootApplication
public class UsermanagementApplication {

	public static void main(String[] args) {
		SpringApplication.run(UsermanagementApplication.class, args);

		DatabaseOperations();
	}

	public static void DatabaseOperations() {
		// MONGO DB CONNECTION URI
		String connectionString = "mongodb+srv://Marjella:Marjella@diamondburg.lxfxn0d.mongodb.net/?retryWrites=true&w=majority&appName=DiamondBurg";
	
		// CONNECTION CONFIGURATIONS
		MongoClientSettings settings = MongoClientSettings.builder()
				.applyConnectionString(new ConnectionString(connectionString))
				.build();
	
		// Create a new client and connect to the server
		try (MongoClient mongoClient = MongoClients.create(settings)) {
                MongoDatabase database = mongoClient.getDatabase("TESTER");

				MongoCollection<Document> collection = database.getCollection("DNTFALL");

                System.out.println("CONNECTED SUCCESSFULLY TO THE DATABASE" + database + " " + collection);
            
		} catch (MongoException e) {
			System.err.println("Error connecting to MongoDB: " + e.getMessage());
			e.printStackTrace();
		}
	}

}
