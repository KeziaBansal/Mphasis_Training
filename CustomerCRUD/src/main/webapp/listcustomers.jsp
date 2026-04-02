<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%@ taglib uri="jakarta.tags.core" prefix="c" %>
    
    <%@ page isELIgnored="false" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>list customers</title>
</head>
<body>
			<h1 align="center">List of Customers</h1>
			
			<table align = "center" border="1" widht="50%">
				
				<tr>
					<th>ID</th>
					<th>Name</th>
					<th>Email</th>
					<th>City</th>
					<th>Action</th>
				</tr>
				
				<tbody>
					<c:forEach items="${data}" var="cst">
					
					<tr>
					
						<td>${cst.getId()}</td>
						<td>${cst.getName()}</td>
						<td>${cst.getEmail()}</td>
						<td>${cst.getCity()}</td>
						<td>Delete &nbsp; &nbsp; Edit</td>
					</tr>
					</c:forEach>
					
				</tbody>
			
			</table>
</body>
</html>