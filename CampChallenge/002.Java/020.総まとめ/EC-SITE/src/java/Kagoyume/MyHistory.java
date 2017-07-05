
package Kagoyume;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.*;
import javax.servlet.http.*;

public class MyHistory extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
        // session
        HttpSession session = request.getSession();
        
        // JavaBeans
        JavaBeans jb = (JavaBeans)session.getAttribute("jb");
        if(jb == null) {
            jb = new JavaBeans();
        }
        
        if(jb.getLogFlag()) {
            
            HashMap<String, String> history = new HashMap();
            try {
            
                jb.setHistory(UserDataDAO.getInstance().MyHistory(jb.getUserID()));
            
                session.setAttribute("jb", jb);
            
                KagoyumeHelper.getInstance().moveTop(jb);
                jb.setMyHistoryDisplay(true);
            
                request.getRequestDispatcher("/index.jsp").forward(request, response);
            
            } catch(Exception e) {
            
        }
            
        } else {
            
            // /index.jspに遷移
            request.getRequestDispatcher("Login").forward(request, response);
            
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
