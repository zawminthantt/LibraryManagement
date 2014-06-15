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
			<font size=+1 color="black" >Book Reserve Detail Form</font>
		</p><br>

	<html:form action="/reserveDetailPath">
<table align="center">
	<tr>
		<td>Title</td>
		<td>${LoginFormBean.myViewBookList.title }</td>
	</tr>
	<tr>
		<td>Author</td>
		<td>${LoginFormBean.myViewBookList.authorName }</td>
	</tr>
	<tr>
		<td>ISBN</td>
		<td>${LoginFormBean.myViewBookList.isbn }</td>
	</tr>
	<tr>
		<td>Edition</td>
		<td>${LoginFormBean.myViewBookList.edition }</td>
	</tr>
	<tr>
		<td>Publisher</td>
		<td>${LoginFormBean.myViewBookList.publisherName }</td>
	</tr>
	<tr>
		<td>Year</td>
		<td>${LoginFormBean.myViewBookList.year }</td>
	</tr>
	<tr>
		<td>No Of Copies</td>
		<td>${LoginFormBean.myViewBookList.noofcopies }</td>
	</tr>
	<tr>
		<td>Remark</td>
		<td>${LoginFormBean.myViewBookList.remark}</td>
	</tr>
	<tr>
		<td>Call Number</td>
		<td>${LoginFormBean.callNumberCode}</td>
	</tr>
	<tr>
		<td>Available Date</td>
		<td>${LoginFormBean.a_Date}</td>
	</tr>
	
														
	<tr>
		<td colspan="2" align="center">
			<html:submit property="btnSave" value="Save"></html:submit>
		</td>
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