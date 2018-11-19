<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<style type="text/css">
body {
	margin-top: 150px;
	padding: 10px;
	font-family: cursive;
	font-size: medium;
	border-color: blue;
}
a {
	position: absolute;
	right: 2em;
	bottom: 2em;
	position-anchor: 90% 90%;
}
</style>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Result</title>
</head>
<body>
	<center>
		<div style="border-radius: 15px; border:medium; padding: 20px; width: 300px; box-shadow: 5px 5px 5px 5px silver;">
			<h3>
				${result}
			</h3>
		</div>
		<a href="index.jsp">Go to main menu</a>
	</center>
</body>
</html>