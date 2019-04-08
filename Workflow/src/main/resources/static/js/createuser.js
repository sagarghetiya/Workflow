var userGroupList = null;
var allUserGroup = null;
$(document).ready(function() {
	loadUserGroups();
});

function loadUserGroups() {
	$.getJSON("http://localhost:8888/getallusergroup", function(json) {
		$('#usergroupdisplay').empty();
		var usergroupdisplay = $('#usergroupdisplay');
		userGroupList = json;
		for (var i = 0; i < json.length; i++) {
			if (json[i].userGroupName != "All") {
				usergroupdisplay.append("<option value='"
						+ json[i].userGroupName + "''>" + json[i].userGroupName
						+ "</option>");
			} else {
				allUserGroup = json[i];
			}
		}
		multiSelectOn();
	});

}
function multiSelectOn() {
	$('#usergroupdisplay').multiselect({
		includeSelectAllOption : true
	});
}

$("#user_submit").click(function() {

	var firstname = document.getElementById("firstname").value;
	var lastname = document.getElementById("lastname").value;
	var username = document.getElementById("username").value;
	var email = document.getElementById("email").value;
	var password = document.getElementById("password").value;
	var designation = document.getElementById("designation").value;
	
	var selectedGroupList = new Array();
	//debugger;
	var selected = $("#usergroupdisplay option:selected");
	for (var i = 0; i < selected.length; i++) {
		for (var j = 0; j < userGroupList.length; j++) {
			if (userGroupList[j].userGroupName == selected[i].value) {
				selectedGroupList.push(userGroupList[j])
			}
		}
		if (allUserGroup != null) {
			selectedGroupList.push(allUserGroup);
		}
	}
	console.log(selectedGroupList);
	$.ajax({
		type : 'POST',
		contentType : "application/json",
		url : "http://localhost:8888/adduser",
		data : JSON.stringify({
			firstName : firstname,
			lastName : lastname,
			userName : username,
			email : email,
			password : password,
			designation : designation,
			groupList : selectedGroupList
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
	document.getElementById("userform").reset();
}