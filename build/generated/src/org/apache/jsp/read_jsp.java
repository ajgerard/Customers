package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class read_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.ArrayList<String>(4);
    _jspx_dependants.add("/includes/bootstrap.jsp");
    _jspx_dependants.add("/includes/header.jsp");
    _jspx_dependants.add("/includes/adminmenu.jsp");
    _jspx_dependants.add("/includes/footer.jsp");
  }

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

      out.write("\r\n");
      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html lang=\"en\">\r\n");
      out.write("    <head>\r\n");
      out.write("\r\n");
      out.write("        ");
      out.write("<!-- Latest compiled and minified CSS -->\r\n");
      out.write("<meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\r\n");
      out.write("<link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css\" integrity=\"sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u\" crossorigin=\"anonymous\">\r\n");
      out.write("<link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css\" integrity=\"sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp\" crossorigin=\"anonymous\">\r\n");
      out.write("<script src=\"//ajax.googleapis.com/ajax/libs/jquery/1.11.0/jquery.min.js\"></script>\r\n");
      out.write("<script src=\"//netdna.bootstrapcdn.com/bootstrap/3.1.1/js/bootstrap.min.js\"></script>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<link rel=\"stylesheet\" href=\"bootstrap.css\">\r\n");
      out.write("\r\n");
      out.write("<script>\r\n");
      out.write("    (function (i, s, o, g, r, a, m) {\r\n");
      out.write("        i['GoogleAnalyticsObject'] = r;\r\n");
      out.write("        i[r] = i[r] || function () {\r\n");
      out.write("            (i[r].q = i[r].q || []).push(arguments)\r\n");
      out.write("        }, i[r].l = 1 * new Date();\r\n");
      out.write("        a = s.createElement(o),\r\n");
      out.write("                m = s.getElementsByTagName(o)[0];\r\n");
      out.write("        a.async = 1;\r\n");
      out.write("        a.src = g;\r\n");
      out.write("        m.parentNode.insertBefore(a, m)\r\n");
      out.write("    })(window, document, 'script', 'https://www.google-analytics.com/analytics.js', 'ga');\r\n");
      out.write("\r\n");
      out.write("    ga('create', 'UA-88405199-1', 'auto');\r\n");
      out.write("    ga('send', 'pageview');\r\n");
      out.write("\r\n");
      out.write("</script>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("        <title>Group 5 Final</title>\r\n");
      out.write("    </head>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("    <body>\r\n");
      out.write("        <div class=\"container\"> <!-- wrap -->\r\n");
      out.write("\r\n");
      out.write("            ");
      out.write("<div class=\"row\">\r\n");
      out.write("    <div class=\"col-sm-5 col-xs-12\">\r\n");
      out.write("         \r\n");
      out.write("            \r\n");
      out.write("                <img src=\"includes/cobra.png\" height=\"150px\" />\r\n");
      out.write("           \r\n");
      out.write("       \r\n");
      out.write("    </div>\r\n");
      out.write("    <div class=\"col-sm-7 col-xs-12\">\r\n");
      out.write("       \r\n");
      out.write("       \r\n");
      out.write("        <h1>Business<br>\r\n");
      out.write("        <small>Customer Information</small>\r\n");
      out.write("        </h1>\r\n");
      out.write("        \r\n");
      out.write("    </div>\r\n");
      out.write("\r\n");
      out.write("</div> <!-- close header -->\r\n");
      out.write(" \r\n");
      out.write("\r\n");
      out.write("            ");
      out.write("<div id=\"custom-bootstrap-menu\" class=\"navbar navbar-default \" role=\"navigation\">\r\n");
      out.write("    <div class=\"container-fluid\">\r\n");
      out.write("        <div class=\"navbar-header\">\r\n");
      out.write("            <button type=\"button\" class=\"navbar-toggle\" data-toggle=\"collapse\" data-target=\".navbar-menubuilder\"><span class=\"sr-only\">Toggle navigation</span><span class=\"icon-bar\"></span><span class=\"icon-bar\"></span><span class=\"icon-bar\"></span>\r\n");
      out.write("            </button>\r\n");
      out.write("        </div>\r\n");
      out.write("        <div class=\"collapse navbar-collapse navbar-menubuilder\">\r\n");
      out.write("            <ul class=\"nav navbar-nav navbar-left\">\r\n");
      out.write("                \r\n");
      out.write("                <li><a href=\"editfaq.jsp\">Edit FAQ</a>\r\n");
      out.write("                </li>\r\n");
      out.write("                <li><a href=\"updatehome\">Edit Homepage</a>\r\n");
      out.write("                </li>\r\n");
      out.write("                <li><a href=\"adminadd.jsp\">Add New Member</a>\r\n");
      out.write("                </li>\r\n");
      out.write("                <li><a href=\"fullcalc\">Tax Records</a>\r\n");
      out.write("                </li>\r\n");
      out.write("                <li><a href=\"dashboard.jsp\">Member Records</a>\r\n");
      out.write("                </li>\r\n");
      out.write("                <li><a href=\"index.jsp\">Logout</a>\r\n");
      out.write("                </li>\r\n");
      out.write("\r\n");
      out.write("            </ul>\r\n");
      out.write("            <div class=\"col-sm-3 col-md-3 pull-right\">\r\n");
      out.write("                <form class=\"navbar-form\" role=\"search\" action=\"search\" method=\"post\">\r\n");
      out.write("                    <div class=\"input-group\">\r\n");
      out.write("                        <input type=\"text\" class=\"form-control\" placeholder=\"Search\" name=\"searchVal\" id=\"searchVal\">\r\n");
      out.write("                        <div class=\"input-group-btn\">\r\n");
      out.write("                            <button class=\"btn btn-default\" type=\"submit\" name=\"submit\"><i class=\"glyphicon glyphicon-search\"></i></button>\r\n");
      out.write("                        </div>\r\n");
      out.write("                    </div>\r\n");
      out.write("                </form>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("            </div>\r\n");
      out.write("        </div>\r\n");
      out.write("    </div>\r\n");
      out.write("</div>\r\n");
      out.write(" \r\n");
      out.write("\r\n");
      out.write("            <div class=\"row\">\r\n");
      out.write("                <div class=\"col-xs-12\">\r\n");
      out.write("                    <div class=\"panel panel-default\">\r\n");
      out.write("                        <div class=\"panel-heading\">\r\n");
      out.write("                            ");
 String fullname = (String) request.getAttribute("fullname");
      out.write(" \r\n");
      out.write("                            <center><h2>Search Results for \"");
      out.print(fullname);
      out.write("\"</h2></center>\r\n");
      out.write("                        </div>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("                        ");
 String searchResults = (String) request.getAttribute("table");
      out.write("\r\n");
      out.write("                        ");
      out.print( searchResults);
      out.write("  \r\n");
      out.write("                    </div>\r\n");
      out.write("                </div>\r\n");
      out.write("            </div>\r\n");
      out.write("            ");
      out.write("<div class=\"row\">\r\n");
      out.write("    <div class=\"col-xs-12\">\r\n");
      out.write("        <div class=\"panel panel-default\">\r\n");
      out.write("            <div class=\"panel-body\">\r\n");
      out.write("                <center>\r\n");
      out.write("                    &copy; Copyright 2016 Software Design and Development\r\n");
      out.write("                    <br>\r\n");
      out.write("                    <a href=\"login.jsp\">Admin</a>   \r\n");
      out.write("                </center>\r\n");
      out.write("            </div>\r\n");
      out.write("        </div>\r\n");
      out.write("    </div>\r\n");
      out.write("</div> <!-- close footer -->   ");
      out.write("\r\n");
      out.write("\r\n");
      out.write("        </div> <!-- close wrap -->\r\n");
      out.write("    </body>\r\n");
      out.write("</html>\r\n");
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
