<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>scope2</h1>
pageContext:<%=pageContext.getAttribute("pageUsername")%><br/>
request:<%=request.getAttribute("reqUser")%><br/>
session:<%=session.getAttribute("sessionUser")%><br/>
application:<%=application.getAttribute("appUser")%><br/>
</body>
</html>