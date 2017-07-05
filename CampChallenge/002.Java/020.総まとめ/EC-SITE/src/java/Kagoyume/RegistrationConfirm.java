
package Kagoyume;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class RegistrationConfirm extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        
        // session
        HttpSession session = request.getSession();
        
        // JavaBeans
        JavaBeans jb = (JavaBeans)session.getAttribute("jb");
        if(jb==null){
            jb = new JavaBeans();
        }
        
        try {
            
            // form受け取り
            jb.setRegistrationUserName(request.getParameter("registrationUserName"));
            jb.setRegistrationPassword(request.getParameter("registrationPassword"));
            jb.setRegistrationPasswordConfirm(request.getParameter("registrationPasswordConfirm"));
            jb.setRegistrationMail(request.getParameter("registrationMail"));
            jb.setRegistrationAddress(request.getParameter("registrationAddress"));
            
            // JavaBeans
            session.setAttribute("jb", jb);
            
            try {
                // 入力されているか
                boolean userNamelength = jb.getRegistrationUserName().length() != 0;
                boolean passwordlength = jb.getRegistrationPassword().length() != 0;
                boolean passwordconfirmlength = jb.getRegistrationPasswordConfirm().length() != 0;
                boolean maillength = jb.getRegistrationMail().length() != 0;
                boolean addresslength = jb.getRegistrationAddress().length() != 0;
                boolean isempty = userNamelength && passwordlength && passwordconfirmlength && maillength && addresslength;
                
                if(isempty) {
                    
                    // 入力されたユーザー名がすでに存在するかどうか(存在:true)
                    boolean existenceusername = UserDataDAO.getInstance().checkuserName(jb.getRegistrationUserName());
                    if(existenceusername) {
                            throw new Exception("");
                    }
                    // ２つのパスワードが一致するかどうか(一致:true)
                    boolean passwordconfirm = jb.getRegistrationPassword().equals(jb.getRegistrationPasswordConfirm());
                    if(!passwordconfirm) {
                        throw new Exception("");
                    }
                    
                    // /registrationconfirm.jspに遷移
                    request.getRequestDispatcher("/registrationconfirm.jsp").forward(request, response);
                        
                } else {
                    throw new Exception("");
                }
                
                } catch(Exception e_1) {
                    
                    // エラー文の表示
                    jb.setRegistrationErrorFlag(true);
                    // /registration.jspに遷移
                    request.getRequestDispatcher("/registration.jsp").forward(request, response);
                    
                }
            
            
            
        } catch(Exception e) {
            
            // JavaBeans
            session.setAttribute("jb", new JavaBeans());
            // /registration.jspに遷移
            request.getRequestDispatcher("/registration.jsp").forward(request, response);
             
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
