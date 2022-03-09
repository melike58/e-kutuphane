package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class ÜyeOl_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("    <meta charset=\"UTF-8\">\n");
      out.write("    <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">\n");
      out.write("    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n");
      out.write("    <title>Üye Ol</title>\n");
      out.write("    <link rel=\"stylesheet\" type=\"text/css\" href=\"giris_uye.css\">\n");
      out.write("    <link rel=\"stylesheet\" href=\"https://use.fontawesome.com/releases/v5.6.3/css/all.css\" crossorigin=\"anonymous\">\n");
      out.write("</head>\n");
      out.write("\n");
      out.write("<body>\n");
      out.write("    <div class=\"container\">\n");
      out.write("        <form class=\"uyeOl\" action=\"GirisIslemleri\" method=\"post\">\n");
      out.write("            <h1>Üye Ol</h1>\n");
      out.write("            <div>\n");
      out.write("                <i class=\"fas fa-user\"></i>\n");
      out.write("                <input type=\"text\" placeholder=\"Kullanıcı Adı\" name=\"USER_NICK\">\n");
      out.write("            </div>\n");
      out.write("            <div>\n");
      out.write("                <i class=\"fas fa-user\"></i>\n");
      out.write("                <input type=\"text\" placeholder=\"Ad\" name=\"USER_NAME\">\n");
      out.write("            </div>\n");
      out.write("            <div>\n");
      out.write("                <i class=\"fas fa-user\"></i>\n");
      out.write("                <input type=\"text\" placeholder=\"Soyadı\" name=\"USER_LNAME\">\n");
      out.write("            </div>\n");
      out.write("            <div>\n");
      out.write("                <i class=\"fas fa-envelope\"></i>\n");
      out.write("                <input type=\"email\" placeholder=\"Email\" name=\"USER_MAIL\">\n");
      out.write("            </div>\n");
      out.write("            <div>\n");
      out.write("                <i class=\"fas fa-key\"></i>\n");
      out.write("                <input type=\"password\" placeholder=\"Parola\" name=\"USER_PASS\">\n");
      out.write("            </div>\n");
      out.write("            <div>\n");
      out.write("                <i class=\"fas fa-key\"></i>\n");
      out.write("                <input type=\"password\" placeholder=\"Parola Tekrar\" name=\"VERIFY\">\n");
      out.write("\n");
      out.write("            </div>\n");
      out.write("            <div>\n");
      out.write("                <i class=\"fas fa-phone\"></i>\n");
      out.write("                <input type=\"text\" placeholder=\"Telefon Numarası\" name=\"USER_PHONE\">\n");
      out.write("            </div>\n");
      out.write("            <div>\n");
      out.write("                <button type=\"submit\">Üye Ol</button>\n");
      out.write("            </div>\n");
      out.write("            <br><hr>\n");
      out.write("            <p> Eğer bir hesabın varsa,\n");
      out.write("                <button onClick=\"location.href='GirişYap.jsp'\"\n");
      out.write("                style=\"width: 100px; height: 35px;\" type=\"button\">Giriş Yap</button></p>\n");
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
