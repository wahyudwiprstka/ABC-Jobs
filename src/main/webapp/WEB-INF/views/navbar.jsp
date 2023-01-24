<%@page import="com.abcjob.bean.User"%>
<% User user = (User) session.getAttribute("user");
	if(user==null){
%>
	<%@ include file = "navbar-guest.jsp" %>
<% }else{
	int admin = user.getAdmin();
		if(admin == 1){%>
			<%@ include file = "navbar-admin.jsp" %>
		<%}else{%>	
			<%@ include file = "navbar-logedin.jsp" %>
<% }} %>