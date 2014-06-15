<%@ include file="inc/common.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head><%@ include file="calendar.jsp"%>
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
<p align="center"><font size=+1 color="black">Reservation
Status Form</font></p>
<br>
<html:form action="/adminViewReservationPath">
	<table align="center">
		<tr>
			<td><font size="4" color="black">From</font></td>
			<td><html:text property="fromDate" styleId="calendar"
				maxlength="10" size="15" readonly="true" /> <html:image
				src="images/calendar.gif" styleId="trigger"
				style="cursor: pointer; border: 1px solid red;"
				title="Date selector" onmouseover="this.style.background='red';"
				onmouseout="this.style.background=''"></html:image> <script
				type="text/javascript">
	//         
	Calendar.setup({
		firstDay : 1,
		electric : false,
		singleClick : true,
		inputField : "calendar",
		button : "trigger",
		ifFormat : "%Y-%m-%d",
		daFormat : "%Y-%m-%d"
	});
	//
</script></td>

			<td><font size="4" color="black">To</font></td>
			<td><html:text property="toDate" styleId="calendar1"
				maxlength="10" size="15" readonly="true" /> <html:image
				src="images/calendar.gif" styleId="trigger1"
				style="cursor: pointer; border: 1px solid red;"
				title="Date selector" onmouseover="this.style.background='red';"
				onmouseout="this.style.background=''"></html:image> <script
				type="text/javascript">
	//         
	Calendar.setup({
		firstDay : 1,
		electric : false,
		singleClick : true,
		inputField : "calendar1",
		button : "trigger1",
		ifFormat : "%Y-%m-%d",
		daFormat : "%Y-%m-%d"
	});
	//
</script></td>
			<td align="center"><html:submit property="btnSearch"
				value="Search"></html:submit></td>

		</tr>
		<tr>
			<td colspan="5" align="center"><html:errors property="dateerror" /></td>
		</tr>
	</table>

	<table align="center">
		<tr>
			<td><font size="3" color="blue">Reservation List between
			&nbsp;&nbsp;"<blink>${AdminViewReserveFormBean.fromDate}</blink>" </font></td>
			<td><font size="3" color="blue">&nbsp;&nbsp;and&nbsp;
			&nbsp;"<blink>${AdminViewReserveFormBean.toDate}</blink>"&nbsp;&nbsp;are
			shown Below.</font></td>
		</tr>
	</table>
	<br>
	<p align="center"><logic:empty
		property="frmAdminViewBookReserveList" name="AdminViewReserveFormBean">
		<font size="4" color="black">No record!!</font>
	</logic:empty></p>

	<logic:notEmpty property="frmAdminViewBookReserveList"
		name="AdminViewReserveFormBean">
		<table border="1" width="100%" height="150px" cellspacing=0
			cellpadding=7>
			<tr bgcolor="lightblue">
				<th>Name</th>
				<th>Member Type</th>
				<th>Title</th>
				<th>Author</th>
				<th>Call Number</th>
				<th>Reserve Date</th>
				<th>Available Date</th>
				<th>Cancel</th>
			</tr>

			<c:forEach var="vrb" begin="${AdminViewReserveFormBean.begin}"
				end="${AdminViewReserveFormBean.end}" step="1">
				<tr>
					<td>${AdminViewReserveFormBean.frmAdminViewBookReserveList[vrb-1].userName}</td>
					<td>${AdminViewReserveFormBean.frmAdminViewBookReserveList[vrb-1].userType}</td>
					<td>${AdminViewReserveFormBean.frmAdminViewBookReserveList[vrb-1].title}</td>
					<td>${AdminViewReserveFormBean.frmAdminViewBookReserveList[vrb-1].authorName}</td>
					<td>${AdminViewReserveFormBean.frmAdminViewBookReserveList[vrb-1].callNumberCode}</td>
					<td>${AdminViewReserveFormBean.frmAdminViewBookReserveList[vrb-1].reserveDate}</td>
					<td>${AdminViewReserveFormBean.frmAdminViewBookReserveList[vrb-1].availableDate}</td>
					<td><c:if
						test="${AdminViewReserveFormBean.frmAdminViewBookReserveList[vrb-1].reserveStatus==0}">
						<html:multibox property="selectedItem"
							value="${AdminViewReserveFormBean.frmAdminViewBookReserveList[vrb-1].id} ${AdminViewReserveFormBean.frmAdminViewBookReserveList[vrb-1].callNumberId} ${AdminViewReserveFormBean.frmAdminViewBookReserveList[vrb-1].email}"
							name="AdminViewReserveFormBean">
						</html:multibox>
					</c:if></td>

				</tr>
			</c:forEach>

		</table>
		<table align="center">
			<tr>
				<td><html:errors property="noselectedItem" /></td>
			</tr>
		</table>
		<table align="right">
			<tr align="center">
				<td><html:submit property="btnDelete"
					value="Reservation Cancel"></html:submit></td>
			</tr>
		</table>
		<table align="center">
			<tr>
				<td>
				<div align="center"><c:if
					test="${AdminViewReserveFormBean.prevBtn}">&lt;&lt;
<html:submit property="prev" value="Previous">
					</html:submit>
				</c:if></div>
				</td>
				<td>
				<div align="center"><c:if
					test="${AdminViewReserveFormBean.nextBtn}">
					<html:submit property="next" value="Next">
					</html:submit>&gt;&gt;
</c:if></div>
				</td>
			</tr>
		</table>

		<html:hidden property="actualPage" name="AdminViewReserveFormBean" />
		<html:hidden property="frmControl" name="AdminViewReserveFormBean"
			value="1" />

	</logic:notEmpty>

</html:form></div>
</div>
</div>
<%@ include file="inc/admin_left_menu.jsp"%></div>
<%@ include file="inc/footer.jsp"%>
</body>
</html>
