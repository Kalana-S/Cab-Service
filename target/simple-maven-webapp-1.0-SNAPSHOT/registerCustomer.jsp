<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Customer Registration</title>
    <link rel="stylesheet" href="Resources/styles.css">
</head>
<body>
    <div class="registration-container">
        <h2>Customer Registration</h2>
        <form action="${pageContext.request.contextPath}/registerCustomer" method="post">
            <div class="input-group">
                <label for="name">Full Name</label>
                <input type="text" id="name" name="name" placeholder="Full Name" required>
            </div>

            <div class="input-group">
                <label for="nic">NIC</label>
                <input type="text" id="nic" name="nic" placeholder="NIC" required>
            </div>

            <div class="input-group">
                <label for="email">Email</label>
                <input type="email" id="email" name="email" placeholder="Email" required>
            </div>

            <div class="input-group">
                <label for="mobileNo">Mobile Number</label>
                <input type="text" id="mobileNo" name="mobileNo" placeholder="Mobile Number" required>
            </div>

            <div class="input-group">
                <label for="password">Password</label>
                <input type="password" id="password" name="password" placeholder="Password" required>
            </div>

            <button type="submit">Register</button>
        </form>
            <a href="index.jsp" class="home-link">Back to Home</a>
    </div>
    
</body>
</html>
