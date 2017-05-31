
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>ログインページ</title>
    </head>
    <body>
        
        
        <%
            
            RequestDispatcher rd;
            if(session.getAttribute("log") != null) {
                if(session.getAttribute("log").equals(true)) {
                    rd = request.getRequestDispatcher("/jsp/product.jsp");
                    rd.forward(request, response);
                }
            } else {
                session.setAttribute("log", false);
            }
            
        %>
        
        
        【ログイン】<br>
        <form action="http://localhost:8080/StockContorolSystem/Login" method="post">
            ユーザー名：<input type="text" name="userName" size="30"><br>
            パスワード：<input type="password" name="password" size="30">
            <input type="submit" value="認証">
        </form>
        
        
    </body>
</html>
