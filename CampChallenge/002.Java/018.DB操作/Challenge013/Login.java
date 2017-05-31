
package org.camp.servlet;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.sql.*;

public class Login extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<body>");
        
        
        HttpSession session = request.getSession();
        session.setAttribute("log", false);
        
        
        // 入力内容の取得
        request.setCharacterEncoding("UTF-8");
        String userName = request.getParameter("userName");
        String password = request.getParameter("password");
        
        
        // SQLログイン情報
        String url = "jdbc:mysql://localhost:8889/Challenge_db";
        String sqluser = "tkm21";
        String sqlpassword = "root";
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet data = null;
        String sql;
        
        
        try {
            
            
            // SQLログイン
            Class.forName("com.mysql.jdbc.Driver").newInstance(); // => DriverManager
            connection = DriverManager.getConnection(url, sqluser, sqlpassword);
            
            
            // userテーブルを取得
            sql = "select * from user";
            statement = connection.prepareStatement(sql);
            data = statement.executeQuery();
            
            
            // チェック
            while(data.next()) {
                if(userName.equals(data.getString("userName")) && password.equals(data.getString("password"))) {
                    session.setAttribute("log", true);
                }
            }
            
            
            // クローズ
            data.close();
            statement.close();
            connection.close();
            
            
            // 移動
            RequestDispatcher rd;
            if((boolean)session.getAttribute("log")) {
                rd = request.getRequestDispatcher("/jsp/product.jsp");
            } else {
                rd = request.getRequestDispatcher("/jsp/login.jsp");
            }
            rd.forward(request, response);
            
            
        } catch(SQLException e_sql) {
            
            
            out.print("Error1：" + e_sql.toString() + "<br>");
            
            
        } catch(Exception e) {
            
            
            RequestDispatcher rd;
            rd = request.getRequestDispatcher("/jsp/login.jsp");
            rd.forward(request, response);
            
            
        } finally {
        }
        
        
        out.println("</body>");
        out.println("</html>");
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
