<%@page import="com.wipro.banking.bean.BeneficiaryBean"%>
<%@page import="com.wipro.banking.*,java.util.*"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<style type="text/css">
#error{
	color: red;
}

</style>
<script type="text/javascript">

let amount  = document.getElementById('amount').value;

if(amount.length<=7)
	return true;
else
	{
	document.getElementById('error').innerHTML="Amount Should Not Be More Than 10 lakhs";
	}
</script>
<style>
input[type=number]::-webkit-inner-spin-button,
input[type=number]::-webkit-outer-spin-button{
-webkit-appearance: none;
margin:0;
}

#myList{
	width: 180px;
}

#myList option{
	width: 180px;
}
.bt{
    padding: 12px;
    width: 30%;
   
    display: block;
    margin-top: 4%;
    background-color:#1c2c54;
    border: none;
    color: silver;
    font-weight: bold;
    border-radius: 4px;
}
</style>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>

<body  background="cash.jpg" style="background-attachment:fixed;height:50%;background-repeat: no-repeat;background-position: center; background-size: cover;">
<%
ArrayList<BeneficiaryBean> arr = (ArrayList<BeneficiaryBean>)request.getAttribute("data");
%>
<form onsubmit="return validation();" action="CustomerController" method="post">
<div align="center">
<h1><b><i><u>TRANSFER FUNDS TO BENEFICIARY</u></i></b></h1>
<hr size="35" width="100%" color="black";></br></hr>
<div align="center">${val }</div>


     <br>
     <br>
     <br>
          <p>
          	<table>
          	<tr>
          	<td>
             <label><b><h2>Beneficiary Name:</b></label>
             </td>
             <td>
             <select id = "myList" name="dropdown" >
               <% for(BeneficiaryBean bean : arr) {%>
		
					<option><%= bean.getBname()%></option>
			<%} %>
             </select>
             </td>
             </tr>
          </p>
          <tr>
       <td><b><h2>  Amount: </b></td> 
       <td><input type="number" min="0" placeholder="Amount" name="amount" id="amount" required><br></h2></td>
       <div id="error"><font color="red"></font></div><br><br>
       </tr>
       <tr></tr>
       <tr>
       
       </tr>
     </table>
     <div align="center"><button  type="submit" name="button" value="money" class="bt">Submit
     </button></div>
    </form>
  </body>
</html>

