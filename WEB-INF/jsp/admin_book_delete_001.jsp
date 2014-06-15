<%@ include file="./inc/common.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link href="css/style.css" rel="stylesheet" type="text/css" media="all">

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%@ include file="inc/admin_header.jsp"%>

<!-- Start of actual page -->
<div id="page">
<div id="content">
<div class="news">
<h1 class="title" align="center">Welcome
${adminLoginFormBean.loginAdmin.name}</h1>
<br>

<div class="table">
<p align="center"><font size=+1 color="black">Book Delete</font></p>
<br>
	<html:form action="/bookdeletePath">
<table align="center">
            <tr>
              <td>Are you sure you want to delete selected book?</td>
            </tr>
			<tr>
				<td>
				<html:submit property="btnOk" value="Ok">
				</html:submit>
				</td>
				<td>
				<html:submit property="btnCancel" value="Cancel">
				</html:submit>
				</td>
			</tr>
			
			
</table>
</html:form>
</div>
</div>
</div>
<%@ include file="inc/admin_left_menu.jsp"%></div>
<%@ include file="inc/footer.jsp"%>
</body>
</html>