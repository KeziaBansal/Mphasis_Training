<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>data</title>
</head>
<body>
			<h1>User Data</h1>
		
			<%
				String usr = request.getParameter("user");
			
				String pas = request.getParameter("pwd");
				
				if(usr.equals("admin") && pas.equals("java"))
				{
			%>
					<jsp:forward page="success.jsp"></jsp:forward>
				<%
				}
				else {
						out.println("<font color = 'red' >Invalid Credentials </font>");
				%>
						<jsp:include page="login.jsp"></jsp:include>
			<%
				}
			
			%>
		
</body>
</html>