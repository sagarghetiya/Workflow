$(document).ready(function() {
});

$("#usergroup_submit").click(function() {
	
	var usergroupname = document.getElementById("groupname").value;
	var usergroupdescription = document.getElementById("description").value;
	$.ajax({
		type : 'POST',
		contentType : "application/json",
		url : "http://localhost:8888/addusergroup",
		data : JSON.stringify({
			userGroupName : usergroupname,
			description : usergroupdescription
		}),
		dataType : "json",
		contentType : "application/json; charset=utf-8",
		statusCode : {
			200 : function() {
				$('#sucess_Modal').modal('show');
			},
			500 : function() {
				$('#failure_Modal').modal('show');
			}
		}
	});
});

function clearFields() {
	document.getElementById("usergroupform").reset();
	
}