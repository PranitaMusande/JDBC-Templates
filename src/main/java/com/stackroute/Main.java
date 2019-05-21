package com.stackroute;

import com.stackroute.db.*;


public class Main {
    public static void main(String[] args) {
//        CrudOperation crudOperation = new CrudOperation();
//        crudOperation.displayData();
//        crudOperation.displayCustomerByName("Pranita", "Female");
//        crudOperation.insertCustomer();
//        crudOperation.deleteCustomer();
//        crudOperation.updateCustomer();

//
//        RowsetDemo rowsetDemo= new RowsetDemo();
//        rowsetDemo.displayCustomrer();

//        ResultsetMetadataDemo resultsetMetadataDemo=new ResultsetMetadataDemo();
//        resultsetMetadataDemo.displayData();

//        DatabaseMetadataDemo databaseMetadataDemo=new DatabaseMetadataDemo();
//        databaseMetadataDemo.getDatabaseMetadataInformation();

        JDBCTransactionDemo jdbcTransactionDemo=new JDBCTransactionDemo();
        jdbcTransactionDemo.jDBCTransaction();

//        JDBCBatchProcessingDemo jdbcBatchProcessingDemo = new JDBCBatchProcessingDemo();
//        jdbcBatchProcessingDemo.jDBCBatchProcessing();
    }
}
