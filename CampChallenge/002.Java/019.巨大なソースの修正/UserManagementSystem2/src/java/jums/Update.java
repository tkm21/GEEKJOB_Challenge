
package jums;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class Update extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        HttpSession session = request.getSession();
        
        try {
            
            // 直リンク禁止
            if(request.getParameter("ac") == null || (Integer)session.getAttribute("ac") != Integer.parseInt(request.getParameter("ac"))) {
                try {
                    request.getRequestDispatcher("/update.jsp").forward(request, response);
                } catch(Exception e) {
                    request.getRequestDispatcher("/Search").forward(request, response);
                }
                
            }
            
            // /update.jspに遷移
            request.getRequestDispatcher("/update.jsp").forward(request, response);
            
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
