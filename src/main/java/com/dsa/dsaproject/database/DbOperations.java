package com.dsa.dsaproject.database;
import com.dsa.dsaproject.entities.Customer;
import com.dsa.dsaproject.entities.InventoryItem;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
public class DbOperations {
    Connection conn = DatabaseConnection.getConnection();
    public void closeConnection() {
        DatabaseConnection.closeConnection(conn);
    }
    public Customer[] getAllCustomers() {
        try {
            // Create a statement
            Statement statement = conn.createStatement();

            // Write SQL query to get all records from the customers table
            String sql = "SELECT * FROM customers";

            // Execute the query
            ResultSet resultSet = statement.executeQuery(sql);
            Customer customers[] = new Customer[100];
            // Process the resultset
            int i =0;
            while (resultSet.next()) {
                // Retrieve values from the resultset for each record
                int customerId = resultSet.getInt("cid");
                String customerCode = resultSet.getString("customercode");
                String fullName = resultSet.getString("fullname");
                String location = resultSet.getString("location");
                String phone = resultSet.getString("phone");
                customers[i] = new Customer(customerId, customerCode, fullName, location, phone);
                i++;


            }

            // Close the statement and resultset
            statement.close();
            resultSet.close();
            return customers;
        } catch (SQLException e) {

            System.out.println(e.getMessage());
        }
        return null;
    }

    public InventoryItem[] getAllProducts() {
        try {
            // Create a statement
            Statement statement = conn.createStatement();

            // Write SQL query to get all records from the customers table
            String sql = "SELECT * FROM products";


            // Execute the query
            ResultSet resultSet = statement.executeQuery(sql);
//        Make an Inventory items array

            InventoryItem items[] = new InventoryItem[100];
            // Process the resultset


            int i =0;
            while (resultSet.next()) {

                // Retrieve values from the resultset for each record
                int productId = resultSet.getInt("pid");
                String productCode = resultSet.getString("productcode");
                String productName = resultSet.getString("productname");
                String productDescription = resultSet.getString("costprice");
                String productPrice = resultSet.getString("brand");

                // Print the retrieved values
                 items[i] = new InventoryItem(productId, productCode, productName, productDescription, productPrice);
                 i++;
            }

            // Close the statement and resultset
            statement.close();
            resultSet.close();
            return items;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }


}
