package org.apache.jsp.WEB_002dINF.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class home_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.List<java.lang.String> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.ArrayList<java.lang.String>(4);
    _jspx_dependants.add("/WEB-INF/jsp/./inc/common.jsp");
    _jspx_dependants.add("/WEB-INF/jsp/inc/header.jsp");
    _jspx_dependants.add("/WEB-INF/jsp/inc/left_menu.jsp");
    _jspx_dependants.add("/WEB-INF/jsp/inc/footer.jsp");
  }

  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fhtml_005fform;

  private javax.el.ExpressionFactory _el_expressionfactory;
  private org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.List<java.lang.String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _005fjspx_005ftagPool_005fhtml_005fform = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
    _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
  }

  public void _jspDestroy() {
    _005fjspx_005ftagPool_005fhtml_005fform.release();
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
      out.write("\t<li class=\"current_page_item\"><a href=\"logoutPath.do\">Logout</a></li>\r\n");
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
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${LoginFormBean.loginUser.userName}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("</h1>\n");
      out.write("<br>\n");
      out.write("\n");
      out.write("<div class=\"table\">");
      if (_jspx_meth_html_005fform_005f0(_jspx_page_context))
        return;
      out.write("</div>\n");
      out.write("</div>\n");
      out.write("</div>\n");
      out.write("\r\n");
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
      out.write("\t<h2 align=\"center\"><a href=\"autoComplementPath.do?\">Search\r\n");
      out.write("\t&nbsp; Book</a></h2>\r\n");
      out.write("\t<h2 align=\"center\"><a href=\"updatePathFirst.do?\">Update Profile</a></h2>\r\n");
      out.write("\t<h2 align=\"center\"><a href=\"viewReservePath.do?frmControl=1\">View\r\n");
      out.write("\t&nbsp;Reservation &nbsp; List</a></h2>\r\n");
      out.write("\t<h2 align=\"center\"><a href=\"viewPath.do?\">View &nbsp; Rent\r\n");
      out.write("\t&nbsp; History</a></h2>\r\n");
      out.write("\t</li>\r\n");
      out.write("\t\r\n");
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

  private boolean _jspx_meth_html_005fform_005f0(javax.servlet.jsp.PageContext _jspx_page_context)
          throws java.lang.Throwable {
    javax.servlet.jsp.PageContext pageContext = _jspx_page_context;
    javax.servlet.jsp.JspWriter out = _jspx_page_context.getOut();
    //  html:form
    org.apache.struts.taglib.html.FormTag _jspx_th_html_005fform_005f0 = (org.apache.struts.taglib.html.FormTag) _005fjspx_005ftagPool_005fhtml_005fform.get(org.apache.struts.taglib.html.FormTag.class);
    _jspx_th_html_005fform_005f0.setPageContext(_jspx_page_context);
    _jspx_th_html_005fform_005f0.setParent(null);
    int _jspx_eval_html_005fform_005f0 = _jspx_th_html_005fform_005f0.doStartTag();
    if (_jspx_eval_html_005fform_005f0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("\n");
        out.write("\t<font size=\"5\" color=\"darkblue\">\n");
        out.write("\t<center><b><i><blink>Welcome to Online Library\n");
        out.write("\tManagement System</blink> </i> </b></center>\n");
        out.write("\t</font>\n");
        out.write("\t<hr>\n");
        out.write("\t<br>\n");
        out.write("\t<br>\n");
        out.write("\t<table>\n");
        out.write("\t\t<tr>\n");
        out.write("\t\t\t<td><img src=\"./images/main.jpg\" align=\"right\" height=\"250px\" />\n");
        out.write("\t\t\t<div><font size=\"3\" color=\"darkblue\" face=\"arial\"><b><i>Our\n");
        out.write("\t\t\tObjectives!</i> </b> </font> <font size=\"2\" color=\"darkblue\">This web site is\n");
        out.write("\t\t\tan online gateway to the library resources of Information and\n");
        out.write("\t\t\tCommunication Technoloy Training Institute(ICTTI) and serves as an\n");
        out.write("\t\t\timportant research tool for current students, teachers and staff of\n");
        out.write("\t\t\tICTTI. <br>\n");
        out.write("\t\t\t<center><b>Member can borrow one book depends on the\n");
        out.write("\t\t\tmember type.</b></center>\n");
        out.write("\t\t\t<ul>\n");
        out.write("\t\t\t\t<li>Teachers can borrow one month.</li>\n");
        out.write("\t\t\t\t<li>Regular Students can borrow two weeks.</li>\n");
        out.write("\t\t\t\t<li>Advanced Students can borrow one week.</li>\n");
        out.write("\t\t\t\t<li>Staff can borrow two weeks.</li>\n");
        out.write("\t\t\t</ul>\n");
        out.write("\t\t\t<center><b>If the required book is not currently\n");
        out.write("\t\t\tavailable.</b></center>\n");
        out.write("\t\t\t<ul>\n");
        out.write("\t\t\t\t<li>The member can reserve the required book.</li>\n");
        out.write("\t\t\t\t<li>This member must check out during 7 days from the day of\n");
        out.write("\t\t\t\treserve.</li>\n");
        out.write("\n");
        out.write("\t\t\t</ul>\n");
        out.write("\t\t\t</font></div>\n");
        out.write("\t\t\t</td>\n");
        out.write("\t\t</tr>\n");
        out.write("\t</table>\n");
        out.write("\t\n");
        out.write("\t\n");
        out.write("\t<br>\n");
        out.write("\t<hr>\n");
        out.write("\n");
        out.write("\n");
        out.write("\n");
        out.write("\n");
        int evalDoAfterBody = _jspx_th_html_005fform_005f0.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
    }
    if (_jspx_th_html_005fform_005f0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fhtml_005fform.reuse(_jspx_th_html_005fform_005f0);
      return true;
    }
    _005fjspx_005ftagPool_005fhtml_005fform.reuse(_jspx_th_html_005fform_005f0);
    return false;
  }
}
