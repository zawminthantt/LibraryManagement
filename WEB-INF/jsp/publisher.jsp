<%@ include file="inc/common.jsp"%>
<%@ include file="inc/calendar.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link href="css/style.css" rel="stylesheet" type="text/css" media="all">

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Library Management System</title>
</head>
<body onload="DWRUtil.useLoadingMessage(); createAutoCompleter()">
<%@ include file="inc/admin_header.jsp"%>

<!-- Start of actual page -->
<div id="page">
<div id="content">
<div class="news">
<h1 class="title" align="center">Welcome
${adminLoginFormBean.loginAdmin.name}</h1>
<br>

<div class="table">
<p >
			<font size=+1 color="black">&nbsp; &nbsp; &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Publisher Registration Form</font>
		</p><br>
<table width="100%">
	<tr>

		<td><html:form action="/adminPublisherPath" method="POST">
			<logic:empty property="frmRegFormControl"
				name="adminRegisterFormBean">

				<table border="0">
					<tbody align="center">



						<tr>
							<td align="right">Publisher Name:</td>
							<td><html:text property="publisherName" maxlength="100"
								size="30"></html:text> <font color="red">***</font></td>
							<td><html:errors property="PubError" /></td>

						</tr>


						<tr>
							<td align="right">Publisher's Address' :</td>
							<td><html:text property="frmPubAddress" maxlength="50"
								size="30"></html:text> <font color="red">***</font></td>
							<td><html:errors property="PubAddressError" /></td>
						</tr>
						<tr>
							<td colspan=2 align="center"><html:submit
								property="btnRegister" value="Register">
							</html:submit> <html:reset property="btnRegisterCancel" value="Cancel">
							</html:reset></td>

						</tr>

					</tbody>
				</table>
			</logic:empty>

			<logic:notEmpty property="frmRegFormControl"
				name="adminRegisterFormBean">
				<table border="0">
					<tbody align="center">

						<tr>
							<td align="right">Publisher name:</td>
							<td><html:text property="publisherName" disabled="true"
								maxlength="100" size="30"></html:text></td>
								

						</tr>


						<tr>
							<td align="right">Publisher's Address:</td>
							<td><html:text property="frmPubAddress" disabled="true"
								maxlength="100" size="30"></html:text></td>
								
						</tr>


						<tr>
							<td colspan=2 align="center">
							<html:submit property="btnSave" value="Save"></html:submit>
							<html:submit property="btnSaveCancel" value="Cancel"></html:submit></td>
						</tr>
					</tbody>
				</table>
			</logic:notEmpty>

		</html:form></td>
	</tr>

</table>
</div>
</div>
</div>
<%@ include file="inc/admin_left_menu.jsp"%></div>
<%@ include file="inc/footer.jsp"%>
</body>
</html>