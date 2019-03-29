$(document).ready(function() {
	loadJQGrid();
	$('#taskTable').jqGrid('filterToolbar');
});
function loadJQGrid() {
	jQuery("#taskTable").jqGrid({
		editurl:'clientArray',
	    datatype: "local",
	    loadonce:true,
		colNames : [ 'Task name', 'Task description', 'Action', "Deadline", "Edit/Delete" ],
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
			editoptions: { value: 'INITIATE:INITIATE;APPROVE:APPROVE'},
			stype: 'select',
			searchoptions: { value: ':ALL;INITIATE:INITIATE;APPROVE:APPROVE'},
			editable: true
		},
		{
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
	var localGridData = $("#taskTable").jqGrid('getRowData');
	var workflow_name = $('#workflowname').val();
	var workflow_description = $('#workflowdescription').val();
    $.ajax({
        type: "POST",
        url: "/addWorkflow",
        contentType: "application/json",
        data : JSON.stringify({ workflowName: workflow_name, workflowDescription: workflow_description, taskList: localGridData}),
        dataType:"json",
        contentType: "application/json; charset=utf-8",
        statusCode : {
        	200: function(){
        		$('#sucess_Modal').modal('show');
        	},
    		500: function(){
    			$('#failure_Modal').modal('show');
    		}
        }
    });
});

function clearFields(){
	document.getElementById("createWorkflowForm").reset();
	$('#taskTable').jqGrid('GridUnload'); 
	loadJQGrid();
}
