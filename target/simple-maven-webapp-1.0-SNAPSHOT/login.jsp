<%@ page contentType="text/html;charset=UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Staff Login</title>
</head>
<body>
    <h2>Staff Login</h2>
    <form action="${pageContext.request.contextPath}/staffLogin" method="post">
        <label>NIC:</label>
        <input type="text" name="nic" required><br>

        <label>Password:</label>
        <input type="password" name="password" required><br>

        <button type="submit">Login</button>
    </form>

    <% if (request.getParameter("message") != null) { %>
        <p><%= request.getParameter("message") %></p>
    <% } %>
    <a href="index.jsp">Home Page</a> 
</body>
</html>
