function loadData(){
	var totalNoOfWorkflowInstance = 0;
	var totalcompletedWorkflowInstance = 0;
	var totalpendingWorkflowInstance = 0;
	var totalrejectWorkflowInstance = 0;
	$.getJSON("http://localhost:8888/getWorkflows", function(json) {
		$("#dashboardtable").empty();
		var dashboardtable = $("#dashboardtable");

		for (var i = 0; i < json.length; i++) {
			totalNoOfWorkflowInstance = totalNoOfWorkflowInstance + json[i].workflowInstances.length;
			for (var j= 0 ; j < json[i].workflowInstances.length ; j++){
				if(json[i].workflowInstances[j].status == "Completed"){
					totalcompletedWorkflowInstance++;
				} else if(json[i].workflowInstances[j].status == "Running"){
					totalpendingWorkflowInstance++;
				} else {
					totalrejectWorkflowInstance++;
				}
				dashboardtable.append("<th colspan='6'>Workflow::"+json[i].workflowInstances[j].workflowInstanceId+"::"+json[i].workflowName+"</th>")
				for(var k =0 ;k<json[i].taskList.length;k++) {	
					if(json[i].workflowInstances[j].taskInstanceList[k].status == "Completed"){
						dashboardtable.append("<tr style='background-color:#a1f49a'><td>"+json[i].taskList[k].taskName+"</td><td>"+json[i].taskList[k].taskDescription+"</td><td>"+json[i].workflowInstances[j].taskInstanceList[k].status+"</td><td>"+json[i].workflowInstances[j].taskInstanceList[k].username+"</td><td>"+"Completed"+"</td><td>"+json[i].workflowInstances[j].taskInstanceList[k].taskInstaceDeadLine+"</td></tr>");
					} else if(json[i].workflowInstances[j].taskInstanceList[k].status == "Running"){
						dashboardtable.append("<tr style='background-color:#faff70'><td>"+json[i].taskList[k].taskName+"</td><td>"+json[i].taskList[k].taskDescription+"</td><td>"+json[i].workflowInstances[j].taskInstanceList[k].status+"</td><td>"+json[i].workflowInstances[j].taskInstanceList[k].username+"</td><td>"+"Response Awaiting"+"</td><td>"+json[i].workflowInstances[j].taskInstanceList[k].taskInstaceDeadLine+"</td></tr>");
					} else if(json[i].workflowInstances[j].taskInstanceList[k].status == "Pending"){
						dashboardtable.append("<tr style='background-color:#8acbe2'><td>"+json[i].taskList[k].taskName+"</td><td>"+json[i].taskList[k].taskDescription+"</td><td>"+json[i].workflowInstances[j].taskInstanceList[k].status+"</td><td>"+json[i].workflowInstances[j].taskInstanceList[k].username+"</td><td>"+"Response Awaiting"+"</td><td>"+json[i].workflowInstances[j].taskInstanceList[k].taskInstaceDeadLine+"</td></tr>");
					} else{
						dashboardtable.append("<tr style='background-color:#ff817c'><td>"+json[i].taskList[k].taskName+"</td><td>"+json[i].taskList[k].taskDescription+"</td><td>"+json[i].workflowInstances[j].taskInstanceList[k].status+"</td><td>"+json[i].workflowInstances[j].taskInstanceList[k].username+"</td><td>"+"Response Awaiting"+"</td><td>"+json[i].workflowInstances[j].taskInstanceList[k].taskInstaceDeadLine+"</td></tr>");
					}
					
				}
			}
			
		}
		
		$("#totalworkflowinstance").empty();
		var totalworkflowinstance = $("#totalworkflowinstance");	
		totalworkflowinstance.append("<h3 style='display: inline-block'>Total Workflow Instances</h3><h4>"+totalNoOfWorkflowInstance+"</h4>");
		
		$("#completedWorkflowInstance").empty();
		var completedWorkflowInstance = $("#completedWorkflowInstance");	
		completedWorkflowInstance.append("<h3 style='display: inline-block'>Total Completed Workflow Instances</h3><h4>"+totalcompletedWorkflowInstance+"</h4>");
		
		$("#pendingWorkflowInstance").empty();
		var pendingWorkflowInstance = $("#pendingWorkflowInstance");	
		pendingWorkflowInstance.append("<h3 style='display: inline-block'>Total Pending Workflow Instances</h3><h4>"+totalpendingWorkflowInstance+"</h4>");
		
		$("#rejectWorkflowInstance").empty();
		var rejectWorkflowInstance = $("#rejectWorkflowInstance");	
		rejectWorkflowInstance.append("<h3 style='display: inline-block'>Total Rejected Workflow Instances</h3><h4>"+totalrejectWorkflowInstance+"</h4>");
	});

}