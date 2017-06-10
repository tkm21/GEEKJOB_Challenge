
<%@ page contentType = "text/html" pageEncoding = "UTF-8" %>
<%@ page import = "jums.*" %>

<!DOCTYPE html>
<html>
    
    <head>
        <meta http-equiv = "Content-Type" content = "text/html; charset=UTF-8">
        <title>登録</title>
    </head>
    
    
    <body>
        
        <div align = "center">
            
            <%
                UserDataBeans udb = (UserDataBeans)session.getAttribute("udb");
            %>
            
            <h1>確認</h1>
            
            <table border = "1" cellspacing = "0" cellpadding = "5">
                <tr>
                    <th width = 150>名前</th>
                    <th width = 100>生年月日</th>
                    <th width = 200>電話番号</th>
                    <th width = 100>種別</th>
                    <th width = 200>コメント</th>
                </tr>
                <tr>
                    <td align = "center" height = 40><%= udb.getName() %></td>
                    <td align = "center"><%= udb.getBirthday() %></td>
                    <td align = "center"><%= udb.getTell() %></td>
                    <td align = "center">
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
                    <td align = "center"><%= udb.getComment() %></td>
                </tr>
            </table>
            
            <br>
            
            上記の内容で登録します。よろしいですか？<br>
            
            <br>
            
            <!-- 登録結果に進む -->
            <form action = "InsertResult" method = "POST" style = "display: inline">
                <input type = "submit" name = "yes" value = "はい">
                <!-- 直リンク防止用 -->
                <input type = "hidden" name = "ac" value = "<%= session.getAttribute("ac") %>">
            </form>　
            
            <!-- 登録画面に戻る -->
            <form action = "insert.jsp" method = "POST" style = "display: inline">
                <input type = "submit" name="no" value = "戻る">
            </form><br>
            
            <br>
            
            <!-- トップリンク -->
            <%= JumsHelper.getInstance().home() %>
        
        </div>
        
    </body>
    
</html>
