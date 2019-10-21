<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Custom login form</title>
</head>
<body>
	<form:form action="${pageContext.request.contextPath}/authenticateTheUser"
				method="POST">
		<c:if test="${param.error != null}">
			<i>Invalid username/password</i>
		</c:if>
		<p>
			Username: <input type="text" name="username"/>
		</p>
		<p>
			Password: <input type="password" name="password"/>
		</p>
		<p>
			<input type="submit" value="Login"/>
		</p>
	</form:form>
</body>
</html>