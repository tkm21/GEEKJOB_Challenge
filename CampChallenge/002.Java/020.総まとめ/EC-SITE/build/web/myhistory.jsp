
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.*"%>
<%@page import="java.text.*"%>
<%@page import="Kagoyume.*"%>

<%
    // JavaBeans
    JavaBeans jb = (JavaBeans)session.getAttribute("jb");
    
    // 商品コードを保存するための変数を定義
    String code;
    
    // 商品画像を保存する変数の定義
    String image;
    
    // 商品名を保存する変数の定義
    String name;
    
    // 商品金額を保存する変数の定義
    int price = 0;
    
    // 合計利用金額を保存する変数の定義
    int total = 0;
    
    // 購入日時を保存する変数の定義
    Date date;
    String date_str; 
    
    // 商品データが入っている配列を定義
    ArrayList<SearchDataBeans> itemDatas = jb.getItemDatas();
    
    // 商品データを保存する変数の定義
    SearchDataBeans itemData;
%>

<!DOCTYPE html>
<html>
    
    
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" href="myhistory.css">
    </head>
    
    
    <body>
        
        <div class="container">
            
            <div class="title">
            注文履歴
            </div>
            
            <div class="subtitle">
                今日までの注文履歴が表示されます。<br>
                <%
                    if(jb.getHistory().size() == 0) {
                %>
                        現在、注文履歴はありません。<br>
                <%
                    }
                %>
            </div>
            
            <div class="myhistorys">
                <%
                    for(Map.Entry<String, String> val: jb.getHistory().entrySet()) {
                        itemData = API.getDetail(val.getKey());
                        image = itemData.getProductImage();
                        name = itemData.getProductName();
                        code = itemData.getProductCode();
                        price = Integer.parseInt(itemData.getProductPrice());
                        total += price;
                        date = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.S").parse(val.getValue());
                        date_str = new SimpleDateFormat("yyyy年MM月dd日hh時mm分ss秒").format(date);
                %>
                        <div class="myhistory">
                                <div class="date">
                                    <span>注文日</span><br>
                                    <span><%= date_str %></span>
                                </div>
                                <div class="item">
                                    <div class="image">
                                        <a href="Item?product_code=<%= code %>">
                                            <img src="<%= image %>" alt="[Get Picture]">
                                        </a>
                                    </div>
                                    <div class="detail">
                                        <div class="name">
                                            <a href="Item?product_code=<%= code %>" target="_blank"><%= name %></a>
                                        </div>
                                        <span class="price">
                                            <span><%= String.format("%,d", price)%>円</span>
                                        </span>
                                    </div>
                                </div>
                        </div>
                <%
                    }
                %>
            </div>
            
        </div>
        
    </body>
    
    
</html>
