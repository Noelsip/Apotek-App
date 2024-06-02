package com.tubes11.apotekerreal.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginDAO {
    private Connection connection;

    public LoginDAO(Connection connection){
        this.connection = connection;
    }

    public boolean isValidUser(String fullName, String userName, String password) {
        String query = "SELECT * FROM user WHERE fullName =? AND userName =? AND password =?";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, fullName);
            statement.setString(2, userName);
            statement.setString(3, password);

            ResultSet resultSet = statement.executeQuery();

            return resultSet.next();
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}
