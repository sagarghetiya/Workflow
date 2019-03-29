$(document).ready(function() {
	loadJQGrid();
	$('#workflowTable').jqGrid('filterToolbar');
});
function loadJQGrid() {
	jQuery("#workflowTable").jqGrid({
		url:'getWorkflows',
	    datatype: "json",
	    loadonce:true,
		colNames : [ "Workflow ID" ,'Workflow name', 'Workflow description', "Edit/Delete" ],
		colModel : [{
			name: 'workflowId',
			hidden:true
		}, {
			name : 'workflowName'
		}, {
			name : 'workflowDescription'
		}, {
			name : 'action',
			formatter: editFormatter
		}
		],
		autowidth : true,
		height : '400',
		viewrecords : true,
		caption : 'Workflow List'

	});
}
function editFormatter(cellValue, opts, rowObject) {
	return "<i class='fas fa-edit' style='font-size:24px'></i>"	
}

		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
