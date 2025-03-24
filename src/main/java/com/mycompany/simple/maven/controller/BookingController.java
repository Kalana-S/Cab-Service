package com.mycompany.simple.maven.controller;

import com.mycompany.simple.maven.model.Booking;
import com.mycompany.simple.maven.model.Customer;
import com.mycompany.simple.maven.service.BookingService;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/addBooking")
public class BookingController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            HttpSession session = request.getSession(false);
            Customer customer = (Customer) session.getAttribute("loggedInCustomer");

            if (customer == null) {
                response.sendRedirect("customerLogin.jsp");
                return;
            }

            String customerName = customer.getName();
            String endLocation = request.getParameter("endLocation");
            String vehicleName = request.getParameter("vehicleName");
            String bookingDateStr = request.getParameter("bookingDate");
            String returnDateStr = request.getParameter("returnDate");
            int totalDays = Integer.parseInt(request.getParameter("totalDays"));
            double totalPrice = Double.parseDouble(request.getParameter("totalPrice"));

            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            Date bookingDate = sdf.parse(bookingDateStr);
            Date returnDate = sdf.parse(returnDateStr);

            java.sql.Date sqlBookingDate = new java.sql.Date(bookingDate.getTime());
            java.sql.Date sqlReturnDate = new java.sql.Date(returnDate.getTime());

            Booking booking = new Booking(customerName, endLocation, vehicleName, sqlBookingDate, sqlReturnDate, totalDays, totalPrice);

            BookingService bookingService = new BookingService();
            boolean isAdded = bookingService.createBooking(booking);

            if (isAdded) {
                session.setAttribute("bookingSuccessMessage", "Booking successful! " +
                        "Booking Date: " + booking.getBookingDate() +
                        ", Return Date: " + booking.getReturnDate() +
                        ", Total Days: " + booking.getTotalDays() +
                        ", Total Price: Rs. " + booking.getTotalPrice());

                response.sendRedirect("customerDashboard.jsp");
            } else {
                response.sendRedirect("addBooking.jsp?error=Something+went+wrong");
            }
        } catch (Exception e) {
            e.printStackTrace();
            response.sendRedirect("addBooking.jsp?error=Something+went+wrong");
        }
    }
}
