package org.apache.jsp.WEB_002dINF.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class admin_005fhome_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.List<java.lang.String> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.ArrayList<java.lang.String>(4);
    _jspx_dependants.add("/WEB-INF/jsp/inc/common.jsp");
    _jspx_dependants.add("/WEB-INF/jsp/inc/admin_header.jsp");
    _jspx_dependants.add("/WEB-INF/jsp/inc/admin_left_menu.jsp");
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
      out.write("\r\n");
      out.write("<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\" \"http://www.w3.org/TR/html4/loose.dtd\">\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<link href=\"css/style.css\" rel=\"stylesheet\" type=\"text/css\" media=\"all\">\r\n");
      out.write("\r\n");
      out.write("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=ISO-8859-1\">\r\n");
      out.write("<title>Library Management System</title>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("\t");
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
      out.write("\r\n");
      out.write("\r\n");
      out.write("\t<!-- Start of actual page -->\r\n");
      out.write("\t<div id=\"page\">\r\n");
      out.write("\t\t<div id=\"content\">\r\n");
      out.write("\t\t\t<div class=\"news\">\r\n");
      out.write("\t\t\t\t<h1 class=\"title\" align=\"center\">Welcome &nbsp;&nbsp;\r\n");
      out.write("\t\t\t\t\t");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${adminLoginFormBean.loginAdmin.name}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("</h1>\r\n");
      out.write("\t\t\t\t<br>\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t<div class=\"table\">\r\n");
      out.write("\t\t\t\t\t");
      if (_jspx_meth_html_005fform_005f0(_jspx_page_context))
        return;
      out.write("\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t\t");
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
      out.write("</div>\r\n");
      out.write("\t");
      out.write("<div id=\"footer\">\r\n");
      out.write("<p>&copy; 2011 All Rights Reserved. <br>\r\n");
      out.write("Designed by <a href=\"#\" title=\"#\">Team4</a> for <a href=\"#\" title=\"#\">ICTTI</a>\r\n");
      out.write("<a href=\"#\">Project</a></p>\r\n");
      out.write("</div>");
      out.write("\r\n");
      out.write("</body>\r\n");
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
        out.write("\r\n");
        out.write("\t\t\t\t\t\t<font size=\"5\" color=\"black\"><center>\r\n");
        out.write("\t\t\t\t\t\t\t\t<b><i><blink>Welcome To Team4 Library</blink> </i> </b>\r\n");
        out.write("\t\t\t\t\t\t\t</center> </font>\r\n");
        out.write("\t\t\t\t\t\t<br>\r\n");
        out.write("\t\t\t\t\t\t<br>\r\n");
        out.write("\t\t\t\t\t\t<table>\r\n");
        out.write("\t\t\t\t\t\t\t<tr>\r\n");
        out.write("\t\t\t\t\t\t\t\t<td><img src=\"./images/BookCoverGif.gif\" align=\"right\"\r\n");
        out.write("\t\t\t\t\t\t\t\t\theight=\"250px\" />\r\n");
        out.write("\t\t\t\t\t\t\t\t\t<div>\r\n");
        out.write("\t\t\t\t\t\t\t\t\t\t<font size=\"2\" color=\"black\" face=\"arial\"><font\r\n");
        out.write("\t\t\t\t\t\t\t\t\t\t\tsize=\"4\"><b><i>We're so glad you're here!</i>\r\n");
        out.write("\t\t\t\t\t\t\t\t\t\t\t</b>\r\n");
        out.write("\t\t\t\t\t\t\t\t\t\t</font> We are a world class library with a fantastic building,\r\n");
        out.write("\t\t\t\t\t\t\t\t\t\t\tamazing collections and terrific people, all ready, willing\r\n");
        out.write("\t\t\t\t\t\t\t\t\t\t\tand able to serve your info needs. I trust your visit will be\r\n");
        out.write("\t\t\t\t\t\t\t\t\t\t\tboth fun and productive. This message is sent on behalf of\r\n");
        out.write("\t\t\t\t\t\t\t\t\t\t\tthe over 100 staff members all working hard to bring you the\r\n");
        out.write("\t\t\t\t\t\t\t\t\t\t\tbest library in Michigan! Our goal is to provide you with\r\n");
        out.write("\t\t\t\t\t\t\t\t\t\t\tworld class resources and unsurpassed service. We're never\r\n");
        out.write("\t\t\t\t\t\t\t\t\t\t\tsatisfied, so we're always adding new books, movies and\r\n");
        out.write("\t\t\t\t\t\t\t\t\t\t\tmusic, fine tuning our services and adjusting our thinking to\r\n");
        out.write("\t\t\t\t\t\t\t\t\t\t\tbring you the latest and greatest available in libraries. Got\r\n");
        out.write("\t\t\t\t\t\t\t\t\t\t\tan idea, question or comment about our library? Keep reading,\r\n");
        out.write("\t\t\t\t\t\t\t\t\t\t\tit's exercise for your mind! As a public institution, we\r\n");
        out.write("\t\t\t\t\t\t\t\t\t\t\tserve all residents, which is affirmed in our mission\r\n");
        out.write("\t\t\t\t\t\t\t\t\t\t\tstatement. As the community consists of people with a wide\r\n");
        out.write("\t\t\t\t\t\t\t\t\t\t\tvariety of beliefs, the public library must attempt to serve\r\n");
        out.write("\t\t\t\t\t\t\t\t\t\t\tall on an equal basis. This the library does by purchasing\r\n");
        out.write("\t\t\t\t\t\t\t\t\t\t\tmaterials that cover a wide variety of topics, as well as\r\n");
        out.write("\t\t\t\t\t\t\t\t\t\t\tboth sides of a particular or controversial topic. This goal\r\n");
        out.write("\t\t\t\t\t\t\t\t\t\t\tof providing materials of both sides of a conflict has always\r\n");
        out.write("\t\t\t\t\t\t\t\t\t\t\tbeen the strength of public libraries across this nation.\r\n");
        out.write("\t\t\t\t\t\t\t\t\t\t\tAnd, public libraries have traditionally been able to provide\r\n");
        out.write("\t\t\t\t\t\t\t\t\t\t\tthese conflicting materials in a neutral and non-threatening\r\n");
        out.write("\t\t\t\t\t\t\t\t\t\t\tsetting. Even though some of the purchased materials may be\r\n");
        out.write("\t\t\t\t\t\t\t\t\t\t\toffensive to an individual or to a group of people, a public\r\n");
        out.write("\t\t\t\t\t\t\t\t\t\t\tlibrary cannot afford to make the physical environment one\r\n");
        out.write("\t\t\t\t\t\t\t\t\t\t\tthat is offensive to anyone. By necessity, this must include\r\n");
        out.write("\t\t\t\t\t\t\t\t\t\t\tthe decorations used to celebrate national and state\r\n");
        out.write("\t\t\t\t\t\t\t\t\t\t\tholidays. Therefore, it shall be the policy of the Hibbing\r\n");
        out.write("\t\t\t\t\t\t\t\t\t\t\tPublic Library that the library will endeavor to decorate the\r\n");
        out.write("\t\t\t\t\t\t\t\t\t\t\tlibrary in an attractive manner to reflect the various\r\n");
        out.write("\t\t\t\t\t\t\t\t\t\t\tholidays and celebrations of the community. In its\r\n");
        out.write("\t\t\t\t\t\t\t\t\t\t\tdecorations, it will refrain from using any symbols or\r\n");
        out.write("\t\t\t\t\t\t\t\t\t\t\tdecorations that are religious in nature. It is noted that\r\n");
        out.write("\t\t\t\t\t\t\t\t\t\t\tthe library's Exhibits and Display Policy allows any group to\r\n");
        out.write("\t\t\t\t\t\t\t\t\t\t\texhibit a display that makes \"the public aware of the\r\n");
        out.write("\t\t\t\t\t\t\t\t\t\t\tdifferent informational, educational and cultural resources\r\n");
        out.write("\t\t\t\t\t\t\t\t\t\t\tof the community.\" This includes displays of a religious\r\n");
        out.write("\t\t\t\t\t\t\t\t\t\t\tnature. </font>\r\n");
        out.write("\t\t\t\t\t\t\t\t\t</div>\r\n");
        out.write("\t\t\t\t\t\t\t\t</td>\r\n");
        out.write("\t\t\t\t\t\t\t</tr>\r\n");
        out.write("\t\t\t\t\t\t</table>\r\n");
        out.write("\r\n");
        out.write("\t\t\t\t\t\t<br>\r\n");
        out.write("\t\t\t\t\t\t<hr>\r\n");
        out.write("\t\t\t\t\t\t<table align=\"right\">\r\n");
        out.write("\t\t\t\t\t\t\t<tr>\r\n");
        out.write("\t\t\t\t\t\t\t\t<td><img src=\"./images/Team4Logo.png\" align=\"right\" /> <font\r\n");
        out.write("\t\t\t\t\t\t\t\t\tsize=\"5\" color=\"black\" face=\"Segoe Script\">Thanks By</font>\r\n");
        out.write("\t\t\t\t\t\t\t\t</td>\r\n");
        out.write("\t\t\t\t\t\t\t</tr>\r\n");
        out.write("\t\t\t\t\t\t</table>\r\n");
        out.write("\r\n");
        out.write("\r\n");
        out.write("\t\t\t\t\t");
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
