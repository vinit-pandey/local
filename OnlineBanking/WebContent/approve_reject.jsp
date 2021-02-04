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

<center><h1>Approve/Reject Pending Request</h1></center>
<hr size="35" width="100%" color="black";></br></hr>

<div id="container" align="center">

	<%
		ArrayList<CustomerBean> arr = (ArrayList<CustomerBean>)request.getAttribute("result");
	
		System.out.println("jsp array="+arr);
		
  	%>
<form action="ManagerController" method="post">
<table>
<tr>
<th>UserName</th>
<th>Account Number</th>
<th>Branch</th>
<th>Approve</th>
<th>Reject</th>
</tr>

<% int count = 0; 
		String val = "r";
	for(CustomerBean bean : arr) {
		val = "r"+count;
	%>
	<tr>
	<td><%=bean.getUname() %></td>
	<td><%=bean.getAccno() %></td>
	<td><%=bean.getBranch() %></td>

	<td><input type="radio" name=<%= val %> value="approve <%= bean.getUname() %>"></td>
	
	<td><input type="radio" name=<%= val %> value="reject <%= bean.getUname() %>"></td>
	</tr>
	
	<% 
	//System.out.print(val+" ");
	val = "r";
	count++;} %>


</table>

<br>
<button type="submit" name="button" value="status">Submit</button>

</form>

</div>

</body>
</html>