package com.example.java_database_practice.dao;

import com.example.java_database_practice.model.User;

public interface UserDao {

    void insertUser(User user);

    User getUserByUsername(String username);

}
