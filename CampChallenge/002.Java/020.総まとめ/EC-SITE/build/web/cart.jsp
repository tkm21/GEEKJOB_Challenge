
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.*"%>
<%@page import="Kagoyume.*"%>

<%
    // JavaBeans
    JavaBeans jb = (JavaBeans)session.getAttribute("jb");
%>

<!DOCTYPE html>
<html>
    
    
    <head>
        <link rel="stylesheet" href="cart.css">
        <title>ショッピングカート</title>
    </head>
    
    
    <body>
        
        <div class="container">
            <div class="title">
            ショッピングカート
            </div>
        
            <div class="subtitle">
                「カートに追加」を押した商品が表示されます。<br>
                <%
                    if(jb.getCart().size() == 0) {
                %>
                現在、お客様のショッピングカートに商品はありません。<br>
                <%
                    }
                %>
            </div>
            
            <div class="cart-left">
                <%
                    int total = 0;
                    for(int i = 0; i < jb.getItemDatas().size(); i ++) {
                        SearchDataBeans itemData = jb.getItemDatas().get(i);
                %>
                    <table>
                        <tr>
                            <td>
                                <a href="Item?product_code=<%= itemData.getProductCode()%>" target="_blank">
                                    <img src="<%= itemData.getProductImage()%>">
                                </a>
                            </td>
                            <td class="name">
                                <span><a href="Item?product_code=<%= itemData.getProductCode()%>" target="_blank"><%= itemData.getProductName()%></a></span>
                            </td>
                            <td class="price">
                                <span><%= String.format("%,d", Integer.parseInt(itemData.getProductPrice()))%>円</span>
                            </td>
                            <td>
                                <form action="DeleteItem" method="POST">
                                    <input type="hidden" name="productCode" value="<%= itemData.getProductCode()%>">
                                    <input type="submit" value="削除">
                                </form>
                            </td>
                        </tr>
                    </table>
            <%
                total += Integer.parseInt(itemData.getProductPrice());
                }
            %>
        </div>
        <div class="cart-right">
            <div>小計(<%= jb.getCart().size() %>点)：<%= String.format("%,d", total)%>円</div>
            <form action="Buy" method="POST">
                <%
                    if(jb.getCart().size() != 0) {
                %>
                        <input type="submit" value="レジに進む">
                <%
                    } else {
                %>
                        <input type="submit" value="レジに進む" disabled="disabled">
                <%
                    }
                %>
                
            </form>
        </div>
        </div>
        
            

        
        
        
    </body>
</html>
