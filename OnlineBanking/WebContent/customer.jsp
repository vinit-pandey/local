<%@page import="com.wipro.banking.*,com.wipro.banking.util.*,java.util.*,java.sql.*"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>

<style type="text/css">
.footer{

	position: fixed;
	left: 0;
	bottom: 0;
	width: 100%;
	background-color: black;
	color: white;

}

</style>

<meta charset="ISO-8859-1">
<title>Customer</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="adminstyle.css">
</head>

<body background="cash.jpg" style="background-attachment:fixed;height:50%;background-repeat: no-repeat;background-position: center; background-size: cover;">

<div class="login-side-image-container">
  <img alt="" src="/cash.jpg" >
   
  </div>
<div class="w3-container">
<center>
  <h2 >Customer Page</h2>
</center>
</div>


<div class="w3-bar w3-black">


<form action="CustomerController" method="post">
	<button type="submit" class="w3-bar-item w3-button" onclick="fetch('account')" name="button" 
	value="account">
	
	<a style="text-decoration: none">Account Details</a></button>
	  <div>
  		<!-- For BackEnd Part -->
  	  </div>
</form>

<button class="w3-bar-item w3-button" onclick="fetch('add')">Add Beneficiary</button>

<!-- Transfer.. -->

<form action="CustomerController" method="post">
<button type="submit" name="button" value="transfer" class="w3-bar-item w3-button" onclick="fetch('transfer')">
<a style="text-decoration: none">Transfer Funds to Beneficiary</a></button>
</form>
  
  
<form action="CustomerController" method="post">
<button class="w3-bar-item w3-button" type="submit" name="button" value="mini">Mini Statements</button>
</form>
    
<!-- Logout -->
<form action="LogoutConntroller" method="post">
  <button type="submit" class="w3-bar-item w3-button" onclick="fetch('logout')">LogOut</button>
  <div>
  		<!-- For BackEnd Part -->
  </div>
</form>

</div>

<br>
<div align="center" id="money">Remaining Balance: ${balance }</div>


<form action="CustomerController" method="post">
<div id="add" class="w3-container city" style="display:none">
  
  <center>
  
  <h1><p> Add Beneficiary Account Number </p></h1>
		
		<table>
		<tr>
		<td><b>Benificiary  Account Number:</b></td>
		<td> <input type="number" min="0" placeholder="Enter Account Number" name="accben" required></td>
		</tr>
		<tr></tr>
		<tr>
		<td><b>Benificiary Account Name:</b></td>
		<td> <input type="text"  placeholder="Benificiary  Account Name" name="accname" required></td>
		</tr>
		<tr>
		<td><b>IFSC Code:</b></td> 
		<td><input type="text"  placeholder="IFSC Code" name="ifsc" required></td>
		</tr>
		</table>
		<br>
		 
		<input type="submit" name="button" value="addBen">
    </center>
</div>
</form>



<div id="mini" class="w3-container city" style="display:none">
  
  <center>
  	<h1> Mini Statement</h1>
  </center>
</div>


<br>
<br>

<div align="center" id="msg">${msg }</div>

<div class="footer">
 		
 	
</div>

<script>


function fetch(cityName) {
	
  var i;
  var x = document.getElementsByClassName("city");
  for (i = 0; i < x.length; i++) {
    x[i].style.display = "none";  
    
  }
  
  document.getElementById(cityName).style.display = "block"; 
  document.getElementById('msg').style.display = "none";
  
}
</script>

</body>
</html>

