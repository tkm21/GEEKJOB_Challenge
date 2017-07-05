
package Kagoyume;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class Buy extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
        // session取得
        HttpSession session = request.getSession();
        
        // JavaBeans
        JavaBeans jb = (JavaBeans)session.getAttribute("jb");
        if(jb==null) {
            jb = new JavaBeans();
        }
        
        if(jb.getLogFlag()) {
            
            jb.setSearchFlag(false);
            jb.setItemDisplay(false);
            jb.setCartDisplay(false);
            jb.setBuyDisplay(true);
            jb.setBuyCompleteDisplay(false);
            
            // /index.jspに遷移
            request.getRequestDispatcher("/index.jsp").forward(request, response);
            
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
