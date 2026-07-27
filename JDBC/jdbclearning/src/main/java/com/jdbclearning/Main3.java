package com.jdbclearning;

import java.sql.*;
import java.util.Scanner;

public class Main3 {
    public static void main(String[] args) throws SQLException {
        ResultSet rs = null;
        Statement stmt = null;
        Connection connect = null;
        PreparedStatement prepstatement = null;
        try{
            connect = JdbcUtil.getConnection();
            stmt = connect.createStatement();
            String sql="SELECT * FROM studentinfo WHERE id= ? ";
            prepstatement = connect.prepareStatement(sql);
            Scanner scan = new Scanner(System.in);

            System.out.println("Enter the details below:");
            System.out.println("Enter the id of the student: ");
            int inputid = scan.nextInt();
            prepstatement.setInt(1,inputid);
            rs = prepstatement.executeQuery();
            if(rs.next()){
                int sid = rs.getInt(1);
                String sname = rs.getString(2);
                int sage = rs.getInt(3);
                String scity = rs.getString(4);
                System.out.println(sid + " " + sname + " " + sage + " " + scity);
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
