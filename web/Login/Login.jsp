<%-- 
    Document   : Login
    Created on : Oct 13, 2017, 10:52:39 AM
    Author     : Altair
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>
        <form name="Login" action="${pageContext.request.contextPath}/DashBoard/Dashboard.jsp">
            <input type="submit" value="Submit" />
        </form>
    </body>
</html>
