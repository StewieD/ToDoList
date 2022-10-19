
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
<title>Insert title here</title>
</head>
<body>
	<table>
		<thead>
			<td>FirstName</td>
			<td>LastName</td>
			<td>UserName</td>
			<td>PassWord</td>
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

</body>
</html>