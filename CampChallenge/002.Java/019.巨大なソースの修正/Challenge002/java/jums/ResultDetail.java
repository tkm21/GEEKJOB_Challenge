
package jums;

import java.io.*;
import java.sql.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class ResultDetail extends HttpServlet {

 
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        response.setContentType("text/html;charset=UTF-8");
        HttpSession session = request.getSession();
        
        // 直リンク禁止用
        session.setAttribute("ac", (int)(Math.random() * 1000));
        
        // userIDの取得
        String userID = request.getParameter("userID");
        
        try {
            
            // /Searchへ遷移
            if(userID == null) {
                request.getRequestDispatcher("/Search").forward(request, response);
            }
            
            // name, birthday, type, tell, comment取得&格納
            UserDataBeans udb = UserDataDAO.getInstance().select(userID);
            session.setAttribute("udb", udb);

            // resultdetail.jspに遷移
            request.getRequestDispatcher("/resultdetail.jsp").forward(request, response);
            
        } catch(SQLException error_sql) {
            
            request.setAttribute("error", error_sql.getMessage());
            request.getRequestDispatcher("/error.jsp").forward(request, response);
            
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
