package com.usermanagement.usermanagement;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.core.io.Resource;
import java.nio.charset.StandardCharsets;

import org.springframework.core.io.ClassPathResource;
import org.springframework.util.StreamUtils;
import java.io.IOException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

import org.bson.Document;


@RestController
public class Routes { 

    // THIS ENABLES US TO HANDLE GET REQUESTS
    @GetMapping("/")
    public String LoginPath() throws IOException {
        Resource resource = new ClassPathResource("static/publicFiles/login.html");

        String htmlContent = StreamUtils.copyToString(resource.getInputStream(),StandardCharsets.UTF_8);

        return htmlContent;
    }

    @GetMapping("/login")
    public String HomePath() throws IOException {
        Resource resource = new ClassPathResource("static/publicFiles/login.html");

        String htmlContent = StreamUtils.copyToString(resource.getInputStream(),StandardCharsets.UTF_8);

        return htmlContent;
    }

    @GetMapping("/signup")
    public String SignupPath() throws IOException {
        Resource resource = new ClassPathResource("static/publicFiles/signup.html");

        String htmlContent = StreamUtils.copyToString(resource.getInputStream(),StandardCharsets.UTF_8);

        return htmlContent; 
    }

    // POST REQUESTS    

    @PostMapping("/signup")
    public String postMethodName(@RequestParam("picture") String picture,@RequestParam("name") String name,@RequestParam("lastName") String lastName,@RequestParam("email") String email, @RequestParam("password") String password) {
        
        try {
            
            MongoClient connection = MongoClients.create("mongodb+srv://Marjella:Marjella@diamondburg.lxfxn0d.mongodb.net/?retryWrites=true&w=majority&appName=DiamondBurg");

            MongoDatabase database = connection.getDatabase("TESTER");
 
            MongoCollection<Document> collection = database.getCollection("DNTFALL");

            Document document = new Document();
            document.append("picture",picture);
            document.append("name", name);



        } catch (Exception e) {
            e.printStackTrace();
        }
        




        
        return "Received POST request for signup with email: " + email + " and password: " + password;
    }
    
    
}
