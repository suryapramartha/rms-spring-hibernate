<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1"> 
<title>Login Form</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/css/bootstrap.min.css" integrity="sha384-GJzZqFGwb1QTTN6wy59ffF1BuGJpLSa9DkKMp0DgiMDm4iYMj70gZWKYbI706tWS" crossorigin="anonymous">
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/js/bootstrap.min.js" integrity="sha384-B0UglyR+jN6CkvvICOB2joaf5I4l3gm9GU6Hc1og6Ls7i6U/mkkaduKaBhlAXv9k" crossorigin="anonymous"></script>
<style>
	.failed{
		color:red
	}
</style>
</head>
<body>
	<div class="container" align="center" style="margin-top: 300px;">
		<form:form action="${pageContext.request.contextPath}/authenticate" method="POST">
			<div class="form-group">
					<div class="panel-title"> <p class="text-center"><h2>Login Form</p></div>
				<table border="1">
					<tr>
						<td width="40%" class="table-secondary">Username</td>
						<td><input type="text" name="username" required="required" placeholder="Username" class="form-control"></input></td>
					</tr>
					<tr>
						<td class="table-secondary">Password</td>
						<td><input type="password" name="password" required="required" placeholder="Password" class="form-control"></input></td>
					</tr>	
				
				</table>
				<br><input type="submit" value="Login" class="btn btn-success btn-lg"><br><br>
				
				<c:if test="${ param.error !=null }">
					<div class="alert alert-danger" role="alert">
						Invalid username or password.
					</div>
				</c:if>
				<c:if test="${ param.logout !=null }">
					<div class="alert alert-success" role="alert">
						You have been logged out.
					</div>
				</c:if>
			</div>
		</form:form>
	</div>
</body>
</html>