
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.*"%>
<%@page import="Kagoyume.*"%>
 
<%
    // sdb
    SearchDataBeans sdb = (SearchDataBeans)session.getAttribute("usd");
%>

<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" href="item.css">
        <title>商品詳細</title>
    </head>
    
    <body>
        
        <div class="title">
            商品詳細
        </div>
        
        <div class="sdf">
            <div class="item-left">
                <img src="<%= sdb.getProductImage()%>" class="ProductImage">
            </div>
        
            <div class="product">
                <div class="product-top">
                    <h2><%= sdb.getProductName()%></h2>
                    <span>評価：<%= sdb.getProductRate()%></span>
                </div>
            
                <div>
                    <div>
                        価格：<span class="darkred"><%= String.format("%,d", Integer.parseInt(sdb.getProductPrice()))%>円</span>
                    </div>
                    <div>
                        商品説明：<br>
                        <span><%= sdb.getProductDescrition()%></span>
                    </div>
                    <div class="item-right">
                        <form action="AddCart?product_code=<%= sdb.getProductCode() %>" method="POST">
                            <input type="hidden" name="productCode" value="<%= sdb.getProductCode()%>">
                            <!--直リンク禁止用-->
                            <input type = "hidden" name = "ac" value = "<%= session.getAttribute("ac") %>">
                            <input type="submit" value="カートに追加">
                        </form>
                    </div>
                </div>
            </div>   
        </div>
        
                    
    </body>
    
</html>
                    
                 
