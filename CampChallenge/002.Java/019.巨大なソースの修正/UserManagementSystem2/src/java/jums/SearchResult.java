
package jums;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class SearchResult extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        request.setCharacterEncoding("UTF-8");
        HttpSession session = request.getSession();
        
        // 直リンク禁止
        session.setAttribute("ac", (int)(Math.random() * 1000));
        
        try {
            
            // userID, name, birthday, type, tell, comment, newDate 取得
            UserDataBeans udb = UserDataDAO.getInstance().select(request.getParameter("name"), request.getParameter("year"), request.getParameter("type1"), request.getParameter("type2"), request.getParameter("type3"));
            session.setAttribute("udb", udb);
            
            // /searchresult.jspに遷移
            request.getRequestDispatcher("/searchresult.jsp").forward(request, response);
            
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
