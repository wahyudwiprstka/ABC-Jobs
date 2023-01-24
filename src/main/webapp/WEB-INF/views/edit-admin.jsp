<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>  
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login</title>
<style>
@import url('https://fonts.googleapis.com/css2?family=Poppins:wght@300;500;600;700;800;900&display=swap');
</style>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/css/bootstrap.min.css">
<link href='<c:url value="resources/css/navbar.css"/>' rel="stylesheet" type="text/css">
<link href='<c:url value="resources/css/footer.css"/>' rel="stylesheet" type="text/css">
<link href='<c:url value="resources/css/edit-admin.css"/>' rel="stylesheet" type="text/css">
</head>
<body>
	<%@ include file="navbar.jsp" %>

	<div class="form-container">
		<form:form modelAttribute="edit" id="editForm" action="editProcess" onsubmit="return validateForm()" method="post">
			<h3>Edit User Profile</h3>
			<label for="fname">First Name</label>
			<input type="text" name="firstname" id="fname" value="${u.firstname}">
			<div id="fnameError" class="error"><p>Please enter first name!</p></div>
			
			<label for="lname">Last Name</label>
			<input type="text" name="lastname" id="lname" value="${u.lastname}">
			<div id="lnameError" class="error"><p>Please enter last name!</p></div>
			
			<label for="address">Address</label>
			<input type="text" name="address" id="address" value="${u.address}">
			<div id="addressError" class="error"><p>Please enter address!</p></div>
			
			<label for="phnum">Phone Number</label>
			<input type="text" name="phonenumber" id="phnum" value="${u.phonenumber}">
			<div id="phnumError" class="error"><p>Please enter phone number!</p></div>
			
			<label for="company">Company</label>
			<input type="text" name="company" id="company" value="${u.company}">
			<div id="companyError" class="error"><p>Please enter company!</p></div>
			
			<label for="birth">Birth Date</label>
			<input type="date" name="birth" id="birth" value="${u.birth}">
			<div id="birthError" class="error"><p>Please enter birth date!</p></div> 
			
			<label for="admin">Admin</label>
			<input type="number" name="admin" id="admin" value="${u.admin}">
			<div id="adminError" class="error"><p>Please enter admin value</p></div> 
			
			<label for="email">Email</label>
			<input type="text" name="email" id="email" value="${u.email}">
			<div id="emailError" class="error"><p>Please enter email!</p></div> 
			
			<label for="password">Password</label>
			<input type="text" name="password" id="password" value="${u.password}">
			<div id="passwordError" class="error"><p>Please enter password!</p></div> 
			
			<button>Submit</button>
		</form:form>
	</div>

	<%@ include file="footer.jsp" %>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/js/bootstrap.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.6.1/jquery.min.js"></script>
<script src="resources/js/updateValidation.js"></script>
</body>
</html>