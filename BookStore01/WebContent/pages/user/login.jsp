<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<%@include file="/include/base.jsp" %>
</head>
<body>
<h1>欢迎登录</h1>
<!-- http://localhost:8080/LoginAndRegist/login.html -->
<!-- http://localhost:8080/LoginAndRegist/LoginServlet -->
<!-- 获取错误提示消息  -->
<% 
	String str = (String)request.getAttribute("msg");
/* 	if(str == null){
		str = "请输入用户名和密码";
	}  */
%>
<!-- out.print(str==null?"请输入用户名和密码":str) -->
<%=str==null?"请输入用户名密码":str %>
<form action="user/LoginServlet" method="post">
	用户名：<input type="text" name="username" value="<%=request.getParameter("username")==null?"":request.getParameter("username") %>"/><br/>
	密码：<input type="password" name="password"/><br/>
	<input type="submit" value="登录"/>
</form>

</body>
</html>