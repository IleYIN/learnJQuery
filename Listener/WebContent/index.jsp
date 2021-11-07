<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%=
	application
%>
<%
	Thread.sleep(1000);
	//销毁session
	session.invalidate();
%>
<a href="note.txt">发请求</a>
<a href="reqAttr.jsp">req域属性监听</a>
</body>
</html>