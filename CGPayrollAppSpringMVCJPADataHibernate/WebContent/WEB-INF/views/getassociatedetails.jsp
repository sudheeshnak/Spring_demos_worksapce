<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login</title>
<style>
.error{
color:red;
font-weight:bold;
}
</style>
</head>
<body>
<h2>Enroll Customer Details here</h2>
<table>
<form:form action="getAssociateDetails" method="post"
modelAttribute="associate">
<tr>
<td>Associate ID:</td>
<td><form:input path="associateID" size="30"/></td>
<td><form:errors path="associateID" cssClass="error"/></td>
</tr>
<tr>
<td><input type="submit" value= "GetDetails"/></td>
</tr>
</form:form>

</table>

</body>
</html>