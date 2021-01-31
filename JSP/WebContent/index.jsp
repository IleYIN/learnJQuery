 <%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<!-- jsp脚本片段 java代码片段-->
<%
	System.out.print("helloWorld");
	out.write("你好");
%>
<!-- jsp表达式  在页面输出内容-->
<%="hiiiiiii!" %>
<%=new Date() %>

<h1>我是JSP，Java server page必须运行在server里</h1>
</body>
</html>