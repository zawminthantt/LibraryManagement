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

	<h3><font color=red>Successfully renew!!!</font></h3>
</div>
</div>
</div>
<%@ include file="inc/left_menu.jsp"%></div>
<%@ include file="inc/footer.jsp"%>
</body>
</html>