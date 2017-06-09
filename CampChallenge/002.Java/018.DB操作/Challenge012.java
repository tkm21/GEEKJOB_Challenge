
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
        out.println("レコードの検索<br>");
        out.println("<form action = \"CampChallenge\" method = \"post\">");
        out.println("名前：<input type = \"text\" name = \"name\">");
        out.println("年齢：<input type = \"text\" name = \"age\">");
        out.println("誕生日：<input type = \"text\" name = \"birthday\">");
        out.println("<input type = submit name = \"btn\" value = \"検索\">");
        out.println("</form>");

        request.setCharacterEncoding("UTF-8");
        String b = request.getParameter("name");
        String d = request.getParameter("age");
        String e = request.getParameter("birthday");

        HttpSession hs = request.getSession();
        hs.setAttribute("name", b);
        hs.setAttribute("age", d);
        hs.setAttribute("birthday", e);

        String name = (String)hs.getAttribute("name");
        int age;
        try {
            age = Integer.parseInt(request.getParameter("age"));
        } catch (NumberFormatException nfex) {
            age = 0;
        }
        String birthday = (String)hs.getAttribute("birthday");

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
            connection = DriverManager.getConnection(url,user,password);


            sql = "SELECT * FROM profiles";

            // 条件追加（判定）
            if(name.length() != 0 || age != 0 || birthday.length() != 0) {
                sql += " WHERE";
            }

            boolean check = false;
            if(name.length() != 0) {
                sql += " name LIKE '%" + name + "%'";
                check = true;
            }
            if(age != 0) {
                if(check == true) {
                    sql += " OR";
                }
                sql += " age = " + age;
                check = true;

            }
            if(birthday.length() != 0) {
                if(check == true) {
                    sql += " OR";
                }
                sql += " birthday LIKE '%" + birthday + "%'";
            }

            statement = connection.prepareStatement(sql);
            data = statement.executeQuery(); // データの取得

            // データ表示
            while(data.next()) {
              out.print(data.getInt("profilesID") + "　" + data.getString("name") + "　" + data.getString("tell") + "　" + data.getInt("age") + "　" + data.getString("birthday") + "<br>");
            }

            // クローズ
            data.close();
            statement.close();
            connection.close();

        } catch(SQLException error_sql) {

            out.print("Error：" + error_sql.toString() + "<br>");

        } catch(Exception error) {

            out.print("Error：" + error.toString() + "<br>");

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
