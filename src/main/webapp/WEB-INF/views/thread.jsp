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
<link href='<c:url value="resources/css/thread.css"/>' rel="stylesheet" type="text/css">
</head>
<body>
	<%@ include file="navbar.jsp" %>

	<div class="container">
		<a href="addThread" class="d-flex"><button type="submit" class="btn-thread">Make A Thread</button></a>
		<div class="d-flex flex-column-reverse justify-content-center align-items-center">
			<c:forEach items="${threads}" var="t">
				<div class="thread card p-3 mb-3">
						<div class="d-flex align-items-center mb-3">
							<a href="search-profile?id=${t.user.id}">
								<img class="me-2" src="resources/img/photoprofile.jpg" alt="photo profile"/>
							</a>
							<a href="search-profile?id=${t.user.id}">
								<h4>${t.user.firstname} ${t.user.lastname}</h4>
							</a>
						</div>
					<h4>${t.title}</h4>
					<hr style="width='70%'; margin='auto'">
					<p>${t.content}</p>
					<hr style="width='70%'; margin='auto'">
					<form class="d-flex flex-column align-items-end mb-2" method="GET" action="addComment/${t.id}">
						<textarea class="form-control mb-2" name="content" id="content" rows="2" placeholder="Comment"></textarea>
						<button class="btn-comment align-items-end">Submit</button>
					</form>
					<c:forEach items="${comments}" var="com">
						<c:if test="${com.thread.id == t.id}">
							<div class="d-flex align-items-center mb-2">
								<a href="search-profile?id=${t.user.id}">
									<img class="me-2 photocomment" src="resources/img/photoprofile.jpg" alt="photo profile"/>
								</a>
								<a href="search-profile?id=${t.user.id}" class="me-3">
									<p>${t.user.firstname} ${t.user.lastname}</p>
								</a>
								<p class="comment-content">${com.content}</p>
							</div>
						</c:if>
					</c:forEach>
				</div>
			</c:forEach>
		</div>
	</div>


	<%@ include file="footer.jsp" %>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/js/bootstrap.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.6.1/jquery.min.js"></script>
<script src="resources/js/updateValidation.js"></script>
</body>
</html>