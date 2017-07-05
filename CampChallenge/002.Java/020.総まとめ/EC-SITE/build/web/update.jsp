
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="Kagoyume.*"%>

<%
    // JavaBeans
    JavaBeans jb = (JavaBeans)session.getAttribute("jb");
%>
<!DOCTYPE html>
<html>
    
    
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" href="update.css">
    </head>
    
    
    <body>
        
        <div class="container">
            <div class="title">
                ユーザー情報の変更
            </div>
        
            <div class="subtitle">
                ここでは名前、パスワード、メールアドレス、住所を変更するこどができます。
            </div>
            
            <div class="update">
                <div class="row">
                    <span>名前</span>
                    <a class="update-btn" href="">編集</a>
                    <br>
                    <span><%= jb.getLoginUserName() %></span>
                </div>
                <div class="row">
                    <span>パスワード</span>
                    <a class="update-btn" href="">編集</a>
                    <br>
                    <span><%= jb.getLoginPassword().replaceAll(".","*") %></span>
                </div>
                <div class="row">
                    <span>メールアドレス</span>
                    <a class="update-btn" href="">編集</a>
                    <br>
                    <span><%= jb.getMail() %></span>
                </div>
                <div class="row">
                    <span>住所</span>
                    <a class="update-btn" href="">編集</a>
                    <br>
                    <span><%= jb.getAddress() %></span>
                    
                </div>
            </div>
            
        </div>
        
    </body>
    
    
</html>
