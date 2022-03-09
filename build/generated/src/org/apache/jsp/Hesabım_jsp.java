package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import com.jdbc.DatabaseOperations;

public final class Hesabım_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html lang=\"en\">\n");
      out.write("\n");
      out.write("<head>\n");
      out.write("    <meta charset=\"UTF-8\">\n");
      out.write("    <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">\n");
      out.write("    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n");
      out.write("    <title>Document</title>\n");
      out.write("    <link rel=\"stylesheet\" href=\"detailStyle.css\">\n");
      out.write("    <link rel=\"stylesheet\" href=\"https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css\">\n");
      out.write("    <link href=\"https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/css/bootstrap.min.css\" rel=\"stylesheet\"\n");
      out.write("        integrity=\"sha384-+0n0xVW2eSR5OomGNYDnhzAbDsOXxcvSN1TPprVMTNDbiYZCxYbOOl7+AMvyTG2x\" crossorigin=\"anonymous\">\n");
      out.write("    <link rel=\"stylesheet\" href=\"https://use.fontawesome.com/releases/v5.6.3/css/all.css\" crossorigin=\"anonymous\">\n");
      out.write("    <link rel=\"stylesheet\" href=\"css/bootstrap.min.css\">\n");
      out.write("</head>\n");
      out.write("\n");
      out.write("<body>\n");
      out.write("    <div class=\"header\">\n");
      out.write("        <div class=\"logo\">E-KÜTÜPHANE</div>\n");
      out.write("\n");
      out.write("        <ul class=\"menu\">\n");
      out.write("            <a href=\"anaSayfa.html\">Ana Sayfa</a>\n");
      out.write("            <a href=\"kiralanaKitaplar.html\">Kiralanan Kitaplar</a>\n");
      out.write("        </ul>\n");
      out.write("    </div>\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("    <div class=\"profil\">\n");
      out.write("        <img src=\"Assets/DefaultProfilePic.jpg\">\n");
      out.write("    </div>\n");
      out.write("   \n");
      out.write("    <div class=\"userDetails\">\n");
      out.write("        <ul>\n");
      out.write("        ");

            HttpSession sess=request.getSession();
            
        	String str[]=DatabaseOperations.getUserInfo((int)sess.getAttribute("USER_ID"));
        
      out.write("\n");
      out.write("            <hr>\n");
      out.write("            <li><h4>Kullanıcı Adı :</h4> <h5>");
      out.print( str[0] );
      out.write("</h5></li>\n");
      out.write("            <hr>\n");
      out.write("            <li><h4>Ad :</h4> <h5>");
      out.print( str[1] );
      out.write("</h5></li>\n");
      out.write("            <hr>\n");
      out.write("            <li><h4>Soyad :</h4> <h5>");
      out.print( str[2] );
      out.write("</h5></li>\n");
      out.write("            <hr>\n");
      out.write("            <li><h4>Email :</h4> <h5>");
      out.print( str[3] );
      out.write("</h5></li>\n");
      out.write("            <hr>\n");
      out.write("            <li><h4>Telefon Numarası :</h4> <h5>");
      out.print( str[4] );
      out.write("</h5></li>\n");
      out.write("            <hr>\n");
      out.write("            \n");
      out.write("\n");
      out.write("        </ul>\n");
      out.write("        <form action=\"HesabimiDuzenle\"><button  type=\"submit\" style=\"width: 100px; height: 35px;\">Düzenle</button></form>\n");
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
