package org.apache.jsp.WEB_002dINF.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class admin_005fbook_005fdelete_005f002_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.List<java.lang.String> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.ArrayList<java.lang.String>(4);
    _jspx_dependants.add("/WEB-INF/jsp/./inc/common.jsp");
    _jspx_dependants.add("/WEB-INF/jsp/inc/admin_header.jsp");
    _jspx_dependants.add("/WEB-INF/jsp/inc/admin_left_menu.jsp");
    _jspx_dependants.add("/WEB-INF/jsp/inc/footer.jsp");
  }

  private javax.el.ExpressionFactory _el_expressionfactory;
  private org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.List<java.lang.String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
    _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
        throws java.io.IOException, javax.servlet.ServletException {

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\" \"http://www.w3.org/TR/html4/loose.dtd\">\n");
      out.write("<html>\n");
      out.write("<head>\n");
      out.write("<link href=\"css/style.css\" rel=\"stylesheet\" type=\"text/css\" media=\"all\">\n");
      out.write("\n");
      out.write("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=ISO-8859-1\">\n");
      out.write("<title>Library Management System</title>\n");
      out.write("</head>\n");
      out.write("<body>\n");
      out.write("<!-- Start of top navigation/header -->\r\n");
      out.write("<div id=\"header\">\r\n");
      out.write("<div id=\"menu\">\r\n");
      out.write("<ul>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\t<li><a href=\"amazonPath.do\">Amazon Search</a></li>\r\n");
      out.write("\t<li><a href=\"adminBookSearch.do\">Library Search</a></li>\r\n");
      out.write("\t<li><a href=\"bookupdatePathFirst.do\">Book Update</a></li>\r\n");
      out.write("\t<li><a href=\"bookdeletePathFirst.do\">Book Delete</a></li>\r\n");
      out.write("\t<li><a href=\"checkinPath.do\">Check In</a></li>\r\n");
      out.write("\t<li><a href=\"checkoutPathFirst.do\">Check Out</a></li>\r\n");
      out.write("\t<li><a href=\"adminLogoutPath.do\">Logout</a></li>\r\n");
      out.write("\r\n");
      out.write("</ul>\r\n");
      out.write("</div>\r\n");
      out.write("</div>\r\n");
      out.write("<!-- End of top navigation/header -->\r\n");
      out.write("\r\n");
      out.write("<!-- Start of logo -->\r\n");
      out.write("<div id=\"logo\">\r\n");
      out.write("<h1><a href=\"#\"><em>Library</em> Management System</a></h1>\r\n");
      out.write("<h2><font color=olive>By Team 4</font></h2>\r\n");
      out.write("</div>\r\n");
      out.write("<!-- End of logo -->\r\n");
      out.write("\r\n");
      out.write("<hr />");
      out.write("\n");
      out.write("\n");
      out.write("<!-- Start of actual page -->\n");
      out.write("<div id=\"page\">\n");
      out.write("<div id=\"content\">\n");
      out.write("<div class=\"news\">\n");
      out.write("<h1 class=\"title\" align=\"center\">Welcome\n");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${adminLoginFormBean.loginAdmin.name}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("</h1>\n");
      out.write("<br>\n");
      out.write("\n");
      out.write("<div class=\"table\">\n");
      out.write("\t<h3><font color=red>The Selected Book are successfully deleted!!!</font></h3>\n");
      out.write("</div>\n");
      out.write("</div>\n");
      out.write("</div>\n");
      out.write("<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\" \"http://www.w3.org/TR/html4/loose.dtd\">\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\r\n");
      out.write("<title>Left Menu</title>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<div id=\"right\" class=\"right\">\r\n");
      out.write("<ul>\r\n");
      out.write("\t<li>\r\n");
      out.write("\t<h2 align=\"center\"><a href=\"adminRegisterPathFirst.do\" >BOOK &nbsp; REGISTRATION</a></h2>\r\n");
      out.write("\t<h2 align=\"center\"><a href=\"viewbookstatusFirst.do\">BOOK STATUS INFORMATION</a></h2>\r\n");
      out.write("\t<h2 align=\"center\"><a href=\"adminViewReservationPath.do\">RESERVATION &nbsp; STATUS</a></h2>\r\n");
      out.write("\t<h2 align=\"center\"><a href=\"adminrecall.do\">RECALL &nbsp; BY &nbsp; EMAIL</a></h2>\r\n");
      out.write("\t<h2 align=\"center\"><a href=\"adminViewRentMemberPath.do\">MOST &nbsp; RENT &nbsp; USER</a></h2>\r\n");
      out.write("\t<h2 align=\"center\"><a href=\"adminViewMemberInfoPath.do?frmControl=1 \">MEMBER &nbsp;INFORMATION</a></h2>\r\n");
      out.write("\t<h2 align=\"center\"><a href=\"adminViewRentBookPath.do\">MOST &nbsp;RENT &nbsp;BOOK</a></h2>\r\n");
      out.write("\t\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\t</li>\r\n");
      out.write("</ul>\r\n");
      out.write("</div>\r\n");
      out.write("<div style=\"clear: both;\">&nbsp;</div>\r\n");
      out.write("\r\n");
      out.write("</body>\r\n");
      out.write("</html>");
      out.write("</div>\n");
      out.write("<div id=\"footer\">\r\n");
      out.write("<p>&copy; 2011 All Rights Reserved. <br>\r\n");
      out.write("Designed by <a href=\"#\" title=\"#\">Team4</a> for <a href=\"#\" title=\"#\">ICTTI</a>\r\n");
      out.write("<a href=\"#\">Project</a></p>\r\n");
      out.write("</div>");
      out.write("\n");
      out.write("</body>\n");
      out.write("</html>");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try { out.clearBuffer(); } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
