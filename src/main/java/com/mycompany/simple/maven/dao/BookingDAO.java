package com.mycompany.simple.maven.dao;

import com.mycompany.simple.maven.model.Booking;
import com.mycompany.simple.maven.util.DatabaseUtil;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class BookingDAO {

    public boolean addBooking(Booking booking) {
        String sql = "INSERT INTO booking (customer_name, end_location, vehicle_name, booking_date, return_date, total_days, total_price) VALUES (?, ?, ?, ?, ?, ?, ?)";

        try (Connection conn = DatabaseUtil.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
             
            stmt.setString(1, booking.getCustomerName());
            stmt.setString(2, booking.getEndLocation());
            stmt.setString(3, booking.getVehicleName());
            stmt.setDate(4, booking.getBookingDate());
            stmt.setDate(5, booking.getReturnDate());
            stmt.setInt(6, booking.getTotalDays());
            stmt.setDouble(7, booking.getTotalPrice());

            return stmt.executeUpdate() > 0;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
    
    public boolean deleteBookingById(int bookingId) {
        String sql = "DELETE FROM booking WHERE booking_number = ?";

        try (Connection conn = DatabaseUtil.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, bookingId);

            int rowsDeleted = stmt.executeUpdate();
            return rowsDeleted > 0;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}
