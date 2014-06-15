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
			<font size=+1 color="black" >Update Profile Form</font>
		</p><br>

<html:form action="/updatePath">
	<logic:empty property="frmRegFormControl" name="UpdateProfileFormBean">
		<table align="center">
			<tr>
				<td>Name:</td>
				<td><html:text property="frmRegName" disabled="true"></html:text></td>
			</tr>
			<tr>
				<td>Login Name:</td>
				<td><html:text property="frmRegLoginName" disabled="true"></html:text></td>
			</tr>

			<tr>
				<td>Password:</td>
				<td><html:password property="frmRegPassword">
				</html:password> <font color="red">***</font></td>
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
				<td><html:text property="frmRegGender" disabled="true"></html:text></td>
			</tr>
			<tr>
				<td>Email:</td>
				<td><html:text property="frmRegEmail"></html:text> <font
					color="red">***</font></td>
				<td><html:errors property="frmRegEmail" /></td>
			</tr>
			<tr>
				<td>NRC number:</td>
				<td><html:text property="frmRegNRC" disabled="true"></html:text></td>
			</tr>

			<tr>
				<td>Phone:</td>
				<td><html:text property="frmRegPhone">
				</html:text></td>
			</tr>
			<tr>
				<td>Address:</td>
				<td><html:textarea property="frmRegAddress"></html:textarea> <font
					color="red">***</font></td>
				<td><html:errors property="frmRegAddress" /></td>

			</tr>
			<tr>
				<td colspan="2" align="center"><html:submit
					property="btnUpdate" value="Update">
				</html:submit> <html:submit property="btnUpdateCancel" value="Cancel">
				</html:submit></td>
			</tr>
		</table>
	</logic:empty>
	<!-- Confirmation -->
	<logic:notEmpty property="frmRegFormControl"
		name="UpdateProfileFormBean">
		<table align="center">
			<tr>
				<td>Name:</td>
				<td><html:text property="frmRegName" disabled="true"></html:text>
				</td>
			</tr>
			<tr>
				<td>Login Name:</td>
				<td><html:text property="frmRegLoginName" disabled="true"></html:text></td>
			</tr>

			<tr>
				<td>Password:</td>
				<td><html:password property="frmRegPassword">
				</html:password> <html:errors property="frmRegPassword" /></td>
			</tr>
			<tr>
				<td>Confirm Password:</td>
				<td><html:password property="frmRegConfPassword">
				</html:password><html:errors property="frmRegConfPassword" /> <html:errors
					property="passwordError" /></td>
			</tr>
			<tr>
				<td>Gender:</td>
				<td><html:text property="frmRegGender" disabled="true"></html:text></td>
			</tr>
			<tr>
				<td>Email:</td>
				<td><html:text property="frmRegEmail"></html:text> <html:errors
					property="frmRegEmail" /></td>
			</tr>


			<tr>
				<td>NRC number:</td>
				<td><html:text property="frmRegNRC" disabled="true"></html:text></td>
			</tr>

			<tr>
				<td>Phone:</td>
				<td><html:text property="frmRegPhone">
				</html:text></td>
			</tr>
			<tr>
				<td>Address:</td>
				<td><html:textarea property="frmRegAddress">
				</html:textarea></td>
			</tr>
			<tr>
				<td colspan="2" align="center"><html:submit property="btnSave"
					value="Save">
				</html:submit> <html:submit property="btnSaveCancel" value="Cancel">
				</html:submit></td>
			</tr>
		</table>
	</logic:notEmpty>
</html:form>

</div>
</div>
</div>
<%@ include file="inc/left_menu.jsp"%></div>
<%@ include file="inc/footer.jsp"%>
</body>
</html>