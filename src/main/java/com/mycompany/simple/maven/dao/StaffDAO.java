package com.mycompany.simple.maven.dao;

import com.mycompany.simple.maven.model.Staff;
import com.mycompany.simple.maven.util.DatabaseUtil;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;


public class StaffDAO {
    
    public boolean addStaff(Staff staff) {
        String sql = "INSERT INTO staff (staff_first_name, staff_last_name, staff_nic, staff_password) VALUES (?, ?, ?, ?)";
        
        try (Connection conn = DatabaseUtil.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, staff.getFirstName());
            stmt.setString(2, staff.getLastName());
            stmt.setString(3, staff.getNic());
            stmt.setString(4, staff.getPassword());

            int rowsInserted = stmt.executeUpdate();
            return rowsInserted > 0;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
    
    public Staff authenticateStaff(String nic, String password) {
        String sql = "SELECT * FROM staff WHERE staff_nic = ? AND staff_password = ?";
        
        try (Connection conn = DatabaseUtil.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, nic);
            stmt.setString(2, password);

            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                Staff staff = new Staff();
                staff.setStaffRegistrationNumber(rs.getInt("staff_registration_number"));
                staff.setFirstName(rs.getString("staff_first_name"));
                staff.setLastName(rs.getString("staff_last_name"));
                staff.setNic(rs.getString("staff_nic"));
                return staff;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    
}