<%@ page contentType="text/html;charset=UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Register Staff</title>
    <link rel="stylesheet" href="Resources/styles.css">
</head>
<body>
    <div class="container">
        <h2>Staff Registration</h2>

        <form action="${pageContext.request.contextPath}/registerStaff" method="post">
            <div class="input-group">
                <label for="firstName">First Name</label>
                <input type="text" name="firstName" id="firstName" placeholder="Enter First Name" required>
            </div>

            <div class="input-group">
                <label for="lastName">Last Name</label>
                <input type="text" name="lastName" id="lastName" placeholder="Enter Last Name" required>
            </div>

            <div class="input-group">
                <label for="nic">NIC</label>
                <input type="text" name="nic" id="nic" placeholder="Enter NIC" required>
            </div>

            <div class="input-group">
                <label for="password">Password</label>
                <input type="password" name="password" id="password" placeholder="Enter Password" required>
            </div>

            <button type="submit" class="register-btn">Register</button>
        </form>

        <a href="index.jsp" class="home-link">Back to Home</a> 
    </div>
</body>
</html>
