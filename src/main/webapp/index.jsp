<%@ page language="java" pageEncoding="UTF-8" session="false"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="security" uri="http://www.springframework.org/security/tags" %>

<!doctype html>
<html lang="en">
<head>
  <meta charset="utf-8">

  <title>RMS</title>
  <meta name="description" content="Index">
  <meta name="author" content="Mitrais">
  <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/bootstrap.min.css">   		
  <script src="${pageContext.request.contextPath}/resources/js/bootstrap.min.js"></script>    	
</head>

<body>
<%-- 	<security:authentication property="principal.username" var="username"/> --%>
    <div align="center" class="container">
	<div class="jumbotron"><h2 align="center" class="help-block">RMS - Employee Management System</h2><br><br></div>
	<br><br><br><br>
<!-- 		 <a href="project/list"> -->
<!-- 		 	<input type="button" class="btn btn-primary btn-lg" value="Project List"> -->
<!-- 		 </a><br><br><br> -->
		 <a href="employee/list">
			<input type="button" class="btn btn-primary btn-lg" value="Employee List">
		 </a><br><br><br>
		 
		 <security:authorize access="hasRole('ADMIN')">
		 	<a href="skill/list">
		 		<input type="button" class="btn btn-primary btn-lg" value="Competency List">
		 	</a><br><br><br>
		 </security:authorize>
		 
		 <form:form action="${pageContext.request.contextPath}/logout" method="POST">
		 	<input type="submit" value="Logout" class="btn btn-danger btn-lg">
		 </form:form><br><br><br><br><br><br><br><br><br>
	
	
	<div class="jumbotron">
		<h6 align="center" class="help-block">Gde Surya pramartha - Mitrais RMS Study Case 2 - Java Bootcamp</h6>
	</div>
	</div>
</body>
</html>
