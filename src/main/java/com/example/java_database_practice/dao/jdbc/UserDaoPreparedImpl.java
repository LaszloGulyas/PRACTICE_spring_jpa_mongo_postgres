package com.example.java_database_practice.dao.jdbc;

import com.example.java_database_practice.dao.UserDao;
import com.example.java_database_practice.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

@Component
public class UserDaoPreparedImpl implements UserDao {

    private final DataSource dataSource;

    @Autowired
    public UserDaoPreparedImpl(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public void insertUser(User user) {
        String sql = "INSERT INTO users (username, email) VALUES (?, ?)";
        try (Connection connection = dataSource.getConnection()) {
            PreparedStatement psc = connection.prepareStatement(sql);
            psc.setString(1, user.getUsername());
            psc.setString(2, user.getEmail());
            psc.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public User getUserByUsername(String username) {
        String sql = "SELECT * FROM users WHERE username=? LIMIT 1";
        User result = null;
        try (Connection connection = dataSource.getConnection()) {
            PreparedStatement psc = connection.prepareStatement(sql);
            psc.setString(1, username);
            ResultSet resultSet = psc.executeQuery();
            while (resultSet.next()) {
                result = new User(resultSet.getString("username"), resultSet.getString("email"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

}
