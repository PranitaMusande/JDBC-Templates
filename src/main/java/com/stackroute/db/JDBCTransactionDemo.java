package com.stackroute.db;

import java.sql.*;

public class JDBCTransactionDemo {
    private Connection con;
    private Statement stmt;

    public void jDBCTransaction()
    {
        try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/customerdb", "root", "Root@123");)
        {
            con.setAutoCommit(false);

            try (PreparedStatement pstmt = con.prepareStatement("Insert into customer (id,name,age,gender) values (?,?,?,?)");)
            {
                pstmt.setInt(1, 15);
                pstmt.setString(2, "Neha");
                pstmt.setInt(3, 15);
                pstmt.setString(4, "Female");

                pstmt.execute();
                con.commit();
                System.out.println("Done!");

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
