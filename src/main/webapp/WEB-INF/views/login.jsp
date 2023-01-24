<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
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
<link href='<c:url value="resources/css/login.css"/>' rel="stylesheet" type="text/css">
</head>
<body>
	<%@ include file="navbar.jsp" %>

	<div class="form-container">
		<form id="loginForm" action="loginProcess" onsubmit="return validateForm()" method="post">
			<h3>Login</h3>
			<div id="wrongData"><p>${msg}</p></div>
			<label for="email">Email</label>
			<input type="text" name="email" id="email">
			<div id="emailError" class="error"><p>Please enter your email!</p></div>
			<label for="password">Password</label>
			<input type="password" name="password" id="password">
			<div id="passwordError" class="error"><p>Password should be at least 8 character</p></div>
			<button>Submit</button>
			<a href="retreive-password">Forget Password?</a>
		</form>
	</div>

	<%@ include file="footer.jsp" %>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/js/bootstrap.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.6.1/jquery.min.js"></script>
<script src="resources/js/loginValidation.js"></script>
</body>
</html>