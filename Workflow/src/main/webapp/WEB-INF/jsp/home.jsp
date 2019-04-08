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

<link rel="stylesheet" href="css/home.css">

<meta charset="UTF-8">
<title>Workflow Management System:Home</title>
</head>
<body>
	<h1 class="text-center">
		<b>Welcome to workflow management system</b>
	</h1>
	<div class="container">
		<a href="createworkflow"><input type="button" id="createWorkflow" value="Create workflow"></a>
		<a href="listworkflow"><input type="button" id="editWorkflow" value="Edit/Delete workflow"></a>
		<a href="dashboard"><input type="button" id="dashboard" value="View Dashboard"></a>
		<a href="createuser"><input type="button" id="createuser" value="Create User"></a>
		<a href="createusergroup"><input type="button" id="createusergroup" value="Create User Group"></a>
	</div>
</body>
</html>