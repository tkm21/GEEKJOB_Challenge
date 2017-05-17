
package org.camp.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.*;

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

            // 表示
            ArrayList<String> profile = new ArrayList<String>();
            profile = profileAdd();
            for(int i = 1; i < profile.size(); i ++) {
                out.print(profile.get(i) + "<br>");
            }

            out.println("</body>");
            out.println("</html>");
        }
    }

    // メソッド
    ArrayList<String> profileAdd() {
        ArrayList<String> profile = new ArrayList<String>();
        profile.add("1");
        profile.add("渡邉拓海");
        profile.add("1996年09月21日");
        profile.add("茨城県龍ケ崎市");
        return profile;
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
