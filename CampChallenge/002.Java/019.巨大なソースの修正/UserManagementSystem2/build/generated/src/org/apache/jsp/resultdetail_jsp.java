package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import jums.*;

public final class resultdetail_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>ユーザー詳細</title>\n");
      out.write("    </head>\n");
      out.write("    \n");
      out.write("    \n");
      out.write("    <body>\n");
      out.write("        \n");
      out.write("        <div align=\"center\">\n");
      out.write("            \n");
      out.write("            <h1>ユーザー詳細</h1>\n");
      out.write("            \n");
      out.write("            ");

                UserDataBeans udb = (UserDataBeans)session.getAttribute("udb");
            
      out.write("\n");
      out.write("            \n");
      out.write("            <!-- 表示 -->\n");
      out.write("            <table border = \"1\" cellspacing = \"0\" cellpadding = \"5\">\n");
      out.write("                <tr>\n");
      out.write("                    <th width = 80>ＩＤ</th>\n");
      out.write("                    <th width = 150>名前</th>\n");
      out.write("                    <th width = 100>生年月日</th>\n");
      out.write("                    <th width = 200>電話番号</th>\n");
      out.write("                    <th width = 100>種別</th>\n");
      out.write("                    <th width = 200>コメント</th>\n");
      out.write("                    <th width = 200>最終更新</th>\n");
      out.write("                </tr>\n");
      out.write("                <tr>\n");
      out.write("                    <td align = \"center\" height = 40>");
      out.print( udb.getID() );
      out.write("</td>\n");
      out.write("                    <td align = \"center\">");
      out.print( udb.getName() );
      out.write("</td>\n");
      out.write("                    <td align = \"center\">");
      out.print( udb.getBirthday() );
      out.write("</td>\n");
      out.write("                    <td align = \"center\">");
      out.print( udb.getTell() );
      out.write("</td>\n");
      out.write("                    <td align = \"center\">\n");
      out.write("                        ");

                            if(udb.getType() == 1) {
                                out.print("エンジニア");
                            } else if(udb.getType() == 2) {
                                out.print("営業");
                            } else {
                                out.print("その他");
                            }
                        
      out.write("\n");
      out.write("                    </td>\n");
      out.write("                    <td align = \"center\">");
      out.print( udb.getComment() );
      out.write("</td>\n");
      out.write("                    <td align = \"center\">");
      out.print( udb.getNewDate() );
      out.write("</td>\n");
      out.write("                </tr>\n");
      out.write("            </table>\n");
      out.write("            \n");
      out.write("            <br>\n");
      out.write("            \n");
      out.write("            <form action = \"Update\" method = \"POST\" style=\"display: inline\">\n");
      out.write("                <input type=\"submit\" name = \"btnSubmit\" value = \"編集\">\n");
      out.write("                <!-- 直リンク防止用 -->\n");
      out.write("                <input type = \"hidden\" name = \"ac\" value = \"");
      out.print( session.getAttribute("ac") );
      out.write("\">\n");
      out.write("            </form>　　\n");
      out.write("            \n");
      out.write("            <form action = \"Delete\" method = \"POST\" style=\"display: inline\">\n");
      out.write("                <input type=\"submit\" name = \"btnSubmit\" value = \"削除\">\n");
      out.write("                <!-- 直リンク防止用 -->\n");
      out.write("                <input type = \"hidden\" name = \"ac\" value = \"");
      out.print( session.getAttribute("ac") );
      out.write("\">\n");
      out.write("            </form><br>\n");
      out.write("            \n");
      out.write("            <br>\n");
      out.write("            \n");
      out.write("            <form action = \"Search\" style=\"display: inline\">\n");
      out.write("                <input type = \"submit\" value = \"戻る\">\n");
      out.write("            </form><br>\n");
      out.write("            \n");
      out.write("            <br>\n");
      out.write("            \n");
      out.write("            <!-- トップリンク -->\n");
      out.write("            ");
      out.print( JumsHelper.getInstance().home() );
      out.write("\n");
      out.write("         \n");
      out.write("        </div>\n");
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
