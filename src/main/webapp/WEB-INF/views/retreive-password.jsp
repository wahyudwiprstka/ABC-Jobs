<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Retreive Password</title>
		
		<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/css/bootstrap.min.css">
		<link href='<c:url value="resources/css/navbar.css"/>' rel="stylesheet" type="text/css">
		<link href='<c:url value="resources/css/footer.css"/>' rel="stylesheet" type="text/css">
		<link href='<c:url value="resources/css/password-retreive.css"/>' rel="stylesheet" type="text/css">
	</head>
	<body>
	
		<%@ include file = "navbar.jsp" %>
	
		<div class="retrievePass">
		    <div 
		    class="container"
		    >
		        <h1 class="mb-3">Retrieve Password</h1>
		        <form onsubmit="return validateForm()" action="retreive-process" method="post">
		            <div class="mb-3">
		                <label for="emailInput" class="form-label">Enter Your Email Address</label>
		                <input type="email" name="email" class="form-control" id="email">
		                <div id="emailError" class="error"><p>Please enter your email!</p></div>
		            </div>
		            <button type="submit" class="btn">Submit</button>
		        </form> 
		    </div>
		</div>
		
		<%@ include file = "footer.jsp" %>
		
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/js/bootstrap.min.js"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.6.1/jquery.min.js"></script>
	<script src="resources/js/retreivepassValidation.js"></script>
	</body>
</html>