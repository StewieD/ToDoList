
<%@page import="DAO.userDAO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="Model.User"%>
<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="DAO.userDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>LIST ACCOUNT</title>
<link rel="icon" type="image/x-icon"
	href="https://cdn-icons-png.flaticon.com/512/243/243942.png">
<link rel="stylesheet" href="styleOfList.css">
</head>
<body>
	<div>
		<div class="card">
			<h1>List UserName</h1>
		</div>
		<div class="card">
			<table>
				<thead>
					<th>First Name</th>
					<th>Last Name</th>
					<th>User Name</th>
					<th>PassWord</th>
				</thead>

				<%
				ArrayList<User> list = userDAO.getInstance().selectAll();
				for (User u : list) {
				%>
				<tbody>
					<td><%=u.getFirstName()%></td>
					<td><%=u.getLastName()%></td>
					<td><%=u.getUserName()%></td>
					<td><%=u.getPassWord()%></td>
				</tbody>
				<%
				}
				%>
			</table>
		</div>
		<div class="card">
		<form action="Register.html"><button class="btn">ADD</button></form>	
		</div>
	</div>
</body>
</html>