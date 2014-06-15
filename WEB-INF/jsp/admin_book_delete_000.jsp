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
	<li><a href="bookupdatePathFirst.do">Book Update</a></li>
	<li class="current_page_item"><a href="bookdeletePathFirst.do">Book Delete</a></li>
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
<p align="center"><font size=+1 color="black">Book Delete</font></p>
<br>
<html:form action="/bookdeletePath">
	<logic:notEmpty name="list">
		<b>Your Book Information have been deleted
		successfully...............</b>
		<br>
		<br>
		<br>
		<br>
	</logic:notEmpty>
	<logic:empty name="rlist">
		<br>
		<br>
							There is no  book Information ...
							<br />
		<br>
		<br>
		<br>
		<br>
		<br>
		<br>
		<br>
		<br>
		<br>
		<br>
		<br>
		<br>
		<br>
		<br>
		<br>
		<br>
	</logic:empty>
	<logic:notEmpty name="rlist">
		<p><html:errors property="noselectedItem" /></p>

		<table border="1">
			<tr>
				<td>Call Number</td>
				<td>Author</td>
				<td>Title</td>
				<td>ISBN</td>
				<td>Delete</td>
			</tr>
			<logic:iterate id="showdata" name="rlist">
				<tr>
					<td align="left"><bean:write name="showdata"
						property="callNumberCode" />&nbsp;</td>
					<td align="left"><bean:write name="showdata"
						property="authorName" />&nbsp;</td>
					<td align="left"><bean:write name="showdata" property="title" />&nbsp;</td>
					<td align="left"><bean:write name="showdata" property="isbn" />&nbsp;</td>
					<td><html:multibox property="selectedItem"
						value="${showdata.id} ${showdata.bookId}"
						name="BookDeleteFormBean">
					</html:multibox></td>
				</tr>
			</logic:iterate>
			<tr>
			<tr>
				<td colspan="5" align="center"><html:submit
					property="btnDelete" value="Delete">${showdata.id}
				</html:submit></td>
			</tr>
		</table>
	</logic:notEmpty>
</html:form></div>
</div>
</div>
<%@ include file="inc/admin_left_menu.jsp"%></div>
<%@ include file="inc/footer.jsp"%>
</body>
</html>