<link rel="stylesheet"
	href="http://ajax.googleapis.com/ajax/libs/jqueryui/1.8.14/themes/base/jquery-ui.css">
<link rel="stylesheet"
	href="http://trirand.com/blog/jqgrid/themes/ui.jqgrid.css">

<link rel="stylesheet" href="css/createworkflow.css">

<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/jqueryui/1.12.1/jquery-ui.min.js">
	
</script>
<script src="http://trirand.com/blog/jqgrid/js/i18n/grid.locale-en.js"></script>
<script src="http://trirand.com/blog/jqgrid/js/jquery.jqGrid.min.js"></script>

<script defer src="js/createworkflow.js"></script>


</head>

<body>
	<h1 class="text-center">
		<b>Create Workflow</b>
	</h1>
	<div class="container">
		<form method="post">
			<label for="workflowname">Workflow Name</label> <input type="text"
				id="workflowname" name="firstname"
				placeholder="Name of workflow ..."> <label
				for="workflowdescription">Workflow description</label> <input type="text"
				id="workflowdescription" name="lastname"
				placeholder="Description of workflow ... ">
			<input type="button" id="addTask" value="Add Task">
			<table id="taskTable"></table>
			<div id="jqGridPager"></div>
			<input type="submit" value="Submit">
		</form>
	</div>




</body>

</html>
<script>
	
</script>