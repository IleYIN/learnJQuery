<%@page import="listener.session.User"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	User user = new User("apache");
	//给session中保存user对象（绑定）
	session.setAttribute("user", user);
	//移除
	Thread.sleep(1000);
	//session.removeAttribute("user");
	session.invalidate();
%>
</body>
</html>