<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Home</title>
</head>
<body>
	<h1>Home</h1>
	
	<p>
		User: 	<security:authentication property="principal.username"/>
		<br/>
		Roles: <security:authentication property="principal.authorities"/>
	</p>
	
	<form:form  action="${pageContext.request.contextPath}/logout"	
	method="POST">
		<button class="btn btn-lg btn-primary btn-block" type="submit">Logout</button>
	</form:form>
</body>
</html>