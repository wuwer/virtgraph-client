function setActive(element){
	element.classList.remove("row");
	element.classList.add("activerow");
	// classList.toggle("name")
}

function startvm(element) {
	element.classList.remove("row");
	element.classList.add("activerow");
	
	//var jq = jquery.noconflict();
	$(function () {
		$.post("/virtgraph-client/startvm",
//				{},
				{vmid: "fakeid"},
				function (data) {
//					jq("#sum").replacewith('<span id="sum">' + data + '</span>');
				});
	});
}