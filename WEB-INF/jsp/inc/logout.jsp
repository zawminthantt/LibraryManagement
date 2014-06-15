<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ page language="java" contentType="text/html" pageEncoding="utf-8"%>
<html>
<head>
<title>Logout form</title>
</head>
<body>
<html:form>
	<table  width="100%">
		<tr>
			<td align="left"><font color="green">Welcome
			${LoginFormBean.loginUser.userName}</font></td>
			<td align="right"><a href="logoutPath.do">Log Out</a></td>
		</tr>
	</table>
</html:form>
</body>
</html>