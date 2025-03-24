package com.mycompany.simple.maven.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.mockito.Mockito;
import static org.mockito.Mockito.*;
import com.mycompany.simple.maven.dao.BookingDAO;
import com.mycompany.simple.maven.service.BookingService;
import com.mycompany.simple.maven.model.Booking;


public class BookingServiceTest {
    
    private BookingService bookingService;
    private BookingDAO bookingDAO;

    @BeforeEach
    void setUp() {
        bookingDAO = Mockito.mock(BookingDAO.class);
        bookingService = new BookingService(bookingDAO);
    }

    @Test
    void testCreateBooking() {
        Booking booking = new Booking();
        Mockito.when(bookingDAO.addBooking(booking)).thenReturn(true);
        boolean result = bookingService.createBooking(booking);
        assertTrue(result);
        Mockito.verify(bookingDAO, Mockito.times(1)).addBooking(booking);
    }
}
