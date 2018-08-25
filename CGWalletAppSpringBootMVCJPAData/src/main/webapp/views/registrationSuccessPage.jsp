<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

</head>
<body>
<div align="center">
<h1>Welcome ${customer.name}</h1><br><br>
<h1>Your mobile number is : ${customer.mobileNo}</h1><br><br>
<h1>Your Balance is : ${customer.wallet.balance}</h1>
<h1>Please login to continue with your account</h1>
<a href ="LoginPage">Login</a><br><br>
<!-- <a href = "showBalance">Show Balance</a><br><br> -->
<!-- <a href = "withdrawAmount" >Withdraw Amount</a"><br><br> -->
<!-- <a href = "depositAmount" >Deposit Amount</a"><br><br> -->
<!-- <a href = "fundsTransfer" >Funds Transfer</a"><br><br> -->
</div>
</body>
</html>