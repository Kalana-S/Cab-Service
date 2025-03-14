package com.mycompany.simple.maven.controller;

import com.mycompany.simple.maven.service.CustomerService;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/deleteCustomer")
public class DeleteCustomerController extends HttpServlet {
    private CustomerService customerService = new CustomerService();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {

        String nic = request.getParameter("nic");

        if (nic == null || nic.isEmpty()) {
            response.sendRedirect("deleteCustomer.jsp?error=NIC+is+required");
            return;
        }

        boolean isDeleted = customerService.deleteCustomer(nic);

        if (isDeleted) {
            response.sendRedirect("deleteCustomer.jsp?success=Customer+deleted+successfully");
        } else {
            response.sendRedirect("deleteCustomer.jsp?error=Customer+not+found+or+deletion+failed");
        }
    }
}