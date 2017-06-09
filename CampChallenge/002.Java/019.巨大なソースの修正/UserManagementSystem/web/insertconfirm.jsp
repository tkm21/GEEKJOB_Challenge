
<%@ page contentType = "text/html" pageEncoding = "UTF-8" %>
<%@ page import = "jums.*" %>

<!DOCTYPE html>
<html>
    
    <head>
        <meta http-equiv = "Content-Type" content = "text/html; charset=UTF-8">
        <title>登録確認画面</title>
    </head>
    
    
    <body>
        
        <div align="center">
            
            <%
                UserDataBeans udb = (UserDataBeans)session.getAttribute("udb");
            %>
            
            <h1>確認画面</h1>
            
            <table border="1" cellspacing="0" cellpadding="5">
                <tr>
                    <th>名前</th>
                    <th>生年月日</th>
                    <th>電話番号</th>
                    <th>種別</th>
                    <th>コメント</th>
                </tr>
                <tr>
                    <td><%= udb.getName() %></td>
                    <td><%= udb.getBirthday() %></td>
                    <td><%= udb.getTell() %></td>
                    <td>
                        <%
                            if(udb.getType() == 1) {
                                out.print("エンジニア");
                            } else if(udb.getType() == 2) {
                                out.print("営業");
                            } else {
                                out.print("その他");
                            }
                        %>
                    </td>
                    <td><%= udb.getComment() %></td>
                </tr>
            </table>
            
            <br>
            
            上記の内容で登録します。よろしいですか？<br>
            
            <br>
            
            <form action="InsertResult" method="POST" style="display: inline">
                <input type="submit" name="yes" value="はい">
                <!-- 直リンク防止用 -->
                <input type = "hidden" name = "ac" value = "<%= session.getAttribute("ac") %>">
            </form>
            
            <form action="insert.jsp" method="POST" style="display: inline">
                <input type="submit" name="no" value="戻る">
            </form><br>
            
            <br>
            
            <%= JumsHelper.getInstance().home() %>
        
        </div>
        
    </body>
    
</html>
