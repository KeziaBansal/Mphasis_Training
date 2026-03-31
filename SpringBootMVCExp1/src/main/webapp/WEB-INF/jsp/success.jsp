<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>success</title>
</head>
<body>
	<h1>Book Information</h1>
	<p>
	ID : ${data.getId()}<br>
	Name : ${data.getName()}<br>
	Author : ${data.getAuthor()}<br>
	Price : ${data.getPrice()}
	</p>
	
	<h3>Thank you, You have done good job to get Book Information</h3>
</body>
</html>