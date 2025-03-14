<%@ page contentType="text/html;charset=UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Delete Customer</title>
    <link rel="stylesheet" type="text/css" href="Resources/styles.css">
</head>
<body>

    <div class="container">
        <h2>Delete Customer</h2>

        <%-- Display error message if present --%>
        <% if (request.getParameter("error") != null) { %>
            <p class="error-message"><%= request.getParameter("error") %></p>
        <% } %>

        <%-- Display success message if present --%>
        <% if (request.getParameter("success") != null) { %>
            <p class="success-message"><%= request.getParameter("success") %></p>
        <% } %>

        <form action="deleteCustomer" method="post">
            <div class="input-group">
                <label for="nic">Enter Customer NIC:</label>
                <input type="text" id="nic" name="nic" required>
            </div>
            <button type="submit">Delete Customer</button>
        </form>

        <a href="dashboard.jsp" class="home-link">Back to Dashboard</a>
    </div>

</body>
</html>
