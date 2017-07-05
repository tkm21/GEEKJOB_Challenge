
package Kagoyume;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class Item extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        
        // session
        HttpSession session = request.getSession();
        
        try {
            
            String productCode = request.getParameter("product_code");
            SearchDataBeans usd = API.getDetail(productCode);
            session.setAttribute("usd", usd);
            
            // JavaBeans
            JavaBeans jb = (JavaBeans)session.getAttribute("jb");
            jb.setItemDisplay(true);
            jb.setSearchFlag(false);
            
            // /index.jspに遷移
            request.getRequestDispatcher("/index.jsp").forward(request, response);
            
        } catch(Exception e){
            
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
