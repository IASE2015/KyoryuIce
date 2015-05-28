<%-- 
    Document   : database
    Created on : 2013/11/25, 17:11:54
    Author     : 
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd" >
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>データベース</title>

    </head>
    <body>
        <h1>データベース</h1>
        <table>
            <c:forEach items="${data}" var="rec">
                <tr>
                    <td>${rec.id}</td>
                    <td>${rec.name}</td>
                    <td>${rec.price}</td>
                </tr>
            </c:forEach>
        </table>
    </body>
</html>
