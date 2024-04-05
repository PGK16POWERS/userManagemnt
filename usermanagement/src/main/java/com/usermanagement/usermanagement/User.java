package com.usermanagement.usermanagement;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "DNTFALL")
public class User {
    @Id
    private String id;
    private String picture;
    private String name;
    private String lastName;
    private String email;
    private String password;

        // Getters and setters
        public String getPicture() {
            return picture;
        }
    
        public void setPicture(String picture) {
            this.picture = picture;
        }
    
        public String getName() {
            return name;
        }
    
        public void setName(String name) {
            this.name = name;
        }
    
        public String getLastName() {
            return lastName;
        }
    
        public void setLastName(String lastName) {
            this.lastName = lastName;
        }
    
        public String getEmail() {
            return email;
        }
    
        public void setEmail(String email) {
            this.email = email;
        }
    
        public String getPassword() {
            return password;
        }
    
        public void setPassword(String password) {
            this.password = password;
        }
}
