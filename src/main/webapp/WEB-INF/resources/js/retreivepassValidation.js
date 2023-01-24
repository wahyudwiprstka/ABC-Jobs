$(function(){
	$(".error").hide();
})

function validateForm(){
	let email = $("#email").val();
	
	// email validation
	if(email == ""){
		$("#emailError").show();
		return false;
	}else if(!(email.includes("@") && email.includes("."))){
		$("#emailError").html("<p>Enter a correct email address!</p>");
		$("#emailError").show();
		return false;
	}else{
		$("#emailError").hide();
	}
}