$(function(){
	$(".error").hide();
})

function validateForm(){
	let password = $("#password").val();
	let password2 = $("#password2").val();
	
	// password validation
	if(password.length < 8){
		$("#passwordError").show();
		return false;
	}else if(password2 != password){
		$("#passwordError").html("<p>Password not same!</p>");
		return false;
	}else{
		$("#passwordError").hide();
	}
}