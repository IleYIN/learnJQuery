<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
<!-- 
  	errorPage="test.jsp"  
   若在此处加errorPage则是转发，可以被filter dispatcher FORWARD拦截   -->
   <!-- filter dispatcher ERROR是去拦截web.xml配置中的全局配置的error-page -->
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>制造错误的页面</h1>
<%
	int i = 10/0;
%>
</body>
</html>