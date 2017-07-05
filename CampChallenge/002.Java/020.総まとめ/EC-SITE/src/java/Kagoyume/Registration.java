
package Kagoyume;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class Registration extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
        // session取得
        HttpSession session = request.getSession();
        
        // JavaBeans
        JavaBeans jb = (JavaBeans)session.getAttribute("jb");
        if(jb == null) {
            jb = new JavaBeans();
        }
        
        jb.setRegistrationUserName("");
        jb.setRegistrationPassword("");
        jb.setRegistrationPasswordConfirm("");
        jb.setRegistrationMail("");
        jb.setRegistrationAddress("");
        jb.setRegistrationErrorFlag(false);
        
        session.setAttribute("jb", jb);
        // /registration.jspに遷移
        request.getRequestDispatcher("/registration.jsp").forward(request, response);
        
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
