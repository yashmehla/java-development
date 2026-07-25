package com.jdbclearning;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class JdbcUtil {
    static{
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

    }
    public static Connection getConnection() throws SQLException {
        String url = "jdbc:mysql://localhost:3306/jdbc_demo";
        String user = "<User>";
        String password = "<Password>";
        return DriverManager.getConnection(url, user, password);
    }
    public static void closeConnection(Connection connect, Statement stmt) throws SQLException{
        stmt.close();
        connect.close();
    }
}
