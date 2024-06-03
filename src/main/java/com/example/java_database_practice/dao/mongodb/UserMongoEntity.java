package com.example.java_database_practice.dao.mongodb;

import com.example.java_database_practice.model.User;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "users")
public class UserMongoEntity {

    @Id
    private String id;
    private String username;
    private String email;

    public UserMongoEntity() {
    }

    public UserMongoEntity(String username, String email) {
        this.username = username;
        this.email = email;
    }

    public UserMongoEntity(User user) {
        this.username = user.getUsername();
        this.email = user.getEmail();
    }

    public String getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
