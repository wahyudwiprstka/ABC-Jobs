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
		<link href='<c:url value="resources/css/search.css"/>' rel="stylesheet" type="text/css">
		</head>
	<body>
		<%@ include file = "navbar.jsp" %>
		<section class="search">
		    <form class="search d-flex flex-column align-items-center" action="result">
		        <input name="searchVal" placeholder="Type Something Here">
		        <button class="btn-search btn btn-outline-success" type="submit">Search</button>
		    </form>
		</section>
		<%@ include file = "footer.jsp" %>
	</body>
</html>