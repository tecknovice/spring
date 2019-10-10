<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Student form</title>
</head>
<body>
	<form:form action="process-form" modelAttribute="student">
		First name: <form:input path="firstName"/>
		<br>
		Last name: <form:input path="lastName"/>
		<br>
		Country: 
		<form:select path="country">
			<form:options items="${student.countryOptions}"/>
		</form:select>
		<br>
		Favorite language: 
		<form:radiobuttons path="favoriteLanguage" items="${student.favoriteLanguageOptions}"/>
		<br>
		Operating Systems: 
		Linux <form:checkbox path="operatingSystems" value="Linux"/>
		Mac <form:checkbox path="operatingSystems" value="Mac"/>
		Windows <form:checkbox path="operatingSystems" value="Windows"/>
		<br>
		<input type="submit" value="Submit"/>
	</form:form>
</body>
</html>