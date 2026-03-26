<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>AsyncTest</title>
</head>
<body>
	<h1> ASYNC WEB APP WITH XMLHTTP REQUEST AND JAVASCRIPT</h1>
	<p id="mla"></p>
	<script type="text/javascript">
	async function getFile()
	{
		let mlaPromise = new Promise(function(resolve)
				{
					let request = new XMLHttpRequest();
					request.open('GET', 'AsyncServlet');
					request.onload = function()
					{
						if(request.status == 200)
							{
							resolve(request.response);
							}
						else
							{
							resolve('NO DATA AVAILABLE');
							}
					};
					request.send();
			
				});
		document.getElementById("mla").innerHTML = await mlaPromise;
	}
	
	getFile();
	
</body>
</html>