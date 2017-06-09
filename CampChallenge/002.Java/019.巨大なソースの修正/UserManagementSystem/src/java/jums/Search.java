
package jums;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;

public class Search extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        // セッション開始
        HttpSession session = request.getSession();
        
        try {
            
            // 全情報取得
            UserDataBeans udb = UserDataDAO.getInstance().select();
            
            // udb格納
            session.setAttribute("udb",udb);
            
            // /search.jspに遷移
            request.getRequestDispatcher("/search.jsp").forward(request, response);
            
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
