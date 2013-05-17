
function setActive(element){
	element.classList.remove("row");
	element.classList.add("activerow");
	// classList.toggle("name")
}

function add() {
	var jq = jQuery.noConflict();
	jq(function () {
		jq.post("/spring-mvc-jquery/krams/main/ajax/add",
				{inputNumber1: jq("#inputNumber1").val(),
				inputNumber2: jq("#inputNumber2").val() },
				function (data) {
					// data contains the result
					// Assign result to the sum id
					jq("#sum").replaceWith('<span id="sum">' + data + '</span>');
				});
	});
}
