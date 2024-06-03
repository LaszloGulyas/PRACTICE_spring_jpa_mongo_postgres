package com.example.java_database_practice.dao;

public enum UserDaoType {
    JDBC_BASIC("userDaoImpl"),
    JDBC_PREPARED_STATEMENTS("userDaoPreparedImpl"),
    JPA("userDaoJpaImpl"),
    MONGO("userDaoMongoImpl");

    private final String beanName;

    UserDaoType(String beanName) {
        this.beanName = beanName;
    }

    public String getBeanName() {
        return beanName;
    }
}
