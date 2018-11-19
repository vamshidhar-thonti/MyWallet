<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="fund" uri="http://www.springframework.org/tags/form" %>
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
h1 {
	font-family: cursive;
	font-size: x-large;
	color: #4A4646;
}
a {
	position: absolute;
    right: 2em;
    bottom: 2em;
    position-anchor: 90% 90%;
}
</style>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Funds Transfer</title>
</head>
<body>
	<center>
		<div style="border-radius: 15px; padding: 20px; width: 600px; box-shadow: 5px 5px 5px 5px silver;">
			<fund:form action="fundsTransfer" method="post" modelAttribute="funding">
			<h1><u>Transfer funds</u></h1>
				<table>
					<tr>
						<td>Sender mobile number:</td>
						<td><fund:input path="mobileNumber" name="mobileSource" pattern = "[7-9][0-9]{9}" title="Mobile number should have 10 digits and the starting digit should be 7 or 8 or 9"/><br></td>
					</tr>
					<tr>
						<td>Recipient mobile number:</td>
						<td><fund:input path="mobileNumber" name="mobileDest" pattern = "[7-9][0-9]{9}" title="Mobile number should have 10 digits and the starting digit should be 7 or 8 or 9"/><br></td>
					</tr>
					<tr>
						<td>Amount to be transfered:</td>
						<td><fund:input path="amount" name="custAmt" pattern = "[1-9][0-9]{0,9}" title="Amount can't be either '-' or '0'"/>
					</tr>
					<tr align="right">
						<td></td>
						<td><input type="submit" value="Transfer"/></td>
					</tr>
				</table>
			</fund:form>
		</div>
		<a href="index.jsp">Go to main menu</a>
	</center>
</body>
</html>