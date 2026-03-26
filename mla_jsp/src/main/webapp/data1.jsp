<%@page import="com.test.Employee"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>data</title>
</head>
<body>	
			<h1>Employee Session Data</h1>
			
			<%
				Employee emp = (Employee)session.getAttribute("emp");
			
				out.println(emp.getName());
				
				Employee obj = (Employee)application.getAttribute("info");
				
				out.println("<br>"+obj.getId()+" "+obj.getName()+" "+obj.getCmp()+" "+obj.getCity());
			%>
</body>
</html>