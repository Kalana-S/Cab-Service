<%@ page contentType="text/html;charset=UTF-8" session="true" %>
<%
    session.invalidate();
    response.sendRedirect("customerLogin.jsp?message=Logged+out+successfully");
%>
