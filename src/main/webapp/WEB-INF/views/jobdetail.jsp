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
<link href='<c:url value="../resources/css/navbar.css"/>' rel="stylesheet" type="text/css">
<link href='<c:url value="../resources/css/footer.css"/>' rel="stylesheet" type="text/css">
<link href='<c:url value="../resources/css/jobdetail.css"/>' rel="stylesheet" type="text/css">
</head>
<body>
	<%@ include file="navbar.jsp" %>
	<div class="content">

		<div class="container job d-flex flex-row justify-content-between align-items-center">
			<div>
				<h3 class="">${job.jobname}</h3>
				<h5>${job.company}<br><br>${job.region}<br>$${job.salary}</h5>
			</div>
			<div>
				<c:choose>
					<c:when test="${status=='1'}"><button disabled>Applied</button></c:when>
					<c:otherwise><a href="${job.id}/apply"><button>Apply Now</button></a></c:otherwise>
				</c:choose>
			</div>
		</div>
		<hr style="width: 70%; margin: 20px auto;">
		<div class="container description">
			<h3>Description</h3>
			<p>${job.description}</p>
		</div>

	</div>

	<%@ include file="footer.jsp" %>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/js/bootstrap.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.6.1/jquery.min.js"></script>
<script src="resources/js/updateValidation.js"></script>
</body>
</html>