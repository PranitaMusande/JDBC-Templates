//package com.stackroute.db;
//
//
//
//import com.sun.rowset.JdbcRowSetImpl;
//
//import javax.sql.rowset.JdbcRowSet;
//import java.sql.*;
//
//public class RowsetDemo {
//    //private Connection con;
//    //demo of connected rowset
//    public void displayCustomrer() {
//
//        try {
//            JdbcRowSet jdbcRs = new JdbcRowSetImpl();
//            jdbcRs.setCommand("select * from customer"); // set properties, and
//            jdbcRs.setUrl("jdbc:mysql://localhost:3306/customerdb"); // connect to database
//            jdbcRs.setUsername("root");
//            jdbcRs.setPassword("Root@123");
//            jdbcRs.execute();
//            //jdbcRs.setCommand("select * from BOOKS");
//
//
//            while (jdbcRs.next())
//                System.out.println("ID " + jdbcRs.getInt(1) + "  " + jdbcRs.getString(2));
//            jdbcRs.close();
//        } catch (Exception e) {
//            System.out.println(e);
//        } finally {
////            try {
////                jd.close();
////            } catch (SQLException e) {
////                e.printStackTrace();
////            }
//        }
//    }
//}
//
//
//
//
//
//
//
//
//
//
//
//    //demo of disconnected rowset
//
//
