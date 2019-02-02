<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
  	<meta name="author" content="Mitrais">
  	<meta name="viewport" content="width=device-width, initial-scale=1.0">
  	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/bootstrap.min.css">   		
    <script src="${pageContext.request.contextPath}/resources/js/bootstrap.min.js"></script>    
<title>New Employee Form</title>
</head>
<body>
	<div class="container">
		<h1>New Employee Form</h1>
		<form:form action="save" modelAttribute="employeeAttribute" method="POST">
			<div class="form-group">
				<table border="1" width="75%">
					<tr>
						<td width="25%">Employee Name</td>
						<td><form:input type="text" path="emplName" required="required" class="form-control"></form:input></td>
					</tr>
					<tr>
						<td>Employee Age</td>
						<td><form:input type="number" path="emplAge" min="0" required="required" class="form-control"></form:input></td>
					</tr>	
					<tr>
						<td>Employee Address</td>
						<td><form:input type="text" path="emplAddress"  multiple="multiple" required="required" class="form-control"></form:input></td>
					</tr>
				</table>
				<br><input type="submit" value="Create" class="btn btn-success">
			</div>
		</form:form>
		<a href="${pageContext.request.contextPath}/employee/list">
			<input type="button" class="btn btn-primary" value="Cancel"></input>
		</a>
	</div>	
</body>
</html>