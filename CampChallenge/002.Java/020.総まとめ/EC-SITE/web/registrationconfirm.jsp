
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="Kagoyume.*"%>

<!DOCTYPE html>
<html>
    
    
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login</title>
        <link rel="stylesheet" href="registrationconfirm.css">
        <%
            // JavaBeans
            JavaBeans jb = (JavaBeans)session.getAttribute("jb");
            // 直リンク禁止用
            session.setAttribute("ac", (int)(Math.random() * 1000));
        %>
    </head>
    
    
    <body>
            <h1 class="logo">
                <a href="Top">Kagoyume</a>
            </h1>
            <div class="container">
                
                <div class="registration">
                    <h2>入力確認</h2>
                    <span>ユーザー名</span><br>
                    <%= jb.getRegistrationUserName() %><br>
                    <span>パスワード</span><br>
                    <%= jb.getRegistrationPassword() %><br>
                    <span>パスワード（確認用）</span><br>
                    <%= jb.getRegistrationPasswordConfirm() %><br>
                    <span>メールアドレス</span><br>
                    <%= jb.getRegistrationMail() %><br>
                    <span>住所</span><br>
                    <%= jb.getRegistrationAddress() %><br>
                    <form action="RegistrationComplete" method="POST">
                        <input class="btn" type="submit" value="アカウントを作成" >
                        <!--直リンク禁止用-->
                        <input type = "hidden" name = "ac" value = "<%= session.getAttribute("ac") %>">
                    </form>
                </div>
                
            </div>
               
          
    </body>
    
    
</html>
