<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Customer confirmation</title>
</head>
<body>
	<p>Customer name: ${customer.firstName} ${customer.lastName}</p>
	<p>Free passes: ${customer.freePasses}</p>
	<p>Postal code: ${customer.postalCode}</p>
	<p>Course code: ${customer.courseCode}</p>
</body>
</html>