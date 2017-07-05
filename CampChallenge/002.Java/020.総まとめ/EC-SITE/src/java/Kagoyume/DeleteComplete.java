
package Kagoyume;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class DeleteComplete extends HttpServlet {

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
        
        // setudd
        UserDataDTO udd = KagoyumeHelper.getInstance().setudd(jb, new UserDataDTO());
        
        try {
            
            UserDataDAO.getInstance().delete(udd);
            
            request.getRequestDispatcher("Logout").forward(request, response);
            
        } catch(Exception e) {
            
            request.getRequestDispatcher("Logout").forward(request, response);
            
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
