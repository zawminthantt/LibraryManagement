<%@ include file="./inc/common.jsp"%>
<%@ include file="inc/calendar.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link href="css/style.css" rel="stylesheet" type="text/css" media="all">

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Library Management System</title>
</head>
<body>
<%@ include file="inc/admin_header.jsp"%>

<!-- Start of actual page -->
<div id="page">
<div id="content">
<div class="news">
<h1 class="title" align="center">Welcome
${adminLoginFormBean.loginAdmin.name}</h1>
<br>

<div class="table">
<p align="center">
			<font size=+1 color="black" >Recall By Email Form</font>
		</p><br>
	<html:form action="/adminrecall" method="POST">


	<table align="center" cellspacing="0" cellpadding="0" border="0">
		<tbody>
			<tr>
				<td>Due Date:</td>
				<td><input type="text" id="calendar" name="date" maxlength="10"
					size="13" readonly="false" value="" /><img
					src="images/calendar.gif" id="trigger" size="13"
					style="cursor: pointer; border: 1px solid red;" title="calendar"
					onmouseover="this.style.background='red';"
					onmouseout="this.style.background=''" /><font face="Verdana"
					size="2" color="blue">&nbsp;YYY/MM/DD</font><html:errors property="nowritetitle" /><script
					type="text/javascript">
	//         
	Calendar.setup({
		date : 1,
		electric : false,
		singleClick : true,
		inputField : "calendar",
		button : "trigger",
		ifFormat : "%Y-%m-%d",
		daFormat : "%Y-%m-%d"
	});
	//
</script></td>

				<td><html:submit property="btnSearch" value="Search"></html:submit>
				</td>
			</tr>
		</tbody>
	</table>

	<logic:notEmpty name="clean">
		<hr />
		<logic:empty name="rlist">
				There is no record for your search...
				</logic:empty>
		
		<br>
		<logic:notEmpty name="rlist">
			<html:errors property="noselectedItem" />

			<html:submit property="btnSend" value="send mail"></html:submit>
			<br>
			<table width="90%" cellspacing="0" cellpadding="0" border="1"
				class="adminlist">
				<tr bgcolor="lightblue">
					<th>User Name</th>
					<th>User Id</th>
					<th>Title</th>
					<th>ISBN</th>
					<th>Due Date</th>
					<th>Email</th>
					<th>Grade</th>
					<th>Previously Sent</th>
					<th>send mail</th>
				</tr>
				<logic:iterate id="recalldata" name="rlist">
					<tr>
					<td valign="top"><bean:write name="recalldata"
							property="username" />&nbsp;</td>
						<td valign="top"><bean:write name="recalldata"
							property="userId" />&nbsp;</td>
						<td valign="top"><bean:write name="recalldata"
							property="title" />&nbsp;</td>
						<td valign="top"><bean:write name="recalldata"
							property="ISBN" />&nbsp;</td>
						<td valign="top"><bean:write name="recalldata"
							property="dueDate" />&nbsp;</td>
						<td valign="top"><bean:write name="recalldata"
							property="email" />&nbsp;</td>
							<td><bean:write name="recalldata" property="userType" /></td>
                        <td nowrap><bean:write name="recalldata" property="sendDate" /></td>
							
						<td valign="top"><html:multibox property="selectedItems"
							value="${recalldata.email} ${recalldata.userId} ${recalldata.bookloanId}">
						</html:multibox></td>

					</tr>
				</logic:iterate>
				
				<tr>
					<td colspan="8"></td>
				</tr>

			</table>
			<br>
		</logic:notEmpty>
	</logic:notEmpty>



</html:form>
</div>
</div>
</div>
<%@ include file="inc/admin_left_menu.jsp"%></div>
<%@ include file="inc/footer.jsp"%>
</body>
</html>