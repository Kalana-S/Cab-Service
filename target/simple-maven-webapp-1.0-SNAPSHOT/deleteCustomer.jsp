<%@ page contentType="text/html;charset=UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Delete Customer</title>
</head>
<body>

    <h2>Delete Customer</h2>

    <% if (request.getParameter("error") != null) { %>
        <p style="color: red;"><%= request.getParameter("error") %></p>
    <% } %>

    <% if (request.getParameter("success") != null) { %>
        <p style="color: green;"><%= request.getParameter("success") %></p>
    <% } %>

    <form action="deleteCustomer" method="post">
        <label for="nic">Enter Customer NIC:</label>
        <input type="text" id="nic" name="nic" required>
        <button type="submit">Delete Customer</button>
    </form>

    <br>
    <a href="dashboard.jsp">Back to Dashboard</a>

</body>
</html>
