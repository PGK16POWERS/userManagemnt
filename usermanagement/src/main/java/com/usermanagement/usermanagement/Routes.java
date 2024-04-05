package com.usermanagement.usermanagement;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.core.io.Resource;
import java.nio.charset.StandardCharsets;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.util.StreamUtils;
import java.io.IOException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
public class Routes {

    @Autowired
    private UserRepository userRepository; 

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
    public String postMethodName(@RequestParam String picture,@RequestParam String name,@RequestParam String lastName,@RequestParam String email, @RequestParam String password) {
        User user = new User();
        user.setPicture(picture);
        user.setName(name);
        user.setLastName(lastName);
        user.setEmail(email);
        user.setPassword(password);

        userRepository.save(user);
        return "Received POST request for signup with email: " + email + " and password: " + password;
    }
    
    
}
