
package jums;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class Insert extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
        
        // セッション開始
        HttpSession session = request.getSession();
        
        // 直リンク禁止用
        session.setAttribute("ac", (int)(Math.random() * 1000));
        
        
        // udbにデータを格納
            UserDataBeans udb = new UserDataBeans();
            udb.setName("");
            udb.setYear(0);
            udb.setMonth(0);
            udb.setDay(0);
            udb.setType(0);
            udb.setTell("");
            udb.setComment("");
            udb.setCount(false);
            
        // udbをセッションに格納
            session.setAttribute("udb", udb);
            
        // "/insert.jsp"へ移動
        request.getRequestDispatcher("/insert.jsp").forward(request, response);
        
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
