
<%@ page contentType = "text/html" pageEncoding = "UTF-8" %>
<%@ page import = "jums.*" %>

<!DOCTYPE html>
<html>
    
    
    <head>
        <meta http-equiv = "Content-Type" content = "text/html; charset=UTF-8">
        <title>検索</title>
    </head>
    
    
    <body>
        
        <div align = "center">
            
            <h1>ユーザーリスト</h1>
            
            <br>
            
            <form action = "SearchResult" method = "GET" style = "display: inline">
                名前：<input type = "text" name = "name" value = "<%= request.getParameter("name") %>">　
                生年月日：
                <select name = "year">
                    <option value = "">----</option>
                    <%
                        int year = 0;
                        if(!request.getParameter("year").equals("")) {
                            year = Integer.parseInt(request.getParameter("year"));
                        }
                        for(int i = 1950; i <= 2017; i ++) {
                            if( i == year) {
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
                </select>年生まれ　
                種別：
                エンジニア<input type = "checkbox" name = "type1" value = "1" <%= request.getParameter("type1") != null ? "checked=\"checked\"" : "" %>>
                営業<input type = "checkbox" name = "type2" value = "2" <%= request.getParameter("type2") != null ? "checked=\"checked\"" : "" %>>
                その他<input type = "checkbox" name = "type3" value = "3" <%= request.getParameter("type3") != null ? "checked=\"checked\"" : "" %>>　
                <input type = "submit" value = "検索">
            </form><br>
            
            <br>
            
            <%
                UserDataBeans udb = (UserDataBeans)session.getAttribute("udb");
                if(udb.getNames().size() != 0) {
            %>
                    <table border = "1" cellspacing = "0" cellpadding = "5">
                        <tr>
                        <th width = 150>名前</th>
                        <th width = 100>生年</th>
                        <th width = 100>種別</th>
                        <th width = 240>最終更新</th>
                        </tr>
                        <%
                            for(int i = 0; i < udb.getNames().size(); i ++) {
                        %>
                                <tr>
                                    <td align = "center" height = 40><a href="ResultDetail?userID=<%= udb.getIDs().get(i) %>"><%= udb.getNames().get(i) %></a></td>
                                    <td align = "center"><%= udb.getYears().get(i) %></td>
                                    <%
                                        String type;
                                        if(udb.getTypes().get(i) == 1) {
                                            type = "エンジニア";
                                        } else if(udb.getTypes().get(i) == 2) {
                                            type = "営業";
                                        } else {
                                            type = "その他";
                                        }
                                    %>
                                    <td align = "center"><%= type %></td>
                                    <td align = "center"><%= udb.getNewDates().get(i) %></td>
                                </tr>
                        <%
                            }
                        %>
                    </table>
            <%
                } else {
            %>
                    該当なし<br>
            <%
                }
            %>
        
            <br>
            
            <!-- トップリンク -->
            <%= JumsHelper.getInstance().home() %>
            
        </div>
        
    </body>
    
    
</html>
