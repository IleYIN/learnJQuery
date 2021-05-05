<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- 所有页面要引入的资源 -->
<!-- 
	base标签的链接一般需要动态获取，而不是指定的
<base href="http://localhost:8080/BookStore01/"/>
协议://主机名:端口号/项目路径
 -->
<%-- <%=request.getScheme() %>
<%=request.getServerName() %>
<%=request.getServerPort() %>
<%=request.getContextPath() %> --%>
<base href="<%=request.getScheme()%>://<%=request.getServerName()%>:<%=request.getServerPort()%><%=request.getContextPath()%>/"/>
<link type="text/css" rel="stylesheet" href="static/css/style.css"></link>
<script type="text/javascript" src="static/script/jquery-1.12.4.js"></script>