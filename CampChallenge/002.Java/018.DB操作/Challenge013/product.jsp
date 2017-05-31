
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.sql.*" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>商品一覧</title>
    </head>
    <body>
        
        
        【商品追加】
        <form action="http://localhost:8080/StockContorolSystem/NewProduct" method="post">
            商品名：<input type="text" name="product" >
            在庫数：<input type="number" name="stock">
            <input type="submit" value="商品追加"><br>
        </form>
        <br>
        
        
        【商品削除】
        <form action="http://localhost:8080/StockContorolSystem/DeleteProduct" method="post">
            ＩＤ：<input type="number" name="id">
            <input type="submit" value="商品削除"><br>
        </form>
        <br><br>
        <form action="http://localhost:8080/StockContorolSystem/Logout" method="post">
            <input type="submit" value="ログアウト"><br>
        </form>
        
        
        <h1>
        【商品一覧】<br>
        <%
            
            
            if(session.getAttribute("log").equals(false)) {
                RequestDispatcher rd;
                rd = request.getRequestDispatcher("/jsp/login.jsp");
                rd.forward(request, response);
            }
            
            
            String url = "jdbc:mysql://localhost:8889/Challenge_db";
            String sqluser = "tkm21";
            String sqlpassword = "root";
        
            
            Connection connection = null;
            String sql;
            PreparedStatement statement = null;
            ResultSet data = null;
            
            
            try {
                
                
                // SQLログイン
                Class.forName("com.mysql.jdbc.Driver").newInstance();
                connection = DriverManager.getConnection(url, sqluser, sqlpassword);
                
                
                // productテーブルを取得
                sql = "select * from products";
                statement = connection.prepareStatement(sql);
                data = statement.executeQuery();
                
                
                //　テーブル表示
                while(data.next()) {
                out.print(data.getString("id") + "　" + data.getString("product") + "　在庫(" + data.getString("stock") + ")<br>");
                }
                
                
                // クローズ
                data.close();
                statement.close();
                connection.close();
            
            
            } catch(SQLException e_sql) {
                
                
                out.print("Error：" + e_sql.toString() + "<br>");
            
            
            } catch(Exception e) {
                
                
                out.print("Error：" + e.toString() + "<br>");
                
                
            } finally {
            }
            

        %>
        </h1>
        
        
    </body>
</html>
