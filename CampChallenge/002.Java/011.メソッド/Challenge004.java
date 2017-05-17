
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
                myProfile(out);
                boolean type = myProfile(out);
                if (type = true) {
                    out.print("この処理は正しく実行できました。<br>");
                } else {
                    out.print("正しく実行できませんでした。<br>");
                }
            }

            out.println("</body>");
            out.println("</html>");
        }
    }

    // メソッド
    boolean myProfile(PrintWriter out) {
        out.print ("名前：渡邉拓海<br>");
        out.print ("生年月日：1996年09月21日(20歳)<br>");
        out.print ("好きなアーティストはGReeeeNです。<br>");
        return true;
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
