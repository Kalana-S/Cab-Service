<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Add Vehicle</title>
</head>
<body>
    <h2>Add New Vehicle</h2>

    <%-- Display success or error message --%>
    <% if (request.getParameter("error") != null) { %>
        <p style="color: red;"><%= request.getParameter("error") %></p>
    <% } else if (request.getParameter("message") != null) { %>
        <p style="color: green;"><%= request.getParameter("message") %></p>
    <% } %>

    <form action="addVehicle" method="post">
        <label>Vehicle Name:</label>
        <input type="text" name="vehicleName" required>
        <br>
        <label>Vehicle Type:</label>
        <select name="vehicleType" required>
            <option value="Car">Car</option>
            <option value="Three Wheeler">Three Wheeler</option>
            <option value="Motor Bike">Motor Bike</option>
        </select>
        <br>
        <label>Added Value:</label>
        <select name="addedValue" required>
            <option value="1.2">1.2</option>
            <option value="1.5">1.5</option>
            <option value="1.8">1.8</option>
        </select>
        <br>
        <input type="submit" value="Add Vehicle">
    </form>

    <br>
    <a href="staffDashboard.jsp">Back to Dashboard</a>
</body>
</html>
