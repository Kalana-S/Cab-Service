<%@ page contentType="text/html;charset=UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Register Customer</title>
</head>
<body>
    <h2>Customer Registration</h2>
    <form action="${pageContext.request.contextPath}/registerCustomer" method="post">
        <input type="text" name="name" placeholder="Full Name" required>
        <input type="text" name="nic" placeholder="NIC" required>
        <input type="email" name="email" placeholder="Email" required>
        <input type="text" name="mobileNo" placeholder="Mobile Number" required>
        <input type="password" name="password" placeholder="Password" required>
        <button type="submit">Register</button>
    </form>
</body>
</html>
