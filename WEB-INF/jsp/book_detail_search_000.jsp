<%@ include file="./inc/common.jsp"%>
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
<script src='dwr/interface/AjaxTitleSearch.js'></script>
<script src='dwr/interface/AjaxAuthorSearch.js'></script>
<script src='dwr/interface/AjaxSearchSubcategory.js'></script>
<script src='dwr/engine.js'></script>
<script src='dwr/util.js'></script>


<script type="text/javascript">
<!--
	//          
	// should be in the "onload" of the body        
	function createAutoCompleter() {
		new Autocompleter.DWR("frmBookTitle", "choices1", populateAutocomplete,
				{
					afterUpdateElement : bookSelected,
					valueSelector : bookValueSelector
				});
		new Autocompleter.DWR("frmAuthorName", "choices2",
				populateAutocomplete1, {
					afterUpdateElement : authorSelected,
					valueSelector : authorValueSelector
				});
	}
	// the callback for the auto completer
	function populateAutocomplete(autocompleter, token) {
		AjaxTitleSearch.findBookByLikeFromService(token, function(suggestions) {
			autocompleter.setChoices(suggestions);
		});

	}
	function populateAutocomplete1(autocompleter, token) {

		AjaxAuthorSearch.findByAuthorNameLikeService(token, function(
				suggestions) {
			autocompleter.setChoices(suggestions);
		});
	}
	//this function extractes string from sample object for matching
	function bookValueSelector(BookList) {
		return BookList.title;
	}
	//this function is fired when users selects sample from list
	function bookSelected(inputElement, selectedElement, BookList) {
		dwr.util.setValue("selectTitleId", BookList.id);
	}
	function authorSelected(inputElement, selectedElement, Author) {
		dwr.util.setValue("selectAuthorId", Author.id);
	}
	function authorValueSelector(Author) {
		//return personObj.firstname+" "+mybean.lastname;
		return Author.authorName;
	}
	//Category and SubCategory function
	function sendCategory(categoryID) {
		AjaxSearchSubcategory.getBySubcategory(categoryID, callbackCat);
	}
	
	function sendCategorySubcategory(categoryId, subcategoryId) {
        AjaxSearchSubcategory.getByCategorySubcategory(categoryId,subcategoryId, callbackCat);

}
	//when subcategory is obtained from server
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
<body onload="sendCategory('${myform.categoryID}'); DWRUtil.useLoadingMessage(); createAutoCompleter() ">
<%@ include file="inc/header.jsp"%>

<!-- Start of actual page -->
<div id="page">
<div id="content">
<div class="news">
<h1 class="title" align="center">Welcome
${LoginFormBean.loginUser.userName}</h1>
<br>

<div class="table">
<p align="center">
			<font size=+1 color="black" >Book Search Form</font>
		</p><br>
<table  width="100%">

	<tr>

		<td><html:form action="/autoComplementPath">
			<table align="center">
				<tr>
					<td>Title:&nbsp;&nbsp;&nbsp;
					<html:text property="frmBookTitle" styleId="frmBookTitle" />
					<div class="choices" id="choices1"></div>
					</td>
					</tr>
					<tr>
					<td>Author:
					<html:text property="frmAuthorName"
						styleId="frmAuthorName" />
					<div class="choices" id="choices2"></div>
					</td>
					</tr>
				<tr>
					<td width="50%"><label for="categoryName">Category:</label> <html:select
						property="categoryId"
						onchange="sendCategory(this[this.selectedIndex].value)">
						<html:optionsCollection property="categoryChoice" />
					</html:select></td>
					</tr>
					<tr>
					<td width="50%"><label for="nextcategory">
					SubCategory:</label> <html:select property="subcategoryId"
						styleId="subcategory">${myform.subcatOption}</html:select></td>
				</tr>
				<tr><td colspan="2"><html:submit property="btnSearch"
				value="Search"></html:submit></td></tr>
				<tr>
					<td><font size="3">
					<html:errors property="searchError" /> </font>
					</td>
					
				</tr>
				
				
			</table>
			<logic:notEmpty property="frmBookList" name="AutoFormBean">
	<table align="center" border="1">
		<tr>

			<td bgcolor="lightblue"><font color="black">No</font></td>
			<td bgcolor="lightblue"><font color="black">Title</font></td>
			<td bgcolor="lightblue"><font color="black">Author</font></td>
			<td bgcolor="lightblue"><font color="black">Category</font></td>
			<td bgcolor="lightblue"><font color="black">SubCategory</font></td>
			<td bgcolor="lightblue"></td>
			<td bgcolor="lightblue"></td>
		</tr>
		<c:forEach var="i" begin="${AutoFormBean.begin}" end="${AutoFormBean.end}" step="1">
			<tr>
				<td><font color="black">${i}</font></td>
				<td><font color="black">${AutoFormBean.frmBookList[i-1].title}</font></td>
				<td><font color="black">${AutoFormBean.frmBookList[i-1].authorName}</font></td>
				<td><font color="black">${AutoFormBean.frmBookList[i-1].categoryName}</font></td>
				<td><font color="black">${AutoFormBean.frmBookList[i-1].subcategoryName}</font></td>
				<td><a href="searchDetailPath.do?frmDetailBookId=${AutoFormBean.frmBookList[i-1].id}&frmControl=1">Detail </a></td>
				<td><a href="reservationPath.do?frmDetailBookId=${AutoFormBean.frmBookList[i-1].id}">Reserve</a></td>
			</tr>
		</c:forEach>
	</table>
	<!--  next and previous button control here -->
	<table align="center">
		<tr>
			<td>
			<div align="center"><c:if
				test="${AutoFormBean.prevBtn}">&lt;&lt;
                      <html:submit property="prev" value="Previous">
				</html:submit>
			</c:if></div>
			</td>
			<td>
			<div align="center"><c:if
				test="${AutoFormBean.nextBtn}">
				<html:submit property="next" value="Next">
				</html:submit>&gt;&gt;
              </c:if></div>
			</td>
		</tr>
	</table>
	<html:hidden property="actualPage" name="AutoFormBean" />
</logic:notEmpty>
		</html:form></td>
	</tr>
</table></div>
</div>
</div>
<%@ include file="inc/left_menu.jsp"%></div>
<%@ include file="inc/footer.jsp"%>
</body>
</html>