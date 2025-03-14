<%@ page contentType="text/html;charset=UTF-8" %>
<%@ page import="com.mycompany.simple.maven.model.Customer" %>

<%
    Customer customer = (Customer) session.getAttribute("loggedInCustomer");
    String bookingMessage = (String) session.getAttribute("bookingSuccessMessage");
%>

<!DOCTYPE html>
<html>
<head>
    <title>Customer Dashboard</title>
    <style>
        body {
            font-family: Arial, sans-serif;
        }
        .success-message {
            background-color: lightgreen;
            color: green;
            padding: 10px;
            border: 1px solid green;
            margin-bottom: 10px;
            width: 50%;
        }
    </style>
</head>
<body>

    <h2>Welcome, <%= (customer != null) ? customer.getName() : "Guest" %></h2>

    <% if (customer == null) { %>
        <p style="color: red;">Session expired or not set. Please log in again.</p>
        <a href="customerLogin.jsp">Login</a>
    <% } else { %>

        <%-- Show Booking Success Message --%>
        <% if (bookingMessage != null) { %>
            <div class="success-message">
                <strong><%= bookingMessage %></strong>
            </div>
            <% session.removeAttribute("bookingSuccessMessage"); %>
        <% } %>

        <p>Your email: <%= customer.getEmail() %></p>
        <p>Your NIC: <%= customer.getNic() %></p>
        <p>Your Mobile: <%= customer.getMobileNo() %></p>
        <a href="customerLogout.jsp">Logout</a><br><br>

        <a href="addBooking.jsp">Add A New Booking</a>
    <% } %>

</body>
</html>
