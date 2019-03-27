package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class SoundFilterApp_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <link rel=\"stylesheet\" href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${pageContext.request.contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("/styles/Style.css\" />\n");
      out.write("        <link href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${pageContext.request.contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("/bootstrap-4.3.1-dist/css/bootstrap.css\" rel=\"stylesheet\">\n");
      out.write("        <title>AUDIOGRAM SOUND FILTER</title>\n");
      out.write("    </head>\n");
      out.write("    <body class=\"text-center body-main\">\n");
      out.write("        <div class=\"cover-container d-flex h-100 p-3 mx-auto flex-column\">\n");
      out.write("          <main role=\"main\" class=\"inner cover\">\n");
      out.write("            <h1 class=\"cover-heading\">The Audiogram Sound Filter App</h1>\n");
      out.write("            <p class=\"lead\">This app allows you  simulate hearing disabilities based on medical\n");
      out.write("            audiogram parameters.</p>\n");
      out.write("            <p class=\"lead\">\n");
      out.write("                <h2>Choose audio file below:</h2>\n");
      out.write("                <form method=\"POST\" action=\"FileUploadServlet\" enctype=\"multipart/form-data\" >\n");
      out.write("                    <input class=\"file-btn btn btn-lg btn-secondary\" type=\"file\" name=\"file\" accept=\".wav\" /> <br/>\n");
      out.write("                    <input class=\"btn btn-lg btn-secondary\" type=\"submit\" value=\"Upload\" name=\"upload\" id=\"upload\" />\n");
      out.write("                </form>\n");
      out.write("            </p>\n");
      out.write("          </main>\n");
      out.write("        </div>\n");
      out.write("    \n");
      out.write("        \n");
      out.write("    </body>\n");
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
