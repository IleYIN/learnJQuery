<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>request域对象属性监听</h1>
<%
	//给request域中保存了一个属性
	request.setAttribute("user","tomcat");
	Thread.sleep(1000);
	//修改user的值
	request.setAttribute("user","apache");
	Thread.sleep(1000);
	request.removeAttribute("user");
%>
</body>
</html>