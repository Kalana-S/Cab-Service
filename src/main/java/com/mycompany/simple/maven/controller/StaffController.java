package com.mycompany.simple.maven.controller;

import com.mycompany.simple.maven.service.StaffService;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/registerStaff")
public class StaffController extends HttpServlet {
    private StaffService staffService = new StaffService();
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        String nic = request.getParameter("nic");
        String password = request.getParameter("password");

        if (firstName == null || lastName == null || nic == null || password == null ||
            firstName.isEmpty() || lastName.isEmpty() || nic.isEmpty() || password.isEmpty()) {
            response.sendRedirect("error.jsp?message=Missing+fields");
            return;
        }

        boolean isRegistered = staffService.registerStaff(firstName, lastName, nic, password);

        if (isRegistered) {
            response.sendRedirect("success.jsp?message=Registration+Successful");
        } else {
            response.sendRedirect("error.jsp?message=Error+registering+staff");
        }
    }
}


