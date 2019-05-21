package com.stackroute.db;

import java.sql.*;
import java.util.Arrays;

public class JDBCBatchProcessingDemo
{
    //private Connection con;
    private Statement stmt;
    public void jDBCBatchProcessing()
    {
        try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/customerdb", "root", "Root@123");)
        {
            con.setAutoCommit(false);

            try (PreparedStatement pstmt = con.prepareStatement("Insert into customer (id,name,age,gender) values (?,?,?,?)");)
            {
                pstmt.setInt(1, 11);
                pstmt.setString(2, "Neha");
                pstmt.setInt(3, 15);
                pstmt.setString(4, "Female");
                pstmt.addBatch();

                pstmt.setInt(1, 12);
                pstmt.setString(2, "Radha");
                pstmt.setInt(3, 15);
                pstmt.setString(4, "Female");
                pstmt.addBatch();

                pstmt.setInt(1, 13);
                pstmt.setString(2, "Soha");
                pstmt.setInt(3, 15);
                pstmt.setString(4, "Female");
                pstmt.addBatch();

                int[] arr = pstmt.executeBatch();
                System.out.println(Arrays.toString(arr));

                con.commit();
            }
            catch (SQLException e)
            {
                e.printStackTrace();
                con.rollback();
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}
