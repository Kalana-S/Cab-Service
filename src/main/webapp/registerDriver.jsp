<%@ page contentType="text/html;charset=UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Register Driver</title>
</head>
<body>
    <h2>Driver Registration</h2>
    <form action="${pageContext.request.contextPath}/registerDriver" method="post">
        <input type="text" name="driverName" placeholder="Driver Name" required>
        <input type="text" name="driverDescription" placeholder="Driver Description" required>
        <input type="text" name="driverMobileNo" placeholder="Mobile No" required>
        <input type="password" name="driverPassword" placeholder="Password" required>
        <button type="submit">Register</button>
    </form>
    <a href="index.jsp">Home Page</a> 
</body>
</html>
