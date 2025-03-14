package com.mycompany.simple.maven.controller;


import com.mycompany.simple.maven.service.VehicleService;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/addVehicle")
public class VehicleController extends HttpServlet {
    private VehicleService vehicleService = new VehicleService();

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String vehicleName = request.getParameter("vehicleName");
        String vehicleType = request.getParameter("vehicleType");
        double addedValue = Double.parseDouble(request.getParameter("addedValue"));

        boolean success = vehicleService.addVehicle(vehicleName, vehicleType, addedValue);

        if (success) {
            response.sendRedirect("dashboard.jsp?message=Vehicle added successfully!");
        } else {
            response.sendRedirect("addVehicle.jsp?error=Failed to add vehicle.");
        }
    }
}