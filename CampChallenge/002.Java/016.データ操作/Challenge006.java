
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
            HttpSession hs = request.getSession();
            
            // 現在時刻取得
            Date now = new Date();
            String time = sdf.format(now);
            
            // 現在時刻表示
            out.print("現在時刻：" + time + "<br>");
            
            // 前回時刻取得
            if(hs.getAttribute("LastAccess") != null) {
                String lunch = (String)hs.getAttribute("LastAccess");
                out.print("前回時刻：" + lunch);
            }
            
            // 現在時刻登録
            hs.setAttribute("LastAccess", time);
            
            
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
