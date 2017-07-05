
package Kagoyume;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class DeleteItem extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
        // session
        HttpSession session = request.getSession();
        
        // JavaBeans
        JavaBeans jb = (JavaBeans)session.getAttribute("jb");
        if(jb==null) {
            jb = new JavaBeans();
        }
        
        String productCode = request.getParameter("productCode");
        jb.deleteCart(productCode);
        session.setAttribute("jb", jb);
        
        // Cartに遷移
        request.getRequestDispatcher("Cart").forward(request, response);
        
        
        
        
        
        
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
