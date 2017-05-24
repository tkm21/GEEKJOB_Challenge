
package org.camp.servlet;

import javax.servlet.*;
import javax.servlet.http.*;
import java.util.*;
import java.text.*;
import java.lang.*;
import java.io.*;


public class CampChallenge extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {

            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>課題</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>");


            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

            // 現在時刻取得
            Date now = new Date();
            String time = sdf.format(now);
            
            // 現在時刻表示
            out.print("現在時刻：" + time + "<br><br>");

            // 現在時刻保存(変数 = "LastLogin")
            Cookie c = new Cookie("LastLogin", time);
            response.addCookie(c);

            // クッキー取得
            Cookie cs[] = request.getCookies();

            // 取得したクッキーから"LastLogin"を探知
            for(int i=0; i<cs.length; i++) {
                if(cs[i].getName().equals("LastLogin")) {
                    out.print("最終ログイン："+ cs[i].getValue());
                    out.print("<br>");
                    break;
                }
            }


            out.println("</h1>");
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
