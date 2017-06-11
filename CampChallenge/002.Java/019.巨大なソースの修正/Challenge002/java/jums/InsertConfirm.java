
package jums;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class InsertConfirm extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        request.setCharacterEncoding("UTF-8");
        HttpSession session = request.getSession();
        UserDataBeans udb = new UserDataBeans();
        JumsHelper jh = JumsHelper.getInstance();
        
        try{
            
            // 直リンク禁止
            if(request.getParameter("ac") == null || (Integer)session.getAttribute("ac") != Integer.parseInt(request.getParameter("ac"))){
                throw new Exception("不正なアクセスです");
            }
            
            // 入力を取得
            // name
            String name = request.getParameter("name");
            // year
            int year = 0;
            if(!request.getParameter("year").equals("")) {
                year = Integer.parseInt(request.getParameter("year"));
            }
            // month
            int month = 0;
            if(!request.getParameter("month").equals("")) {
                month = Integer.parseInt(request.getParameter("month"));
            }
            // day
            int day = 0;
            if(!request.getParameter("day").equals("")) {
                day = Integer.parseInt(request.getParameter("day"));
            }
            // type
            int type = Integer.parseInt(request.getParameter("type"));
            // tell
            String tell = request.getParameter("tell");
            // comment
            String comment = request.getParameter("comment");
            
            // udbに格納
            udb = jh.udbSet(udb, name, year, month, day, type, tell, comment);
            session.setAttribute("udb", udb);
            
            // 入力不足確認
            if(jh.check(name, year, month, day, type, tell, comment)) {
                // "insertcomfilm.jsp"へ移動
                request.getRequestDispatcher("/insertconfirm.jsp").forward(request, response);
            } else {
                // /insert.jspに遷移
                request.getRequestDispatcher("/insert.jsp").forward(request, response);
            } 
            
            
        } catch(Exception e) {
            
            request.setAttribute("error", e.getMessage());
            request.getRequestDispatcher("/error.jsp").forward(request, response);
            
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
