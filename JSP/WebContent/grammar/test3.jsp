<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>我是test3</h1>
	<%-- <%@include file="error.jsp" %> --%>
	<%-- <%@include file="/grammar/error.jsp" %> --%>
	<%-- 	<jsp:include page="error.jsp"></jsp:include> --%>
	<jsp:forward page="error.jsp">
		<jsp:param value="mingzi" name="username"/>	
		<jsp:param value="123456" name="password"/>	
	</jsp:forward>
</body>
</html>