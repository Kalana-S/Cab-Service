<%@ page contentType="text/html;charset=UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Register Staff</title>
</head>
<body>
    <h2>Staff Registration</h2>
    <form action="${pageContext.request.contextPath}/registerStaff" method="post">
        <input type="text" name="firstName" required>
        <input type="text" name="lastName" required>
        <input type="text" name="nic" required>
        <input type="password" name="password" required>
        <button type="submit">Register</button>
    </form>
    <a href="index.jsp">Home Page</a>    
</body>
</html>
