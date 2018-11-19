<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="print" uri="http://java.sun.com/jsp/jstl/core"%>
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
	position: fixed;
	right: 2em;
	bottom: 2em;
	position-anchor: 90% 90%;
}
</style>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Transactions</title>
</head>
<body>
	<center>
		<div
			style="border-radius: 15px; padding: 20px; width: 1000px; box-shadow: 5px 5px 5px 5px silver;">
			<h1>
				<u>Transactions for your mobile number</u>
			</h1>
			<table>
				<tr>
					<th>Transaction type</th>
					<th>Transaction amount</th>
					<!-- <th>Transaction date</th> -->
				</tr>
				<print:forEach var="printing" items="${result}">
					<tr>
						<td>${printing.tranType}<br></td>
						<td>${printing.amount}<br></td>
						<%-- <td>${printing.tranDate}</td> --%>
					</tr>
				</print:forEach>
			</table>
		</div>
		<a href="index.jsp">Go to main menu</a>
	</center>
</body>
</html>