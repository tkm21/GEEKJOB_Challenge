
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="Kagoyume.*"%>

<!DOCTYPE html>
<html>
    
    
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login</title>
        <link rel="stylesheet" href="login.css">
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
                
                <div class="login">
                    <h2>ログイン</h2>
                    <form action="LoginCheck" method="POST">
                        <span>ユーザー名</span><br>
                        <input class="input" type="text" name="loginUserName" value="<%= jb.getLoginUserName() %>"><br>
                        <span>パスワード</span><br>
                        <input class="input" type="password" name="loginPassword" value="<%= jb.getLoginPassword() %>"><br>
                        <input class="btn" type="submit" value="サインイン" >
                        <!--直リンク禁止用-->
                        <input type = "hidden" name = "ac" value = "<%= session.getAttribute("ac") %>">
                    </form>
                </div>
                
                <div class="registration">
                    <span>アカウントをお持ちでありませんか？</span>
                    <a class="btn" href="Registration">アカウントを作成</a>
                </div>
            </div>
          
        <br>
        
        
                    
            
            
            <p class="error-message">
            <%
                if(jb.getLoginErrorFlag()) {
                    out.print("エラー<br>");
                    
                        if(jb.getLoginUserName().length() != 0) {
                            if(!UserDataDAO.getInstance().checkuserName(jb.getLoginUserName())) {
                                    out.print("このユーザー名は登録されていません<br>");
                                } else {
                                    if(jb.getLoginPassword().length() != 0) {
                                        out.print("パスワードが正しくありません<br>");
                                    } else {
                                        out.print("パスワードが入力されていません<br>");
                                    }
                                }
                        } else {
                            out.print("ユーザー名が入力されていません<br>");
                            if(jb.getLoginPassword().length() == 0) {
                                out.print("パスワードが入力されていません<br>");
                            }
                        }
                        
                }
            %>
            </p>
            
        
    </body>
    
    
</html>
