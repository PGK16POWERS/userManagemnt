package com.usermanagement.usermanagement;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.core.io.Resource;
import java.nio.charset.StandardCharsets;
import org.springframework.core.io.ClassPathResource;
import org.springframework.util.StreamUtils;
import java.io.IOException;

@RestController
public class Routes {

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
    
}
