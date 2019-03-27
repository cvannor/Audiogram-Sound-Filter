package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class InputParams_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("        <title>Input Parameters</title>\n");
      out.write("    </head>\n");
      out.write("    <body class=\"text-center body-second\">\n");
      out.write("        <form method=\"POST\" action=\"FormExecute\" enctype=\"multipart/form-data\">\n");
      out.write("            <div class=\"form-group\">\n");
      out.write("            <h4>Choose Frequency(Pitch) in Hz: </h4>\n");
      out.write("            <label class=\"container\">125 (lowest)\n");
      out.write("              <input type=\"radio\" checked=\"checked\" name=\"radio\">\n");
      out.write("              <span class=\"checkmark\"></span>\n");
      out.write("            </label>\n");
      out.write("            <label class=\"container\">250\n");
      out.write("              <input type=\"radio\" name=\"radio\">\n");
      out.write("              <span class=\"checkmark\"></span>\n");
      out.write("            </label>\n");
      out.write("            <label class=\"container\">500\n");
      out.write("              <input type=\"radio\" name=\"radio\">\n");
      out.write("              <span class=\"checkmark\"></span>\n");
      out.write("            </label>\n");
      out.write("            <label class=\"container\">1000\n");
      out.write("              <input type=\"radio\" name=\"radio\">\n");
      out.write("              <span class=\"checkmark\"></span>\n");
      out.write("            </label>\n");
      out.write("            <label class=\"container\">2000\n");
      out.write("              <input type=\"radio\" name=\"radio\">\n");
      out.write("              <span class=\"checkmark\"></span>\n");
      out.write("            </label>\n");
      out.write("            <label class=\"container\">3000\n");
      out.write("              <input type=\"radio\" name=\"radio\">\n");
      out.write("              <span class=\"checkmark\"></span>\n");
      out.write("            </label>\n");
      out.write("            <label class=\"container\">4000\n");
      out.write("              <input type=\"radio\" name=\"radio\">\n");
      out.write("              <span class=\"checkmark\"></span>\n");
      out.write("            </label>\n");
      out.write("            <label class=\"container\">8000 (highest)\n");
      out.write("              <input type=\"radio\" name=\"radio\">\n");
      out.write("              <span class=\"checkmark\"></span>\n");
      out.write("            </label>\n");
      out.write("            </div>\n");
      out.write("            <div class=\"slidecontainer\">\n");
      out.write("                <h4>Set hearing level(dB): </h4>\n");
      out.write("                <input type=\"range\" min=\"0\" max=\"120\" value=\"0\" class=\"slider\" id=\"myRange\">\n");
      out.write("            </div>\n");
      out.write("            <p id=\"value\"></p>\n");
      out.write("            <h3 id=\"classification\"></h3>\n");
      out.write("            <script>\n");
      out.write("                var slider = document.getElementById(\"myRange\");\n");
      out.write("                var output = document.getElementById(\"classification\");\n");
      out.write("                var valueBox = document.getElementById(\"value\");\n");
      out.write("                output.innerHTML = \"Normal Hearing\";\n");
      out.write("                valueBox.innerHTML = \"0 dB\";\n");
      out.write("                // Update the current slider value (each time you drag the slider handle)\n");
      out.write("                slider.oninput = function() {\n");
      out.write("                    valueBox.innerHTML = this.value + \"dB\";\n");
      out.write("                    if(slider.value <= 15){\n");
      out.write("                        output.innerHTML = \"Normal Hearing\";\n");
      out.write("                    }else if(slider.value >15 && slider.value <= 25 ){\n");
      out.write("                        output.innerHTML = \"Slight Hearing Loss\";  \n");
      out.write("                    }else if(slider.value >25 && slider.value <= 40 ){\n");
      out.write("                        output.innerHTML = \"Mild Hearing Loss\";  \n");
      out.write("                    }else if(slider.value >40 && slider.value <= 55 ){\n");
      out.write("                        output.innerHTML = \"Moderate Hearing Loss\";  \n");
      out.write("                    }else if(slider.value >55 && slider.value <= 70 ){\n");
      out.write("                        output.innerHTML = \"Moderately Severe Hearing Loss\";  \n");
      out.write("                    }else if(slider.value >70 && slider.value <= 90 ){\n");
      out.write("                        output.innerHTML = \"Severe Hearing Loss\";  \n");
      out.write("                    }else if (slider.value >90){\n");
      out.write("                        output.innerHTML = \"Profound Hearing Loss\";  \n");
      out.write("                    }\n");
      out.write("                }\n");
      out.write("            </script>\n");
      out.write("            <input class=\"btn\" type=\"submit\" value=\"Process Audio\" name=\"process\" />\n");
      out.write("        </form>\n");
      out.write("        \n");
      out.write("    </body>\n");
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
