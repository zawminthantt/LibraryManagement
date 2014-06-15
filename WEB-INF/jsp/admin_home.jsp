<%@ include file="inc/common.jsp"%>
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
				<h1 class="title" align="center">Welcome &nbsp;&nbsp;
					${adminLoginFormBean.loginAdmin.name}</h1>
				<br>

				<div class="table">
					<html:form>
						<font size="5" color="black"><center>
								<b><i><blink>Welcome To Team4 Library</blink> </i> </b>
							</center> </font>
						<br>
						<br>
						<table>
							<tr>
								<td><img src="./images/BookCoverGif.gif" align="right"
									height="250px" />
									<div>
										<font size="2" color="black" face="arial"><font
											size="4"><b><i>We're so glad you're here!</i>
											</b>
										</font> We are a world class library with a fantastic building,
											amazing collections and terrific people, all ready, willing
											and able to serve your info needs. I trust your visit will be
											both fun and productive. This message is sent on behalf of
											the over 100 staff members all working hard to bring you the
											best library in Michigan! Our goal is to provide you with
											world class resources and unsurpassed service. We're never
											satisfied, so we're always adding new books, movies and
											music, fine tuning our services and adjusting our thinking to
											bring you the latest and greatest available in libraries. Got
											an idea, question or comment about our library? Keep reading,
											it's exercise for your mind! As a public institution, we
											serve all residents, which is affirmed in our mission
											statement. As the community consists of people with a wide
											variety of beliefs, the public library must attempt to serve
											all on an equal basis. This the library does by purchasing
											materials that cover a wide variety of topics, as well as
											both sides of a particular or controversial topic. This goal
											of providing materials of both sides of a conflict has always
											been the strength of public libraries across this nation.
											And, public libraries have traditionally been able to provide
											these conflicting materials in a neutral and non-threatening
											setting. Even though some of the purchased materials may be
											offensive to an individual or to a group of people, a public
											library cannot afford to make the physical environment one
											that is offensive to anyone. By necessity, this must include
											the decorations used to celebrate national and state
											holidays. Therefore, it shall be the policy of the Hibbing
											Public Library that the library will endeavor to decorate the
											library in an attractive manner to reflect the various
											holidays and celebrations of the community. In its
											decorations, it will refrain from using any symbols or
											decorations that are religious in nature. It is noted that
											the library's Exhibits and Display Policy allows any group to
											exhibit a display that makes "the public aware of the
											different informational, educational and cultural resources
											of the community." This includes displays of a religious
											nature. </font>
									</div>
								</td>
							</tr>
						</table>

						<br>
						<hr>
						<table align="right">
							<tr>
								<td><img src="./images/Team4Logo.png" align="right" /> <font
									size="5" color="black" face="Segoe Script">Thanks By</font>
								</td>
							</tr>
						</table>


					</html:form>
				</div>
			</div>
		</div>
		<%@ include file="inc/admin_left_menu.jsp"%></div>
	<%@ include file="inc/footer.jsp"%>
</body>
</html>