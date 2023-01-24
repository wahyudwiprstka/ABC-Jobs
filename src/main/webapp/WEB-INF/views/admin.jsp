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
<link href='<c:url value="resources/css/admin.css"/>' rel="stylesheet" type="text/css">
</head>
<body>

	<%@ include file = "navbar.jsp" %>
		<div class="content">
		<div class="d-flex">
			<a href="add"><button class="btn-add mx-1">Add User</button></a>
			<a href="addjob"><button class="btn-add mx-1">Add Job</button></a>
			<a href="applyjobList"><button class="btn-add mx-1">Apply Job List</button></a>
		</div>
			<table>
				<tr>
					<th>Id</th>
					<th>First Name</th>
					<th>Last Name</th>
					<th>Address</th>
					<th>Phone Number</th>
					<th>Birth Date</th>
					<th>Company</th>
					<th>Email</th>
					<th>Password</th>
					<th colspan="2">Action</th>
				</tr>
				<c:forEach items="${listUser}" var="user">
					<tr>
						<td>${user.id}</td>
						<td>${user.firstname}</td>
						<td>${user.lastname}</td>
						<td>${user.address}</td>
						<td>${user.phonenumber}</td>
						<td>${user.birth}</td>
						<td>${user.company}</td>
						<td>${user.email}</td>
						<td>${user.password}</td>
						<td><a href="edit?id=${user.id}">Edit</a></td>
						<td><a href="delete-user?id=${user.id}">Delete</a></td>
					</tr>
				</c:forEach>
			</table>
		</div>
	<%@ include file = "footer.jsp" %>
</body>
</html>
