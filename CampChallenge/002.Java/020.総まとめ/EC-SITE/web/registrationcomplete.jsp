
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="Kagoyume.*"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        
        <div align="center">
            
            <%
                // JavaBeans
                JavaBeans jb = (JavaBeans)session.getAttribute("jb");
            %>
            
            <h1 style="display: inline">
                登録完了
            </h1><br>
            
            <br><br>
            
            <table style="border-collapse: separate; border-spacing: 1px; text-align: left; line-height: 1.5; border-top: 1px solid #ccc;">
                <tr>
                    <th style="background: #efefef; border-bottom: 1px solid #ccc; width: 100px; padding: 10px; padding-left: 20px;">ユーザー名</th>
                    <td style="border-bottom: 1px solid #ccc; width: 250px; padding: 10px; padding-left: 20px;"><%= jb.getRegistrationUserName() %></td>
                </tr>
                <tr>
                    <th style="background: #efefef; border-bottom: 1px solid #ccc; width: 100px; padding: 10px; padding-left: 20px;">パスワード</th>
                    <td style="border-bottom: 1px solid #ccc; width: 250px; padding: 10px; padding-left: 20px;"><%= jb.getRegistrationPassword().replaceAll(".","*") %></td>
                </tr>
            </table>
                
            <br>
            
            <p style="display: inline; font-size: 14px">
                以上内容で登録しました。
            </p><br>
            
            <br>
            
            <form action="LoginCheck" method = "POST" style = "display: inline">
                <input type="hidden" name="loginUserName" value="<%= jb.getRegistrationUserName()%>">
                <input type="hidden" name="loginPassword" value="<%= jb.getRegistrationPassword() %>">
                <!-- 直リンク防止用 -->
                <input type = "hidden" name = "ac" value = "<%= session.getAttribute("ac") %>">
                <button type="submit">ログイン</button>
            </form><br>
            
            <br>
            
            <a href="Top" style="color: black; font-size: 14px">戻る</a>
            
        </div>
        
    </body>
</html>
