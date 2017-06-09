
<%@ page contentType = "text/html" pageEncoding = "UTF-8"%>
<%@ page import = "jums.*" %>

<!DOCTYPE html>
<html>
    
    <head>
        <meta http-equiv = "Content-Type" content = "text/html; charset=UTF-8">
        <title>削除完了</title>
    </head>
    
    
    <body>
        
        <div align = "center">
            
            <h1>削除完了</h1>
            
            <%
                UserDataBeans udb = (UserDataBeans)session.getAttribute("udb");
            %>
            
            <!-- 表示 -->
            <table border="1" cellspacing="0" cellpadding="5">
                <tr>
                    <th>ＩＤ</th>
                    <th>名前</th>
                    <th>生年月日</th>
                    <th>電話番号</th>
                    <th>種別</th>
                    <th>コメント</th>
                    
                </tr>
                <tr>
                    <td><%= udb.getID() %></td>
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
                
                上記の内容を削除しました。<br>
                
                <br>
                
                <form action = "" method = "POST">
                    <input type = "submit" value = "取り消し">
                </form>
                
                <br>
                
                <!-- トップリンク -->
                <%= JumsHelper.getInstance().home() %>
        
        </div>
        
    </body>
    
</html>
