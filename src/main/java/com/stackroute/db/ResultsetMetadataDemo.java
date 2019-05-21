package com.stackroute.db;

import java.sql.*;

public class ResultsetMetadataDemo
{
    private Connection con;
    private Statement stmt;
    private ResultSet rs ;


    public void displayData()

    {
        try
        {
        Class.forName("com.mysql.cj.jdbc.Driver");

            String URL = "jdbc:mysql://localhost:3306/customerdb";
            String username = "root";
            String password = "Root@123";
            con = DriverManager.getConnection(URL, username, password);
            stmt = con.createStatement();

            String sql = "SELECT * FROM customer";
            rs = stmt.executeQuery(sql);
            //ResultSetMetaData rsmd = rs.getMetaData();

//            int colCount = rsmd.getColumnCount();



            PreparedStatement ps = con.prepareStatement("select * from customer");
            ResultSet rs = ps.executeQuery("Select * from customer");
            ResultSetMetaData rsmd = rs.getMetaData();

            System.out.println("Total columns: " + rsmd.getColumnCount());
            System.out.println("Column Name of 1st column: " + rsmd.getColumnName(1));
            System.out.println("Column Type Name of 1st column: " + rsmd.getColumnTypeName(1));

        }
        catch (Exception e)
        {

        }

    }
}
