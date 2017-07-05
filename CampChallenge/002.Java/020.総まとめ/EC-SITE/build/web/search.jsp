
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.*"%>
<%@page import="Kagoyume.*"%>

<%
    // 商品情報
    ArrayList<SearchDataBeans> itemData = (ArrayList<SearchDataBeans>)session.getAttribute("itemData");
    
    // フォーム初期値設定
    int category = 1;
    if(!request.getParameter("category").isEmpty()) {
        category = Integer.parseInt(request.getParameter("category"));
    }
    String keyword = "";
    if(!request.getParameter("keyword").isEmpty()) {
        keyword = request.getParameter("keyword");
    }
%>

<!DOCTYPE html>
<html>
    
    
    <head>
        <link rel="stylesheet" href="search.css">
        <title>検索</title>
    </head>
    
    
    <body>
        
        <div class="container">
            
            <%
                for(Map.Entry<Integer, String> val: KagoyumeHelper.getInstance().category().entrySet()) {
                    if(val.getKey() == category) {
            %>
                        <div class="title">
                            検索結果 <%= itemData.size() %>件 "<span><%= keyword %></span>"<br>
                            
                        </div>
                        
                        <%
                            if(keyword.isEmpty() && category == 1) {
                        %>
                                <div class="subtitle">
                                    エラー：キーワードの入力をしてください
                                </div>
                        <%
                            }
                        %>
                        
                        <div class="search">
                            <%
                                for (int i = 0; i < itemData.size(); i ++) {
                            %>
                                    <div class="product">
                                        <a href="Item?product_code=<%= itemData.get(i).getProductCode()%>" target="_blank"><img src="<%= itemData.get(i).getProductImage()%>" class="image"></a>
                                        <div class="name">
                                            <a href="Item?product_code=<%= itemData.get(i).getProductCode()%>" target="_blank"><%= itemData.get(i).getProductName()%></a>
                                        </div>
                                        <div>
                                            <%= String.format("%,d", Integer.parseInt(itemData.get(i).getProductPrice()))%>円
                                        </div>
                                    </div>
                            <%
                                }
                            %>
                        </div>
            <%
                    }
                }
            %>
        </div>
        
        </body>
        
        
</html>