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
<div class="table"><html:form action="/amazonPath">
	<table style='padding: 5px' align="center">
		<tbody>
			<tr>
				<td>Enter ISBN-10 or ASIN:</td>
				<td><html:text property="frmSearchIsbn"></html:text></td>
				<td><html:submit property="btnAmazon"
					value="Search by Amazon API"></html:submit></td>
			</tr>
		</tbody>
	</table>
	<!-- Amazon Output Display Here -->
	<logic:empty name="AmazonFormBean" property="frmFormControl">
		<logic:notEmpty name="AmazonFormBean" property="frmErrorMsg">
			<font color="red"> ${AmazonFormBean.frmErrorMsg } </font>
		</logic:notEmpty>
	</logic:empty>
	<logic:notEmpty name="AmazonFormBean" property="frmFormControl">
	<br>
	
			<table  align="center">		
			
			<tr>
				<td></td><td><img src="${AmazonFormBean.frmPhotoPath }"
					width="120" height="150" /></td>
			</tr>
			<tr><td>&nbsp;</td></tr>
			<tr>
				<td>ISBN-10:</td>
				<td><font color="black">${AmazonFormBean.frmIsbn10 }</font></td>					
			</tr>
			<tr>
				<td>ISBN-13:</td>
				<td><font color="black">${AmazonFormBean.frmIsbn13}</font></td>
				
			</tr>
			<tr>
				<td>Title:</td>
				<td><font color="black">${AmazonFormBean.frmTitle}</font></td>					
			</tr>
			<tr>
				<td>Author:</td>
				<td><font color="black">${AmazonFormBean.frmAuthor}</font></td>						
			</tr>
			<tr>
				<td>Publisher:</td>
				<td><font color="black">${AmazonFormBean.frmManufacturer}</font></td>					
			</tr>
			<tr>
				<td>Published Date:</td>
				<td><font color="black">${AmazonFormBean.frmPublicationDate }</font></td>					
			</tr>
			<tr>
				<td>No of Pages:</td>
				<td><font color="black">${AmazonFormBean.frmNoOfPages }</font></td>						
			</tr>
			<tr>
				<td>Price:</td>
				<td><font color="black">${AmazonFormBean.frmPrice }</font></td>						
			</tr>
			<tr>
				<td>Size:</td>
				<td><font color="black">${AmazonFormBean.frmSize }</font></td>						
			</tr>
			
			<tr>
				<td>PhotoPath:</td>
				<td><font color="black">${AmazonFormBean.frmPhotoPath }</font></td>					
			</tr>
			<tr>&nbsp;</tr>
			
		</table>
	</logic:notEmpty>

</html:form></div>
</div>
</div>
<%@ include file="inc/admin_left_menu.jsp"%></div>
<%@ include file="inc/footer.jsp"%>
</body>
</html>