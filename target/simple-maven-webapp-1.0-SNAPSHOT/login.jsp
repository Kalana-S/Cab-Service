<%@ page contentType="text/html;charset=UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Staff Login</title>
    <!-- Link to external CSS file -->
    <link rel="stylesheet" type="text/css" href="Resources/styles.css">
</head>
<body>

    <div class="container">
        <h2>Staff Login</h2>

        <form action="${pageContext.request.contextPath}/staffLogin" method="post">
            <div class="input-group">
                <label for="nic">NIC:</label>
                <input type="text" id="nic" name="nic" required><br>
            </div>

            <div class="input-group">
                <label for="password">Password:</label>
                <input type="password" id="password" name="password" required><br>
            </div>

            <button type="submit">Login</button>
        </form>

        <% if (request.getParameter("message") != null) { %>
            <p class="error-message"><%= request.getParameter("message") %></p>
        <% } %>

        <a href="index.jsp" class="home-link">Home Page</a>
    </div>

</body>
</html>
