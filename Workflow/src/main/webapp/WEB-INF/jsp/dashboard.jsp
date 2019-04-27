<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet"
	href="http://ajax.googleapis.com/ajax/libs/jqueryui/1.8.14/themes/base/jquery-ui.css">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/jqueryui/1.12.1/jquery-ui.min.js">
	
</script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>

<link rel="stylesheet" href="css/dashboard.css">
<script defer src="js/dashboard.js"></script>

<meta charset="UTF-8">
<title>Workflow Management System:Dashboard</title>
</head>
<body onload="loadData()">
	<nav class="navbar navbar-default navbar-fixed-top">
  <div class="container-fluid">
    <div class="navbar-header">
      <a class="navbar-brand" href="dashboard">Welcome Admin</a>
    </div>
    <ul class="nav navbar-nav">
      <li class="active" ><a id="activeBar" href="dashboard">Dashboard</a></li>
      <li><a href="createworkflow">Create workflow</a></li>
      <li><a href="listworkflow">Delete workflow</a></li>
      <li><a href="createuser">Create user</a></li>    
      <li><a href="createusergroup">Create user group</a></li>
    </ul>
  </div>
</nav>
	<h1 class="text-center" style="margin-top: 60px">
		<b>Dashboard</b>
	</h1>
	<div style="text-align: center">
		<div style="display: inline-block">
			<div
				style="height: 200px; width: 220px; background-color: #3e74e8; align-items: center"
				id="totalworkflowinstance">
			</div>
			<div
				style="height: 200px; width: 220px; background-color: #e8305b; margin-left: 280px; margin-top: -200px; align-items: center"
				id="completedWorkflowInstance">
			</div>
			<div
				style="height: 200px; width: 220px; background-color: #f26321; margin-left: 560px; margin-top: -200px; align-items: center"
				id="pendingWorkflowInstance">
			</div>
			<div
				style="height: 200px; width: 220px; background-color: #963ae8; margin-left: 840px; margin-top: -200px; align-items: center"
				id="rejectWorkflowInstance">	
			</div>
		</div>
		<table id="dashboardtable" align="center"
			style="margin-top: 20px; width: 80%;">
		</table>
	</div>

</body>
</html>