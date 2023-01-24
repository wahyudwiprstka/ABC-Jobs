<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>  
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Job List</title>
<style>
@import url('https://fonts.googleapis.com/css2?family=Poppins:wght@300;500;600;700;800;900&display=swap');
</style>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/css/bootstrap.min.css">
<link href='<c:url value="resources/css/navbar.css"/>' rel="stylesheet" type="text/css">
<link href='<c:url value="resources/css/footer.css"/>' rel="stylesheet" type="text/css">
<link href='<c:url value="resources/css/job.css"/>' rel="stylesheet" type="text/css">
</head>
<body>
	<%@ include file="navbar.jsp" %>

	<div class="job">
		<h3 class="text-center">Job List</h3>
		<div class="container">
			<c:forEach items="${jobs}" var="jobs">
				<a href="job/${jobs.id}">
					<div class="item card">
						<h4>${jobs.jobname}</h4>
						<p>${jobs.company}<p>
						<br>
						<h6>${jobs.region}<br>$ ${jobs.salary}</h6>
					</div>
				</a>
			</c:forEach>
		</div>
	</div>


	<%@ include file="footer.jsp" %>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/js/bootstrap.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.6.1/jquery.min.js"></script>
<script src="resources/js/updateValidation.js"></script>
</body>
</html>