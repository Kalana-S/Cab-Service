package com.mycompany.simple.maven.controller;

import com.mycompany.simple.maven.model.Staff;
import com.mycompany.simple.maven.service.StaffService;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/staffLogin")
public class StaffLoginController extends HttpServlet {
    private StaffService staffService = new StaffService();

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String nic = request.getParameter("nic");
        String password = request.getParameter("password");

        Staff staff = staffService.loginStaff(nic, password);

        if (staff != null) {
            HttpSession session = request.getSession();
            session.setAttribute("staff", staff);
            response.sendRedirect("dashboard.jsp?message=Login+Successful");
        } else {
            response.sendRedirect("login.jsp?message=Invalid+NIC+or+Password");
        }
    }
}
