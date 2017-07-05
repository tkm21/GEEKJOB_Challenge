package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import Kagoyume.*;

public final class registration_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("        <link rel=\"stylesheet\" href=\"registration.css\">\n");
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
      out.write("                <div class=\"registration\">\n");
      out.write("                    <h2>アカウント作成</h2>\n");
      out.write("                    <form action=\"RegistrationConfirm\" method=\"POST\">\n");
      out.write("                        <span>ユーザー名</span><br>\n");
      out.write("                        <input class=\"input\" type=\"text\" name=\"registrationUserName\" value=\"");
      out.print( jb.getRegistrationUserName() );
      out.write("\"><br>\n");
      out.write("                        <span>パスワード</span><br>\n");
      out.write("                        <input class=\"input\" type=\"password\" name=\"registrationPassword\" value=\"");
      out.print( jb.getRegistrationPassword() );
      out.write("\"><br>\n");
      out.write("                        <span>パスワード（確認用）</span><br>\n");
      out.write("                        <input class=\"input\" type=\"password\" name=\"registrationPasswordConfirm\" value=\"");
      out.print( jb.getRegistrationPasswordConfirm() );
      out.write("\"><br>\n");
      out.write("                        <span>メールアドレス（適当に記入してください）</span><br>\n");
      out.write("                        <input class=\"input\" type=\"text\" name=\"mail\" value=\"\"><br>\n");
      out.write("                        <span>住所（適当に記入してください）</span><br>\n");
      out.write("                        <input class=\"input\" type=\"text\" name=\"mail\" value=\"\"><br>\n");
      out.write("                        <input class=\"btn\" type=\"submit\" value=\"アカウントを作成\" >\n");
      out.write("                        <!--直リンク禁止用-->\n");
      out.write("                        <input type = \"hidden\" name = \"ac\" value = \"");
      out.print( session.getAttribute("ac") );
      out.write("\">\n");
      out.write("                    </form>\n");
      out.write("                </div>\n");
      out.write("                \n");
      out.write("                <div class=\"login\">\n");
      out.write("                    <span>アカウントをすでにお持ちですか？</span>\n");
      out.write("                    <a class=\"btn\" href=\"Login\">ログイン</a>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("                    \n");
      out.write("            <br>\n");
      out.write("                    \n");
      out.write("            <p class=\"error-message\">\n");
      out.write("            ");

                if(jb.getRegistrationErrorFlag()) {
                    out.print("エラー<br>");
                    
                        if(jb.getRegistrationUserName().length() != 0) {
                            if(UserDataDAO.getInstance().checkuserName(jb.getRegistrationUserName())) {
                                out.print("このユーザー名はすでに登録されています<br>");
                            }
                        } else {
                            out.print("ユーザー名が入力されていません<br>");
                        }
                        
                        if(jb.getRegistrationPassword().length() != 0) {
                            if(!jb.getRegistrationPassword().equals(jb.getRegistrationPasswordConfirm())) {
                                out.print("パスワードが一致しません<br>");
                            }
                        } else {
                            out.print("パスワードが入力されていません<br>");
                        }
                        
                            
                        
                }
            
      out.write("\n");
      out.write("            </p>\n");
      out.write("          \n");
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
