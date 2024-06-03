package com.example.java_database_practice.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class UserDaoFactory {

    private final Map<String, UserDao> userDaoMap;

    @Autowired
    public UserDaoFactory(Map<String, UserDao> userDaoMap) {
        this.userDaoMap = userDaoMap;
    }

    public UserDao getUserDao(UserDaoType userDaoType) {
        return userDaoMap.get(userDaoType.getBeanName());
    }
}
