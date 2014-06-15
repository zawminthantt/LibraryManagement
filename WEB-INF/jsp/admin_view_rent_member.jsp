<%@ include file="./inc/common.jsp"%>
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
<p align="center"><font size=+1 color="black">Most Rent User Form</font></p>
<br>
<html:form action="/adminViewRentMemberPath">
	<table align="center">
		<tr>
			<td>Member Type</td>
			<td><html:select property="frmUserTypeId">
				<html:option value="0">SELECT</html:option>
				<html:optionsCollection property="frmUserTypeList"
					value="userTypeName" label="userTypeName" />
			</html:select></td>
			<td colspan="2" align="center"><html:submit property="btnSearch"
				value="Search">
			</html:submit></td>
		</tr>
	</table>
	<table>
		<tr>
			<td><html:errors property="usertypeError" /></td>
		</tr>
	</table>
	<table align="center">
		<tr>
			<td><html:errors property="searchMemberError" /></td>
		</tr>
	</table>
	<logic:notEmpty name="AdminViewMemberFormBean"
		property="frmViewRentMemberList">
		<table border="1" width="100%" height="150px" cellspacing=0
			cellpadding=7>
			<tr bgcolor="lightblue">
				<th>Member Name:</th>
				<th>Email</th>
				<th>Rent Count</th>

			</tr>
			<c:forEach var="i" begin="${AdminViewMemberFormBean.begin}"
				end="${AdminViewMemberFormBean.end}" step="1">
				<tr align="center">
					<td>${AdminViewMemberFormBean.frmViewRentMemberList[i-1].userName}</td>
					<td>${AdminViewMemberFormBean.frmViewRentMemberList[i-1].userEmail}</td>
					<td>${AdminViewMemberFormBean.frmViewRentMemberList[i-1].rentCount}</td>
				</tr>
			</c:forEach>

		</table>
		<table align="center">
			<tr>
				<td>
				<div align="center"><c:if
					test="${AdminViewMemberFormBean.prevBtn}">&lt;&lt;
													<html:submit property="prev" value="Prev">
					</html:submit>
				</c:if></div>
				</td>
				<td>
				<div align="center"><c:if
					test="${AdminViewMemberFormBean.nextBtn}">
					<html:submit property="next" value="Next">
					</html:submit>&gt;&gt;
				</c:if></div>
				</td>
			</tr>
		</table>
	</logic:notEmpty>

</html:form></div>
</div>
</div>
<%@ include file="inc/admin_left_menu.jsp"%></div>
<%@ include file="inc/footer.jsp"%>
</body>
</html>
