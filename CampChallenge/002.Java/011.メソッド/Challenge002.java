
package org.camp.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
            for (int i = 1; i <= 10; i ++) {
                out.print (i + "は");
                numJudge (i, out);
            }

            out.println("</body>");
            out.println("</html>");
        }
    }

    // メソッド
    void numJudge(int num, PrintWriter out){
        if (num % 2 == 0) {
            out.print("偶数です。<br>");
        } else {
            out.print("奇数です。<br>");
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
