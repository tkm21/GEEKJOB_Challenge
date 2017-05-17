
package org.camp.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.*;
import java.text.*;


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
            
            
            Calendar c = Calendar.getInstance();
            // 2015/01/01 00:00:00
            c.set(2015,0,1,1,0,0);
            long timeStamp1 = c.getTime().getTime();
            // 2015/12/31 23:59:59
            c.set(2015,11,31,23,59,59);
            long timeStamp2 = c.getTime().getTime();
             
            long timeStamp = timeStamp2 - timeStamp1;
            
            out.print("365日は<br>" + timeStamp + "ミリ秒<br>");
            
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
