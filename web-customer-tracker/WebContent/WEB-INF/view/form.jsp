<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/style.css"/>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/add-customer-style.css"/>
</head>
<body>
 <div id="container">
 	<form:form action="save" modelAttribute="customer" method="POST">
 		<form:hidden path="id"/>
 		<label> First name: </label><form:input path="firstName"/>
 		<br/>
 		<label>Last name: </label><form:input path="lastName"/>
 		<br/>
 		<label>Email: </label><form:input path="email"/>
 		<br/>
 		<label></label><input type="submit" value="Save" class="save"/>
 	</form:form>
 	<a href="${pageContext.request.contextPath}/customer/list">back to list</a>
 </div>
</body>
</html>