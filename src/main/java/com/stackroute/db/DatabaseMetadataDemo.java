package com.stackroute.db;

import java.sql.*;

public class DatabaseMetadataDemo
{
    // JDBC driver name and database URL
    static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost:3306/customerdb";

    // Database credentials
    static final String USERNAME = "root";
    static final String PASSWORD = "Root@123";

    public void getDatabaseMetadataInformation()
    {
        Connection connection = null;
        Statement stmt = null;
        try
        {
            /*
             * Register the JDBC driver in DriverManager
             */

            Class.forName(JDBC_DRIVER);

            /*
             * Establish connection to the Database using DriverManager
             */

            connection = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);

            DatabaseMetaData dbmd = connection.getMetaData();

            System.out.println("Driver Name: " + dbmd.getDriverName());
            System.out.println("Driver Version: " + dbmd.getDriverVersion());
            System.out.println("UserName: " + dbmd.getUserName());
            System.out.println("Database Product Name: "
                    + dbmd.getDatabaseProductName());
            System.out.println("Database Product Version: "
                    + dbmd.getDatabaseProductVersion());

            /*
             * Get all the table names from the world schema
             */
            System.out.println();
            System.out
                    .println("------------------Tables-----------------------------");

            String table[] =
                    {
                            "TABLE"
                    };
            ResultSet rs = dbmd.getTables(null, null, null, table);

            while (rs.next())
            {
                System.out.println(rs.getString(3));
            }

            rs.close();
            connection.close();
        }
        catch (SQLException se)
        {
            /*
             * Handle errors for JDBC
             */
            se.printStackTrace();
        }
        catch (ClassNotFoundException e)
        {
            /*
             * Handle errors for Class.forName
             */
            e.printStackTrace();
        }
        finally
        {
            /*
             * finally block used to close resources
             */
            try
            {
                if (stmt != null)
                {
                    stmt.close();
                }
            }
            catch (SQLException sqlException)
            {
                sqlException.printStackTrace();
            }
            try
            {
                if (connection != null)
                {
                    connection.close();
                }
            }
            catch (SQLException sqlException)
            {
                sqlException.printStackTrace();
            }
        }

    }

}
