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
	<li><a href="bookdeletePathFirst.do">Book Delete</a></li>
	<li><a href="checkinPath.do">Check In</a></li>
	<li class="current_page_item"><a href="checkoutPathFirst.do">Check Out</a></li>
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
<p align="center"><font size=+1 color="black">Check Out Book</font></p>
<br>
<html:form action="/checkoutPath">
	<table align="center">
		<tr>
				<td>ISBN</td>
				<td><html:text property="frmIsbn" maxlength="10"></html:text></td>
				<td><font
					color="red">***</font><html:errors property="frmIsbn" /></td>
				<td><html:errors property="nobookerror"></html:errors>
				<html:errors property="checkoutbookerror"></html:errors>
				<html:errors property="checkoutbookreserror"></html:errors>
				</td>
			</tr>
		<tr>
			<td>Login Name</td>
			<td><html:text property="frmLoginName"></html:text></td>
			<td><font color="red">***</font><html:errors
				property="frmLoginName" /></td>
			<td><html:errors property="checkoutError"></html:errors></td>
			<td><html:errors property="bookonLoanError"></html:errors> <html:errors
				property="checkoutUserError"></html:errors></td>
		</tr>

		<tr>
			<td><html:submit property="btnSearch" value="Search">
			</html:submit></td>
		</tr>

	</table>
	<logic:notEmpty property="frmCheckoutFormControl"
		name="CheckOutFormBean">
		<table>
			<tr>
				<td>Login Name</td>
				<td><html:text property="frmLoginName" disabled="true"></html:text></td>
			</tr>
			<tr>
				<td>ISBN</td>
				<td><html:text property="frmIsbn" disabled="true"></html:text></td>
			</tr>
			<tr>
				<td>Author</td>
				<td><html:text property="frmAuthor" disabled="true"></html:text></td>
			</tr>
			<tr>
				<td>Issue Date</td>
				<td><html:text property="issue_date" disabled="true"></html:text></td>
			</tr>
			<tr>
				<td>Due Date</td>
				<td><html:text property="due_date" disabled="true"></html:text></td>
			</tr>
			<tr>
				<td><html:submit property="btnCheckOut" value="CheckOut">
				</html:submit></td>
			</tr>

			<tr>
				<td><html:errors property="bookreserveError"></html:errors></td>
			</tr>
		</table>
	</logic:notEmpty>
	<tr>
		<td>${CheckOutFormBean.frmCheckoutMessage }</td>
	</tr>
</html:form></div>
</div>
</div>
<%@ include file="inc/admin_left_menu.jsp"%></div>
<%@ include file="inc/footer.jsp"%>
</body>
</html>