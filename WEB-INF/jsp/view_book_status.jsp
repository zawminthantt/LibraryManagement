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
<p align="center">
			<font size=+1 color="black" >View Book Status Form</font>
		</p><br>
<html:form action="/viewbookstatus">
	<logic:empty property="frmRegFormControl" name="BookStatusFormBean">
		<table cellpadding="10" align="center">
			<tr>
				<td><font size="3"><b>Call Number :</b></font></td>
				<td colspan="2"><html:text property="frmRegCallNumber"></html:text></td>
				<td align="center" colspan="2"><html:submit
					property="btnSearch" value="Search"></html:submit></td>
				<td colspan="2"><font size="3"><html:errors
					property="callnumbrError"></html:errors> <html:errors
					property="callnumbrNotExit"></html:errors> </font></td>
			</tr>
		</table>
	</logic:empty>
	<logic:notEmpty property="frmRegFormControl" name="BookStatusFormBean">
		<table cellpadding="10" align="center">
			<tr>
				<td><font size="3"><b>Call Number :</b></font></td>
				<td><font size="3"><b>${BookStatusFormBean.frmCallnumber}</b></font></td>
			</tr>
			<tr>
				<td><font size="3"><b>ISBN No. :</b></font></td>
				<td><font size="3"><b>${BookStatusFormBean.frmRegISBN}</b></font></td>
			</tr>
			<tr>
				<td><font size="3"><b>Title :</b></font></td>
				<td><font size="3"><b>${BookStatusFormBean.frmRegTitle}</b></font></td>
			</tr>
			<tr>
				<td><font size="3"><b>Author :</b></font></td>
				<td><font size="3"><b>${BookStatusFormBean.frmRegAuthor}</b></font></td>
			</tr>
			<tr>
				<td><font size="3"><b>Book Status :</b></font></td>
				<td><c:choose>

					<c:when test="${BookStatusFormBean.frmLoanStatus==1}">
						<font size="3"><b>Available</b></font>
					</c:when>
					<c:when test="${BookStatusFormBean.frmReserveStatus==0}">
						<font size="3"><b>Check-Out And Reserved</b></font>
					</c:when>
					<c:when test="${BookStatusFormBean.frmLoanStatus==0}">
						<font size="3"><b>Check-Out</b></font>
					</c:when>
					<c:when test="${BookStatusFormBean.frmLoanStatus==null}">
						<font size="3"><b>Available</b></font>
					</c:when>
				</c:choose></td>	
			</tr>
			<tr>
				<td><font size="3"><b>Reserved User Name :</b></font></td>
				<c:choose>
					<c:when test="${BookStatusFormBean.frmReserveStatus==1}"></c:when>
					<c:when test="${BookStatusFormBean.frmReserveStatus==0}">
						<td><font size="3"><b>${BookStatusFormBean.frmRegReserveUserName}</b></font></td>
					</c:when>
				</c:choose>
			</tr>
			<tr>
				<td><font size="3"><b>Reserved Date:</b></font></td>
				<c:choose>
					<c:when test="${BookStatusFormBean.frmReserveStatus==1}"></c:when>
					<c:when test="${BookStatusFormBean.frmReserveStatus==0}">
						<td><font size="3"><b>${BookStatusFormBean.frmReserved}</b></font></td>
					</c:when>
				</c:choose>
			</tr>
			<tr>
				<td><font size="3"><b>Check-Out User Name :</b></font></td>
				<c:choose>
					<c:when test="${BookStatusFormBean.frmLoanStatus==1}"></c:when>
					<c:when test="${BookStatusFormBean.frmLoanStatus==0}">
						<td><font size="3"><b>${BookStatusFormBean.frmRegCheckUserName}</b></font></td>
					</c:when>
				</c:choose>
			</tr>
			<tr>
				<td><font size="3"><b>Issue Date:</b></font></td>
				<c:choose>
					<c:when test="${BookStatusFormBean.frmLoanStatus==1}">-</c:when>
					<c:when test="${BookStatusFormBean.frmLoanStatus==0}">
						<td><font size="3"><b>${BookStatusFormBean.frmIssueDate}</b></font></td>
					</c:when>
				</c:choose>
			</tr>
			
			<tr>
				<td><font size="3"><b>Due Date:</b></font></td>
					<c:choose>
					<c:when test="${BookStatusFormBean.frmLoanStatus==1}"></c:when>
					<c:when test="${BookStatusFormBean.frmLoanStatus==0}">
						<td><font size="3"><b>${BookStatusFormBean.frmDueDate}</b></font></td>
					</c:when>
				</c:choose>
			</tr>
			
			
			
			<tr>
				<td colspan="4" align="center"><html:submit property="btnNextSearch"
					value="OK"></html:submit></td>
			</tr>
		</table>
		<br>
		<br>
        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
     
<!-- End Main -->
	</logic:notEmpty>
</html:form></div>
</div>
</div>
<%@ include file="inc/admin_left_menu.jsp"%></div>
<%@ include file="inc/footer.jsp"%>
</body>
</html>