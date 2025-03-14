package com.mycompany.simple.maven.dao;

import com.mycompany.simple.maven.model.Location;
import com.mycompany.simple.maven.util.DatabaseUtil;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class LocationDAO {
    
   public boolean addLocation(Location location) {
        String sql = "INSERT INTO location (end_location_name, distance) VALUES (?, ?)";

        try (Connection conn = DatabaseUtil.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, location.getEndLocationName());
            stmt.setInt(2, location.getDistance());

            int rowsInserted = stmt.executeUpdate();
            return rowsInserted > 0; // Return true if at least 1 row inserted

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

}