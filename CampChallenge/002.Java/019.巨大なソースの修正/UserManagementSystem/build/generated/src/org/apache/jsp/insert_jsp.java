package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import jums.*;

public final class insert_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("        <title>登録画面</title>\n");
      out.write("    </head>\n");
      out.write("    \n");
      out.write("    \n");
      out.write("    <body>\n");
      out.write("        \n");
      out.write("        \n");
      out.write("        <div align=\"center\">\n");
      out.write("            \n");
      out.write("            ");

                UserDataBeans udb = (UserDataBeans)session.getAttribute("udb");
            
      out.write("\n");
      out.write("            \n");
      out.write("            <h1>登録画面</h1>\n");
      out.write("            \n");
      out.write("            <form action = \"InsertConfirm\" method = \"POST\">\n");
      out.write("                \n");
      out.write("                名前<br>\n");
      out.write("                <input type = \"text\" name = \"name\" value = \"");
      out.print( udb.getName() );
      out.write("\"><br>\n");
      out.write("                \n");
      out.write("                <br>\n");
      out.write("                \n");
      out.write("                生年月日<br>\n");
      out.write("                <!--年-->\n");
      out.write("                <select name = \"year\">\n");
      out.write("                    ");

                        if(!udb.getYear().equals("")){
                    
      out.write("\n");
      out.write("                    <option value = \"");
      out.print( udb.getYear() );
      out.write('"');
      out.write('>');
      out.print( udb.getYear() );
      out.write("</option>\n");
      out.write("                    ");

                        } else {
                    
      out.write("\n");
      out.write("                    <option value = \"\">----</option>\n");
      out.write("                    ");

                        }

                        for(int i = 1950; i <= 2010; i ++) {
                            out.print("<option value = \"" + i + "\">" + i + "</option>");
                        }
                    
      out.write("\n");
      out.write("                </select>年\n");
      out.write("                <!--月-->\n");
      out.write("                <select name = \"month\">\n");
      out.write("                    ");

                        if(!udb.getMonth().equals("")){
                    
      out.write("\n");
      out.write("                    <option value = \"");
      out.print( udb.getMonth() );
      out.write('"');
      out.write('>');
      out.print( udb.getMonth() );
      out.write("</option>\n");
      out.write("                    ");

                        } else {
                    
      out.write("\n");
      out.write("                    <option value = \"\">--</option>\n");
      out.write("                    ");

                        }

                        for(int i = 1; i <= 12; i ++) {
                            out.print("<option value = \"" + i + "\">" + i + "</option>");
                        }
                    
      out.write("\n");
      out.write("                </select>月\n");
      out.write("                <!--日-->\n");
      out.write("                <select name = \"day\">\n");
      out.write("                    ");

                        if(!udb.getDay().equals("")){
                    
      out.write("\n");
      out.write("                    <option value = \"");
      out.print( udb.getDay() );
      out.write('"');
      out.write('>');
      out.print( udb.getDay() );
      out.write("</option>\n");
      out.write("                    ");

                        } else {
                    
      out.write("\n");
      out.write("                    <option value = \"\">--</option>\n");
      out.write("                    ");

                        }
    
                        for(int i = 1; i <= 31; i ++) {
                            out.print("<option value = \"" + i + "\">" + i + "</option>");
                        }
                    
      out.write("\n");
      out.write("                </select>日<br>\n");
      out.write("                \n");
      out.write("                <br>\n");
      out.write("            \n");
      out.write("                種別<br>\n");
      out.write("                選択してください<input type = \"radio\" name = \"type\" value = \"0\" ");
      out.print( udb.getType() == 0 ? "checked=\"checked\"" : "" );
      out.write("><br>\n");
      out.write("                エンジニア<input type = \"radio\" name = \"type\" value = \"1\" ");
      out.print( udb.getType() == 1 ? "checked=\"checked\"" : "" );
      out.write(">　\n");
      out.write("                営業<input type = \"radio\" name = \"type\" value = \"2\" ");
      out.print( udb.getType() == 2 ? "checked=\"checked\"" : "" );
      out.write(">　\n");
      out.write("                その他<input type = \"radio\" name = \"type\" value = \"3\" ");
      out.print( udb.getType() == 3 ? "checked=\"checked\"" : "" );
      out.write("><br>\n");
      out.write("                \n");
      out.write("                <br>\n");
      out.write("            \n");
      out.write("                電話番号<br>\n");
      out.write("                <input type = \"text\" name = \"tell\" value = \"");
      out.print( udb.getTell() );
      out.write("\"><br>\n");
      out.write("                \n");
      out.write("                <br>\n");
      out.write("            \n");
      out.write("                自己紹介文<br>\n");
      out.write("                <textarea name = \"comment\" rows = 10 cols = 50 style = \"resize:none\" wrap = \"hard\">");
      out.print( udb.getComment() );
      out.write("</textarea><br>\n");
      out.write("                \n");
      out.write("                <br>\n");
      out.write("            \n");
      out.write("                <input type = \"submit\" name = \"btnSubmit\" value = \"確認画面へ\">\n");
      out.write("            \n");
      out.write("                <!-- 直リンク防止用 -->\n");
      out.write("                <input type = \"hidden\" name = \"ac\" value = \"");
      out.print( session.getAttribute("ac") );
      out.write("\">\n");
      out.write("            \n");
      out.write("            </form><br>\n");
      out.write("            \n");
      out.write("            ");

                if(udb.getCount()) {
                    if(udb.getName().equals("")) {
                    out.print("名前を入力してください。<br>");
                    }
                    if(udb.getYear().equals("") || udb.getMonth().equals("") || udb.getDay().equals("")) {
                        out.print("生年月日をすべて入力してください。<br>");
                    }
                    if(udb.getType() == 0) {
                        out.print("タイプを選択してください。<br>");
                    }
                    if(udb.getTell().equals("")) {
                        out.print("電話番号を入力してください。<br>");
                    }
                    if(udb.getComment().equals("")) {
                        out.print("自己紹介文を入力してください。<br>");
                    }
                }
            
      out.write("\n");
      out.write("            \n");
      out.write("            <br>\n");
      out.write("            \n");
      out.write("            ");
      out.print( JumsHelper.getInstance().home() );
      out.write("\n");
      out.write("        \n");
      out.write("        </div>\n");
      out.write("        \n");
      out.write("    </body>\n");
      out.write("    \n");
      out.write("    \n");
      out.write("</html>\n");
      out.write("\n");
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
