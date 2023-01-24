<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Profile</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/css/bootstrap.min.css">
<link href='<c:url value="resources/css/navbar.css"/>' rel="stylesheet" type="text/css">
<link href='<c:url value="resources/css/footer.css"/>' rel="stylesheet" type="text/css">
<link href='<c:url value="resources/css/profile.css"/>' rel="stylesheet" type="text/css">
</head>
<body>

	<%@ include file = "navbar.jsp" %>

	<div class="profile card d-flex flex-column text-center align-items-center justify-content-center pt-3">
	    <img class="mb-3" src="resources/img/photoprofile.jpg" alt="photo profile">
	    <h3 class="mb-3">${u.firstname} ${u.lastname}</h3>
	    <div class="company d-flex">
	        <b class="me-2">Company: </b>
	        <p>${u.company}</p>
	    </div>
	    <div class="d-flex">
	  		<b class="me-2">Job: </b>
	        <p>${u.job.jobname}</p>
	    </div>
	    <div class="country d-flex">
	        <b class="me-2">Address: </b>
	        <p>${u.address}</p>
	    </div>
	    <div class="birth d-flex">
	        <b class="me-2">Date of Birth: </b>
	        <p>${u.birth}</p>
	    </div>
	    <a href="update-profile"><button class="btn-update">Update Profile</button></a>
	</div>
	
	<%@ include file = "footer.jsp" %>
	
</body>
</html>
