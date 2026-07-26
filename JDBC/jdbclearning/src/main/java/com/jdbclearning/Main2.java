package com.jdbclearning;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Main2 {
    public static void main(String[] args) throws SQLException {

        Statement stmt = null;
        Connection connect = null;
        PreparedStatement prepstatement = null;
        try{
            connect = JdbcUtil.getConnection();
            stmt = connect.createStatement();
            String sql="UPDATE studentinfo SET sage= ? WHERE id= ? ";
            prepstatement = connect.prepareStatement(sql);
            Scanner scan = new Scanner(System.in);

            System.out.println("Enter the details to change age.");
            System.out.println("Enter the id of the student: ");
            int inputid = scan.nextInt();
            System.out.println("Enter the new corrected age: ");
            int inputage = scan.nextInt();
            prepstatement.setInt(1,inputage);
            prepstatement.setInt(2,inputid);
            int rowsAffected = prepstatement.executeUpdate();
            if(rowsAffected!=0){
                System.out.println("Successfully edited the records.");
            }
            else{
                System.out.println("Error");
            }
        }
        catch(SQLException e){
            e.printStackTrace();
        }
        catch(Exception e){
            e.printStackTrace();
        }
        finally{
            JdbcUtil.closeConnection(connect,stmt);
            prepstatement.close();
        }
    }

}
