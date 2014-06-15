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
			if(suggestions!=null)
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
		AjaxSearchSubcategory.getByCategorySubcategory(categoryId,
				subcategoryId, callbackCat);

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
<title>Library Management System</title>
</head>
<body
	onload="sendCategory('${myform.categoryID}');DWRUtil.useLoadingMessage(); createAutoCompleter()">
<%@ include file="inc/admin_header.jsp"%>

<!-- Start of actual page -->
<div id="page">
<div id="content">
<div class="news">
<h1 class="title" align="center">Welcome
${adminLoginFormBean.loginAdmin.name}</h1>
<br>

<div class="table">
<p align="center"><font size=+1 color="black">Book Registration Form</font></p>
<br>
<table width="100%">
	<tr>
		<td><html:form action="/adminRegisterPath" method="POST"
			enctype="multipart/form-data">
			<logic:empty property="frmRegFormControl"
				name="adminRegisterFormBean">
				<table border="0">
					<tbody align="center">
						<tr>
							<td align="right">ISBN 10:</td>
							<td><html:text property="frmRegISBN" maxlength="10"
								size="30"></html:text> <font color="red">***</font></td>
							<td><html:errors property="frmRegISBN" /></td>
							<td><html:errors property="falseisbn" /></td>
							<td><html:errors property="falseisbn13" /></td>
							<td><html:errors property="registerError" /></td>

						</tr>
						<tr>
							<td align="right">Title :</td>
							<td><html:text property="frmRegTitle" maxlength="100"
								size="30"></html:text> <font color="red">***</font></td>
							<td><html:errors property="frmRegTitle" /></td>
						</tr>

						<tr>
							<td align="right">Author1:</td>
							<td><html:text property="frmRegAuthor1"
								styleId="frmRegAuthor1" maxlength="100" size="30" />
							<div class="choices" id="choices1"></div>
							<font color="red">***</font></td>
							<td><html:errors property="frmRegAuthor1" /></td>
						</tr>
						<tr>
							<td align="right">Author2:</td>
							<td><html:text property="frmRegAuthor2"
								styleId="frmRegAuthor2" maxlength="100" size="30" />
							<div class="choices" id="choices2"></div>
							</td>
							<td></td>

						</tr>
						<tr>
							<td align="right">Author3:</td>
							<td><html:text property="frmRegAuthor3"
								styleId="frmRegAuthor3" maxlength="100" size="30" />
							<div class="choices" id="choices3"></div>
							</td>
							<td></td>
						</tr>
						<tr>
							<td align="right">Edition:</td>
							<td><html:text property="frmRegEdition" maxlength="50"
								size="30"></html:text> <font color="red">***</font></td>
							<td><html:errors property="frmRegEdition" /></td>
						</tr>
						<tr>
							<td>Publisher:</td>
							<td><html:select property="frmRegPublisher">
								<html:optionsCollection property="publisherChoice" value="id"
									label="pubName" />
							</html:select><font color="red">***</font>
							<td><font size="3"> <a href="publisherPathFirst.do">New
							Publisher</a></font></td>
							<td><html:errors property="frmRegPublisher" /></td>
						</tr>
						<tr>
							<td align="right">Price:</td>
							<td><html:text property="frmRegPrice" maxlength="10"
								size="30" value=""></html:text>Kyats <font color="red">***</font></td>
							<td><html:errors property="frmRegPrice" /></td>
						</tr>

						<tr>
							<td align="right">Number of Pages:</td>
							<td><html:text property="frmRegPage" maxlength="10"
								size="30" value=""></html:text> <font color="red">***</font></td>
							<td><html:errors property="frmRegPage" /></td>
						</tr>

						<tr>
							<td align="right">Number of copies:</td>
							<td><html:text property="frmRegCopy" maxlength="10"
								size="30" value=""></html:text> <font color="red">***</font></td>
							<td><html:errors property="frmRegCopy" /></td>
						</tr>
						<tr>
							<td align="right">Organization:</td>
							<td><html:text property="frmOrgName" maxlength="50"
								size="30"></html:text> <font color="red">***</font></td>
							<td><html:errors property="frmOrgName" /></td>
						</tr>

						<tr>
							<td align="right">Year:</td>
							<td><html:text property="frmRegDate" styleId="calendar"
								maxlength="100" size="30" readonly="true" /> <html:image
								src="images/calendar.gif" styleId="trigger"
								style="cursor: pointer; border: 1px solid red;"
								title="Date selector" onmouseover="this.style.background='red';"
								onmouseout="this.style.background=''">
							</html:image></td>
							<td><font face="Verdana" size="2" color="blue">&nbsp;YYYY-MM-DD</font>
							<script type="text/javascript">
	//         
	Calendar.setup({
		firstDay : 1,
		electric : false,
		singleClick : true,
		inputField : "calendar",
		button : "trigger",
		ifFormat : "%Y-%m-%d",
		daFormat : "%Y-%m-%d"
	});
	//
</script></td><td><html:errors property="dateError" /></td>
						</tr>
						<tr>
							<td align="right"><label for="categoryName">Category:</label></td>
							<td><html:select property="categoryId"
								onchange="sendCategory(this[this.selectedIndex].value)">
								<html:optionsCollection property="categoryChoice" />
							</html:select><html:errors property="CategoryError" /></td>
						</tr>
						<tr>
							<td align="right"><label for="subcategory">
							SubCategory:</label></td>
							<td><html:select property="subCategoryId"
								styleId="subcategory"></html:select><html:errors
								property="CategoryError" /><html:errors property="SubcategoryError" /></td>
								
						</tr>
						<tr>

							<td align="right">Resources:</td>
							<td><html:radio property="frmRegResource" value="denote">Denote</html:radio>
							<html:radio property="frmRegResource" value="denote">Buy</html:radio>
							<font color="red">***</font></td>
							<td><html:errors property="frmRegResource" /></td>
						</tr>
						<tr>
							<td align="right">Remark:</td>
							<td><html:text property="frmRegRemark" maxlength="100" size="30"></html:text>
						 <font color="red">***</font></td>
							<td><html:errors property="frmRegRemark" /></td>
						</tr>
						<tr>
							<td>Photo:</td>
							<td><html:file property="frmUploadPhoto" maxlength="100"
								size="30" /></td>
							<td><html:errors property="PhotoError" /></td>
							<td><html:errors property="PhotoTypeWrong" /></td>
							<td><html:errors property="NoPhoto" /></td>
							
						</tr>
						<tr>
							<td colspan=2 align="center"><html:submit
								property="btnRegister" value="Register">
							</html:submit> <html:reset property="btnRegisterCancel" value="Cancel">
							</html:reset></td>

						</tr>
					</tbody>
				</table>
			</logic:empty>

			<logic:notEmpty property="frmRegFormControl"
				name="adminRegisterFormBean">
				<table align="center">
					<tr>
						<td align="right">ISBN:</td>
						<td><html:text property="frmRegISBN" disabled="true"
							maxlength="100" size="30"></html:text></td>
								<td><html:errors property="registerError" /></td>
						
					</tr>
					<tr>
						<td align="right">Title:</td>
						<td><html:text property="frmRegTitle" disabled="true"
							maxlength="100" size="30"></html:text></td>
					</tr>
					<tr>
						<td align="right">Author:</td>
						<td><html:text property="frmRegAuthor1" disabled="true"
							maxlength="100" size="30"></html:text></td>
					</tr>
					<tr>
						<td align="right">Edition:</td>
						<td><html:text property="frmRegEdition" disabled="true"
							maxlength="100" size="30"></html:text></td>
					</tr>
					<tr>
						<td align="right">Publisher:</td>
						<td><html:text property="publisherName" disabled="true"
							maxlength="100" size="30"></html:text></td>
					</tr>
					<tr>
						<td align="right">Price:</td>
						<td><html:text property="frmRegPrice" disabled="true"
							maxlength="100" size="30"></html:text></td>
					</tr>
					<tr>
						<td align="right">Number of Pages:</td>
						<td><html:text property="frmRegPage" disabled="true"
							maxlength="100" size="30"></html:text></td>
					</tr>
					<tr>
						<td align="right">Number of copies:</td>
						<td><html:text property="frmRegCopy" disabled="true"
							maxlength="100" size="30"></html:text></td>
					</tr>
					<tr>
						<td align="right">Organization:</td>
						<td><html:text property="frmOrgName" disabled="true"
							maxlength="100" size="30"></html:text></td>
					</tr>
					<tr>
						<td align="right">Year:</td>
						<td><html:text property="frmRegDate" disabled="true"
							maxlength="100" size="30"></html:text></td>
						
					</tr>
					<tr>
						<td align="right">Category:</td>
						<td><html:text property="categoryName" disabled="true"
							maxlength="100" size="30"></html:text></td>
					</tr>
					<tr>
						<td align="right">SubCategory:</td>
						<td><html:text property="subcategoryName" disabled="true"
							maxlength="100" size="30"></html:text></td>
					</tr>
					<tr>
						<td align="right">Resources:</td>
						<td><html:text property="frmRegResource" disabled="true"
							maxlength="100" size="30"></html:text></td>
					</tr>
					<tr>
						<td align="right">Remark:</td>
						<td><html:text property="frmRegRemark" disabled="true" maxlength="100" size="30"></html:text></td>
					</tr>
					<tr>
						<td>Photo:</td>
						<td><html:text property="frmUploadPhoto" disabled="true"
							maxlength="100" size="30" /></td>
					</tr>
					<tr>
						<td colspan=2 align="center"><html:submit property="btnSave"
							value="Save"></html:submit> <html:submit property="btnSaveCancel"
							value="Cancel"></html:submit></td>
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