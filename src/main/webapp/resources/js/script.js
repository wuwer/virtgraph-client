function setActive(element){
	element.classList.remove("row");
	element.classList.add("activerow");
	// classList.toggle("name")
}

function startvm(element, vmidArg, hostAddrArg) {
	if ($(element).hasClass("row"))
	{
		element.classList.remove("row");
		element.classList.add("activerow");
	}
	else
	{
		element.classList.remove("activerow");
		element.classList.add("row");
		
	}
	console.log("Attempting to start the vm");
	
	//var jq = jquery.noconflict();
	$(function () {
		$.post("/virtgraph-client/startvm",
//				{},
				{vmid: vmidArg, hostAddr: hostAddrArg},
				function (data) {
//					jq("#sum").replacewith('<span id="sum">' + data + '</span>');
				});
	});
}

function startservice(element, serviceNameArg, vmidArg, hostAddrArg) {
	element.classList.remove("row");
	element.classList.add("activerow");
	console.log("Attempting to start the vm");
	
	//var jq = jquery.noconflict();
	$(function () {
		$.post("/virtgraph-client/startservice",
//				{},
				{vmid: vmidArg, hostAddr: hostAddrArg, serviceName: serviceNameArg},
				function (data) {
//					jq("#sum").replacewith('<span id="sum">' + data + '</span>');
				});
	});
}