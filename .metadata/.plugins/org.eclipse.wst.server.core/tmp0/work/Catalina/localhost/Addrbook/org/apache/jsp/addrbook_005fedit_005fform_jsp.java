/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/9.0.69
 * Generated at: 2022-12-06 08:37:48 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import com.addrbook.model.*;
import java.util.*;

public final class addrbook_005fedit_005fform_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  private static final java.util.Set<java.lang.String> _jspx_imports_packages;

  private static final java.util.Set<java.lang.String> _jspx_imports_classes;

  static {
    _jspx_imports_packages = new java.util.HashSet<>();
    _jspx_imports_packages.add("javax.servlet");
    _jspx_imports_packages.add("java.util");
    _jspx_imports_packages.add("javax.servlet.http");
    _jspx_imports_packages.add("com.addrbook.model");
    _jspx_imports_packages.add("javax.servlet.jsp");
    _jspx_imports_classes = null;
  }

  private volatile javax.el.ExpressionFactory _el_expressionfactory;
  private volatile org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public java.util.Set<java.lang.String> getPackageImports() {
    return _jspx_imports_packages;
  }

  public java.util.Set<java.lang.String> getClassImports() {
    return _jspx_imports_classes;
  }

  public javax.el.ExpressionFactory _jsp_getExpressionFactory() {
    if (_el_expressionfactory == null) {
      synchronized (this) {
        if (_el_expressionfactory == null) {
          _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
        }
      }
    }
    return _el_expressionfactory;
  }

  public org.apache.tomcat.InstanceManager _jsp_getInstanceManager() {
    if (_jsp_instancemanager == null) {
      synchronized (this) {
        if (_jsp_instancemanager == null) {
          _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
        }
      }
    }
    return _jsp_instancemanager;
  }

  public void _jspInit() {
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
      throws java.io.IOException, javax.servlet.ServletException {

    if (!javax.servlet.DispatcherType.ERROR.equals(request.getDispatcherType())) {
      final java.lang.String _jspx_method = request.getMethod();
      if ("OPTIONS".equals(_jspx_method)) {
        response.setHeader("Allow","GET, HEAD, POST, OPTIONS");
        return;
      }
      if (!"GET".equals(_jspx_method) && !"POST".equals(_jspx_method) && !"HEAD".equals(_jspx_method)) {
        response.setHeader("Allow","GET, HEAD, POST, OPTIONS");
        response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED, "JSP들은 오직 GET, POST 또는 HEAD 메소드만을 허용합니다. Jasper는 OPTIONS 메소드 또한 허용합니다.");
        return;
      }
    }

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html; charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			"addrbook_error.jsp", true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\r\n");
      out.write("    \r\n");
      com.addrbook.model.AddrDto addr = null;
      addr = (com.addrbook.model.AddrDto) _jspx_page_context.getAttribute("addr", javax.servlet.jsp.PageContext.REQUEST_SCOPE);
      if (addr == null){
        addr = new com.addrbook.model.AddrDto();
        _jspx_page_context.setAttribute("addr", addr, javax.servlet.jsp.PageContext.REQUEST_SCOPE);
      }
      out.write('\r');
      out.write('\n');
 

      out.write("\r\n");
      out.write("\r\n");
      out.write("    \r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("	\r\n");
      out.write("	<script>\r\n");
      out.write("		function delcheck(){\r\n");
      out.write("			result = confirm(\"정말로 삭제하시겠습니까?\");\r\n");
      out.write("			\r\n");
      out.write("			if(result){\r\n");
      out.write("				document.form1.action.value=\"delete\";\r\n");
      out.write("				document.form1.submit();\r\n");
      out.write("			}\r\n");
      out.write("			else {\r\n");
      out.write("				return;\r\n");
      out.write("			}\r\n");
      out.write("		}\r\n");
      out.write("	</script>\r\n");
      out.write("	<meta charset=\"UTF-8\">\r\n");
      out.write("	<link rel=\"stylesheet\" href=\"addrbook.css\" type=\"text/css\" media=\"screen\"/>\r\n");
      out.write("</head>\r\n");
      out.write("\r\n");
      out.write("<title>주소록 : 수정화면</title>\r\n");
      out.write("\r\n");
      out.write("<body>\r\n");
      out.write("<div align =\"center\">\r\n");
      out.write("	<h2>주소록 : 수정화면</h2>\r\n");
      out.write("	<hr>\r\n");
      out.write("	<a href = /Addrbook/list.do >주소록 목록</a><p>\r\n");
      out.write("	<form name = form1\r\n");
      out.write("		method = post\r\n");
      out.write("		action = /Addrbook/update.do >\r\n");
      out.write("\r\n");
      out.write("	<input type=hidden name=\"id\" value=\"");
      out.print(addr.getId());
      out.write("\">\r\n");
      out.write("	\r\n");
      out.write("	<table border=\"1\">\r\n");
      out.write("		<tr>\r\n");
      out.write("		<th>이름</th>\r\n");
      out.write("		<td><input type=\"text\" name = \"name\" value=\"");
      out.print(addr.getName() );
      out.write("\" ></td>\r\n");
      out.write("		</tr>\r\n");
      out.write("		\r\n");
      out.write("		<tr>\r\n");
      out.write("		<th>이메일</th>\r\n");
      out.write("		<td><input type=\"text\" name = \"email\" value=\"");
      out.print(addr.getEmail() );
      out.write("\" ></td>\r\n");
      out.write("		</tr>\r\n");
      out.write("		\r\n");
      out.write("		<tr>\r\n");
      out.write("		<th>회사</th>\r\n");
      out.write("		<td><input type=\"text\" name = \"comdept\" value=\"");
      out.print(addr.getComdept() );
      out.write("\"></td>\r\n");
      out.write("		</tr>\r\n");
      out.write("		\r\n");
      out.write("		<tr>\r\n");
      out.write("		<th>생일</th>\r\n");
      out.write("		<td><input type=\"date\" name = \"birth\" value=\"");
      out.print(addr.getBirth() );
      out.write("\"></td>\r\n");
      out.write("		</tr>\r\n");
      out.write("		\r\n");
      out.write("		<tr>\r\n");
      out.write("		<th>전화번호</th>\r\n");
      out.write("		<td><input type=\"text\" name = \"tel\" value=\"");
      out.print(addr.getTel() );
      out.write("\"></td>\r\n");
      out.write("		</tr>\r\n");
      out.write("		\r\n");
      out.write("		<tr>\r\n");
      out.write("		<th>메모</th>\r\n");
      out.write("		<td><input type=\"text\" name = \"memo\" value=\"");
      out.print(addr.getMemo() );
      out.write("\"></td>\r\n");
      out.write("		</tr>\r\n");
      out.write("		\r\n");
      out.write("		<tr>\r\n");
      out.write("		<td colspan=2 align=center>\r\n");
      out.write("		<input type =\"submit\" value =\"저장\">\r\n");
      out.write("		<input type =\"reset\"  value =\"취소\">\r\n");
      out.write("		<input type =\"button\" value =\"삭제\" onClick=\"delcheck()\"></td>\r\n");
      out.write("		</tr>\r\n");
      out.write("	\r\n");
      out.write("	</table>\r\n");
      out.write("	\r\n");
      out.write("	\r\n");
      out.write("	</form>\r\n");
      out.write("	\r\n");
      out.write("	\r\n");
      out.write("	\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("</div>\r\n");
      out.write("</body>\r\n");
      out.write("\r\n");
      out.write("</html>\r\n");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try {
            if (response.isCommitted()) {
              out.flush();
            } else {
              out.clearBuffer();
            }
          } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
