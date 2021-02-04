<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<!DOCTYPE html>
<html>
<title>Customer</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="adminstyle.css">
<body background="cash.jpg" style="background-attachment:fixed;height:50%;background-repeat: no-repeat;background-position: center; background-size: cover;">

<div class="w3-container">
<center>
  <h2 >Branch Manager</h2>
  </center>
</div>


<div class="w3-bar w3-black">


<button class="w3-bar-item w3-button" onclick="openCity('pending')">View All Pending Task</button>
<!-- search -->
<button class="w3-bar-item w3-button" onclick="openCity('search')">Search</button>

<!-- Approve Reject -->

	<form action="ManagerController" method="post">
  <button type="submit" class="w3-bar-item w3-button" onclick="openCity('task')"
  name="button" value="approve">Approve/Reject Pending Request</button>
  
  </form>
  
  
  <button class="w3-bar-item w3-button" onclick="openCity('app_reject')">View Approve/Reject</button>
 
  
  <form action="ManagerController" method="post">
  <button type="submit" class="w3-bar-item w3-button" onclick="openCity('logout')" 
  name="button" value="logout">Logout</button>
 </form>
  </div>


<form action="ManagerController" method="post">
<div id="search" class="w3-container city" style="display:none">
  
  <center>
  
  <h2>Search</h2>
  
  
  <label for="ifsccode"><b>Start Date </b></label>
    <input type="date" name="sdate" required>
    
    <label for="ifsccode"><b>End Date </b></label>
    <input type="date" name="edate" required>
    <br>
    <br>
    <input type="submit" name="button" value="search">
    
    </center>
</div>
</form>
 

<form action="ManagerController" method="post">
<div id="pending" class="w3-container city" style="display:none">
  
  <center>
  	<h2>View All Pending Task</h2>
  	<br>
  	<input type="text" name="branch" placeholder="Enter Your Branch" required="required">
    </br>
    </br>
    <input type="submit" name="button" value="pending">
    
    </center>
</div>
</form>
 
<form action="ManagerController" method="post">
<div id="app_reject" class="w3-container city" style="display:none">
  
  <center>
  	<h2>View Approved/Rejected Request</h2>
  	<br>
  	<input type="text" name="branch" placeholder="Enter Your Branch" required="required">
    </br>
    </br>
    <input type="submit" name="button" value="newStatus">
    
    </center>
</div>
</form>

<script>
function openCity(cityName) {
  var i;
  var x = document.getElementsByClassName("city");
  for (i = 0; i < x.length; i++) {
    x[i].style.display = "none";  
  }
  document.getElementById(cityName).style.display = "block";  
}
</script>

</body>
</html>

</body>
</html>