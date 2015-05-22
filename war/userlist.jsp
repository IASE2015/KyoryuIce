<%-- 
    Document   : userlist
    Created on : 2013/11/25, 18:14:43
    Author     : 
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>ユーザーリスト</title>
    </head>
    <body>
        <h1>ユーザーリスト</h1>
            <table>
            <c:forEach items="${data}" var="rec">
                <tr>
                    <td>${rec.id}</td>
                    <td>${rec.name}</td>
                    <td>${rec.password}</td>
                </tr>
            </c:forEach>
        </table>
    </body>
</html>
