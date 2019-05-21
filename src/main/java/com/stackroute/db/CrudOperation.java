package com.stackroute.db;

import java.sql.*;

public class CrudOperation {
    private Connection con;
    private Statement stmt;
    public void displayData()
    {
        System.out.println("\nDisplay Customer Data");
        try (Connection con = DriverManager.getConnection( "jdbc:mysql://localhost:3306/customerdb","root","Root@123");
             Statement stmt = con.createStatement();
             ResultSet rs=stmt.executeQuery("select * from customer"))
        {
            //Resister Driver with driver manager service
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Driver loaded");//create connection
            System.out.println("got connected");

            while(rs.next()) {

                System.out.println(rs.getInt(1) + "  " + rs.getString("name") + " " + rs.getInt(3) + " " + rs.getString(4));
            }
        }catch(Exception e){ System.out.println(e);}

    }


    public void displayCustomerByName(String name,String gender) {

        try{
            System.out.println("\nDisplay Customer By Name");
            //Resister Driver with driver manager service
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Driver loaded");//create connection
            //here db1 is database name, root is username and root123 is password
            con= DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/customerdb","root","Root@123");
            //create statement object
            System.out.println("got connected");

            PreparedStatement stmt=con.prepareStatement("Select * from customer where name = ? and gender = ?");
            // stmt.setInt(1,3);
            stmt.setString(1,name);
            stmt.setString(2,gender);
            ResultSet rs = stmt.executeQuery();
            //execute query
            //  ResultSet rs=stmt.executeQuery("select * from customers");
            //process result
            while(rs.next())
                System.out.println(rs.getInt(1)+"  "+rs.getString(2)+" "+rs.getString(4));
            con.close();
        }catch(Exception e){ System.out.println(e);}

    }

    public void insertCustomer()
    {
        try {
            System.out.println("\nInsert Customer Query");
            //Resister Driver with driver manager service
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Driver loaded");//create connection
            //here db1 is database name, root is username and root123 is password
            con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/customerdb", "root", "Root@123");
            //create statement object
            System.out.println("got connected");

            String query1 = "insert into customer(id,name,age,gender) values(?,?,?,?)";
            PreparedStatement stmt = con.prepareStatement(query1);

            stmt.setInt(1, 7);
            stmt.setString(2,"Amit");
            stmt.setInt(3,17);
            stmt.setString(4,"Male");
            int rs=stmt.executeUpdate();
            System.out.println("Customer inserted succesfully...!!!!");

            CrudOperation crudOperation = new CrudOperation();
            crudOperation.displayData();

            con.close();

        }
        catch (Exception e)
        {
            System.out.println(e);
        }


    }
    public void deleteCustomer() {
        try {
            System.out.println("\nDelete Customer Query");
            //Resister Driver with driver manager service
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Driver loaded");//create connection
            //here db1 is database name, root is username and root123 is password
            con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/customerdb", "root", "Root@123");
            //create statement object
            System.out.println("got connected");

            String query2 = "delete from customer where name = ?";
            PreparedStatement stmt = con.prepareStatement(query2);

            stmt.setString(1, "Pranita");

            int rs = stmt.executeUpdate();
            System.out.println("Customer deleted succesfully...!!!!");

            CrudOperation crudOperation = new CrudOperation();
            crudOperation.displayData();

            con.close();

        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void updateCustomer() {
        try {
            System.out.println("\nUpdate Customer Query");
            //Resister Driver with driver manager service
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Driver loaded");//create connection
            //here db1 is database name, root is username and root123 is password
            con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/customerdb", "root", "Root@123");
            //create statement object
            System.out.println("got connected");

            String query2 = "update customer set name= 'Kavita' where id=?";
            PreparedStatement stmt = con.prepareStatement(query2);

            stmt.setInt(1, 5);

            int rs = stmt.executeUpdate();
            System.out.println("Customer updated succesfully...!!!!");

            CrudOperation crudOperation = new CrudOperation();
            crudOperation.displayData();

            con.close();

        } catch (Exception e) {
            System.out.println(e);
        }
    }


    }