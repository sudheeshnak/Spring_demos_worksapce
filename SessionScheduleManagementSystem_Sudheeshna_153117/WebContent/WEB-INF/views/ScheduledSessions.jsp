<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<body>
	<h1>Scheduled Sessions</h1>
	<br>
	<br>
	<br>
	<table>
		<tr>
			<th>Session Name</th>
			<th>Duration(Days)</th>
			<th>Faculty</th>
			<th>Mode</th>
		</tr>
		<c:forEach items="${scheduled_Sessions}" var="Sessions">
			<tr>
				<td>${Sessions.name}</td>
				<td>${Sessions.duration}</td>
				<td>${Sessions.faculty}</td>
				<td>${Sessions.mode1}</td>
				<td><a href="Success">Enroll Me</a></td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>