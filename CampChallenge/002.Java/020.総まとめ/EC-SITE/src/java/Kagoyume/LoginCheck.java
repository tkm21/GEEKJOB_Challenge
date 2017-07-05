
package Kagoyume;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class LoginCheck extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        
        // session
        HttpSession session = request.getSession();
        
        // JavaBeans
        JavaBeans jb = (JavaBeans)session.getAttribute("jb");
        if(jb == null) {
            jb = new JavaBeans();
        }
        
        try {
            
            // 直リンク禁止
            if(request.getParameter("ac") == null || (Integer)session.getAttribute("ac") != Integer.parseInt(request.getParameter("ac"))){
                throw new Exception("不正なアクセスです");
            }
            
            jb.setLoginUserName(request.getParameter("loginUserName"));
            jb.setLoginPassword(request.getParameter("loginPassword"));
            session.setAttribute("jb", jb);
            
            // user password確認
            boolean login = UserDataDAO.getInstance().login(request.getParameter("loginUserName"), request.getParameter("loginPassword"));
            if(login) {
                
                jb = new JavaBeans();
                
                // ログイン状態に変更
                jb.setLogFlag(true);
                
                // ログインしているuserNameを保存
                jb.setLoginUserName(request.getParameter("loginUserName"));
                
                // userNameからuseridを取得して保持(String)
                UserDataDAO.getInstance().getUserID(jb.getLoginUserName(), jb);
                
                session.setAttribute("jb", jb);
                
                // カートに追加を押していた場合商品ページに遷移
                if(session.getAttribute("productCode") != null) {
                    // /item.jspに遷移
                    request.getRequestDispatcher("Item?product_code=" + session.getAttribute("productCode")).forward(request, response);
                } else {
                    // /index.jspに遷移
                    request.getRequestDispatcher("/index.jsp").forward(request, response);
                }
                
            } else {
                
                // エラー文の表示
                jb.setLoginErrorFlag(true);
                // /login.jspに遷移
                request.getRequestDispatcher("/login.jsp").forward(request, response);
                
            }
            
        } catch(Exception e) {
            
                // JavaBeans
                session.setAttribute("jb", new JavaBeans());
                // /login.jspに遷移
                request.getRequestDispatcher("/login.jsp").forward(request, response);
            
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
