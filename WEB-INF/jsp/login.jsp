<%@ include file="inc/common.jsp"%>
<html>
<head>
<title>Library Management System</title>
<link href="css/style.css" rel="stylesheet" type="text/css"
	media="screen" />
</head>
<body>

<!-- Start of logo -->
<div id="logo">
<h1><a href="#"><em>Library</em><font color=black>Management
System</font> </a></h1>
<h2><font color=olive>By Team 4</font></h2>
</div>
<!-- End of logo -->

<hr />

<!-- Start of actual page -->
<div id="page">
<div id="content">
<div class="news">
<div class="entry">
<div class="table">
<table align="center">
	<tr>
		<td><%@ include file="book_search_000.jsp"%></td>
	</tr>
	<tr height="40px"></tr>
	<tr>
		<td align="center"><img src="images/searchbook.jpg"></img></td>
	</tr>
</table>
</div>
</div>
</div>
</div>

<div id="right" class="right">
<ul>
	<li>
	<h2 align="center"><a href="http://www.ictti.site/">ICTTI</a></h2>
	</li>
	<html:form action="/loginPath">
		<li>
		<table width="230px">

			<tr height="10px">
				<td align="right">Login Name:</td>
				<td><html:text property="frmLoginName" size="15"></html:text></td>
				<td><font color="red">***</font></td>
			</tr>
			<tr>
				<td colspan="3"><html:errors property="frmLoginName" /></td>
			</tr>

			<tr>
				<td align="right">Password:</td>
				<td><html:password property="frmPassword" size="15">
				</html:password></td>
				<td><font color="red">***</font></td>
			</tr>
			<tr>
				<td colspan="3"><html:errors property="frmPassword" /></td>
			</tr>
			<tr>
				<td colspan="3"><html:errors property="loginerror" /></td>
			</tr>
			<tr>
				<td colspan="2" align="center"><html:submit property="btnLogin"
					value="Login">
				</html:submit></td>
			</tr>
		</table>
		</li>
	</html:form>
	<li>
	<table width="230px">
		<tr>
			<td><font size="3" color="black">Are you new User?Please
			</font><a href="registerPathFirst.do"><font color="blue"
				face="Segoe Script" size="4">Registration</font> </a></td>
		</tr>
	</table>
	<br>
	<br>
	</li>
</ul>
<!-- <table width="230px">
				<tr>
					<td><img src="images/Book-Shelf.gif" width="230px"></img>
					</td>
				</tr>
			</table> --></div>

<%@ include file="inc/footer.jsp"%></div>
<!-- End of footer -->
</html>

