package com.jdbclearning;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

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
            prepstatement.setInt(1,18);
            prepstatement.setInt(2,1);
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
