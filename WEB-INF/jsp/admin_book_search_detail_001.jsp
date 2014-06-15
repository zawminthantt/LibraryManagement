<%@ include file="./inc/common.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link href="css/style.css" rel="stylesheet" type="text/css" media="all">

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Library Management System</title>
</head>
<body>
<!-- Start of top navigation/header -->
<div id="header">
<div id="menu">
<ul>


	<li><a href="amazonPath.do">Amazon Search</a></li>
	<li class="current_page_item"><a href="adminBookSearch.do">Library Search</a></li>
	<li><a href="bookupdatePathFirst.do">Book Update</a></li>
	<li><a href="bookdeletePathFirst.do">Book Delete</a></li>
	<li><a href="checkinPath.do">Check In</a></li>
	<li><a href="checkoutPathFirst.do">Check Out</a></li>
	<li><a href="adminLogoutPath.do">Logout</a></li>

</ul>
</div>
</div>
<!-- End of top navigation/header -->

<!-- Start of logo -->
<div id="logo">
<h1><a href="#"><em>Library</em> Management System</a></h1>
<h2><font color=olive>By Team 4</font></h2>
</div>
<!-- End of logo -->

<hr />

<!-- Start of actual page -->
<div id="page">
<div id="content">
<div class="news">
<h1 class="title" align="center">Welcome
${adminLoginFormBean.loginAdmin.name}</h1>
<br>

<div class="table">
<p align="center"><font size=+1 color="black">Book Search
Detail Form</font></p>
<br>
<html:form action="/adminSearchDetailPath">
	<table align="center">

		<tr>
			<td><html:img src="${AutoFormBean.frmViewPhoto}" height="200"
				width="200" /></td>
		</tr>

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
			<td><font color="black"> ${AutoFormBean.frmViewBook.year}</font></td>
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
			<td colspan="2" align="center"><html:submit property="btnOk"
				value="OK"></html:submit></td>
		</tr>
	</table>
</html:form></div>
</div>
</div>
<%@ include file="inc/admin_left_menu.jsp"%></div>
<%@ include file="inc/footer.jsp"%>
</body>
</html>