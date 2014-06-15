<%@ include file="inc/common.jsp"%>
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
<h1 class="title" align="center">Welcome&nbsp;&nbsp;&nbsp;${LoginFormBean.loginUser.userName}</h1>
<br>
<div class="table"><html:form action="/viewReservePath">

	<table>
		<tr>
			<td><html:errors property="noRecordError" /></td>
		</tr>
	</table>
	<logic:notEmpty property="frmViewBookReserveList"
		name="ViewReserveFormBean">
		<table border="1" width="100%" cellspacing=0 cellpadding=7>
			<tr bgcolor="lightblue">
				<th>CallNumber</th>
				<th>Title</th>
				<th>Author</th>
				<th>ISBN</th>
				<th>Reserved Date</th>
				<th>Due Date</th>
				<th>Status</th>
				<th></th>
			</tr>

			<c:forEach var="i" begin="${ViewReserveFormBean.begin}"
				end="${ViewReserveFormBean.end}" step="1">
				<tr>
					<td>${ViewReserveFormBean.frmViewBookReserveList[i-1].callNumberCode}</td>
					<td>${ViewReserveFormBean.frmViewBookReserveList[i-1].title}</td>
					<td>${ViewReserveFormBean.frmViewBookReserveList[i-1].authorName}</td>
					<td>${ViewReserveFormBean.frmViewBookReserveList[i-1].isbn}</td>
					<td>${ViewReserveFormBean.frmViewBookReserveList[i-1].reserveDate}</td>
					<td>${ViewReserveFormBean.frmViewBookReserveList[i-1].dueDate}</td>
					<td><c:if
						test="${ViewReserveFormBean.frmViewBookReserveList[i-1].reserveStatus==0}">Reserved</c:if>
					<c:if
						test="${ViewReserveFormBean.frmViewBookReserveList[i-1].reserveStatus==1}">Canceled</c:if>
					</td>
					<td><c:if
						test="${ViewReserveFormBean.frmViewBookReserveList[i-1].reserveStatus==0}">
						<a
							href="cancelReservePath.do?frmCancelReserveId=${ViewReserveFormBean.frmViewBookReserveList[i-1].id} ${ViewReserveFormBean.frmViewBookReserveList[i-1].callNumberId}&frmControl=2">
						ReserveCancel </a>
					</c:if></td>
				</tr>
			</c:forEach>

		</table>
		<table align="center">
			<tr>
				<td>
				<div align="center"><c:if
					test="${ViewReserveFormBean.prevBtn}">&lt;&lt;
		<html:submit property="prev" value="Prev">
					</html:submit>
				</c:if></div>
				</td>
				<td>
				<div align="center"><c:if
					test="${ViewReserveFormBean.nextBtn}">
					<html:submit property="next" value="Next">
					</html:submit>&gt;&gt;
</c:if></div>
				</td>
			</tr>
		</table>
		<html:hidden property="actualPage" name="ViewReserveFormBean" />
		<html:hidden property="frmControl" name="ViewReserveFormBean"
			value="1" />


	</logic:notEmpty>


	<!-- to carry the actual page -->

</html:form></div>
</div>
</div>
<%@ include file="inc/left_menu.jsp"%></div>
<%@ include file="inc/footer.jsp"%>
</body>
</html>
