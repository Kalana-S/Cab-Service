package com.mycompany.simple.maven.controller;

import com.mycompany.simple.maven.service.BookingService;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/deleteBooking")
public class DeleteBookingController extends HttpServlet {
    private BookingService bookingService = new BookingService();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {

        String bookingIdStr = request.getParameter("bookingId");

        if (bookingIdStr == null || bookingIdStr.isEmpty()) {
            response.sendRedirect("deleteBooking.jsp?error=Booking+ID+is+required");
            return;
        }

        try {
            int bookingId = Integer.parseInt(bookingIdStr);
            boolean isDeleted = bookingService.deleteBooking(bookingId);

            if (isDeleted) {
                response.sendRedirect("deleteBooking.jsp?success=Booking+deleted+successfully");
            } else {
                response.sendRedirect("deleteBooking.jsp?error=Booking+not+found+or+deletion+failed");
            }
        } catch (NumberFormatException e) {
            response.sendRedirect("deleteBooking.jsp?error=Invalid+Booking+ID");
        }
    }
}