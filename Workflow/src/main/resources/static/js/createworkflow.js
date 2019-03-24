$(document).ready(function() {
	loadJQGrid();
});
function loadJQGrid() {
	jQuery("#taskTable").jqGrid({
		datatype : "clientSide",
		data : [ {
			"name" : "Task-1",
			"description" : "Take Signature of officer",
			"action" : "1",
			"data" : "passbook.jpg",
			"deadline" : "12-12-2021"
		}, {
			"name" : "Task-2",
			"description" : "Go to manager with documents",
			"action" : "2",
			"data" : "passbook.jpg",
			"deadline" : "15-12-2021"
		}, {
			"name" : "Task-3",
			"description" : "Approve loan",
			"action" : "2",
			"data" : "passbook.jpg",
			"deadline" : "20-12-2021"
		}, ],
		colNames : [ 'Task name', 'Task description', 'Action', "Data", "Deadline", "Edit/Delete" ],
		colModel : [ {
			name : 'name',
			editable: true
		}, {
			name : 'description',
			editable: true
		}, {
			name : 'action',
			formatter: 'select',
			edittype: 'select',
			sortable: false,
			editoptions: { value: '1:INITIATE;2:APPROVE'},
			editable: true
		}, {
			name: "data"
		},{
			name: "deadline",
			formatter: "date",
			formatoptions: { newformat:'d-M-y H:i'},
			editable: true,
			editoptions: { dataInit: function(el) { setTimeout(function() { $(el).datetimepicker(); }, 200); } } 
		},{
			label: "Edit/Delete",
            name: "actions",
            width: 100,
            formatter: "actions",
            formatoptions: {
                keys: true,
                editOptions: {},
                addOptions: {},
                delOptions: {}
            },
			sortable: false
        }
        ],
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
// Adds a new row to the jqgrid on clicking add task button
function addEditableTask(){
    $("#taskTable").jqGrid('addRow',"new");
}