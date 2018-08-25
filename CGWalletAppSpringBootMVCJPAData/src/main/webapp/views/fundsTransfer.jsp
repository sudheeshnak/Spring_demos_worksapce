<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<body>
	<table>
		<form:form action="CustomerFundsTransfer" method="post"
			modelAttribute="customer">

			
			<tr>
				<td>Source MobileNo:</td>
				<td><input type="text" name = "sourceMobileNo" /></td>
			</tr>
			
			<tr>
				<td>Target MobileNo:</td>
				<td><input type="text" name = "targetMobileNo" /></td>
			</tr>
			
			
			<tr>
				<td>Amount:</td>
				<td><input type="number" name = "amount" /></td>
			</tr>
			
			<tr>
			<td><input type ="submit" value="Submit"></td>
			</tr>
		</form:form>
	</table>
</body>
</html>