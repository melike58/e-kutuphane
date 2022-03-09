package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class GirişYap_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<!DOCTYPE html>\n");
      out.write("<html lang=\"en\">\n");
      out.write("\n");
      out.write("<head>\n");
      out.write("    <meta charset=\"UTF-8\"> <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\"> <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n");
      out.write("    \n");
      out.write("    <title>Giriş Yap</title>\n");
      out.write("    \n");
      out.write("    <link rel=\"stylesheet\" type=\"text/css\" href=\"giris_uye.css\"> <link rel=\"stylesheet\" href=\"https://use.fontawesome.com/releases/v5.6.3/css/all.css\" crossorigin=\"anonymous\">\n");
      out.write("</head>\n");
      out.write("\n");
      out.write("<body>\n");
      out.write("    <div class=\"container\">\n");
      out.write("    \t\n");
      out.write("        <form class=\"giris\" action=\"GirisIslemleri\" method=\"get\">\n");
      out.write("            <h1>Giriş Yap</h1>\n");
      out.write("            \n");
      out.write("            <div>\n");
      out.write("                <i class=\"fas fa-envelope\"></i>\n");
      out.write("                <input type=\"email\" placeholder=\"Email\" name=\"USER_MAIL\" \n");
      out.write("                ");

                  if(request.getParameter("USER_MAIL")!=null) {
                	  
                	  out.print("value="+request.getParameter("USER_MAIL"));
                  }
                
      out.write(">\n");
      out.write("            </div>\n");
      out.write("            \n");
      out.write("            <div>\n");
      out.write("                <i class=\"fas fa-key\"></i>\n");
      out.write("                <input type=\"password\" placeholder=\"Parola\" name=\"USER_PASS\">\n");
      out.write("            </div>\n");
      out.write("            \n");
      out.write("            <div>\n");
      out.write("                <button type=\"submit\">Giriş Yap</button>\n");
      out.write("            </div>\n");
      out.write("            \n");
      out.write("            <br><hr>\n");
      out.write("                <p><a href=\"ŞifremiUnuttum.jsp\">Şifreni mi unuttun?</a></p>\n");
      out.write("            <br><hr>\n");
      out.write("            \n");
      out.write("            <p> Eğer bir hesabın yoksa,\n");
      out.write("                <button onClick=\"location.href='ÜyeOl.jsp'\"\n");
      out.write("                style=\"width: 100px; height: 35px;\" type=\"button\">Üye Ol</button>\n");
      out.write("            </p>\n");
      out.write("        </form>\n");
      out.write("    </div>\n");
      out.write("</body>\n");
      out.write("\n");
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
