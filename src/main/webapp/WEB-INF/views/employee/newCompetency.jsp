<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<%@ page import="java.util.*" %>    

    
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<meta name="author" content="Mitrais">
  	<meta name="viewport" content="width=device-width, initial-scale=1.0">
  	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/bootstrap.min.css">   		
    <script src="${pageContext.request.contextPath}/resources/js/bootstrap.min.js"></script>   
<title>New Competency Assignment Form</title>
</head>
<%
	Boolean isEmpty=false;
	List<String> data = (List<String>)request.getAttribute("listSkillAttribute");
	if(data==null||data.isEmpty()){
		isEmpty=true;
	}else{
		isEmpty=false;
	}
%>
<body>
	<div class="container">
	<h1>New Competency Assignment Form</h1>
		<form action="save-competency" method="POST">
			<div class="form-group">
				<table border="1" width="75%">
					<c:forEach var="temp" items="${employeeSelectedAttribute}">
					<tr>
						<td width="40%">Employee ID</td>
						<td><input type="text" name="emplId" required="required" maxlength="5" class="form-control" value="${temp.emplId}" readonly="readonly"></input></td>
					</tr>
					<tr>
						<td width="40%">Employee Name</td>
						<td><input type="text" name="emplName" required="required" maxlength="50" class="form-control" value="${temp.emplName}" readonly="readonly"></input></td>
					</tr>
					<tr>
						<td width="40%">Competency Name</td>
						<td>
							<select name="ListSkill">
								<c:forEach var="x" items="${listSkillAttribute}">	
									<option value="${x.skillId}">${x.skillName}</option>	
  								</c:forEach>
  							</select>
  							<c:choose>
  								<c:when test="<%=isEmpty%>">
    								<c:out value="${'List Skills not found or You already Assigned all available Skills !!'}"></c:out>
  								</c:when>
							</c:choose>
						</td>
					</tr>
					<c:url var="tempCancel" value="view-competency">
						<c:param name="employeeId" value="${temp.emplId}"></c:param>
					</c:url>
					</c:forEach>
				</table>
				<br><input type="submit" value="Create" class="btn btn-success" >
			</div>
		</form>
		<a href="${tempCancel}">
 			<button class="btn btn-primary">Cancel</button>
 		</a> 
	</div>	
</body>
</html>