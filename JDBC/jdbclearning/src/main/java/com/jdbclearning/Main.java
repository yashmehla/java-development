package com.jdbclearning;
import java.sql.*;
public class Main {
    public static void main(String[] args) throws ClassNotFoundException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        try {
            String url = "jdbc:mysql://localhost:3306/";
            String user = "DEMOUSER";
            String password = "DEMOPASS";

            // Connection is a interface
            Connection db = DriverManager.getConnection(url, user, password);
            System.out.println("Connected!");

            // create statement
            Statement stmt = db.createStatement();

            //Create database
            String createDatabase = "CREATE DATABASE IF NOT EXISTS jdbc2";


            // execute query
            stmt.executeUpdate(createDatabase);
            System.out.println("Database 'jdbc2' created.");
            // Use database
            stmt.executeUpdate("USE jdbc2");
            System.out.println("Using database 'jdbc2'.");
            // Create students table
            String createTable = """
                    CREATE TABLE IF NOT EXISTS students (
                        id INT PRIMARY KEY AUTO_INCREMENT,
                        name VARCHAR(100) NOT NULL,
                        age INT,
                        course VARCHAR(100)
                    )
                    """;
            stmt.executeUpdate(createTable);
            System.out.println("Table 'students' created.");
            // Insert student records
            stmt.executeUpdate("INSERT INTO students(name, age, course) VALUES('Alice', 20, 'Computer Science')");
            stmt.executeUpdate("INSERT INTO students(name, age, course) VALUES('Bob', 21, 'Mathematics')");
            stmt.executeUpdate("INSERT INTO students(name, age, course) VALUES('Charlie', 19, 'Physics')");

            System.out.println("Student records inserted.");

            // process the result
            ResultSet rs = stmt.executeQuery("SELECT * FROM students");
            System.out.println("\nStudents Table:");
            System.out.println("-------------------------------");

            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                int age = rs.getInt("age");
                String course = rs.getString("course");

                System.out.println(
                        "ID: " + id +
                                ", Name: " + name +
                                ", Age: " + age +
                                ", Course: " + course
                );
            }

            // close the query
            stmt.close();
            db.close(); // disconnecting the connection

        } catch (SQLException e) {
            e.printStackTrace();
        }


    }
}