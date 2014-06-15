<%@ include file="inc/common.jsp"%>
<%@ include file="inc/calendar.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link href="css/style.css" rel="stylesheet" type="text/css" media="all">
<style type="text/css">
<!--
div.choices ul { /* autocomplete candidate */
	list-style-type: none;
	background-color: #fff;
	border: 2px solid #ccc;
	margin-left: 0;
	margin-top: 0;
	padding-left: 5px;
	padding-top: 0;
}

div.choices ul li.selected { /* selected autocomplete*/
	background-color: #ffc;
	font-weight: bold;
}
-->
</style>
<!-- scriptaculous js -->
<script type="text/javascript" src="js/prototype.js"></script>
<script type="text/javascript" src="js/effects.js"></script>
<script type="text/javascript" src="js/controls.js"></script>
<script type="text/javascript" src="js/scriptaculous.js"></script>
<script type='text/javascript' src="js/autocompleteex.js"></script>
<!-- dwr js -->
<script src='dwr/interface/AjaxAuthorSearch.js'></script>
<script src='dwr/interface/AjaxSearchSubcategory.js'></script>
<script src='dwr/engine.js'></script>
<script src='dwr/util.js'></script>


<script type="text/javascript">
<!--
	function createAutoCompleter() {

		//Book Register for author1,author2 and author3
		new Autocompleter.DWR("frmRegAuthor1", "choices1",
				populateAutocomplete, {
					afterUpdateElement : author1Selected,
					valueSelector : authorValueSelector
				});

		new Autocompleter.DWR("frmRegAuthor2", "choices2",
				populateAutocomplete, {
					afterUpdateElement : author2Selected,
					valueSelector : authorValueSelector
				});

		new Autocompleter.DWR("frmRegAuthor3", "choices3",
				populateAutocomplete, {
					afterUpdateElement : author3Selected,
					valueSelector : authorValueSelector
				});
	}
	//function for author 
	function populateAutocomplete(autocompleter, token) {

		AjaxAuthorSearch.findByAuthorNameLikeService(token, function(
				suggestions) {
			autocompleter.setChoices(suggestions);
		});
	}

	//For author 1
	function author1Selected(inputElement, selectedElement, Author) {
		dwr.util.setValue("selectAuthorId", Author.id);
	}

	//For author 2
	function author2Selected(inputElement, selectedElement, Author) {
		dwr.util.setValue("selectAuthorId", Author.id);
	}

	//For author 3
	function author3Selected(inputElement, selectedElement, Author) {
		dwr.util.setValue("selectAuthorId", Author.id);
	}

	function authorValueSelector(Author) {
		//return personObj.firstname+" "+mybean.lastname;
		return Author.authorName;
	}
	//     
	function sendCategory(categoryId) {
		AjaxSearchSubcategory.getBySubcategory(categoryId, callbackCat);
	}
	//when subcategory is obtained from server
	function sendCategorySubcategory(categoryId, subcategoryId) {
		AjaxSearchSubcategory.getByCategorySubcategory(categoryId,subcategoryId, callbackCat);

	}
	function callbackCat(message) {
		dwr.util.removeAllOptions("subcategory");
		dwr.util.addOptions("subcategory", message, "id", "subCategoryName");
		//dwr.util.addOptions(selectid, data, valueprop, textprop);

	}
	//
//-->
</script>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body onload="sendCategory('${myform.categoryID}');DWRUtil.useLoadingMessage(); createAutoCompleter()">
<!-- Start of top navigation/header -->
<div id="header">
<div id="menu">
<ul>

	<li class="current_page_item"><a href="amazonPath.do">Amazon Search</a></li>
	<li><a href="adminBookSearch.do">Library Search</a></li>
	<li><a href="bookupdatePathFirst.do">Book Update</a></li>
	<li><a href="bookdeletePathFirst.do">Book Delete</a></li>
	<li><a href="checkinPath.do">Check In</a></li>
	<li><a href="checkoutPathFirst.do">Check Out</a></li>
	<li><a href="adminLogoutPath.do">Logout</a></li>

</ul>
</div>
</div>
<!-- End of top navigation/header -->

<!-- Start of logo -->
<div id="logo">
<h1><a href="#"><em>Library</em> Management System</a></h1>
<h2><font color=olive>By Team 4</font></h2>
</div>
<!-- End of logo -->

<hr />

<!-- Start of actual page -->
<div id="page">
<div id="content">
<div class="news">
<h1 class="title" align="center">Welcome
${adminLoginFormBean.loginAdmin.name}</h1>
<br>
<div class="table">
<p align="center"><font size=+1 color="black">Amazon Book
Registration Form </font></p>
<br>
<table width="100%">
	<tr>
		<td><html:form action="/amazonPath" enctype="multipart/form-data">
			<table align="center">
				<tbody>
					<tr>
						<td>Enter ISBN-10 or ASIN:</td>
						<td><html:text property="frmSearchIsbn"></html:text></td>
						<td><html:submit property="btnAmazon"
							value="Search by Amazon API"></html:submit></td>
					</tr>
				</tbody>
			</table>
			<br>
			<br>
			<!-- Amazon Output Display Here -->
			<logic:empty name="AmazonFormBean" property="frmFormControl">
				<logic:notEmpty name="AmazonFormBean" property="frmErrorMsg">
					<font color="red"> ${AmazonFormBean.frmErrorMsg} </font>
				</logic:notEmpty>
			</logic:empty>
			<logic:notEmpty name="AmazonFormBean" property="frmFormControl">
				<table align="center">
					<tr>
						<td>&nbsp;&nbsp;<font color="green">If you want to register this book,please
						Download And Save Photo</font></td>
					</tr>
					<tr>
						<td><img src="${AmazonFormBean.frmPhotoPath}" width="110"
							height="110" /></td>

						<td><a href="${AmazonFormBean.frmPhotoPath}">Download</a></td>
					</tr>
					<tr>
						<td align="left">ISBN-10:</td>
						<td>${AmazonFormBean.frmRegISBN}</td>
						<td><html:errors property="registerError" /></td>
					</tr>

					<tr>
						<td align="left">Title:</td>
						<td>${AmazonFormBean.frmRegTitle}</td>
					</tr>
					<tr>
						<td>Author:</td>
						<td>${AmazonFormBean.frmRegAuthor1}</td>
					</tr>
					<tr>
						<td>Publisher:</td>
						<td>${AmazonFormBean.frmRegPublisher}</td>
					</tr>
					<tr>
						<td>Published Date:</td>
						<td>${AmazonFormBean.frmRegDate}</td>
					</tr>
					<tr>
						<td>Price:</td>
						<td>${AmazonFormBean.frmRegPrice}&nbsp;$</td>
					</tr>
					<tr>
						<td align="left">No of Pages:</td>
						<td>${AmazonFormBean.frmRegPage }</td>
					</tr>

					<tr>
						<td>Edition:</td>
						<td><html:text property="frmRegEdition" maxlength="100"
							size="30" value=""></html:text><font color="red">***</font></td>
						<td><html:errors property="EditionError" /></td>
					</tr>
					<tr>
						<td align="left"><label for="categoryName">Category:</label></td>
						<td><html:select property="categoryId"
							onchange="sendCategory(this[this.selectedIndex].value)">
							<html:optionsCollection property="categoryChoice" />
						</html:select><font color="red">***</font><html:errors property="CategoryError" /></td>
					</tr>

					<tr>
						<td align="left"><label for="subcategory">SubCategory:</label></td>
						<td><html:select property="subCategoryId"
							styleId="subcategory">
						</html:select><font color="red">***</font><html:errors property="CategoryError" /></td>
					</tr>
					<tr>
						<td align="left">Number of copies:</td>
						<td><html:text property="frmRegCopy" maxlength="100"
							size="30" value=""></html:text> <font color="red">***</font></td>
						<td><html:errors property="CopyError" /></td>
						<td><html:errors property="negativecopy" /></td>
						<td><html:errors property="copymax" /></td>
						
					</tr>

					<tr>
						<td align="left">Photo:</td>
						<td><html:file property="frmUploadFile" name="frmUploadFile"
							size="30" value="${AmazonFormBean.frmUploadFile}" /></td>

						<td><html:errors property="PhotoError" /></td>
						<td><html:errors property="PhotoTypeWrong" /></td>
						<td><html:errors property="NoPhoto" /></td>
						
					</tr>

					<tr>
						<td align="left">Remark:</td>
						<td><html:text property="frmRegRemark" maxlength="100" size="30"></html:text>
						<font color="red">***</font></td>
						<td><html:errors property="RemarkError" /></td>
					</tr>


					<tr>
						<td colspan=2 align="center"><html:submit
							property="btnRegister" value="Register">
						</html:submit> <html:reset property="btnRegisterCancel" value="Cancel">
						</html:reset></td>
					</tr>
				</table>
			</logic:notEmpty>
			
		</html:form></td>
	</tr>
</table>
</div>
</div>
</div>
<%@ include file="inc/admin_left_menu.jsp"%></div>
<%@ include file="inc/footer.jsp"%>
</body>
</html>