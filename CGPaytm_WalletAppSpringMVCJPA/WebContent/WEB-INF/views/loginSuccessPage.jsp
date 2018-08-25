<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<h2>Welcome ${customer.name}</h2>
<h2>Your mobile number is: ${customer.mobileNo}</h2>
<h2>Your balance is : ${customer.wallet.balance}</h2>
<a href = "showBalance">Show Balance</a><br><br>
<a href = "withdrawAmount" >Withdraw Amount</a"><br><br>
<a href = "depositAmount" >Deposit Amount</a"><br><br>
<a href = "fundsTransfer" >Funds Transfer</a"><br><br>
</body>
</html>