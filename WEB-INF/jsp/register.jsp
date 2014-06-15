<%@ include file="inc/common.jsp"%>
<html>
<head>
<title>Library Management System</title>
<link href="css/style.css" rel="stylesheet" type="text/css"
	media="screen" />
</head>
<body>
<!-- Start of top navigation/header -->
<div id="header">
<div id="menu"><ul><!--
	<li class="current_page_item"><a href="logoutPath.do">Home</a></li>
--></ul>

</div>
</div>
<!-- End of top navigation/header -->


<!-- Start of logo -->
<div id="logo">
<h1><a href="#"><em>Library</em><font color=black>Management
System</font></a></h1>
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
<h3 align="center">Registration Page</h3>
<hr>
<html:form action="/registerPath">
	<logic:empty property="frmRegFormControl" name="RegFormBean">
		<table align="center">
			<tr>
				<td>Name:</td>
				<td><html:text property="frmRegName"></html:text> <font
					color="red">***</font></td>
				<td><html:errors property="frmRegName" /></td>
			</tr>
			<tr>
				<td>Login Name:</td>
				<td><html:text property="frmRegLoginName"></html:text> <font
					color="red">***</font><html:errors property="frmRegLoginName"></html:errors></td>
				<td><html:errors property="accountError" /></td>
				<td><html:errors property="registerError" /></td>
				<td><html:errors property="expiredError"/>
				</td>
			</tr>
			<tr>
				<td>Password:</td>
				<td><html:password property="frmRegPassword"></html:password> <font
					color="red">***</font></td>
				<td><html:errors property="frmRegPassword" /></td>
			</tr>
			<tr>
				<td>Confirm Password:</td>
				<td><html:password property="frmRegConfPassword">
				</html:password> <font color="red">***</font></td>
				<td><html:errors property="frmRegConfPassword" /> <html:errors
					property="passwordError" /></td>
			</tr>
			<tr>

				<td>Gender:</td>
				<td><html:radio property="frmRegGender" value="male">Male</html:radio>
				<html:radio property="frmRegGender" value="female">Female</html:radio>
				</td>
			</tr>

			<tr>
				<td>Email:</td>
				<td><html:text property="frmRegEmail"></html:text> <font
					color="red">***</font></td>
				<td><html:errors property="frmRegEmail" /></td>
			</tr>
			<tr>
				<td>User Type:</td>
				<td><html:select property="frmRegUserTypeId">
					<html:option value="0">SELECT</html:option>
					<html:optionsCollection property="frmRegUserTypeList" value="id"
						label="userTypeName" />
				</html:select></td>
				<td><html:errors property="usertypeError" />
				<html:errors property="userTypeError" />
				</td>
			</tr>

			<tr>
				<td>NRC number:</td>
				<td><html:text property="frmRegNRC"></html:text>eg.12/LaMaNa(N)123456<font
					color="red">***</font></td>
				<td><html:errors property="frmRegNRC" /></td>
			</tr>
			<tr>
				<td>Phone:</td>
				<td><html:text property="frmRegPhone"></html:text><font
					color="red">***</font></td>
				<td><html:errors property="frmRegPhone" /></td>
				
			</tr>
			<tr>
				<td>Address:</td>
				<td><html:text property="frmRegAddress" maxlength="100" size="30">
				</html:text><font color="red">***</font></td>
				<td><html:errors property="frmRegAddress" /></td>
			</tr>
			<tr>
				<td colspan="2" align="center"><html:submit
					property="btnRegister" value="Register">
				</html:submit> <html:reset property="btnRegisterCancel" value="Cancel">
				</html:reset></td>
			</tr>

		</table>
	</logic:empty>
	<!-- Confirmation portion here -->
	<logic:notEmpty property="frmRegFormControl" name="RegFormBean">
		<table align="center">
			<tr>
				<td>Name:</td>
				<td><html:text property="frmRegName" disabled="true"></html:text> 
				
			</tr>
			<tr>
				<td>Login Name:</td>
				<td><html:text property="frmRegLoginName" disabled="true"></html:text>
				</td>
			</tr>
			<tr>
				<td>Password:</td>
				<td><html:password property="frmRegPassword" disabled="true"></html:password>
				    </td>
				<td><html:errors property="frmRegPassword" /></td>
			</tr>
			<tr>
				<td>Confirm Password:</td>
				<td><html:password property="frmRegConfPassword"
					disabled="true">
				</html:password> </td>
				
			</tr>
			<tr>
				<td>Gender:</td>
				<td><html:text property="frmRegGender" disabled="true"></html:text>
				</td>
			</tr>

			<tr>
				<td>Email:</td>
				<td><html:text property="frmRegEmail" disabled="true"></html:text>
				</td>
			</tr>
			<tr>
				<td>User Type:</td>
				<td><html:text property="frmRegUserTypeName" disabled="true"></html:text>
				</td>
			</tr>

			<tr>
				<td>NRC number:</td>
				<td><html:text property="frmRegNRC" disabled="true"></html:text></td>
				

			</tr>
			<tr>
				<td>Phone:</td>
				<td><html:text property="frmRegPhone" disabled="true"></html:text></td>
			</tr>
			<tr>
				<td>Address:</td>
				<td><html:text property="frmRegAddress" disabled="true" maxlength="100" size="30"></html:text>
				
			</tr>
			<tr>
				<td colspan="2" align="center"><html:submit property="btnSave"
					value="Save">
				</html:submit> <html:submit property="btnSaveCancel" value="Cancel">
				</html:submit></td>
			</tr>
			
		</table>
	</logic:notEmpty>
</html:form></div>
</div>
</div>
</div>
<div id="right" class="right"><br>
<br>
<br>
<br>
<br>
<table>
	<tr>
		<td><img src="images/Book-Shelf.gif" width="250" size="300"></img></td>
	</tr>
</table>
</div>
<div style="clear: both;">&nbsp;</div>
</div>
<!-- End of actual page -->

<hr>
<!-- Start of footer -->

<div id="footer"><%@ include file="inc/footer.jsp"%>
</div>
<!-- End of footer -->
</html>