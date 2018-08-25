<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<body>
	<table>
		<form:form action="depositCustomerAmount" method="post"
			modelAttribute="customer">

			
			<tr>
				<td>MobileNo:</td>
				<td><form:input path="mobileNo" /></td>
				<td><form:errors path="mobileNo" cssClass="error"  /></td>
			</tr>
			
			<tr>
				<td>Deposit Amount:</td>
				<td><input type ="number" name = "amount"></td>
			</tr>
			
			
			<tr>
			<td><input type ="submit" value="Submit"></td>
			</tr>
		</form:form>
	</table>
</body>
</html>