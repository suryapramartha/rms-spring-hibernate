<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>


    
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
	<div class="jumbotron">
	<c:forEach var="temp" items="${employeeSelectedAttribute}">
		<p>Employee ID 		: ${temp.emplId}</p>
		<p>Employee Name    : ${temp.emplName}</p>
		<p>Employee Age     : ${temp.emplAge}</p>
		<p>Employee Address : ${temp.emplAddress}</p><br>
		<c:url var="tempEmployee" value="new-competency">
			<c:param name="employeeId" value="${temp.emplId}"></c:param>
		</c:url>
		<c:url var="emplId" value="${temp.emplId}"></c:url>
	</c:forEach>
	</div>
	<table border="1" class="table table-striped">
		<tr>
			<th>ID</th>
			<th>Competency</th>
			<th>Action</th>
		</tr>
		<c:forEach var="x" items="${assignedSkillAttribute}">
			<c:url var="tempDelete" value="delete-competency">
				<c:param name="skillId" value="${x.skillId}"></c:param>
				<c:param name="employeeId" value="${emplId}"></c:param>
			</c:url>
		<tr>
			<td>${x.skillId}</td>
			<td>${x.skillName}</td>
			<td><a href="${tempDelete}" onclick="if(!(confirm('Are you sure?'))) return false">Delete</a></td>
		</tr>
		</c:forEach>
	</table>
	<a href="${pageContext.request.contextPath}">
		<input type="button" class="btn btn-primary" value="Home"></input>
	</a>	
	<a href="${pageContext.request.contextPath}/employee/list">
		<input type="button" class="btn btn-primary" value="Back to Employee List"></input>
	</a>	
		
 	<a href="${tempEmployee}">
 		<button class="btn btn-success"> Assign New Competency </button>
 	</a>   
	</div>
</body>
</html>