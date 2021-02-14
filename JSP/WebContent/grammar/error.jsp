<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isErrorPage="true"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>发生错误</h1>
<%-- <%=exception.getMessage()%> --%>
<%=
	request.getParameter("username")+"--"+request.getParameter("password")
%>
</body>
</html>