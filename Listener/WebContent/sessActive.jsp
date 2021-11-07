<%@page import="listener.session.Student"%>
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
	//给session域中保存一个Student对象
	Student stu = new Student("tomcat");
	session.setAttribute("stu", stu);
%>
</body>
</html>