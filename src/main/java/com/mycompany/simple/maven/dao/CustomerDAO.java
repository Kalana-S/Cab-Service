package com.mycompany.simple.maven.dao;

import com.mycompany.simple.maven.model.Customer;
import com.mycompany.simple.maven.util.DatabaseUtil;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;

public class CustomerDAO {

    public boolean addCustomer(Customer customer) {
        String sql = "INSERT INTO customer (customer_name, customer_nic, customer_email, customer_mobile_no, customer_password) VALUES (?, ?, ?, ?, ?)";

        try (Connection conn = DatabaseUtil.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, customer.getName());
            stmt.setString(2, customer.getNic());
            stmt.setString(3, customer.getEmail());
            stmt.setString(4, customer.getMobileNo());
            stmt.setString(5, customer.getPassword());

            int rowsInserted = stmt.executeUpdate();
            return rowsInserted > 0;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
    
    public boolean authenticateCustomer(String nic, String password) {
        String sql = "SELECT * FROM customer WHERE customer_nic = ? AND customer_password = ?";
        
        try (Connection conn = DatabaseUtil.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            
            stmt.setString(1, nic);
            stmt.setString(2, password);
            
            ResultSet rs = stmt.executeQuery();
            return rs.next(); // If there's a result, authentication is successful
            
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
    
    public Customer getCustomerByNIC(String nic){
        String sql = "SELECT * FROM customer WHERE customer_nic = ?";
        Customer customer = null;
        
        try (Connection conn = DatabaseUtil.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            
            stmt.setString(1, nic);
            ResultSet rs = stmt.executeQuery();
            
            if (rs.next()) {
                customer = new Customer();
                customer.setCustomerRegistrationNumber(rs.getInt("customer_registration_number"));
                customer.setName(rs.getString("customer_name"));
                customer.setNic(rs.getString("customer_nic"));
                customer.setEmail(rs.getString("customer_email"));
                customer.setMobileNo(rs.getString("customer_mobile_no"));
                customer.setPassword(rs.getString("customer_password"));
            }
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        return customer;
    }
    public boolean deleteCustomerByNIC(String nic) {
        String sql = "DELETE FROM customer WHERE customer_nic = ?";

        try (Connection conn = DatabaseUtil.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, nic);

            int rowsDeleted = stmt.executeUpdate();
            return rowsDeleted > 0;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}
