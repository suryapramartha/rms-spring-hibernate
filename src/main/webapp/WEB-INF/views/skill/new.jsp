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
<title>New Competency Form</title>
</head>
<body>
<div class="container">
<h1>New Competency Form</h1>
	<form:form action="save" method="POST" modelAttribute="skillAttribute">
		<div class="form-group">
		<table border="1" width="75%">
			<tr>
				<td width="30%">Competency Name</td>
				<td><form:input type="text" path="skillName" required="required" maxlength="50" class="form-control"></form:input></td>
			</tr>
			<tr>
				<td>Competency Description</td>
				<td><form:input type="text" path="skillDesc" multiple="true" maxlength="200" class="form-control"></form:input></td>
			</tr>
		</table>
		<br><input type="submit" value="Create" class="btn btn-success">
		</div>
	</form:form>
		<a href="${pageContext.request.contextPath}/skill/list">
			<input type="button" class="btn btn-primary" value="Cancel"></input>
		</a></div>	

</body>
</html>