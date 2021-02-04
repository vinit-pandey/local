<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<script type="text/javascript">


function validation() {
	
	let psw = document.getElementById('psw').value;
	let rpsw = document.getElementById('psw-repeat').value;
	
	let username = document.getElementById('username');
	let accno = document.getElementById('accno').value;
	let state = document.getElementById('state').value;
	
	username.addEventListener('keypress',function(event){
		
		console.log('space')
		
		var key = event.keyCode;
		if(key==32)
			return false;
	});

	console.log(username)
	console.log(accno.length)
	
	
	if(psw!=rpsw)
		{
		document.getElementById('psw-error').innerHTML="Password and Repeat Password has to be same";
		document.getElementById('rpsw-error').innerHTML="Password and Repeat Password has to be same";
			return false;
		}
		
	if(accno.length>10)
	{
		document.getElementById('acc-error').innerHTML="Account Number Length Cannot Be More Than 10";
		return false;
	}
	if(state.length>10)
		{
			document.getElementById('state-error').innerHTML="State Length Cannot Be More Than 10";
			return false;
		}
			return true;
		
	
}
</script>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style>* {box-sizing: border-box}

#psw-error{
	color: red;
}

#rpsw-error,#acc-error,#state-error{
	color: red;
}
/* Add padding to containers */
.container {
  padding: 16px;
  width : 500px;
 
}

/* Full-width input fields */
input[type=text], input[type=password] {
  width: 100%;
  padding: 15px;
  margin: 5px 0 22px 0;
  display: inline-block;
  border: none;
  background: #f1f1f1;
}

input[type=text]:focus, input[type=password]:focus {
  background-color: #ddd;
  outline: none;
}

/* Overwrite default styles of hr */
hr {
  border: 1px solid #f1f1f1;
  margin-bottom: 25px;
}

/* Set a style for the submit/register button */
.registerbtn {
  background-color: #4caf50;
  color: white;
  padding: 16px 20px;
  margin: 8px 0;
  border: none;
  cursor: pointer;
  width: 100%;
  opacity: 0.9;
}

.registerbtn:hover {
  opacity:1;
}

/* Add a blue text color to links */
a {
  color: dodgerblue;
}

/* Set a grey background color and center the text of the "sign in" section */
.signin {
  background-color: #f1f1f1;
  text-align: center;
}
.bg{
}
</style>
<!--style="background-color:#fec16d;"-->
</head>
<body background="cash.jpg" style="background-attachment:fixed;height:100%;background-repeat: no-repeat;background-position: center; background-size: cover;" >
${msg }

<center>
<form onsubmit="return validation();" action="CustomerController" method="post">
  <div class="container">
    <h1>Register</h1>
    <p>Please fill in this form to create an account.</p>
    <hr>

    <label for="username"><b>User Name</b></label>
    <input type="text" placeholder="Enter user name" name="username" pattern="[^\s]+" id="username" 
    title="UserName Should Not Have Sapce" required="No space">
    
     <label for="psw"><b>Password</b></label>
    <input type="password" placeholder="Enter Password" name="psw" id="psw" 
    pattern="(?=.*\d)(?=.*[a-z])(?=.*[A-Z]).{8,}" 
    title="Must contain at least one number and one uppercase and lowercase letter, and at least 8 or more characters" required>
	
	<div id="psw-error"><font color="red"></font></div><br>
	
    <label for="psw-repeat"><b>Repeat Password</b></label>
    <input type="password" placeholder="Enter Repeat Password" name="psw-repeat" id="psw-repeat" required>
    <div id="rpsw-error"><font color="red"></font></div><br>

    <label for="address"><b>Address</b></label>
    <input type="text" placeholder=" Enter Address" name="address" required>
    
     <label for="state"><b>  State</b></label>
    <input type="text" placeholder="Enter State" name="state" id="state" required>
    <div id="state-error"><font color="red"></font></div><br>
    
    <label for="accountno"><b>Account No.</b></label>
    <input type="text" placeholder="Enter Account No." name="account" id="accno" required>
    <div id="acc-error"><font color="red"></font></div><br>
    
    <label for="branch"><b>Branch</b></label>
    <input type="text" placeholder="Enter Branch" name="branch" required>
    
     <label for="ifsccode"><b>IFSC Code</b></label>
    <input type="text" placeholder="Enter IFSC Code" name="ifsccode" required>
    
    <label for="ifsccode"><b>Date </b></label>
    <input type="date" name="date" required>
    
    <label for="mobile"><b>Mobile No.</b></label>
    <input type="tel" min="10" max="10" pattern="[0-9]{10}"placeholder="Enter Mobile No." name="mobile" required>
    <hr>

    <button type="submit" class="registerbtn" name="button" value="registration">Register</button>
  </div>

  
</form>
</center>

</body>
</html>