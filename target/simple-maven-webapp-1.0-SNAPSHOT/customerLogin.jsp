<%@ page contentType="text/html;charset=UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Customer Login</title>
    <link rel="stylesheet" type="text/css" href="Resources/styles.css">
</head>
<body>

    <div class="login-container">
        <h2>Customer Login</h2>

        <c:if test="${not empty param.error}">
            <p class="error-message">${param.error}</p>
        </c:if>

        <form action="${pageContext.request.contextPath}/customerLogin" method="post">
            <div class="input-group">
                <label for="nic">NIC:</label>
                <input type="text" id="nic" name="nic" placeholder="Enter NIC" required>
            </div>

            <div class="input-group">
                <label for="password">Password:</label>
                <input type="password" id="password" name="password" placeholder="Enter Password" required>
            </div>

            <button type="submit">Login</button>
        </form>

        <a href="index.jsp" class="home-link">Back to Home</a> 
    </div>

</body>
</html>
