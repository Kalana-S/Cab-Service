package com.mycompany.simple.maven.controller;

import com.mycompany.simple.maven.service.CustomerService;
import com.mycompany.simple.maven.dao.CustomerDAO;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/registerCustomer")
public class CustomerController extends HttpServlet {
    private CustomerService customerService = new CustomerService();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        
        String name = request.getParameter("name");
        String nic = request.getParameter("nic");
        String email = request.getParameter("email");
        String mobileNo = request.getParameter("mobileNo");
        String password = request.getParameter("password");

        if (name == null || nic == null || email == null || mobileNo == null || password == null ||
            name.isEmpty() || nic.isEmpty() || email.isEmpty() || mobileNo.isEmpty() || password.isEmpty()) {
            response.sendRedirect("error.jsp?message=Missing+fields");
            return;
        }

        boolean isRegistered = customerService.registerCustomer(name, nic, email, mobileNo, password);

        if (isRegistered) {
            response.sendRedirect("success.jsp?message=Registration+Successful");
        } else {
            response.sendRedirect("error.jsp?message=Error+registering+customer");
        }
    }
}
