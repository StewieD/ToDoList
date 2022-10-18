
<%@page import="DAO.userDAO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="Model.User"%>
<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="DAO.userDAO" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<% User user = new User("zxcasd","qwefff","fffssww", "poorj");%>
	<% out.println(user.toString()); %>
	<%ArrayList<User> list = userDAO.getInstance().selectByCondition("username='haidan0'"); %>
	<%for (User u : list) {
		System.out.println(u);
	} %>

</body>
</html>