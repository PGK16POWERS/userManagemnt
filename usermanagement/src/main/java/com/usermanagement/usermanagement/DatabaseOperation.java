package com.usermanagement.usermanagement;

import com.mongodb.ConnectionString;
import com.mongodb.MongoClientSettings;
import com.mongodb.MongoException;
import com.mongodb.ServerApi;
import com.mongodb.ServerApiVersion;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import org.springframework.boot.SpringApplication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
public class DatabaseOperation {

    public static void main(String[] args) {
        SpringApplication.run(UsermanagementApplication.class, args);
        createDatabaseConnection();
    }
 
    public static void createDatabaseConnection() {
        // MONGO DB CONNECTION URI
        String connectionString = "mongodb+srv://Marjella:Marjella@diamondburg.lxfxn0d.mongodb.net/?retryWrites=true&w=majority&appName=DiamondBurg";

        ServerApi serverApi = ServerApi.builder()
            .version(ServerApiVersion.V1)
            .build();

        // CONNECTION CONFIGURATIONS
        MongoClientSettings settings = MongoClientSettings.builder()
            .applyConnectionString(new ConnectionString(connectionString))
            .serverApi(serverApi)
            .build();

        // Create a new client and connect to the server
        try (MongoClient mongoClient = MongoClients.create(settings)) {
            try {
                // Send a ping to confirm a successful connection
                MongoDatabase database = mongoClient.getDatabase("TESTER");
                database.runCommand(new Document("ping", 1));
                System.out.println("Pinged your deployment. You successfully connected to MongoDB! **************************");
            } catch (MongoException e) {
                e.printStackTrace();
            }

        }
    }

    @PostMapping("/accounts")
    public String createAccount(@RequestParam MultiValueMap<String, String> formData) {
        // Logic to save the account data to the database
        // You can use the formData MultiValueMap to access form parameters
        // Example: String email = formData.getFirst("email");
        return "Account created successfully";
    }
}
