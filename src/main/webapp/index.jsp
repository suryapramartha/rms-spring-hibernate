<%@ page language="java" pageEncoding="UTF-8" session="false"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    

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
<%
//allow access only if session exists
String user = (String) request.getSession().getAttribute("user");
%>
    
    <div align="center" class="container">
	<div class="jumbotron"><h2 align="center" class="help-block">RMS - Employee Management System</h2><br><br></div>
	<br><br><br><br>
		 <c:choose>
  			<c:when test="<%=user==null%>">
   			 	<a href="login">
    	 			<input type="button" class="btn btn-danger btn-lg" value="Login">
				</a><br><br><br>
  			</c:when>
  			<c:when test="<%=user!=null%>">
        		<a href="logout"><input type="button" class="btn btn-danger btn-lg" value="Hi <%=user %>, Logout">
        		</a><br><br><br>
  			</c:when>
		</c:choose>
<!-- 		 <a href="project/list"> -->
<!-- 		 	<input type="button" class="btn btn-primary btn-lg" value="Project List"> -->
<!-- 		 </a><br><br><br> -->
		 <a href="employee/list">
			<input type="button" class="btn btn-primary btn-lg" value="Employee List">
		 </a><br><br><br>
		 <a href="skill/list">
		 	<input type="button" class="btn btn-primary btn-lg" value="Competency List">
		 </a><br><br><br><br><br><br><br><br><br>
        
	<div class="jumbotron">
		<h6 align="center" class="help-block">Gde Surya pramartha - Mitrais RMS Study Case 2 - Java Bootcamp</h6>
	</div>
	</div>
</body>
</html>
