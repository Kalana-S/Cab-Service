<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Add Location</title>
    <link rel="stylesheet" type="text/css" href="Resources/book.css">
    <script>
        window.onload = function() {
            <% if (request.getAttribute("message") != null) { %>
                alert("<%= request.getAttribute("message") %>");
            <% } else if (request.getAttribute("error") != null) { %>
                alert("<%= request.getAttribute("error") %>");
            <% } %>
        };
    </script>
</head>
<body>

    <div class="location-container">
        <h2>Add a New Location</h2>

        <form action="addLocation" method="post">
            <div class="input-group">
                <label for="endLocationName">End Location:</label>
                <input type="text" id="endLocationName" name="endLocationName" required>
            </div>

            <div class="input-group">
                <label for="distance">Distance (km):</label>
                <input type="number" id="distance" name="distance" required>
            </div>

            <button type="submit">Add Location</button>
        </form>

        <a href="dashboard.jsp" class="home-link">Back to Dashboard</a>
    </div>

</body>
</html>
