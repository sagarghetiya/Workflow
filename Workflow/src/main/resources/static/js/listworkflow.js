$(document).ready(function() {
	loadJQGrid();
	$('#workflowTable').jqGrid('filterToolbar');
});
function loadJQGrid() {
	jQuery("#workflowTable").jqGrid(
			{
				url : 'getWorkflows',
				datatype : "json",
				loadonce : true,
				colNames : [ "Workflow ID", 'Workflow name',
						'Workflow description', "Edit/Delete" ],
				colModel : [ {
					name : 'workflowId',
					hidden : true
				}, {
					name : 'workflowName'
				}, {
					name : 'workflowDescription'
				}, {
					name : 'Edit/Delete',
					search : false,
					sortable : false,
					formatter : editFormatter
				} ],
				autowidth : true,
				height : '400',
				viewrecords : true,
				caption : 'Workflow List'

	});
}
function editFormatter(cellValue, opts, rowObject) {
	console.log("Data::" + rowObject.isDeleted);
	if (rowObject.isDeleted == false) {
		return "<div class='text-center'><input type='button' value='Inactivate' style='background-color:#e51b1b' onClick='doDelete("
				+ rowObject.workflowId + ",1)'></div>";
	} else {
		return "<div class='text-center'><input type='button' value='Activate' onClick='doDelete("
				+ rowObject.workflowId + ",0)'></div>";
	}
}

function doDelete(i,j){
	$.ajax({
		type : 'GET',
		contentType : "application/json",
		url : "http://localhost:8888/deleteWorkflow/"+i+"_"+j,
		dataType : "json",
		contentType : "application/json; charset=utf-8",
		statusCode : {
			200 : function() {
				$('#workflowTable').jqGrid('GridUnload');
				loadJQGrid();
				$('#workflowTable').jqGrid('filterToolbar');
				$('#sucess_Modal').modal('show');
			},
			201 : function() {
				$('#failure_Modal').modal('show');
			}
		}
	});
}