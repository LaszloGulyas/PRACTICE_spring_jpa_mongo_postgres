package com.example.java_database_practice.dao.jpa;

import com.example.java_database_practice.dao.UserDao;
import com.example.java_database_practice.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserDaoJpaImpl implements UserDao {

    private final UserRepository userRepository;

    @Autowired
    public UserDaoJpaImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void insertUser(User user) {
        UserEntity userEntity = new UserEntity(user);
        userRepository.save(userEntity);
    }

    @Override
    public User getUserByUsername(String username) {
        UserEntity userEntity = userRepository.findFirstByUsername(username);
        return mapEntityToUser(userEntity);
    }

    private User mapEntityToUser(UserEntity userEntity) {
        return new User(userEntity.getUsername(), userEntity.getEmail());
    }
}
