
<%@ page contentType = "text/html" pageEncoding = "UTF-8"%>
<%@ page import = "jums.*" %>

<!DOCTYPE html>
<html>
    
    
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>登録画面</title>
    </head>
    
    
    <body>
        
        
        <div align="center">
            
            <%
                UserDataBeans udb = (UserDataBeans)session.getAttribute("udb");
            %>
            
            <h1>登録画面</h1>
            
            <form action = "InsertConfirm" method = "POST">
                
                名前<br>
                <input type = "text" name = "name" value = "<%= udb.getName() %>"><br>
                
                <br>
                
                生年月日<br>
                <!--年-->
                <select name = "year">
                    <option value = "">----</option>
                    <%
                        for(int i = 1950; i <= 2010; i ++) {
                            if(i == udb.getYear()) {
                    %>
                                <option value = "<%= i %>" selected><%= i %></option>
                    <%
                            } else {
                    %>
                                <option value = "<%= i %>"><%= i %></option>
                    <%
                            }
                        }
                    %>
                </select>年
                <!--月-->
                <select name = "month">
                    <option value = "">--</option>
                    <%
                        for(int i = 1; i <= 12; i ++) {
                            if(i == udb.getMonth()) {
                    %>
                                <option value = "<%= i %>" selected><%= i %></option>
                    <%
                            } else {
                    %>
                                <option value = "<%= i %>"><%= i %></option>
                    <%
                            }
                        }
                    %>
                </select>月
                <!--日-->
                <select name = "day">
                    <option value = "">--</option>
                    <%
                        for(int i = 1; i <= 31; i ++) {
                            if(i == udb.getDay()) {
                    %>
                                <option value = "<%= i %>" selected><%= i %></option>
                    <%
                            } else {
                    %>
                                <option value = "<%= i %>"><%= i %></option>
                    <%
                            }
                        }
                    %>
                </select>日<br>
                
                <br>
            
                種別<br>
                選択してください<input type = "radio" name = "type" value = "0" <%= udb.getType() == 0 ? "checked=\"checked\"" : "" %>><br>
                エンジニア<input type = "radio" name = "type" value = "1" <%= udb.getType() == 1 ? "checked=\"checked\"" : "" %>>　
                営業<input type = "radio" name = "type" value = "2" <%= udb.getType() == 2 ? "checked=\"checked\"" : "" %>>　
                その他<input type = "radio" name = "type" value = "3" <%= udb.getType() == 3 ? "checked=\"checked\"" : "" %>><br>
                
                <br>
            
                電話番号<br>
                <input type = "text" name = "tell" value = "<%= udb.getTell() %>"><br>
                
                <br>
            
                自己紹介文<br>
                <textarea name = "comment" rows = 10 cols = 50 style = "resize:none" wrap = "hard"><%= udb.getComment() %></textarea><br>
                
                <br>
            
                <input type = "submit" name = "btnSubmit" value = "確認画面へ">
            
                <!-- 直リンク防止用 -->
                <input type = "hidden" name = "ac" value = "<%= session.getAttribute("ac") %>">
            
            </form><br>
            
            <%
                if(udb.getCount()) {
                    if(udb.getName().equals("")) {
                        out.print("名前を入力してください。<br>");
                    }
                    if(udb.getYear() == 0 || udb.getMonth() == 0 || udb.getDay() == 0) {
                        out.print("生年月日をすべて入力してください。<br>");
                    }
                    if(udb.getType() == 0) {
                        out.print("タイプを選択してください。<br>");
                    }
                    if(udb.getTell().equals("")) {
                        out.print("電話番号を入力してください。<br>");
                    }
                    if(udb.getComment().equals("")) {
                        out.print("自己紹介文を入力してください。<br>");
                    }
                }
            %>
            
            <br>
            
            <%= JumsHelper.getInstance().home() %>
        
        </div>
        
    </body>
    
    
</html>

