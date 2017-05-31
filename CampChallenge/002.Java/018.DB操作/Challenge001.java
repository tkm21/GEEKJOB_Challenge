
package org.camp.servlet;

import javax.servlet.*;
import javax.servlet.http.*;
import java.util.*;
import java.text.*;
import java.lang.*;
import java.io.*;
import java.sql.*;


public class CampChallenge extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.println("<html>");
        out.println("<head>");
        out.println("<title>課題</title>");
        out.println("</head>");
        out.println("<body>");

        // ログイン情報
        String url = "jdbc:mysql://localhost:8889/Challenge_db";
        String user = "tkm21";
        String password = "root";

        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet data = null;
        String sql;

        try {

            Class.forName("com.mysql.jdbc.Driver").newInstance(); // = DriverManager
            connection = DriverManager.getConnection(url, user, password); // データベースへの接続

            out.print("接続に成功しました<br>");

            // クローズ
            connection.close();

        } catch(SQLException e_sql) {

            out.print("Error：" + e_sql.toString() + "<br>");

        } catch(Exception e) {

            out.print("Error：" + e.toString() + "<br>");

        } finally {

            if(connection != null) {
                try {
                    connection.close();
                } catch (Exception e_con) {
                    System.out.println(e_con.getMessage());
                }
            }

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
