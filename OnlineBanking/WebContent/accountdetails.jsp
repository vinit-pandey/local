<%@page import="com.wipro.banking.bean.*,java.util.*,java.lang.*"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<style type="text/css">
#container {
  font-family: "Trebuchet MS", Arial, Helvetica, sans-serif;
  border-collapse: collapse;
  width: 100%;
}
#container td, #container th {
  border: 1px solid #ddd;
  padding: 8px;
}
#container th {
  padding-top: 12px;
  padding-bottom: 12px;
  text-align: left;
  background-color: #4CAF50;
  color: white;
}

</style>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body background="cash.jpg" style="background-attachment:fixed;height:50%;background-repeat: no-repeat;background-position: center; background-size: cover;">
<center><h1>Account Details</h1></center>
<hr size="35" width="100%" color="black";></br></hr>


	<%
		ArrayList<CustomerBean> arr = (ArrayList<CustomerBean>)request.getAttribute("data");
	
		//System.out.println("jsp array="+arr);
		
  	%>
  	
  	<div id="container" align="center">
  	<table>
	<tr>
	<th>User Name</th>
	<th>Account Number</th>
	<th>Address</th>
	<th>Branch</th>
	<th>State</th>
	<th>IFSC</th>
	<th>Amount</th>
	<th>Mobile</th>
	</tr>
	<% for(CustomerBean bean : arr) {%>
	<tr>
	<td><%=bean.getUname()%></td>
	<td><%=bean.getAccno()%></td>
	<td><%=bean.getAddress()%></td>
	<td><%=bean.getBranch()%></td>
	<td><%=bean.getState()%></td>
	<td><%=bean.getIfsc()%></td>
	<td><%=bean.getAmount()%></td>
	<td><%=bean.getMobile()%></td>
	</tr>
	
	<%} %>
</table>
</div>

</body>
</html>