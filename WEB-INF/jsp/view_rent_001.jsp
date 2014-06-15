<%@ include file="./inc/common.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link href="css/style.css" rel="stylesheet" type="text/css" media="all">

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Library Management System</title>
</head>
<body>
<%@ include file="inc/header.jsp"%>

<!-- Start of actual page -->
<div id="page">
<div id="content">
<div class="news">
<h1 class="title" align="center">Welcome
${LoginFormBean.loginUser.userName}</h1>
<br>


<div class="table">
<p align="center"><font size=+1 color="black">View
Rent History Form</font></p>
<br>
	<html:form action="/renewPath">
			<table align="center" border="1">
				<tr>
					<td>Call Number</td>
					<td>${ViewRentFormBean.frmViewRentedHistory.callNumber }</td>
				</tr>
				<tr>
					<td>Title</td>
					<td>${ViewRentFormBean.frmViewRentedHistory.title }</td>
				</tr>
				<tr>
					<td>Issue Date</td>
					<td>${ViewRentFormBean.frmViewRentedHistory.issueDate }</td>
				</tr>
				<tr>
					<td>Due Date</td>
					<td> ${ViewRentFormBean.frmViewRentedHistory.dueDate}</td>
				</tr>
				<tr>
					<td colspan="2" align="center"><html:submit property="btnRenew" value="Renew"></html:submit></td>
				</tr>
			</table>
			
</html:form>
</div>
</div>
</div>
<%@ include file="inc/left_menu.jsp"%></div>
<%@ include file="inc/footer.jsp"%>
</body>
</html>