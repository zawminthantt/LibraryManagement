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
	<li><a href="adminBookSearch.do">Library Search</a></li>
	<li class="current_page_item"><a href="bookupdatePathFirst.do">Book Update</a></li>
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
<p align="center"><font size=+1 color="black">Book Update Form</font></p>
<html:form action="/bookupdatePathFirst">
	<table align="center">
		<tr>
			<td>ISBN Number</td>
			<td>${BookUpdateFormBean.frmViewDetailBook.isbn }</td>
		</tr>
		<tr>
			<td>Title</td>
			<td>${BookUpdateFormBean.frmViewDetailBook.title }</td>
		</tr>
		<tr>
			<td>Author</td>
			<td>${BookUpdateFormBean.frmViewDetailBook.authorName }</td>
		</tr>
		<tr>
			<td>Edition</td>
			<td>${BookUpdateFormBean.frmViewDetailBook.edition }</td>
		</tr>
		<tr>
			<td>Publisher</td>
			<td>${BookUpdateFormBean.frmViewDetailBook.publisherName }</td>
		</tr>
		<tr>
			<td>Year</td>
			<td>${BookUpdateFormBean.frmViewDetailBook.year }</td>
		</tr>
		<tr>
			<td>Price</td>
			<td>${BookUpdateFormBean.frmViewDetailBook.price }</td>
		</tr>
		<tr>
			<td>No Of Copies</td>
			<td>${BookUpdateFormBean.noOfcopies}</td>
		</tr>

		<tr>
			<td><html:submit property="btnSave" value="Save">
			</html:submit></td>
			<td><html:submit property="btnSaveCancel" value="Cancel">
			</html:submit></td>
		</tr>
	</table>
</html:form></div>
</div>
</div>
<%@ include file="inc/admin_left_menu.jsp"%></div>
<%@ include file="inc/footer.jsp"%>
</body>
</html>