
<%@ page contentType = "text/html" pageEncoding = "UTF-8"%>
<%@ page import = "jums.*" %>

<!DOCTYPE html>
<html>
    
    
    <head>
        <meta http-equiv = "Content-Type" content = "text/html; charset=UTF-8">
        <title>詳細</title>
    </head>
    
    
    <body>
        
        <%
            UserDataBeans udb = (UserDataBeans)session.getAttribute("udb");
        %>
        
        <div align = "center">
            
            <h1>詳細</h1>
            
            <!-- 表示 -->
            <table border = "1" cellspacing = "0" cellpadding = "5">
                <tr>
                    <th width = 80>ＩＤ</th>
                    <th width = 150>名前</th>
                    <th width = 100>生年月日</th>
                    <th width = 200>電話番号</th>
                    <th width = 100>種別</th>
                    <th width = 200>コメント</th>
                    <th width = 200>最終更新</th>
                </tr>
                <tr>
                    <td align = "center" height = 40><%= udb.getID() %></td>
                    <td align = "center"><%= udb.getName() %></td>
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
                    <td align = "center"><%= udb.getNewDate() %></td>
                </tr>
            </table>
            
            <br>
            
            <!-- 編集画面に進む -->
            <form action = "Update" method = "POST" style = "display: inline">
                <input type = "submit" name = "btnSubmit" value = "編集">
                <!-- 直リンク禁止 -->
                <input type = "hidden" name = "ac" value = "<%= session.getAttribute("ac") %>">
            </form>　　
            
            <!-- 削除確認画面に進む -->
            <form action = "Delete" method = "POST" style = "display: inline">
                <input type = "submit" name = "btnSubmit" value = "削除">
                <!-- 直リンク禁止 -->
                <input type = "hidden" name = "ac" value = "<%= session.getAttribute("ac") %>">
            </form><br>
            
            <br>
            
            <!-- 検索画面に戻る -->
            <form action = "Search" style = "display: inline">
                <input type = "submit" value = "戻る">
            </form><br>
            
            <br>
            
            <!-- トップリンク -->
            <%= JumsHelper.getInstance().home() %>
         
        </div>
        
            
    </body>
    
    
</html>
