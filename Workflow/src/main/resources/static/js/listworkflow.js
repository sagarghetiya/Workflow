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
			name : 'Edit/Delete',
            search:false,
			sortable: false,
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
	return "<div class='text-center'><a href='getworkflow'><i class='fa fa-edit' style='font-size:24px' ></i></a>&nbsp;&nbsp;&nbsp;<a href='deleteworkflow'><i class='fa fa-trash' style='font-size:24px' ></i></a></div>";
}

		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
