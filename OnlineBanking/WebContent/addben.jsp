<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<style>
input[type=number]::-webkit-inner-spin-button,
input[type=number]::-webkit-outer-spin-button{
-webkit-appearance: none;
margin:0;
}
</style>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body background="cash.jpg" style="background-attachment:fixed;height:50%;background-repeat: no-repeat;background-position: center; background-size: cover;">


<center>
<form>
	<div>
		<h1><p> Add Beneficiary Account Number </p></h1>
		
		<hr size="35" width="100%" color="black";></br></hr>
		<b>Benificiary  Account Number:</b> <input type="number" min="0" placeholder="Enter Account Number" name="accben" required><br>
		<br>
		
		<b>Benificiary Account Name:</b> <input type="text"  placeholder="Benificiary  Account Name" name="accname" required><br>
		<br>
		<br>
		 
		<input type="submit" name="submit" value="Submit">
	</div>
</form> 
</center>
</body>
</html>