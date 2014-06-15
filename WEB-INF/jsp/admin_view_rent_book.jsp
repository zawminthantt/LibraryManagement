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
<p align="center"><font size=+1 color="black">Most Rent Book Form</font></p>
<br>
<html:form action="/adminViewRentBookPath">
	<table align="center">
		<tr>
			<td>Category</td>
			<td><html:select property="frmCategoryId">
				<html:optionsCollection property="frmCategoryList"
					value="categoryName" label="categoryName" />
			</html:select></td>
			<td colspan="2" align="center"><html:submit property="btnSearch"
				value="Search">
			</html:submit></td>
		</tr>
	</table>

	<table>
		<tr>
			<td><html:errors property="searchBookError" /></td>
		</tr>
	</table>
	<logic:notEmpty name="AdminViewBookFormBean"
		property="frmViewRentBookList">
		<table border="1" width="100%" height="150px" cellspacing=0
			cellpadding=7>
			<tr bgcolor="lightblue">
				<th>Title</th>
				<th>ISBN</th>
				<th>Category Name</th>
				<th>Sub Category Name</th>
				<th>Author Name</th>
				<th>Publisher Name</th>
				<th>Publisher Date</th>
				<th>Register Date</th>
				<th>Rented Times</th>

			</tr>
			<c:forEach var="i" begin="${AdminViewBookFormBean.begin}"
				end="${AdminViewBookFormBean.end}" step="1">
				<tr align="center">
					<td>${AdminViewBookFormBean.frmViewRentBookList[i-1].title}</td>
					<td>${AdminViewBookFormBean.frmViewRentBookList[i-1].isbn}</td>
					<td>${AdminViewBookFormBean.frmViewRentBookList[i-1].categoryName}</td>
					<td>${AdminViewBookFormBean.frmViewRentBookList[i-1].subCategoryName}</td>
					<td>${AdminViewBookFormBean.frmViewRentBookList[i-1].authorName}</td>
					<td>${AdminViewBookFormBean.frmViewRentBookList[i-1].publisherName}</td>
					<td>${AdminViewBookFormBean.frmViewRentBookList[i-1].pubDate}</td>
					<td>${AdminViewBookFormBean.frmViewRentBookList[i-1].registerDate}</td>
					<td>${AdminViewBookFormBean.frmViewRentBookList[i-1].rentTimes}</td>
				</tr>
			</c:forEach>

		</table>
		<%-- <table align="right">
								<tr align="center">
									<td><html:submit property="btnOK" value="OK"></html:submit>
									</td>
								</tr>
							</table> --%>
		<table align="center">
			<tr>
				<td>
				<div align="center"><c:if
					test="${AdminViewBookFormBean.prevBtn}">&lt;&lt;
													<html:submit property="prev" value="Prev">
					</html:submit>
				</c:if></div>
				</td>
				<td>
				<div align="center"><c:if
					test="${AdminViewBookFormBean.nextBtn}">
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
