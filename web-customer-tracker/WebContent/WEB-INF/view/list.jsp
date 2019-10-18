<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>List customer</title>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/style.css"/>
</head>
<body>

	<div class="container">
		<input type="button" value="Create customer" onclick="window.location.href='create';" class="add-button"/>
		<div class="content">
			<form:form action="search" method="GET">
				<input type="text" name="keyword" />
				<input type="submit" value="Search" class="save"/>
			</form:form>
			<table>
				<thead>
				<tr>
					<th>First name</th>
					<th>Last name</th>
					<th>Email</th>
					<th>Actions</th>
				</tr>
				</thead>
				<tbody>
					<c:forEach var="customer" items="${customers}">
						<c:url var="updateLink" value="/customer/update">
							<c:param name="id" value="${customer.id}"></c:param>
						</c:url>
						<c:url var="deleteLink" value="/customer/delete">
							<c:param name="id" value="${customer.id}"></c:param>
						</c:url>
						<tr>
							
							<td>${customer.firstName}</td>
							<td>${customer.lastName}</td>
							<td>${customer.email}</td>
							<td>
								<a href="${updateLink}">Update</a> 
								| 
								<a href="${deleteLink}" onclick="if(!confirm('Are you sure?')) return false">Delete</a>
							</td>					
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</div>

</body>
</html>