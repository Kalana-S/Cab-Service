<%@ page contentType="text/html;charset=UTF-8" %>
<%@ page import="com.mycompany.simple.maven.model.Customer" %>

<%
    Customer customer = (Customer) session.getAttribute("loggedInCustomer");
    String bookingMessage = (String) session.getAttribute("bookingSuccessMessage");
%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Customer Dashboard</title>
    <link rel="stylesheet" type="text/css" href="Resources/dashboardStyles.css">
</head>
<body>

    <div class="dashboard-container">

        <div class="welcome-section">
            <h2>Welcome, <%= (customer != null) ? customer.getName() : "Guest" %> 👋</h2>
        </div>

        <% if (customer == null) { %>
            <div class="error-message">
                <p>Session expired or not set. Please log in again.</p>
                <a href="customerLogin.jsp" class="btn">Login</a>
            </div>
        <% } else { %>

            <%-- Booking Success Message with Auto-Fade Effect --%>
            <% if (bookingMessage != null) { %>
                <div class="success-message">
                    <strong><%= bookingMessage %></strong>
                </div>
                <% session.removeAttribute("bookingSuccessMessage"); %>
            <% } %>

            <div class="customer-info">
                <p><strong>Email:</strong> <%= customer.getEmail() %></p>
                <p><strong>NIC:</strong> <%= customer.getNic() %></p>
                <p><strong>Mobile:</strong> <%= customer.getMobileNo() %></p>
            </div>

            <div class="action-buttons">
                <a href="addBooking.jsp" class="btn primary">➕ Add A New Booking</a>
                <a href="customerLogout.jsp" class="btn danger">🚪 Logout</a>
            </div>

        <% } %>
    </div>

</body>
</html>
