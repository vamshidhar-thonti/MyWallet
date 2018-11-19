<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="show" uri="http://www.springframework.org/tags/form" %>
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
<!-- <script type="text/javascript">
	function formValidation() {
		var show = document.show.mobile.value;
		if(show == ""){
			alert("Please fill mobile number");
		}
	}
</script> -->
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Show Balance</title>
</head>
<body>
	<center>
		<div style="border-radius: 15px; padding: 20px; width: 600px; box-shadow: 5px 5px 5px 5px silver;">
			<show:form action="showBalanceNow" method="post" modelAttribute="showBal">
			<h1><u>Show user's balance</u></h1>
				<table>
					<tr>
						<td>Mobile number:</td>
						<td><show:input path="mobileNumber" name="mobile" pattern = "[7-9][0-9]{9}" title="Mobile number should have 10 digits and the starting digit should be 7 or 8 or 9"/><br></td>
					</tr>
					<tr align="right">
						<td></td>
						<td><input type="submit" value="Show Balance"/></td>
					</tr>
				</table>
			</show:form>
		</div>
	</center>
	<a href="index.jsp">Go to main menu</a>
</body>
</html>