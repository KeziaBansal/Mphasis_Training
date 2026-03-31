<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>success</title>
</head>
<body>
	<h1>Customer Data</h1>
	<h2>
		Id : ${data.getId()}<br>
		Name : ${data.getName()}<br>
		City : ${data.getCity()}
	</h2>
</body>
</html>