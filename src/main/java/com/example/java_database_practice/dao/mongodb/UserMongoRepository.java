package com.example.java_database_practice.dao.mongodb;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserMongoRepository extends MongoRepository<UserMongoEntity, String> {

    UserMongoEntity findFirstByUsername(String username);
}
