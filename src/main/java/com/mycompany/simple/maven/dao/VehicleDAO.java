package com.mycompany.simple.maven.dao;

import com.mycompany.simple.maven.model.Vehicle;
import com.mycompany.simple.maven.util.DatabaseUtil;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class VehicleDAO {
     public boolean addVehicle(Vehicle vehicle) {
        String sql = "INSERT INTO vehicle (vehicle_name, vehicle_type, added_value) VALUES (?, ?, ?)";

        try (Connection conn = DatabaseUtil.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, vehicle.getVehicleName());
            stmt.setString(2, vehicle.getVehicleType());
            stmt.setDouble(3, vehicle.getAddedValue());

            int rowsInserted = stmt.executeUpdate();
            return rowsInserted > 0; // Return true if at least 1 row inserted

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
    
}
