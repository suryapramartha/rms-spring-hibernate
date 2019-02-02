<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
    
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<meta name="author" content="Mitrais">
  	<meta name="viewport" content="width=device-width, initial-scale=1.0">
  	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/bootstrap.min.css">   		
    <script src="${pageContext.request.contextPath}/resources/js/bootstrap.min.js"></script>     
<title>Competency List</title>
</head>
<body>
<div class="container">
<h1 align="left">Competency List</h1>
<table border="1" class="table table-striped">
	<tr>
		<th>ID</th>
		<th>Name</th>
		<th>Description</th>
		<th>Status</th>
		<th>Action</th>
	</tr>
	<c:forEach var="x" items="${skillAttribute}">
		<c:url var="tempUpdate" value="edit">
			<c:param name="skillId" value="${x.skillId}"></c:param>
		</c:url>
		<c:url var="tempDelete" value="delete">
			<c:param name="skillId" value="${x.skillId}"></c:param>
		</c:url>
		<tr>
			<td>${x.skillId}</td>
			<td>${x.skillName}</td>
			<td>${x.skillDesc}</td>
			<td>${x.skillStatus}</td>
			<td><a href="${tempUpdate}">Edit</a> | 
			<a href="${tempDelete}" onclick="if(!(confirm('Are you sure?'))) return false">Delete</a></td>
		</tr>
	</c:forEach>
</table>
<a href="${pageContext.request.contextPath}">
	<input type="button" class="btn btn-primary" value="Back to Home"></input>
</a>
	<a href="${pageContext.request.contextPath}/skill/new">
		<input type="button" class="btn btn-success" value="Add New Skill"></input>
	</a>
 
</div>

</body>
</html>