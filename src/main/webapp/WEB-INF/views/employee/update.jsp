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
<title>Update Employee</title>
</head>
<body>
<div class="container">
	<h1>Update Employee</h1>
	<div class="form-group">
	<form:form action="${pageContext.request.contextPath}/employee/update" method="POST" modelAttribute="employeeSelectedAttribute">
		<table border="1">
			<c:forEach var="x" items="${employeeSelectedAttribute}">
				<tr>
					<td>Employee ID</td>
					<td><input type="text" name="emplId" readonly="readonly" value="${x.emplId}" class="form-control"></input></td>
				</tr>
				<tr>
					<td>Employee Name</td>
					<td><input type="text" name="emplName" value="${x.emplName}" required="required" class="form-control"></input></td>
				</tr>
				<tr>
					<td>Employee Status</td>
					<td><input type="text"  name="emplStatus" readonly="readonly" value="${x.emplStatus}" class="form-control"></input></td>
				</tr>
				<tr>
					<td>Employee Age</td>
					<td><input type="number" name="emplAge" min="0" value="${x.emplAge}" required="required" class="form-control"></input></td>
				</tr>
				<tr>
					<td>Employee Address</td>
					<td><input type="text" name="emplAddress" value="${x.emplAddress}" required="required" class="form-control" ></input></td>
				</tr>
			</c:forEach>
		</table>
		<br><input type="submit" value="Update" class="btn btn-success">
	</form:form>
	</div>
	<a href="${pageContext.request.contextPath}/employee/list">
	<input type="button" class="btn btn-primary" value="Cancel"></input> 
	</a>
	</div>
</body>
</html>