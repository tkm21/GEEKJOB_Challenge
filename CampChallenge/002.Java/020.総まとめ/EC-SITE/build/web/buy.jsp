
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="Kagoyume.*"%>

<!DOCTYPE html>
<html>
    
    
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="buy.css">
        <%
            // JavaBeans
            JavaBeans jb = (JavaBeans)session.getAttribute("jb");
        %>
    </head>
    
    
    <body>
        
        <div class="buy">
            
            <div class="title">
                注文内容確認
            </div>
            
            <div class="main">
                「注文を確定する」ボタンを押して注文頂くことで、商品を注文されたことになります。<br>
                実際に料金が発生したり商品が届くことはございませんのでご了承ください。
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
                                    <span><%= itemData.getProductName()%></span>
                                </td>
                                <td class="price">
                                    <span><%= String.format("%,d", Integer.parseInt(itemData.getProductPrice()))%>円</span>
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
                <form action="BuyComplete" method="POST">
                    <!--直リンク禁止用-->
                    <input type = "hidden" name = "ac" value = "<%= session.getAttribute("ac") %>">
                    <input type="submit" value="注文を確定する">
                </form>
            </div>
        </div>
        
    </body>
    
    
</html>
