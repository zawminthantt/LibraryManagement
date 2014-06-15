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
<p align="center"><font size=+1 color="black">View
Rent History Form</font></p>
<br>
	<html:form action="/viewPath">
	<html:errors property="norecordError"></html:errors>
		<logic:notEmpty property="myViewRentedHistory"
			name="ViewRentFormBean">
			<table align="center" border="1">
				<tr>
					<td bgcolor="lightblue"><font color="black">Call Number</font></td>
					<td bgcolor="lightblue"><font color="black">Title</font></td>
					<td bgcolor="lightblue"><font color="black">Author</font></td>
					<td bgcolor="lightblue"><font color="black">Issue Date</font></td>
					<td bgcolor="lightblue"><font color="black">Due Date</font></td>
					<td bgcolor="lightblue"><font color="black">Return Date</font></td>
					<td bgcolor="lightblue"><font color="black">Late Fees</font></td>
				</tr>
				<c:forEach var="i" begin="${ViewRentFormBean.begin }" end="${ViewRentFormBean.end }" step="1">
					<tr>
						<td>${ViewRentFormBean.myViewRentedHistory[i-1].callNumber}</td>
						<td>${ViewRentFormBean.myViewRentedHistory[i-1].title}</td>
						<td>${ViewRentFormBean.myViewRentedHistory[i-1].authorName}</td>
						<td>${ViewRentFormBean.myViewRentedHistory[i-1].issueDate}</td>
						<td>${ViewRentFormBean.myViewRentedHistory[i-1].dueDate}</td>
						<td>${ViewRentFormBean.myViewRentedHistory[i-1].returnDate}</td>
						<td>${ViewRentFormBean.myViewRentedHistory[i-1].lateFees}</td>
						<td><c:if test="${ViewRentFormBean.myViewRentedHistory[i-1].returnDate==null}">
								<a href=renewPath.do?>Renew</a>
							</c:if>
							
					</tr>
				</c:forEach>
			</table>
			<html:errors property="renewError"></html:errors>
			<html:errors property="renewoverError"></html:errors>
			<html:errors property="overdueError"></html:errors>
			<table align="center">
							<tr>
							<td>
							<div align="center">
							<c:if test="${ViewRentFormBean.prevBtn}">&lt;&lt;
		<html:submit property="prev" value="Prev">
		</html:submit>
							</c:if>
					</div></td>
							<td>
							<div align="center">
							<c:if test="${ViewRentFormBean.nextBtn}">
		<html:submit property="next" value="Next">
						</html:submit>&gt;&gt;
</c:if>
							</div></td>
							</tr>
							</table>
							<html:hidden property="actualPage" name="ViewRentFormBean" />
									<html:hidden property="frmControl" name="ViewRentFormBean"
										value="1" />
							
		</logic:notEmpty>
</html:form>
</div>
</div>
</div>
<%@ include file="inc/left_menu.jsp"%></div>
<%@ include file="inc/footer.jsp"%>
</body>
</html>