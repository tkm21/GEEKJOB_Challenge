
package Kagoyume;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class AddCart extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
        // session
        HttpSession session = request.getSession();
        
        // JavaBeans
        JavaBeans jb = (JavaBeans)session.getAttribute("jb");
        
        try {
            // 直リンク禁止
            if(request.getParameter("ac") == null || (Integer)session.getAttribute("ac") != Integer.parseInt(request.getParameter("ac"))) {
                    throw new Exception("不正なアクセスです");
            }
            // 更新禁止用
            session.setAttribute("ac", (int)(Math.random() * 1000));
            
            if(jb.getLogFlag()) {
                
                String productCode = request.getParameter("product_code");
                jb.addCart(productCode, 1); //　一個追加
                // Cartに遷移
                request.getRequestDispatcher("Cart").forward(request, response);
            } else {
                // form受け取り
                if(request.getParameter("product_code") != null) {
                    session.setAttribute("productCode", request.getParameter("product_code"));
                }
                // /login.jspに遷移
                request.getRequestDispatcher("/login.jsp").forward(request, response);
            }
        } catch(Exception e) {
            
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
