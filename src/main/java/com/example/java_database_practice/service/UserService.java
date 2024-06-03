package com.example.java_database_practice.service;

import com.example.java_database_practice.dao.UserDao;
import com.example.java_database_practice.dao.UserDaoFactory;
import com.example.java_database_practice.dao.UserDaoType;
import com.example.java_database_practice.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserDaoFactory userDaoFactory;
    private UserDao userDao;

    @Autowired
    public UserService(UserDaoFactory userDaoFactory) {
        this.userDaoFactory = userDaoFactory;
    }

    @Bean
    public void run() {
        userDao = userDaoFactory.getUserDao(UserDaoType.MONGO);

        User user = new User("Laca", "laca@gmail.hu");
        createUser(user);

        User foundUser = getUserByUsername("Laca");
        System.out.println(foundUser);
    }

    public void createUser(User user) {
        userDao.insertUser(user);
    }

    public User getUserByUsername(String username) {
        return userDao.getUserByUsername(username);
    }
}
