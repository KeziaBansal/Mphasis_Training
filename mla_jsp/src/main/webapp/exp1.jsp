<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
		<!-- declaration tag -->
		
		<%!
			
			int x = 11;
			int y = 33;
			
			public int add()
			{
				return x+y;
			}
		
		%>
		
		<!-- expression tag -->
		
		<%= add() %>
		
		<br>
		
		<%= new Date() %>
		
		<!-- scriplet tag -->
		
		<br>
		<%
			out.println("Scriplet Tag ".toUpperCase());
		%>
		
</body>
</html>