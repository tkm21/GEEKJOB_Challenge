
package Kagoyume;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class Cart extends HttpServlet {

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
            jb.clearItemData();
            for(Map.Entry<String, Integer> val: jb.getCart().entrySet()) {
                SearchDataBeans itemData = API.getDetail(val.getKey());
                jb.setItemData(itemData);
            }
            session.setAttribute("jb", jb);
            
            KagoyumeHelper.getInstance().moveTop(jb);
            jb.setCartDisplay(true);
            session.setAttribute("jb", jb);
            // /index.jspに遷移
            request.getRequestDispatcher("/index.jsp").forward(request, response);
            
        } else {
            session.setAttribute("jb", jb);
            // /login.jspに遷移
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
