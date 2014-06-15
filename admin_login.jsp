<%@ include file="/WEB-INF/jsp/inc/common.jsp"%>
<html>
<head>
<title>Online Library Management System</title>
<link href="css/style.css" rel="stylesheet" type="text/css"
	media="screen" />
</head>
<body>
	<!-- Start of top navigation/header -->
	<div id="header">
		<div id="menu">
			<ul>
			</ul>
		</div>
	</div>
	<!-- End of top navigation/header -->
	<!-- Start of logo -->
	<div id="logo">
		<h1>
			<a href="#"><em>Library</em><font color=black>Management
					System</font>
			</a>
		</h1>
		<h2>
			<font color=olive>By Team 4</font>
		</h2>
	</div>
	<!-- End of logo -->
	<hr />
	<!-- Start of actual page -->
	<div id="page">

		<p align="center">
			<font size=+2 color="black" face="Segoe Script">Login Page</font>
		</p><br>


		<html:form action="/adminLoginPath">

			<table align="center">

				<tr>
					<td><font size="3" color="black">Login Name:</font>
					</td>
					<td><html:text property="frmLoginName" size="20px"></html:text>
						<font color="red">***</font>
					</td>
					<td><html:errors property="frmLoginName" />
					</td>
				<tr>
					<td><font size="3" color="black">Password:</font>
					</td>
					<td><html:password property="frmPassword">
						</html:password> <font color="red">***</font>
					</td>
					<td><html:errors property="frmPassword" />
					</td>
				</tr>
				<tr>
					<td colspan="2" align="center"><html:submit
							property="btnLogin" value="Login">
						</html:submit>
					</td>
				</tr>
			</table>
			<table align="center">
				<tr>
					<td><html:errors property="loginerror" />
					</td>
				</tr>
			</table>

		</html:form>

		<br> <br>

	</div>
	<div style="clear: both;">&nbsp;</div>
	<!-- End of actual page -->
	<hr>
	<!-- Start of footer -->
	<div id="footer"><%@ include file="/WEB-INF/jsp/inc/footer.jsp"%>
	</div>
	<!-- End of footer -->
</html>


