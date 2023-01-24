<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Search</title>
		
		<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/css/bootstrap.min.css">
		<link href='<c:url value="resources/css/navbar.css"/>' rel="stylesheet" type="text/css">
		<link href='<c:url value="resources/css/footer.css"/>' rel="stylesheet" type="text/css">
		<link href='<c:url value="resources/css/search-result.css"/>' rel="stylesheet" type="text/css">
		</head>
	<body>
	<%@ include file = "navbar.jsp" %>
		<h5 style="margin-left: 10vw">Search result for "${searchVal}"</h5>
		<div class="result">
		<c:forEach items="${listUser}" var="user" >
			<div class="box-result">
		        <a href="search-profile?id=${user.id}">
		        <div class="container card d-flex flex-row mb-3" >
		            <div class="photoprofile"><img src="resources/img/photoprofile.jpg" alt="Photo Profile"></div>
		            <div class="ms-5 d-flex flex-column justify-content-center">
		                <h3>${user.firstname} ${user.lastname}</h3>
		                <h4>${user.company}</h4>
		                <p>${user.address}<p>
		            </div>
		        </div>
		        </a>
		    </div>
		</c:forEach>
		</div>
	<%@ include file = "footer.jsp" %>
	
	</body>
</html>