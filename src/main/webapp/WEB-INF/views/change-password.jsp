<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>  
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
		<form:form modelAttribute="change-password" id="loginForm" action="changepass-process" onsubmit="return validateForm()" method="post">
			<h3>Change Password</h3>
			<div id="passwordError" class="error"><p>Password should be at least 8 character</p></div>
			<label for="password">Password</label>
			<input type="password" name="password" id="password">
			<label for="password2">Confirm Password</label>
			<input type="password" name="password2" id="password2">
			<button>Submit</button>
		</form:form>
	</div>

	<%@ include file="footer.jsp" %>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/js/bootstrap.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.6.1/jquery.min.js"></script>
<script src="resources/js/changePassValidation.js"></script>
</body>
</html>