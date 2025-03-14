package com.mycompany.simple.maven.controller;

import com.mycompany.simple.maven.model.Location;
import com.mycompany.simple.maven.service.LocationService;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/addLocation")
public class LocationController extends HttpServlet {
    private LocationService locationService = new LocationService();

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String endLocationName = request.getParameter("endLocationName");
        int distance = Integer.parseInt(request.getParameter("distance"));

        boolean success = locationService.addLocation(endLocationName, distance);

        if (success) {
            response.sendRedirect("dashboard.jsp?message=Location added successfully!");
        } else {
            response.sendRedirect("addLocation.jsp?error=Failed to add location.");
        }
    }
}
