<%@ page contentType="text/html;charset=UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Customer Login</title>
</head>
<body>
    <h2>Customer Login</h2>
    
    <c:if test="${not empty param.error}">
        <p style="color: red;">${param.error}</p>
    </c:if>

    <form action="${pageContext.request.contextPath}/customerLogin" method="post">
        <input type="text" name="nic" placeholder="Enter NIC" required>
        <input type="password" name="password" placeholder="Enter Password" required>
        <button type="submit">Login</button>
    </form>
   
    <a href="index.jsp">Home Page</a> 
</body>
</html>
