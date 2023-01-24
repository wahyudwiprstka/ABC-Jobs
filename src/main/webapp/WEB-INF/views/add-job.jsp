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
<link href='<c:url value="resources/css/addjob.css"/>' rel="stylesheet" type="text/css">
</head>
<body>
	<%@ include file="navbar.jsp" %>

	<div class="container card">
		<h3 class="text-center mt-3">Add Job</h3>
		<form:form modelAttribute="addjob" id="addjob" action="addjobProcess">
			    <input type="text" class="form-control mb-2" id="jobname" name="jobname" placeholder="Job Name">
			    <input type="text" class="form-control mb-2" id="company" name="company" placeholder="Company">
			    <input type="text" class="form-control mb-2" id="region" name="region" placeholder="Region">
			    <div class="salary input-group">
				  <span class="input-group-text" id="basic-addon1">$</span>
				  <input type="text" class="form-control" name="salary" id="salary" placeholder="Salary" aria-describedby="salaryaddon">
				</div>
			    <textarea class="form-control" name="description" id="jobdesc" rows="5" placeholder="Job Description"></textarea>
			  <button type="submit" class="text-center">Submit</button>
		</form:form>
	</div>


	<%@ include file="footer.jsp" %>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/js/bootstrap.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.6.1/jquery.min.js"></script>
<script src="resources/js/updateValidation.js"></script>
</body>
</html>