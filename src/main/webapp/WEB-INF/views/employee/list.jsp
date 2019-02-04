<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<%@taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
    
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Employee List</title>	
	<meta name="author" content="Mitrais">
  	<meta name="viewport" content="width=device-width, initial-scale=1.0">
  	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/bootstrap.min.css">   		
    <script src="${pageContext.request.contextPath}/resources/js/bootstrap.min.js"></script>     
</head>
<body>
<div class="container">
	<h1 align="left">Employee List</h1>
	<table border="1" class="table table-striped">
		<tr>
			<th>ID</th>
			<th>Name</th>
			<th>Status</th>
			<th>Age</th>
			<th>Address</th>
			<th>Action</th>
		</tr>
		<c:forEach var="x" items="${employeeAttribute}">
			<c:url var="tempUpdate" value="edit">
				<c:param name="employeeId" value="${x.emplId}"></c:param>
			</c:url>
			<c:url var="tempDelete" value="delete">
				<c:param name="employeeId" value="${x.emplId}"></c:param>
			</c:url>
			<c:url var="tempCompetency" value="view-competency">
				<c:param name="employeeId" value="${x.emplId}"></c:param>
			</c:url>
			<tr>
				<td>${x.emplId}</td>
				<td>${x.emplName}</td>
				<td>${x.emplStatus}</td>
				<td>${x.emplAge}</td>
				<td>${x.emplAddress}</td>
				<td>
					<a href="${tempUpdate}">Edit |</a>
					<security:authorize access="hasRole('ADMIN')">
						<a href="${tempDelete}" onclick="if(!(confirm('Are you sure?'))) return false">Delete</a> | 	
					</security:authorize>		
					<a href="${tempCompetency}">View Competency</a>
				</td>
			</tr>
		</c:forEach>
	</table> 
	<a href="${pageContext.request.contextPath}">
		<input type="button" class="btn btn-primary" value="Back to Home"></input>
	</a>
	
	<security:authorize access="hasRole('ADMIN')">
		<a href="${pageContext.request.contextPath}/employee/new">
			<input type="button" class="btn btn-success" value="Add New Employee"></input>
		</a>
	</security:authorize>
	</div>

</body>
</html>