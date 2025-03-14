<%@ page import="java.sql.*, com.mycompany.simple.maven.util.DatabaseUtil" %>
<%@ page import="javax.servlet.http.HttpSession" %>
<%@ page import="com.mycompany.simple.maven.model.Customer" %>
<%@ page import="com.mycompany.simple.maven.model.Location" %>
<%@ page import="com.mycompany.simple.maven.model.Vehicle" %>

<%
    Customer customer = (Customer) session.getAttribute("loggedInCustomer");
%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Add Booking</title>
    <link rel="stylesheet" type="text/css" href="Resources/book.css">
    <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
</head>
<body>

    <div class="booking-container">
        <h2>Welcome, <%= (customer != null) ? customer.getName() : "Guest" %></h2>

        <% if (customer == null) { %>
            <p class="error-message">Session expired or not set. Please log in again.</p>
            <a href="customerLogin.jsp" class="btn">Login</a>
        <% } else { %>
            <p><strong>Email:</strong> <%= customer.getEmail() %></p>
            <p><strong>NIC:</strong> <%= customer.getNic() %></p>
            <p><strong>Mobile:</strong> <%= customer.getMobileNo() %></p>
        <% } %>

        <form action="addBooking" method="post">
        
        <label>Start Location:</label>
        <input type="text" value="Colombo" readonly><br>
        
        <label>End Location:</label>
        <input type="hidden" name="endLocation" id="endLocation">
        <select name="location" id="location">
            <%
                Connection conn = DatabaseUtil.getConnection();
                PreparedStatement ps = conn.prepareStatement("SELECT * FROM location");
                ResultSet rs = ps.executeQuery();
                while (rs.next()) {
            %>
                <option value="<%= rs.getInt("location_number") %>" 
                        data-distance="<%= rs.getInt("distance") %>" 
                        data-price="<%= rs.getInt("price") %>">
                    <%= rs.getString("end_location_name") %>
                </option>
            <% } %>
        </select><br>

        <label>Distance:</label>
        <input type="text" id="distance" name="price" readonly><br>

        <label>Price:</label>
        <input type="text" id="price" readonly><br>

        <label>Vehicle Type:</label>
        <input type="hidden" name="vehicleName" id="vehicleName">
        <select id="vehicleType">
            <option value="">-- Select Vehicle Type --</option>
            <%
                ps = conn.prepareStatement("SELECT DISTINCT vehicle_type FROM vehicle");
                rs = ps.executeQuery();
                while (rs.next()) {
            %>
                <option value="<%= rs.getString("vehicle_type") %>"><%= rs.getString("vehicle_type") %></option>
            <% } %>
        </select><br>

        <label>Vehicle Name:</label>
        <select name="vehicle" id="vehicle">
            <option value="">-- Select Vehicle --</option>
            <%  
                ps = conn.prepareStatement("SELECT * FROM vehicle");
                rs = ps.executeQuery();
                while (rs.next()) {
            %>
                <option value="<%= rs.getInt("vehicle_number") %>" 
                        data-type="<%= rs.getString("vehicle_type") %>" 
                        data-added-value="<%= rs.getDouble("added_value") %>">
                    <%= rs.getString("vehicle_name") %>
                </option>
            <% } %>
        </select><br>
        
        <label>New Price:</label>
        <input type="text" id="newPrice" name="newPrice" readonly><br>

        <label>Booking Date:</label>
        <input type="date" name="bookingDate" id="bookingDate" required><br>

        <label>Return Date:</label>
        <input type="date" name="returnDate" id="returnDate" required><br>

        <label>Total Days:</label>
        <input type="text" id="totalDays" name="totalDays" readonly><br>

        <label>Total Price:</label>
        <input type="text" id="totalPrice" name="totalPrice" readonly><br>

        <button type="submit">Add Booking</button>
    </form>
        
    </div>

    <script src="Resources/scripts.js"></script>

</body>
</html>
