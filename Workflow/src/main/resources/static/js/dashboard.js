
$("#display").click(function() {
	var totalNoOfWorkflowInstance = 0;
	$.getJSON("http://localhost:8888/getWorkflows", function(json) {
		$("#dashboardtable").empty();
		var dashboardtable = $("#dashboardtable");
		
//		//$("#total").empty();
//		var total = $("#total");
//		total.append("<h3>Total</h3><h3>Workflows</h3><h4>43</h4>");
//		
//		//$("#total1").empty();
//		var total1 = $("#total1");
//		total1.append("<h3>Total</h3><h3>Workflows</h3><h4>43</h4>");
//		
//		//$("#total2").empty();
//		var total2 = $("#total2");
//		total2.append("<h3>Total</h3><h3>Workflows</h3><h4>43</h4>");
//		
//		//$("#total3").empty();
//		var total3 = $("#total3");
//		total3.append("<h3>Total</h3><h3>Workflows</h3><h4>43</h4>");
		
		for (var i = 0; i < json.length; i++) {
			totalNoOfWorkflowInstance = totalNoOfWorkflowInstance + json[i].workflowInstances.length;
			for (var j= 0 ; j < json[i].workflowInstances.length ; j++){
				dashboardtable.append("<th colspan='6'>Workflow::"+json[i].workflowInstances[j].workflowInstanceId+"::"+json[i].workflowName+"</th>")
				for(var k =0 ;k<json[i].taskList.length;k++) {	
					if(json[i].workflowInstances[j].taskInstanceList[k].status == "Completed"){
						dashboardtable.append("<tr style='background-color:#a1f49a'><td>"+json[i].taskList[k].taskName+"</td><td>"+json[i].taskList[k].taskDescription+"</td><td>"+json[i].workflowInstances[j].taskInstanceList[k].status+"</td><td>"+json[i].workflowInstances[j].taskInstanceList[k].username+"</td><td>"+json[i].taskList[k].action+"</td><td>"+json[i].workflowInstances[j].taskInstanceList[k].taskInstaceDeadLine+"</td></tr>");
					} else if(json[i].workflowInstances[j].taskInstanceList[k].status == "Running"){
						dashboardtable.append("<tr style='background-color:#faff70'><td>"+json[i].taskList[k].taskName+"</td><td>"+json[i].taskList[k].taskDescription+"</td><td>"+json[i].workflowInstances[j].taskInstanceList[k].status+"</td><td>"+json[i].workflowInstances[j].taskInstanceList[k].username+"</td><td>"+json[i].taskList[k].action+"</td><td>"+json[i].workflowInstances[j].taskInstanceList[k].taskInstaceDeadLine+"</td></tr>");
					} else if(json[i].workflowInstances[j].taskInstanceList[k].status == "Pending"){
						dashboardtable.append("<tr style='background-color:#8acbe2'><td>"+json[i].taskList[k].taskName+"</td><td>"+json[i].taskList[k].taskDescription+"</td><td>"+json[i].workflowInstances[j].taskInstanceList[k].status+"</td><td>"+json[i].workflowInstances[j].taskInstanceList[k].username+"</td><td>"+json[i].taskList[k].action+"</td><td>"+json[i].workflowInstances[j].taskInstanceList[k].taskInstaceDeadLine+"</td></tr>");
					} else{
						dashboardtable.append("<tr style='background-color:#ff817c'><td>"+json[i].taskList[k].taskName+"</td><td>"+json[i].taskList[k].taskDescription+"</td><td>"+json[i].workflowInstances[j].taskInstanceList[k].status+"</td><td>"+json[i].workflowInstances[j].taskInstanceList[k].username+"</td><td>"+json[i].taskList[k].action+"</td><td>"+json[i].workflowInstances[j].taskInstanceList[k].taskInstaceDeadLine+"</td></tr>");
					}
					
				}
			}
			
		}
	});

});