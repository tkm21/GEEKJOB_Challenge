
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.*"%>
<%@page import="Kagoyume.*"%>

<%
            // JavaBeans
            JavaBeans jb = (JavaBeans)session.getAttribute("jb");
            if(jb==null) {
                jb = new JavaBeans();
            }
%>

<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" href="header.css">
        <title>検索</title>
    </head>
    
    <body>
        
        <div class="header">
    
            <div class="logo">
                <a href="Top" >Kagoyume</a>
            </div>
    
    
            <div class="search_form">
                <form action="Search" method="GET">
                    <span class="form_left">
                        <select name="category">
                            <%
                                int category = 1;
                                if(request.getParameter("category") != null) {
                                    category = Integer.parseInt(request.getParameter("category"));
                                }
                                String keyword = "";
                                if(request.getParameter("keyword") != null) {
                                    keyword = request.getParameter("keyword");
                                }
                                for(Map.Entry<Integer, String> val: KagoyumeHelper.getInstance().category().entrySet()) {
                                    if(val.getKey() == category) {
                            %>
                                        <option value="<%= val.getKey() %>" selected><%= val.getValue() %></option>
                            <%
                                    } else {
                            %>
                                        <option value="<%= val.getKey() %>"><%= val.getValue() %></option>
                            <%
                                    }
                                }
                            %>
                        </select>
                    </span>
                    <span class="form_center">
                        <input type="text" name="keyword" value="<%= keyword %>" placeholder = "商品を検索" class="search-box">
                    </span>
                    <span class="form_right">
                        <input type="submit" value="検索" class="submit-btn">
                    </span>
                </form>
            </div>
            
                
            <div class="header-right">
                <%
                    if(!jb.getLogFlag()) {
                %>
                <span>
                        <a href="Login" class="border-right">ログイン</a>
                        <a href="Registration">アカウント作成</a>
                </span>
                <%
                    } else {
                %>
                <span>
                        <a href="Account" class="border-right">ようこそ<%= jb.getLoginUserName() %>さん</a>
                        <a href="Cart">カート(<%= jb.getCart().size() %>)</a>
                </span>
                <%
                    }
                %>
            </div>
            
        </div>
    </body>
</html>