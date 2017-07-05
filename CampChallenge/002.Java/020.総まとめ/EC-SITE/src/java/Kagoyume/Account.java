
package Kagoyume;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class Account extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
        // session
        HttpSession session = request.getSession();
        
        // JavaBeans
        JavaBeans jb = (JavaBeans)session.getAttribute("jb");
        if(jb==null){
            jb = new JavaBeans();
        }
        
        if(jb.getLogFlag()) {
            
            KagoyumeHelper.getInstance().moveTop(jb);
            jb.setAccountDisplay(true);
            
            request.getRequestDispatcher("/index.jsp").forward(request, response);
            
        } else {
            
            // /login.jspに遷移
            request.getRequestDispatcher("/login.jsp").forward(request, response);
            
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
