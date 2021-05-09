<%@page import="cookie.User"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	session.setAttribute("sessAttr","sessionValue");
	session.setAttribute("user", new User("张三"));
%>
<a href="s.jsp">去其他页面获取数据</a>
<!-- 重写url -->
<%=
	response.encodeRedirectURL(request.getContextPath()+"/s.jsp")
%>
<a href="<%=response.encodeRedirectURL(request.getContextPath()+"/s.jsp")%>">去其他页面获取数据2</a>
<!-- jstl可以替代  value指定要重写哪个url  /代表当前项目 -->
<c:url value="/s.jsp"></c:url>
<a href="<c:url value="/s.jsp"></c:url>">去其他页面获取数据3</a>
</body>
</html>