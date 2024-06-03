package com.example.java_database_practice.dao.mongodb;

import com.example.java_database_practice.dao.UserDao;
import com.example.java_database_practice.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserDaoMongoImpl implements UserDao {

    private final UserMongoRepository userMongoRepository;

    @Autowired
    public UserDaoMongoImpl(UserMongoRepository userMongoRepository) {
        this.userMongoRepository = userMongoRepository;
    }

    @Override
    public void insertUser(User user) {
        UserMongoEntity userMongoEntity = new UserMongoEntity(user);
        userMongoRepository.insert(userMongoEntity);
    }

    @Override
    public User getUserByUsername(String username) {
        UserMongoEntity result = userMongoRepository.findFirstByUsername(username);
        return mapEntityToUser(result);
    }

    private User mapEntityToUser(UserMongoEntity userMongoEntity) {
        return new User(userMongoEntity.getUsername(), userMongoEntity.getEmail());
    }
}
