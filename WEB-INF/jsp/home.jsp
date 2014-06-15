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

<div class="table"><html:form>
	<font size="5" color="darkblue">
	<center><b><i><blink>Welcome to Online Library
	Management System</blink> </i> </b></center>
	</font>
	<hr>
	<br>
	<br>
	<table>
		<tr>
			<td><img src="./images/main.jpg" align="right" height="250px" />
			<div><font size="3" color="darkblue" face="arial"><b><i>Our
			Objectives!</i> </b> </font> <font size="2" color="darkblue">This web site is
			an online gateway to the library resources of Information and
			Communication Technoloy Training Institute(ICTTI) and serves as an
			important research tool for current students, teachers and staff of
			ICTTI. <br>
			<center><b>Member can borrow one book depends on the
			member type.</b></center>
			<ul>
				<li>Teachers can borrow one month.</li>
				<li>Regular Students can borrow two weeks.</li>
				<li>Advanced Students can borrow one week.</li>
				<li>Staff can borrow two weeks.</li>
			</ul>
			<center><b>If the required book is not currently
			available.</b></center>
			<ul>
				<li>The member can reserve the required book.</li>
				<li>This member must check out during 7 days from the day of
				reserve.</li>

			</ul>
			</font></div>
			</td>
		</tr>
	</table>
	
	
	<br>
	<hr>




</html:form></div>
</div>
</div>
<%@ include file="inc/left_menu.jsp"%></div>
<%@ include file="inc/footer.jsp"%>
</body>
</html>