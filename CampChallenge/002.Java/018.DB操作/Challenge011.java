
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
        out.println("レコードの更新");
        out.println("<form action = \"CampChallenge\" method = \"post\">");
        out.println("ＩＤ：<input type = \"text\" name = \"id\">");
        out.println("名前：<input type = \"text\" name = \"name\">");
        out.println("電話番号：<input type = \"text\" name = \"tell\">");
        out.println("年齢：<input type = \"text\" name = \"age\">");
        out.println("誕生日：<input type = \"text\" name = \"birthday\">");
        out.println("<input type = submit name = \"btn\" value = \"更新\">");
        out.println("</form>");

        request.setCharacterEncoding("UTF-8");
        String a = request.getParameter("id");
        String b = request.getParameter("name");
        String c = request.getParameter("tell");
        String d = request.getParameter("age");
        String e = request.getParameter("birthday");

        HttpSession hs = request.getSession();
        hs.setAttribute("id", a);
        hs.setAttribute("name", b);
        hs.setAttribute("tell", c);
        hs.setAttribute("age", d);
        hs.setAttribute("birthday", e);
        String id = (String)hs.getAttribute("id");
        String name = (String)hs.getAttribute("name");
        String tell = (String)hs.getAttribute("tell");
        String age = (String)hs.getAttribute("age");
        String birthday = (String)hs.getAttribute("birthday");

        // ログイン情報
        String url = "jdbc:mysql://localhost:8889/Challenge_db";
        String user = "tkm21";
        String password = "root";

        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet data = null;
        String sql = null;

        try {

            Class.forName("com.mysql.jdbc.Driver").newInstance(); // = DriverManager
            connection = DriverManager.getConnection(url,user,password);

            sql = "UPDATE profiles SET name = '" + name + "', tell = '" + tell + "', age = " + Integer.parseInt(age) + ",birthday = '" + birthday + "' WHERE profilesID =" + Integer.parseInt(id);
            statement = connection.prepareStatement(sql);
            statement.executeUpdate(); // 更新

            sql = "SELECT * FROM profiles";
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
