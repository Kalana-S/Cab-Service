<%@ page contentType="text/html;charset=UTF-8" %>
<%@ page import="com.mycompany.simple.maven.model.Staff" %>
<%@ page import="javax.servlet.http.HttpSession" %>

<%
    HttpSession sessionObj = request.getSession(false);
    Staff staff = (sessionObj != null) ? (Staff) sessionObj.getAttribute("staff") : null;

    if (staff == null) {
        response.sendRedirect("login.jsp?message=Please+login+first");
    }
%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Staff Dashboard</title>
    <!-- Link to external CSS file -->
    <link rel="stylesheet" type="text/css" href="Resources/styles.css">
</head>
<body>

    <div class="dashboard-container">
        <h2>Welcome, <%= staff.getFirstName() %> <%= staff.getLastName() %>!</h2>
        <p>NIC: <%= staff.getNic() %></p>

        <form action="logout" method="post">
            <button type="submit" class="lgo">Logout</button>
        </form>

        <div class="dashboard-links">
            <a href="addLocation.jsp">Add Locations</a>
            <a href="addVehicle.jsp">Add Vehicle</a>
            <a href="deleteCustomer.jsp">Delete Customer Accounts</a>
            <a href="deleteBooking.jsp">Delete Customer Bookings</a>
        </div>
    </div>

</body>
</html>
