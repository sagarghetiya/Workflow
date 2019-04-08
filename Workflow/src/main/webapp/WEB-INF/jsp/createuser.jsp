<!DOCTYPE link PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<link rel="stylesheet"
	href="http://ajax.googleapis.com/ajax/libs/jqueryui/1.8.14/themes/base/jquery-ui.css">
<link rel="stylesheet"
	href="http://trirand.com/blog/jqgrid/themes/ui.jqgrid.css">
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
<link
	href="https://cdnjs.cloudflare.com/ajax/libs/select2/4.0.6-rc.0/css/select2.min.css"
	rel="stylesheet" />
<link rel="stylesheet" href="css/createuser.css">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">

<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/jqueryui/1.12.1/jquery-ui.min.js">
	<link href="http://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/3.0.3/css/bootstrap.min.css"
    rel="stylesheet" type="text/css" />
	<script type="text/javascript" src="http://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/3.0.3/js/bootstrap.min.js">
</script>
<link
	href="http://cdn.rawgit.com/davidstutz/bootstrap-multiselect/master/dist/css/bootstrap-multiselect.css"
	rel="stylesheet" type="text/css" />
<script
	src="http://cdn.rawgit.com/davidstutz/bootstrap-multiselect/master/dist/js/bootstrap-multiselect.js"
	type="text/javascript"></script>

<!-- Latest compiled JavaScript -->
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>

<script
	src="https://cdnjs.cloudflare.com/ajax/libs/select2/4.0.6-rc.0/js/select2.min.js"></script>
<script defer src="js/createuser.js"></script>
<body>
	<h1 class="text-center">
		<b>Add User</b>
	</h1>

	<div class="container" style="margin-top: 80px">
		<div>
			<img src="/images/usersurround.png" height="400px" width="400px">
		</div>
		<div class="incontainer">
			<form method="post" id="userform">
				<label for="username">User Name</label> <input type="text"
					id="username" name="username"> <label for="firstname">First
					Name</label> <input type="text" id="firstname" name="firstname"> <label
					for="lastname">Last Name</label> <input type="text" id="lastname"
					name="lastname"> <label for="email">Email</label> <input
					type="email" id="email" name="email"> <label for="password">Password</label>
				<input type="password" id=password name="password"> <label
					for="designation">Designation</label> <input type="text" id=designation
					name="designation"> <label for="usergroup">User Group</label>
				<select id="usergroupdisplay" multiple="multiple">
				</select> <input type="button" value="Submit" id="user_submit">
			</form>
		</div>
	</div>
	<div id="sucess_Modal" class="modal fade" role="dialog">
		<div class="modal-dialog">

			<!-- Modal content-->
			<div class="modal-content">
				<div class="modal-header">
					<h4 class="modal-title">User created successfully!!!... :)</h4>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-success" data-dismiss="modal"
						onclick="clearFields()">Close</button>
				</div>
			</div>
		</div>
	</div>
	<div id="failure_Modal" class="modal fade" role="dialog">
		<div class="modal-dialog">

			<!-- Modal content-->
			<div class="modal-content">
				<div class="modal-header">
					<h4 class="modal-title">Sorry an unexpected error occured
						while creating user!!!... :(</h4>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-success" data-dismiss="modal">Close</button>
				</div>
			</div>
		</div>
	</div>
</body>

</html>
<script>
	
</script>