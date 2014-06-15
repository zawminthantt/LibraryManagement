<%@ include file="inc/common.jsp"%>
<html>
<head>
<title>Library Management System</title>
<!--<link href="css/style.css" rel="stylesheet" type="text/css"
	media="screen" />

--><style type="text/css">
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
		
	}
	// the callback for the auto completer
	function populateAutocomplete(autocompleter, token) {
		AjaxTitleSearch.findBookByLikeFromService(token, function(suggestions) {
			if(suggestions!=null)
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
	
	
	//
//-->
</script>
</head>

<body>
<body onload="DWRUtil.useLoadingMessage(); createAutoCompleter()">

<hr>
<table align="center">

	<tr>

		<td><html:form action="/searchPath">
			<table align="center">
				<tr>
					<td align="right"><font color="black" size="4">Title</font></td>
					
					<td><html:text property="frmBookTitle" styleId="frmBookTitle" size="40" maxlength="100" />
					<div class="choices" id="choices1"></div>
					</td>
					<td colspan="2" align="center"><html:submit property="btnSearch"
				value="Search"></html:submit></td>
					<tr>
					<td align="center"><font size="3">
					<html:errors property="searchTitle" /> </font>
					</td>
					<td align="center"><font size="3">
					<html:errors property="searchError" /></font> 
					</td>
					</tr>
				
				
					</tr>
					</table>
		</html:form></td>
		
	</tr>
</table>

</body>


</html>
