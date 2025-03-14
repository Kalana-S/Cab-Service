<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add Location</title>
</head>
<body>
    <h2>Add a New Location</h2>
    <% if (request.getAttribute("message") != null) { %>
        <p style="color: green;"><%= request.getAttribute("message") %></p>
    <% } else if (request.getAttribute("error") != null) { %>
        <p style="color: red;"><%= request.getAttribute("error") %></p>
    <% } %>
    <form action="addLocation" method="post">
        <label>End Location:</label>
        <input type="text" name="endLocationName" required><br>

        <label>Distance (km):</label>
        <input type="number" name="distance" required><br>

        <input type="submit" value="Add Location">
    </form>
</body>
</html>
