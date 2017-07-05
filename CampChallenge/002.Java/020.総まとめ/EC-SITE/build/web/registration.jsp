
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="Kagoyume.*"%>

<!DOCTYPE html>
<html>
    
    
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login</title>
        <link rel="stylesheet" href="registration.css">
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
                    <h2>アカウント作成</h2>
                    <form action="RegistrationConfirm" method="POST">
                        <span>ユーザー名</span><br>
                        <input class="input" type="text" name="registrationUserName" value="<%= jb.getRegistrationUserName() %>"><br>
                        <span>パスワード</span><br>
                        <input class="input" type="password" name="registrationPassword" value="<%= jb.getRegistrationPassword() %>"><br>
                        <span>パスワード（確認用）</span><br>
                        <input class="input" type="password" name="registrationPasswordConfirm" value="<%= jb.getRegistrationPasswordConfirm() %>"><br>
                        <span>メールアドレス</span><br>
                        <input class="input" type="text" name="registrationMail" value="<%= jb.getRegistrationMail() %>"><br>
                        <span>住所</span><br>
                        <input class="input" type="text" name="registrationAddress" value="<%= jb.getRegistrationAddress() %>"><br>
                        <input class="btn" type="submit" value="アカウントを作成" >
                        <!--直リンク禁止用-->
                        <input type = "hidden" name = "ac" value = "<%= session.getAttribute("ac") %>">
                    </form>
                </div>
                
                <div class="login">
                    <span>アカウントをすでにお持ちですか？</span>
                    <a class="btn" href="Login">ログイン</a>
                </div>
            </div>
                    
            <br>
                    
            <p class="error-message">
            <%
                if(jb.getRegistrationErrorFlag()) {
                    out.print("エラー<br>");
                    
                        if(jb.getRegistrationUserName().length() != 0) {
                            if(UserDataDAO.getInstance().checkuserName(jb.getRegistrationUserName())) {
                                out.print("このユーザー名はすでに登録されています<br>");
                            }
                        } else {
                            out.print("ユーザー名が入力されていません<br>");
                        }
                        
                        if(jb.getRegistrationPassword().length() != 0) {
                            if(!jb.getRegistrationPassword().equals(jb.getRegistrationPasswordConfirm())) {
                                out.print("パスワードが一致しません<br>");
                            }
                        } else {
                            out.print("パスワードが入力されていません<br>");
                        }
                        
                        if(jb.getRegistrationMail().length() == 0) {
                            out.print("メールアドレスが入力されていません<br>");
                        }
                        if(jb.getRegistrationAddress().length() == 0) {
                            out.print("住所が入力されていません<br>");
                        }
                        
                            
                        
                }
            %>
            </p>
          
    </body>
    
    
</html>
