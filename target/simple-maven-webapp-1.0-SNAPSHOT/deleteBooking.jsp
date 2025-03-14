<%@ page contentType="text/html;charset=UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Delete Booking</title>
</head>
<body>

    <h2>Delete Booking</h2>

    <% if (request.getParameter("error") != null) { %>
        <p style="color: red;"><%= request.getParameter("error") %></p>
    <% } %>

    <% if (request.getParameter("success") != null) { %>
        <p style="color: green;"><%= request.getParameter("success") %></p>
    <% } %>

    <form action="deleteBooking" method="post">
        <label for="bookingId">Enter Booking ID:</label>
        <input type="text" id="bookingId" name="bookingId" required>
        <button type="submit">Delete Booking</button>
    </form>

    <br>
    <a href="dashboard.jsp">Back to Dashboard</a>

</body>
</html>
