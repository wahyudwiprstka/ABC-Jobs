<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Profile</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/css/bootstrap.min.css">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.5.0/font/bootstrap-icons.css">
<link href='<c:url value="resources/css/navbar.css"/>' rel="stylesheet" type="text/css">
<link href='<c:url value="resources/css/footer.css"/>' rel="stylesheet" type="text/css">
<link href='<c:url value="resources/css/applylist.css"/>' rel="stylesheet" type="text/css">
</head>
<body>

	<%@ include file = "navbar.jsp" %>
		<div class="content">
			<table>
				<tr>
					<th>Id</th>
					<th>First Name</th>
					<th>Last Name</th>
					<th>Address</th>
					<th>Phone Number</th>
					<th>Job Applied</th>
					<th colspan="2">Action</th>
				</tr>
				<c:forEach items="${UserApplyList}" var="user">
					<tr>
						<td>${user.id}</td>
						<td>${user.firstname}</td>
						<td>${user.lastname}</td>
						<td>${user.address}</td>
						<td>${user.phonenumber}</td>
						<td>${user.applyJob.jobname}</td>
						<td><a href="<%=request.getContextPath()%>/applyjobResponse?id=${user.id}&jobid=${user.applyJob.id}&response=1"><i class="bi bi-check-square-fill"></i></a></td>
						<td><a href="<%=request.getContextPath()%>/applyjobResponse?id=${user.id}&jobid=${user.applyJob.id}&response=0"><i class="bi bi-x-square-fill"></i></a></td>
					</tr>
				</c:forEach>
			</table>
		</div>
	<%@ include file = "footer.jsp" %>
</body>
</html>
