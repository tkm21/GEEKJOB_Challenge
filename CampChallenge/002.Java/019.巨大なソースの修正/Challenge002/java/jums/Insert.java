
package jums;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class Insert extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        // セッション開始
        HttpSession session = request.getSession();
        
        // 直リンク禁止
        session.setAttribute("ac", (int)(Math.random() * 1000));
        
        
        // udbリセット
            UserDataBeans udb = new UserDataBeans();
            udb.setName("");
            udb.setTell("");
            udb.setComment("");
            session.setAttribute("udb", udb);
            
        // /insert.jspへ遷移
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
