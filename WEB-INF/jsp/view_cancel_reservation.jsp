<%@ include file="inc/common.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link href="../css/style.css" rel="stylesheet" type="text/css"
	media="all">

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Library Management System</title>
</head>
<body>
<%@ include file="inc/header.jsp"%>

<!-- Start of actual page -->
<div id="page">
<div id="content">
<div class="news">
<h1 class="title" align="center">Welcome</h1>
<br>

<div class="table">
<table align="center" width="100%" height="auto">

	<tr>
		<%@ include file="inc/left_menu.jsp"%>

		<td><html:form action="/viewReservePath">
			<logic:notEmpty property="frmBookReserveList"
				name="ViewReserveFormBean">
				<tr>
					<td>
					<table border="1" width="100%" cellspacing=0 cellpadding=7>
						<tr>
							<th>CallNumber</th>
							<th>Title</th>
							<th>Author</th>
							<th>ISBN</th>
							<th>Reserved Date</th>
							<th>Due Date</th>
							<th>Status</th>
							<th>Cancel</th>
						</tr>
						<c:forEach var="i" begin="${ViewReserveFormBean.begin}"
							end="${ViewReserveFormBean.end}" step="1">
							<tr>
								<td>${i}</td>
								<td>${ViewReserveFormBean.frmBookReserveList[i-1].callNumber}</td>
								<td>${ViewReserveFormBean.frmBookReserveList[i-1].title}</td>
								<td>${ViewReserveFormBean.frmBookReserveList[i-1].authorName}</td>
								<td>${ViewReserveFormBean.frmBookReserveList[i-1].isbn}</td>
								<td>${ViewReserveFormBean.frmBookReserveList[i-1].reserveDate}</td>
								<td>${ViewReserveFormBean.frmBookReserveList[i-1].dueDate}</td>
								<td>${ViewReserveFormBean.frmBookReserveList[i-1].status}</td>
								<td><a
									href="cancelReservePath.do?frmBookReserveListId=${ViewReserveFormBean.frmBookReserveList[i-1].id}&frmControl=1">Cancel
								</a></td>
							</tr>
						</c:forEach>
					</table>
					</td>
				<tr>
			</logic:notEmpty>
		</html:form>
	</tr>
</table>


</div>
</div>
</div>
<%@ include file="inc/left_menu.jsp"%></div>
<%@ include file="inc/footer.jsp"%>
</body>
</html>