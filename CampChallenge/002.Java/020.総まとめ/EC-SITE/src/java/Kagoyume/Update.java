
package Kagoyume;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class Update extends HttpServlet {

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
        
            // ユーザーデータの取得
            try {
                
                UserDataDAO.getInstance().getUserData(jb.getUserID(), jb);
                
                KagoyumeHelper.getInstance().moveTop(jb);
                jb.setUpdateDisplay(true);
                
                session.setAttribute("jb", jb);
            
                // /index.jspに遷移
                request.getRequestDispatcher("/index.jsp").forward(request, response);
                
            } catch(Exception e) {
                
            }
        } else {
            
            // /index.jspに遷移
            request.getRequestDispatcher("Top").forward(request, response);
            
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
