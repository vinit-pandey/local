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
<form action="ManagerController" method="post">

<div>
	<!-- Back End -->
</div>

<div class="loginPage" >
   
 <span class="login-line">
Update Your Password</span>

  
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
          
      <input class="input-field" type="password" placeholder="Enter Your New Password" name="password" id="password"
      required="required">
   
         </div>

        
    <button class="Login-Button" id="Login-Button" type="submit" name="button" value="update">Update</button>
          
 	</br>
 	
 
    
  </div>
  
  </div>


</div>
</form>
</body>

</html>