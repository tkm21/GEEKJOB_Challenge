
package Kagoyume;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class RegistrationComplete extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        
        // session
        HttpSession session = request.getSession();
        
        // JavaBeans
        JavaBeans jb = (JavaBeans)session.getAttribute("jb");
        
        try {
            
            // 直リンク禁止
            if(request.getParameter("ac") == null || (Integer)session.getAttribute("ac") != Integer.parseInt(request.getParameter("ac"))) {
                    throw new Exception("");
            }
            
            // 更新禁止用
            session.setAttribute("ac", (int)(Math.random() * 1000));
            
            // setudd
            UserDataDTO udd = KagoyumeHelper.getInstance().setudd(jb, new UserDataDTO());
            
            // insert_registration
            UserDataDAO.getInstance().insert(udd);
            
            // login
            jb.setLoginUserName(jb.getRegistrationUserName());
            jb.setLoginPassword(jb.getRegistrationPassword());
            
            session.setAttribute("jb", jb);
            
            // /registrationcomplete.jspに遷移
            request.getRequestDispatcher("/registrationcomplete.jsp").forward(request, response);
            
            
        } catch(Exception e) {
            
            // /registrationcomplete.jspに遷移
            request.getRequestDispatcher("Registration").forward(request, response);
            
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
