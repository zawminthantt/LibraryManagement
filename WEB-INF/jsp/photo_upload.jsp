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
${LoginFormBean.loginUser.userName}</h1>
<br>

<div class="table">
		<html:form action="/photoPath" method="post" enctype="multipart/form-data">
			<table align="center">
				<tr>
					<td>Select your photo type:</td>
					<td><html:radio property="frmPhotoType" value="0" />Image Type
					<html:radio property="frmPhotoType" value="1" />Other File Type</td>
				</tr>
				<tr>
					<td>Photo</td>
					<td><html:file property="frmUploadPhoto" /></td>
				</tr>
				<tr>
					<td colspan="2" align="center"><html:submit
						property="btnUpload" value="Upload" /> <html:submit
						property="btnCancel" value="Cancel" /></td>
				</tr>
			</table>
			<br></br>
			<logic:notEmpty name="PhotoFormBean" property="frmViewPhoto">
				<html:img src="${PhotoFormBean.frmViewPhoto}" height="100" width="100" />
			</logic:notEmpty>
				</html:form>
		</div>
</div>
</div>
<%@ include file="inc/admin_left_menu.jsp"%></div>
<%@ include file="inc/footer.jsp"%>
</body>
</html>