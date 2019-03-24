$(document).ready(function() {
	loadJQGrid();
	$('#taskTable').jqGrid('filterToolbar');
});
function loadJQGrid() {
	jQuery("#taskTable").jqGrid({
		editurl:'clientArray',
	    datatype: "local",
	    loadonce:true,
		colNames : [ 'Task name', 'Task description', 'Action', "Data", "Deadline", "Edit/Delete" ],
		colModel : [ {
			name : 'name',
			editable: true,
			editoptions: {defaultValue: 'New-Task'}
		}, {
			name : 'description',
			editoptions: {defaultValue: 'Add description'},
			editable: true
		}, {
			name : 'action',
			formatter: 'select',
			edittype: 'select',
			sortable: false,
			editoptions: { value: '1:INITIATE;2:APPROVE'},
			stype: 'select',
			searchoptions: { value: '1:INITIATE;2:APPROVE'},
			editable: true
		}, {
			name: "data",
			search:false
		},{
			name: "deadline",
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