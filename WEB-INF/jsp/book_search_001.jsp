<%@ include file="./inc/common.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link href="css/style.css" rel="stylesheet" type="text/css" media="all">

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Library Management System</title>
</head>
<body>
<%@ include file="inc/header0.jsp"%>

<!-- Start of actual page -->
<div id="page">
<div id="content">
<div class="news">
<h1 class="title" align="center"></h1>
<br>

<div class="table">
<p align="center">
			<font size=+1 color="black" >Book Search Detail Form</font>
		</p><br>
<html:form action="/searchPath">
<logic:notEmpty property="frmBookList" name="SearchFormBean">
	<table align="center" border=1>
		<tr>
			<td bgcolor="lightblue"><font color="black">No</font></td>
			<td bgcolor="lightblue"><font color="black">Title</font></td> 
			<td bgcolor="lightblue"><font color="black">ISBN Number</font></td>
			<td bgcolor="lightblue"><font color="black">Edition</font></td>
			<td bgcolor="lightblue"><font color="black">Price</font></td>
			
		</tr>
		<c:forEach var="i" begin="${SearchFormBean.begin}" end="${SearchFormBean.end}" step="1">
			<tr>
				<td><font color="black">${i}</font></td>
				<td><font color="black">${SearchFormBean.frmBookList[i-1].title}</font></td>
				<td><font color="black">${SearchFormBean.frmBookList[i-1].isbnNo}</font></td>
				<td><font color="black">${SearchFormBean.frmBookList[i-1].edition}</font></td>
			<td><font color="black">${SearchFormBean.frmBookList[i-1].price}</font></td>
			</tr>
		</c:forEach>
		
		
	</table>
	
		<center><html:submit  property="btnOk" value="Ok"></html:submit></center>	
		
	<!--  next and previous button control here -->
	<table align="center">
		<tr>
			<td>
			<div align="center"><c:if
				test="${SearchFormBean.prevBtn}">&lt;&lt;
                      <html:submit property="prev" value="Previous">
				</html:submit>
			</c:if></div>
			</td>
			<td>
			<div align="center"><c:if
				test="${SearchFormBean.nextBtn}">
				<html:submit property="next" value="Next">
				</html:submit>&gt;&gt;
              </c:if></div>
			</td>
		</tr>
	</table>
	<!-- to carry the actual page -->
	<html:hidden property="actualPage" name="SearchFormBean" />
</logic:notEmpty>
<html:hidden property="frmControl" name="SearchFormBean" value="1" />
</html:form>

</div>
</div>
</div>

<%@ include file="inc/left_image.jsp"%>

</div>
<%@ include file="inc/footer.jsp"%>
</body>
</html>