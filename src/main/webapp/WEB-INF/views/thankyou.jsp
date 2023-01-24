<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Thank You For Registering</title>
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/css/bootstrap.min.css" rel="stylesheet">
	<style>
	@import url('https://fonts.googleapis.com/css2?family=Poppins:wght@300;500;600;700;800;900&display=swap');
	</style>
	<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/css/bootstrap.min.css">
	<link href='<c:url value="resources/css/navbar.css"/>' rel="stylesheet" type="text/css">
	<link href='<c:url value="resources/css/footer.css"/>' rel="stylesheet" type="text/css">
	<link href='<c:url value="resources/css/ty.css"/>' rel="stylesheet" type="text/css">
</head>
<body>
	<%@include file="navbar.jsp" %>
	
	<div class="ty-container">
		<h3>Your Registration Has Done Successfully!</h3>
		<p>Thank you for registering in ABC Job Portal</p>
		<a href="./"><button>Back To Homepage</button></a>
	</div>
	
	<%@ include file="footer.jsp" %>
	
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/js/bootstrap.min.js"></script>
</body>
</html>