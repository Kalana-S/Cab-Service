package com.mycompany.simple.maven.service;

import com.mycompany.simple.maven.dao.BookingDAO;
import com.mycompany.simple.maven.model.Booking;

public class BookingService {
    
    private BookingDAO bookingDAO;

    public BookingService() {
        this.bookingDAO = new BookingDAO();
    }

    public boolean createBooking(Booking booking) {
        return bookingDAO.addBooking(booking);
    }
    
    public boolean deleteBooking(int bookingId) {
        return bookingDAO.deleteBookingById(bookingId);
    }
    
    public BookingService(BookingDAO bookingDAO) {
        this.bookingDAO = bookingDAO;
    }
}
