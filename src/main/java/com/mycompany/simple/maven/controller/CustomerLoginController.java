package com.mycompany.simple.maven.controller;

import com.mycompany.simple.maven.service.CustomerService;
import com.mycompany.simple.maven.model.Customer;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/customerLogin")
public class CustomerLoginController extends HttpServlet {
    private CustomerService customerService = new CustomerService();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
        throws ServletException, IOException {
    
        String nic = request.getParameter("nic");
        String password = request.getParameter("password");

        System.out.println("Received NIC: " + nic);
        System.out.println("Received Password: " + password);

        if (customerService.loginCustomer(nic, password)) {
            Customer customer = customerService.getCustomerDetails(nic);

            System.out.println("Customer Retrieved: " + customer.getName());

            HttpSession session = request.getSession();
            session.setAttribute("loggedInCustomer", customer);
            session.setAttribute("customerId", customer.getCustomerRegistrationNumber());

            response.sendRedirect("customerDashboard.jsp"); 
        } else {
            System.out.println("Invalid credentials");
            response.sendRedirect("customerLogin.jsp?error=Invalid credentials");
        }
    }

}
