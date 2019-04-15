<!DOCTYPE link PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<link rel="stylesheet"
	href="http://ajax.googleapis.com/ajax/libs/jqueryui/1.8.14/themes/base/jquery-ui.css">
<link rel="stylesheet"
	href="http://trirand.com/blog/jqgrid/themes/ui.jqgrid.css">
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
<link href="https://cdnjs.cloudflare.com/ajax/libs/select2/4.0.6-rc.0/css/select2.min.css" rel="stylesheet" />
<link rel="stylesheet" href="css/createworkflow.css">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">

<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/jqueryui/1.12.1/jquery-ui.min.js">
</script>
<script src="http://trirand.com/blog/jqgrid/js/i18n/grid.locale-en.js"></script>
<script src="http://trirand.com/blog/jqgrid/js/jquery.jqGrid.min.js"></script>

<!-- Latest compiled JavaScript -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>


<script src="https://cdnjs.cloudflare.com/ajax/libs/select2/4.0.6-rc.0/js/select2.min.js"></script>
<script defer src="js/createworkflow.js"></script>


<body>
<nav class="navbar navbar-default navbar-fixed-top">
  <div class="container-fluid">
    <div class="navbar-header">
      <a class="navbar-brand" href="#">Welcome Admin</a>
    </div>
    <ul class="nav navbar-nav">
      <li><a href="dashboard">Dashboard</a></li>
      <li class="active" ><a id="activeBar" href="createworkflow">Create workflow</a></li>
      <li><a href="listworkflow">Delete workflow</a></li>
      <li><a href="createuser">Create user</a></li>    
      <li><a href="createusergroup">Create user group</a></li>
    </ul>
  </div>
</nav>
	<h1 class="text-center" style="margin-top: 60px">
		<b>Create Workflow</b>
	</h1>
	
	<div class="container">
		<form method="post" id="createWorkflowForm">
			<label for="workflowname">Workflow Name</label> <input type="text"
				id="workflowname" name="workflowname"
				placeholder="Name of workflow ..."> <label
				for="workflowdescription">Workflow description</label> <input
				type="text" id="workflowdescription" name="workflowdescription"
				placeholder="Description of workflow ... "> <input
				type="button" id="addTask" value="Add Task"
				onclick="addEditableTask()">
			<table id="taskTable"></table>
			<input type="button" value="Submit" id="workflow_submit">
		</form>
	</div>
	<div id="sucess_Modal" class="modal fade" role="dialog">
		<div class="modal-dialog">

			<!-- Modal content-->
			<div class="modal-content">
				<div class="modal-header">
					<h4 class="modal-title">Workflow created successfully!!!... :)
					</h4>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-success" data-dismiss="modal" onclick="clearFields()">Close</button>
				</div>
			</div>
		</div>
	</div>
	<div id="failure_Modal" class="modal fade" role="dialog">
		<div class="modal-dialog">

			<!-- Modal content-->
			<div class="modal-content">
				<div class="modal-header">
					<h4 class="modal-title">Sorry an unexpected error occured while creating workflow!!!... :(
					</h4>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-success" data-dismiss="modal" >Close</button>
				</div>
			</div>
		</div>
	</div>
</body>
</html>
<script>
	
</script>