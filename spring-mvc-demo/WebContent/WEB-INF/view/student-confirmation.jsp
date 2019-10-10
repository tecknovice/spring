<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Student confirmation</title>
</head>
<body>
<p>Student name: ${student.firstName} ${student.lastName}</p>
<p>Country: ${student.country}</p>
<p>Favorite language: ${student.favoriteLanguage}</p>
<p> Operating System:
	<ul>
	<c:forEach var="os" items="${student.operatingSystems}">
		<li>${os}</li>
	</c:forEach>
	</ul>
</p>
</body>
</html>