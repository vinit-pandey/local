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
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body background="cash.jpg" style="background-attachment:fixed;height:50%;background-repeat: no-repeat;background-position: center; background-size: cover;">
<div class="w3-container">
<center>
  <h2 >Admin</h2>
  </center>
</div>

<hr size="35" width="100%" color="black"></hr>

<div class="w3-bar w3-black"></div>


	<%
		ArrayList<ManagerBean> arr = (ArrayList<ManagerBean>)request.getAttribute("mset");
	
		System.out.println("jsp array="+arr);
		
  	%>
	<div id="container" align="center">
  	<table>
	<tr>
	<th>EmployeeID</th>
	<th>Branch</th>
	<th>IFSC</th>
	</tr>
	<% for(ManagerBean bean : arr) {%>
	<tr>
	<td><%=bean.getEid()%></td>
	<td><%=bean.getBranch()%></td>
	<td><%=bean.getIfsc()%></td>
	</tr>
	
	<%} %>
</table>
</div>
</body>
</html>