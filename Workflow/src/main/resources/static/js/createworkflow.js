$(document).ready(function() {
	loadJQGrid();
	$('#taskTable').jqGrid('filterToolbar');
});
function loadJQGrid() {
	jQuery("#taskTable").jqGrid({
		editurl:'clientArray',
	    datatype: "local",
	    loadonce:true,
		colNames : [ 'Task name', 'Task description', 'Action', /*"Data",*/ "Deadline", "Edit/Delete" ],
		colModel : [ {
			name : 'taskName',
			editable: true,
			editoptions: {defaultValue: 'New-Task'}
		}, {
			name : 'taskDescription',
			editoptions: {defaultValue: 'Add description'},
			editable: true
		}, {
			name : 'action',
			formatter: 'select',
			edittype: 'select',
			sortable: false,
			editoptions: { value: '1:INITIATE;2:APPROVE'},
			stype: 'select',
			searchoptions: { value: ':ALL;1:INITIATE;2:APPROVE'},
			editable: true
		}, /*{
			name: "data",
			search:false
		},*/{
			name: "deadLine",
			formatter: "date",
			formatoptions: {srcformat: 'd/m/Y h:i A' ,newformat: "d/m/Y h:i A" },
			editable: true,
			edittype: 'text',
			sortable: true,
			attr: { placeholder: "dd/mm/yyyy hh:mm" },
			editoptions: {defaultValue: "25/12/2019 11:59 PM"}
		},{
			label: "Edit/Delete",
            name: "actions",
            width: 100,
            search:false,
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
		viewrecords : true,
		caption : 'Task List'

	});
	jQuery("#taskTable").sortableRows();
}
// Adds a new row to the jqgrid on clicking add task button
function addEditableTask(){
	var parameters =
	{
	    position :"last",
	    useDefValues : true
	}
    $("#taskTable").jqGrid("addRow", parameters);
	var ids = $("#taskTable").jqGrid('getDataIDs');
	jQuery("#taskTable").jqGrid('saveRow',ids[ids.length-1], false, 'clientArray');
}

$("#workflow_submit").click(function(){
	var localGridData = $("#taskTable").jqGrid('getGridParam','data');
	var workflow_name = $('#workflowname').val();
	var workflow_description = $('#workflowdescription').val();
    $.ajax({
        type: "POST",
        url: "/addWorkflow",
        contentType: "application/json",
        data : JSON.stringify({ workflowName: workflow_name, workflowDescription: workflow_description, taskList: localGridData}),
        dataType:"json",
        contentType: "application/json; charset=utf-8",
        success: function(response, textStatus, xhr) {
            alert("Workflow added successfully");
        },
        error: function(xhr, textStatus, errorThrown) {
            alert("Error occured while adding workflow");
        }
    });
});
