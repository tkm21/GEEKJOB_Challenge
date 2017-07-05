package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import Kagoyume.*;

public final class login_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    \n");
      out.write("    \n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>Login</title>\n");
      out.write("        <link rel=\"stylesheet\" href=\"login.css\">\n");
      out.write("        ");

            // JavaBeans
            JavaBeans jb = (JavaBeans)session.getAttribute("jb");
            // 直リンク禁止用
            session.setAttribute("ac", (int)(Math.random() * 1000));
        
      out.write("\n");
      out.write("    </head>\n");
      out.write("    \n");
      out.write("    \n");
      out.write("    <body>\n");
      out.write("            <h1 class=\"logo\">\n");
      out.write("                <a href=\"/EC-SITE/\">Kagoyume</a>\n");
      out.write("            </h1>\n");
      out.write("            <div class=\"container\">\n");
      out.write("                \n");
      out.write("                <div class=\"login\">\n");
      out.write("                    <h2>ログイン</h2>\n");
      out.write("                    <form action=\"LoginCheck\" method=\"POST\">\n");
      out.write("                        <span>ユーザー名</span><br>\n");
      out.write("                        <input class=\"input\" type=\"text\" name=\"loginUserName\" value=\"");
      out.print( jb.getLoginUserName() );
      out.write("\"><br>\n");
      out.write("                        <span>パスワード</span><br>\n");
      out.write("                        <input class=\"input\" type=\"password\" name=\"loginPassword\" value=\"");
      out.print( jb.getLoginPassword() );
      out.write("\"><br>\n");
      out.write("                        <input class=\"btn\" type=\"submit\" value=\"サインイン\" >\n");
      out.write("                        <!--直リンク禁止用-->\n");
      out.write("                        <input type = \"hidden\" name = \"ac\" value = \"");
      out.print( session.getAttribute("ac") );
      out.write("\">\n");
      out.write("                    </form>\n");
      out.write("                </div>\n");
      out.write("                \n");
      out.write("                <div class=\"registration\">\n");
      out.write("                    <span>アカウントをお持ちでありませんか？</span>\n");
      out.write("                    <a class=\"btn\" href=\"Registration\">アカウントを作成</a>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("          \n");
      out.write("        <br>\n");
      out.write("        \n");
      out.write("        \n");
      out.write("                    \n");
      out.write("            \n");
      out.write("            \n");
      out.write("            <p class=\"error-message\">\n");
      out.write("            ");

                if(jb.getLoginErrorFlag()) {
                    out.print("エラー<br>");
                    
                        if(jb.getLoginUserName().length() != 0) {
                            if(!UserDataDAO.getInstance().checkuserName(jb.getLoginUserName())) {
                                    out.print("このユーザー名は登録されていません<br>");
                                } else {
                                    if(jb.getLoginPassword().length() != 0) {
                                        out.print("パスワードが正しくありません<br>");
                                    } else {
                                        out.print("パスワードが入力されていません<br>");
                                    }
                                }
                        } else {
                            out.print("ユーザー名が入力されていません<br>");
                            if(jb.getLoginPassword().length() == 0) {
                                out.print("パスワードが入力されていません<br>");
                            }
                        }
                        
                }
            
      out.write("\n");
      out.write("            </p>\n");
      out.write("            \n");
      out.write("        \n");
      out.write("    </body>\n");
      out.write("    \n");
      out.write("    \n");
      out.write("</html>\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
