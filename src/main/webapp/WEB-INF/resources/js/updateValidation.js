$(function(){
	$(".error").hide();
})

function validateForm(){
	let fname = $("#fname").val();
	let lname = $("#lname").val();
	let address = $("#address").val();
	let phnum = $("#phnum").val();
	let company = $("#company").val();
	let birth = $("#birth").val();
	let admin = $("#admin").val();
	let email = $("#email").val();
	let password = $("#password").val();
	
	// first name validation
	if(fname == ""){
		$("#fnameError").show();
		return false;
	}else{
		$("#fnameError").hide()
	}
	
	// last name validation
	if(lname == ""){
		$("#lnameError").show();
		return false;
	}else{
		$("#lnameError").hide()
	}
	
	// address validation
	if(address == ""){
		$("#addressError").show();
		return false;
	}else{
		$("#addressError").hide();
	}
	
	// phone number validation
	if(phnum.length < 12){
		$("#phnumError").show();
		return false;
	}else if(isNaN(parseFloat(phnum))){
		$("#phnumError p").html("Don't input anything except numbers!");
		$("#phnumError").show();
		return false;
	}else{
		$("#phnumError").hide();
	}
	
	// company validation
	if(company == ""){
		$("#companyError").show();
		return false;
	}else{
		$("#companyError").hide();
	}
	
	// birth validation
	if(birth == ""){
		$("#birthError").show();
		return false;
	}else{
		$("#birthError").hide();
	}
	
	// admin validation
	if(admin == ""){
		$("#adminError").show();
		return false;
	}else{
		$("#adminError").hide();
	}
	
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
	
	// password validation
	if(password.length < 8){
		$("#passwordError").show();
		return false;
	}
}