<%-- 
    Document   : cartCheckBox
    Created on : 2013/12/09, 11:02:39
    Author     : 
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>☆ドラゴンアイス☆カート一覧</h1>
        <div align="center">
            <h2>カート内の商品は以下の通りです</h2>

            <form action="cart.do" method="get" class="cart">
                <table class ="menu">
                    <c:forEach items="${data}" var="rec">
                        <tr>
                            <td>${rec.name}</td>
                            <td class="price">${rec.price} 円</td>

                        </tr>
                    </c:forEach>
                        <td class="total">合計金額${total}円</td>
                            
                </table></form>
            <form action="thankyou.jsp" method="post">
                <input type="submit" name="thankyou.jsp" value="この内容で注文する"/>
            </form>
        </div>
    </body>
</html>
