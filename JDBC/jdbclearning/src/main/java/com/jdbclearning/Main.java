package com.jdbclearning;
import java.sql.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws ClassNotFoundException {
        Statement stmt = null;
        Connection connect = null;
        PreparedStatement prepstatement = null;
        try {
            connect = JdbcUtil.getConnection();
            stmt = connect.createStatement();
            System.out.println("Using database 'jdbc_demo'.");
            // Create students table
            String createTable = """
                    CREATE TABLE IF NOT EXISTS studentinfo (
                        id INT PRIMARY KEY AUTO_INCREMENT,
                        sname VARCHAR(100) NOT NULL,
                        sage INT,
                        scity VARCHAR(100)
                    )
                    """;
            stmt.executeUpdate(createTable);
            System.out.println("Table 'students' created.");
            // Insert student records
            String query="INSERT INTO studentinfo(id,sname,sage,scity) VALUES(?,?,?,?)";
            prepstatement = connect.prepareStatement(query);
            Scanner scan = new Scanner(System.in);
            System.out.println("Enter the following details to be put into DB");
            System.out.println("Enter the ID of student : ");
            Integer id = scan.nextInt();
            System.out.println("Enter the name of student : ");
            String name = scan.next();
            System.out.println("Enter the age of student : ");
            Integer age = scan.nextInt();
            System.out.println("Enter the city of student : ");
            String city = scan.next();
            prepstatement.setInt(1, id);
            prepstatement.setString(2,name);
            prepstatement.setInt(3,age);
            prepstatement.setString(4,city);
            int rowsAffected = prepstatement.executeUpdate();
            if(rowsAffected==0){
                System.out.println("No data added.");
            }
            else {
                System.out.println("Student records inserted.");
            }

            // process the result
            ResultSet rs = stmt.executeQuery("SELECT * FROM studentinfo");
            System.out.println("\nStudents Table:");
            System.out.println("-------------------------------");

            while (rs.next()) {
                int sid = rs.getInt("id");
                String sname = rs.getString("sname");
                int sage = rs.getInt("sage");
                String scity = rs.getString("scity");

                System.out.println(
                        "ID: " + sid +
                                ", Name: " + sname +
                                ", Age: " + sage +
                                ", City: " + scity
                );
            }

            // close the query
            prepstatement.close();
            JdbcUtil.closeConnection(connect,stmt);

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e){
            e.printStackTrace();
        }


    }
}