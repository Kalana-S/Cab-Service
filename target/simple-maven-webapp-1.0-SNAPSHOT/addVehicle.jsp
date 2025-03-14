<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Add Vehicle</title>
    <!-- Link to external CSS file -->
    <link rel="stylesheet" type="text/css" href="Resources/book.css">
</head>
<body>

    <div class="location-container">
        <h2>Add New Vehicle</h2>

        <%-- Display success or error message --%>
        <% if (request.getParameter("error") != null) { %>
            <p class="error-message"><%= request.getParameter("error") %></p>
        <% } else if (request.getParameter("message") != null) { %>
            <p class="success-message"><%= request.getParameter("message") %></p>
        <% } %>

        <form action="addVehicle" method="post">
            <div class="input-group">
                <label for="vehicleName">Vehicle Name:</label>
                <input type="text" id="vehicleName" name="vehicleName" required>
            </div>

            <div class="input-group">
                <label for="vehicleType">Vehicle Type:</label>
                <select name="vehicleType" id="vehicleType" required>
                    <option value="Car">Car</option>
                    <option value="Three Wheeler">Three Wheeler</option>
                    <option value="Motor Bike">Motor Bike</option>
                </select>
            </div>

            <div class="input-group">
                <label for="addedValue">Added Value:</label>
                <select name="addedValue" id="addedValue" required>
                    <option value="1.2">1.2</option>
                    <option value="1.5">1.5</option>
                    <option value="1.8">1.8</option>
                </select>
            </div>

            <button type="submit">Add Vehicle</button>
        </form>

        <a href="dashboard.jsp" class="home-link">Back to Dashboard</a>
    </div>

</body>
</html>
