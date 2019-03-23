$(document).ready(function() {
	loadJQGrid();
});
function loadJQGrid() {
	jQuery("#taskTable").jqGrid({
		datatype : "clientSide",
		data : [ {
			"name" : "Task-1",
			"description" : "Take Signature of officer",
			"action" : "Some action",
			"data" : "passbook.jpg",
			"deadline" : "12-12-2021"
		}, {
			"name" : "Task-2",
			"description" : "Go to manager with documents",
			"action" : "Some action",
			"data" : "passbook.jpg",
			"deadline" : "15-12-2021"
		}, {
			"name" : "Task-3",
			"description" : "Approve loan",
			"action" : "Some action",
			"data" : "passbook.jpg",
			"deadline" : "20-12-2021"
		}, ],
		colNames : [ 'Task name', 'Task description', 'Action', "Data", "Deadline" ],
		colModel : [ {
			name : 'name'
		}, {
			name : 'description'
		}, {
			name : 'action'
		}, {
			name: "data"
		},{
			name: "deadline"
		}],
		autowidth : true,
		height : '200',
		sortable: true,
		sortname : 'number',
		viewrecords : true,
		caption : 'Task List',
		altRows : true

	});
	jQuery("#taskTable").sortableRows();
}