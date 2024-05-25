package com.tubes11.apotekerreal.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

class Connector {
    static Connection connect() {
        Connection conn = null;
        String url = "jdbc:mysql://localhost:3306/db_apotek";
        String user = "root";
        String password = "";

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(url, user, password);
            System.out.println("Connected to the database!");
        
        } catch (ClassNotFoundException e) {
            System.out.println("MySQL driver not found.");
            e.printStackTrace();
        } catch (SQLException e) {
            System.out.println("Connection failed.");
            e.printStackTrace();
        }
        return conn;
    }
}