
package org.camp.servlet;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.sql.*;


public class DeleteProduct extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<body>");
            
            
            // 入力内容の取得
            request.setCharacterEncoding("UTF-8");
            String id = request.getParameter("id");
            
            
            // SQLログイン情報
            String url = "jdbc:mysql://localhost:8889/Challenge_db";
            String sqluser = "tkm21";
            String sqlpassword = "root";
            Connection connection = null;
            PreparedStatement statement = null;
            String sql;
            
            
            try {
                
                
                // SQLログイン
                Class.forName("com.mysql.jdbc.Driver").newInstance(); // => DriverManager
                connection = DriverManager.getConnection(url, sqluser, sqlpassword);
            
            
                // 削除
                sql = "delete from products where id = " + Integer.parseInt(id);
                statement = connection.prepareStatement(sql);
                statement.executeUpdate(); 
                
                
                // idを詰める
                sql = "SET @j := 0";
                statement = connection.prepareStatement(sql);
                statement.executeUpdate(); 
                sql = "UPDATE products SET id = (@j := @j +1);";
                statement = connection.prepareStatement(sql);
                statement.executeUpdate(); 
                
                
                // クローズ
                statement.close();
                connection.close();
                
                
                RequestDispatcher rd;
                rd = request.getRequestDispatcher("/jsp/product.jsp");
                rd.forward(request, response);
                
                
            } catch(SQLException e_sql) {
                
                
                out.print("Error1：" + e_sql.toString() + "<br>");
                
                
            } catch(Exception e) {
                
                
                RequestDispatcher rd;
                rd = request.getRequestDispatcher("/jsp/product.jsp");
                rd.forward(request, response);
                
                
            } finally {
            }
            
            
            out.println("</body>");
            out.println("</html>");
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    
    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
