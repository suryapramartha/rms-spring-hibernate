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
<title>Update Competency</title>
</head>

<body>
<div class="container">
	<h1>Update Competency</h1>
	<div class="form-group" >
	<form:form action="${pageContext.request.contextPath}/skill/update" method="POST">
		<table border="1" width="75%" >
		<c:forEach var="x" items="${skillSelectedAttribute}">
			<tr>
				<td width="25%">Competency ID</td>
				<td><input type="text" name="skillId" readonly="readonly" value="${x.skillId}" class="form-control"></input></td>
			</tr>
			<tr>
				<td>Competency Name</td>
				<td><input type="text" name="skillName" value="${x.skillName}" required="required" class="form-control" maxlength="50"></input></td>
			</tr>
			<tr>
				<td>Competency Description</td>
				<td><input type="text" name="skillDesc" value="${x.skillDesc}" required="required" class="form-control" maxlength="200" width="300px" multiple="true" height="5">
					 </input></td>
			</tr>
			<tr>
				<td>Competency Status</td>
				<td><input type="text" readonly="readonly" value="${x.skillStatus}" class="form-control"></input></td>
			</tr>
		</c:forEach>
		</table>
		<input name="skillId" value="${x.skillId}" type="hidden"></input>
		<br><input type="submit" value="Update" class="btn btn-success">
	</form:form>
	</div>
	<input type="button" class="btn btn-primary" value="Cancel" onclick="window.location='list';"></input> 
	
	</div>
</body>
</html>