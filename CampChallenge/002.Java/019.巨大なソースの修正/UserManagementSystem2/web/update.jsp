
<%@ page contentType = "text/html" pageEncoding = "UTF-8"%>
<%@ page import = "jums.*" %>

<!DOCTYPE html>
<html>
    
    
    <head>
        <meta http-equiv = "Content-Type" content = "text/html; charset=UTF-8">
        <title>編集</title>
    </head>
    
    
    <body>
        
        <%
            UserDataBeans udb = (UserDataBeans)session.getAttribute("udb");
        %>
        
        <div align="center">
            
            <h1>編集</h1>
            
            ＩＤ：<%= udb.getID() %><br>
            
            <br>
            
            <form action = "UpdateConfirm" method = "POST" accept-charset = "UTF-8">
                
                名前<br>
                <input type = "text" name = "name" value = "<%= udb.getName() %>" placeholder = "例)山田 太郎"><br>
                
                <br>
                
                生年月日<br>
                <!--年-->
                <select name = "year">
                    <option value = "">----</option>
                    <%
                        for(int i = 1950; i <= 2017; i ++) {
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
                <input type = "text" name = "tell" value = "<%= udb.getTell() %>" placeholder = "×××-××××-××××"><br>
                
                <br>
            
                自己紹介文<br>
                <textarea name = "comment" rows = 10 cols = 50 style = "resize:none" wrap = "hard" placeholder = "自己紹介をを入力してください。"><%= udb.getComment() %></textarea><br>
                
                <br>
            
                <input type = "submit" name = "btnSubmit" value = "確認画面">
                
                <!-- 直リンク防止用 -->
                <input type = "hidden" name = "ac" value = "<%= session.getAttribute("ac") %>">
            
            </form><br>
            
            <!-- 詳細画面に戻る -->
            <form action = "ResultDetail" method = "POST">
                <input type = "submit" value = "戻る">
                <input type = "hidden" name = "userID" value = "<%= udb.getID() %>">
            </form><br>
            
            <%
                if(udb.getFlag()) {
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
                
            <!-- トップリンク -->
            <%= JumsHelper.getInstance().home() %>
            
        </div>
            
    </body>
    
    
</html>
