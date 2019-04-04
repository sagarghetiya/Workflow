$(document).ready(function() {
	loadJQGrid();
	$('#taskTable').jqGrid('filterToolbar');
});
function loadJQGrid() {
	jQuery("#taskTable").jqGrid({
		editurl:'clientArray',
	    datatype: "local",
	    loadonce:true,
		colNames : [ 'Task name', 'Task description', 'Message', 'Action', "Notificaton Status", "Deadline", "Edit/Delete" ],
		colModel : [ {
			name : 'taskName',
            width: 60,
			editable: true,
			editoptions: {defaultValue: 'Task-Name'}
		}, {
			name : 'taskDescription',
			editoptions: {defaultValue: 'Description of task'},
            width: 100,
			editable: true
		},{
			name : 'message',
			editoptions: {defaultValue: 'Message to be sent on completion of task'},
			editable: true
		}, 
		{
			name : 'action',
			formatter: 'select',
			edittype: 'select',
			sortable: false,
            width: 70,
			editoptions: { value: 'INITIATE:INITIATE;APPROVE:APPROVE;REJECT:REJECT'},
			stype: 'select',
			searchoptions: { value: ':ALL;INITIATE:INITIATE;APPROVE:APPROVE;REJECT:REJECT'},
			editable: true
		},{
			name : 'notificationStatus',
			formatter: 'select',
			edittype: 'select',
			sortable: false,
			 width: 70,
			editoptions: { value: 'ANY:ANY;ALL:ALL'},
			stype: 'select',
			searchoptions: { value: ':ALL;ANY:ANY;ONE:ONE'},
			editable: true
		},
		{
			/*name: "deadLine",
			formatter: "date",
			formatoptions: {srcformat: 'd/m/Y h:i A' ,newformat: "d/m/Y h:i A" },
			editable: true,
			edittype: 'text',
			sortable: true,
			attr: { placeholder: "dd/mm/yyyy hh:mm" },
			editoptions: {defaultValue: "25/12/2019 11:59 PM"}*/
			name:"deadLine",
			editable: true,
			editoptions: {defaultValue: 'Relative(dd)/Absolute(dd/mm/yyyy hh:mm)'},
			sortable: false
				
		},{
			label: "Edit/Delete",
            name: "actions",
            width: 40,
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
