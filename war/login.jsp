<%-- 
    Document   : login
    Created on : 2013/12/02, 17:54:15
    Author     : 
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login</title>
    </head>
    <h1>☆ドラゴンアイスへようこそ！☆</h1>
    <form action="login.do" method="post" class="login">
        <table>
            <tr>
                <td>ユーザ名</td>
                <td><input type="text" name="user" size="16" value="" /></td>
                <td>パスワード</td>
                <td><input type="text" name="password" size="16" value="" /></td>     
            </tr>
        </table> 
        <input type="submit" value="ログイン" />
    </form>
</html>
