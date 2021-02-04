<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="mystyle.css">

<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body background="cash.jpg" style="background-attachment:fixed;height:50%;background-repeat: no-repeat;background-position: center; background-size: cover;">

<div>
	<!-- Back End -->
</div>

<form action="ManagerController" method="post">
<div class="loginPage" >
   
 <span class="login-line">
Manager Login</span>

  
  <div class="login-side-image-container">
  <img alt="" src="/bank.jpg">
   
 </div>
   
 <div class="login-container">
 
 <div align="center">${val }</div>
   
     <div class="input-container-wrapper">
  
        <div class="input-container">
 
               <input class="input-field" type="text" placeholder="Manager Employee ID" name="eid" id="eid"
               required="required">
  
          </div>

       
     <div class="input-container">
          
      <input class="input-field" type="password" placeholder="Password" name="password" id="password"
      required="required">
   
         </div>

        
    <button class="Login-Button" id="Login-Button" type="submit" name="button" value="login">Login</button>
    <a href="managerUpdatePassword.jsp"> Update Password </a>
          
 
      
  </div>
  
  </div>

  


</div>
</form>
</body>

</html>