
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
            profile = profileFind("3");
            for(int i = 1; i < profile.size(); i ++) {
                out.print(profile.get(i) + "<br>");
            }

            out.println("</body>");
            out.println("</html>");
        }
    }

    // メソッド
    ArrayList<String> profileFind(String id) {

        ArrayList<String> profile1 = new ArrayList<String>();
        profile1.add("1");
        profile1.add("HIDE");
        profile1.add("1980年04月03日");
        profile1.add("大阪府");

        ArrayList<String> profile2 = new ArrayList<String>();
        profile2.add("2");
        profile2.add("nivi");
        profile2.add("1980年04月30日");
        profile2.add("宮城県");

        ArrayList<String> profile3 = new ArrayList<String>();
        profile3.add("3");
        profile3.add("92");
        profile3.add("1982年03月21日");
        profile3.add("神奈川県");

        ArrayList<String> profile4 = new ArrayList<String>();
        profile4.add("4");
        profile4.add("SOH");
        profile4.add("1981年02月02日");
        profile4.add("佐賀県");

        ArrayList<String> profile = new ArrayList<String>();
        switch(id) {
            case "1":
                profile = profile1;
                break;
            case "2":
                profile = profile2;
                break;
            case "3":
                profile = profile3;
                break;
            default:
            profile.add("0"); //指定されたIDがない場合、IDが0のみのプロフを返す
            break;
        }
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
