<%-- 
    Document   : admin
    Created on : 2013/12/02, 17:05:09
    Author     : 
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>データベース</title>
    </head>
    <body>
        <h1>データベース</h1>
        <table border="1">
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
