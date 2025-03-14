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
<html>
<head>
    <title>Staff Dashboard</title>
</head>
<body>
    <h2>Welcome, <%= staff.getFirstName() %> <%= staff.getLastName() %>!</h2>
    <p>NIC: <%= staff.getNic() %></p>

    <form action="logout" method="post">
        <button type="submit">Logout</button>
    </form>
    <a href="addLocation.jsp">Add Locations</a>
    <br>
    <a href="addVehicle.jsp">Add Vehicle</a>
    <br>
    <a href="deleteCustomer.jsp">Delete Customer Accounts</a>
    <br>
    <a href="deleteBooking.jsp">Delete Customer Bookings</a>
</body>
</html>
