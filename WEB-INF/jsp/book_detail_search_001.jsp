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
<p align="center">
			<font size=+1 color="black" >Book Search Detail Form</font>
		</p><br>
	<html:form action="/searchDetailPath" >
	<table align="center" >
		
	<tr><td>
	<html:img src="${AutoFormBean.frmViewPhoto}" height="200" width="200"/></td></tr>
	
		<tr>
			<td><font color="black">Title:</font></td>
			<td><font color="black">${AutoFormBean.frmViewBook.title}</font></td>
		</tr>
		<tr>
			<td><font color="black">Author:</font></td>
			<td><font color="black">${AutoFormBean.frmViewBook.authorName}</font></td>
		</tr>
		<tr>
			<td><font color="black">ISBN:</font></td>
			<td><font color="black">${AutoFormBean.frmViewBook.isbn}</font></td>
		</tr>
		<tr>
			<td><font color="black">Edition:</font></td>
			<td><font color="black">${AutoFormBean.frmViewBook.edition}</font></td>
		</tr>
		<tr>
			<td><font color="black">Publisher:</font></td>
			<td><font color="black">${AutoFormBean.frmViewBook.publisherName}</font></td>
		</tr>
		<tr>
			<td><font color="black">Year:</font></td>
			<td><font color="black">
			${AutoFormBean.frmViewBook.year}</font></td>
		</tr>
		<tr>
			<td><font color="black">Number of Copies:</font></td>
			<td><font color="black">${AutoFormBean.frmViewBook.noofcopies}</font></td>
		</tr>
		
		<tr>
			<td><font color="black">Remark:</font></td>
			<td><font color="black">${AutoFormBean.frmViewBook.remark}</font></td>
		</tr>
		
		<tr>
			<td colspan="2" align="center"><html:submit property="btnOk" value="OK"></html:submit></td>
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