<%@page import="com.wipro.banking.bean.*,java.util.*"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>

<head>
<title>Customer</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="adminstyle.css">
</head>

<body background="cash.jpg" style="background-attachment:fixed;height:50%;background-repeat: no-repeat;background-position: center; background-size: cover;">

<div class="w3-container">
<center>
  <h2 >Admin</h2>
  </center>
</div>


<div class="w3-bar w3-black">

<button class="w3-bar-item w3-button" onclick="openCity('add')">Add Branch Manager</button>
<button class="w3-bar-item w3-button" onclick="openCity('modify')">Modify</button>
  <button class="w3-bar-item w3-button" onclick="openCity('delete')">Delete</button>
  
  
  <button type="button" class="w3-bar-item w3-button" onclick="openCity('search')" >Search</button>
  
 	 <form action="AdminController" method="post">
   <button type="submit" class="w3-bar-item w3-button" onclick="openCity('view')" name="button" value="view">
   View</button>
   	</form>
   	
   	<form action="AdminController" method="post">
    <button class="w3-bar-item w3-button" onclick="openCity('logout')" name="button"
     value="logout">Logout</button>
    </form>
 
  </div>



<form action="AdminController" method="post">
<div id="add" class="w3-container city"style="display:none">
  <center>
  <h2>Add Branch Manager</h2>
  <table>
  <tr>
  <td>
  <b>Employee ID:</b>
  </td>
  <td>
  <input type="text"  placeholder="Enter ID" name="eid" required>
  </td>
  </tr>
  <tr></tr>
  <tr>
  <td>
  <b>Branch:  </b>
  </td>
  <td>
  <input type="text"  placeholder="Enter Branch" name="branch" required>
  </td>
  </tr>
  <tr></tr>
  <tr>
  <td>
  <b>IFSC Code:  </b>
  </td>
  <td>
  <input type="text"  placeholder="Enter IFSC" name="ifsc" required>
  </td>
  </tr>
  <tr>
  <td>
  </td>
  <td>
 <button type="submit" name="button" value="insert">Submit</button>
  </td>
  </tr>
  </table>
   </div> 
  </center>
  </form>
  
  <form action="AdminController" method="post">
     <div id="modify" class="w3-container city" style="display:none">
     <center>
     <h2>Modify</h2>
    <table>
    <tr>
    <td>
    <b>Employee ID:</b>
    </td>
    <td>
   <input type="text"  placeholder="Enter ID" name="eid" required>
   </td>
   </tr>
   <tr></tr>
   <tr>
   <td>
   <b>Branch:  </b>
   </td>
   <td>
   <input type="text"  placeholder="Enter Branch" name="branch" required>
   </td>
   </tr>
   <tr></tr>
   <tr>
  <td>
  <b>IFSC Code:  </b>
  </td>
  <td>
  <input type="text"  placeholder="Enter IFSC" name="ifsc" required>
  </td>
  </tr>
  <tr>
  <td>
  </td>
  <td>
 <button type="submit" name="button" value="modify">Submit</button>
  </td>
  </tr>
  </table>
   </div>
  </form>
  </center>
  
  <form action="AdminController" method="post">
     <div id="delete" class="w3-container city" style="display:none">
     <center>
     <h2>Delete</h2>
    <table>
    <tr>
    <td>
    <b>Employee ID:</b>
    </td>
    <td>
   <input type="text"  placeholder="Enter ID" name="eid" required>
   </td>
   </tr>
   <tr></tr>
   <tr>
  <td>
  </td>
  <td>
 <button type="submit" name="button" value="delete">Submit</button>
  </td>
  </tr>
  </table>
   </div> 
  </form>
  </center>
 
   <form action="AdminController" method="post">
     <div id="search" class="w3-container city" style="display:none">
     <center>
     <h2>Search</h2>
    <table>
    <tr>
    <td>
    <b>Employee ID:</b>
    </td>
    <td>
   <input type="text"  placeholder="Enter ID" name="eid" required>
   </td>
   </tr>
   <tr></tr>
   <tr>
  <td>
  </td>
  <td>
 <button type="submit" name="button" value="search">Submit</button>
  </td>
  </tr>
  </table>
   </div>
  </form>
  </center>
	

  	
  	
     <div id="view" class="w3-container city" style="display:none">
		  		<%
		ArrayList<ManagerBean> arr = (ArrayList<ManagerBean>)request.getAttribute("mset");
	
		System.out.println("jsp array="+arr);
		
  	%>
	
  	     
     </div>
  
  
 <div id="ans">
   <!-- For BackEnd Part -->
   ${val }
 </div>


 


<script>
function openCity(cityName) {
  var i;
  var x = document.getElementsByClassName("city");
  for (i = 0; i < x.length; i++) {
    x[i].style.display = "none";
  }
  document.getElementById('ans').style.display = "none";
  document.getElementById(cityName).style.display = "block";  
}
</script>

</body>
</html>

