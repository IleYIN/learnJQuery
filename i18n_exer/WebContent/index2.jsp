<%@page import="java.util.Locale"%>
<%@page import="java.util.ResourceBundle"%>
<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<!-- fmt标签 JSTL（JSP Standard TagLibrary) -->
<!-- 设置区域的全名 语言_国家 -->
<fmt:setLocale value="${param.lang }"/>
<!-- 设置Locale要在Bundle之前 -->
<!-- 设置资源的基础名 -->
<fmt:setBundle basename="bookstore"/>
<h3>
	<!-- 获取资源文件中的信息 -->
	<fmt:message key="info">
		<fmt:param><span style="color:blue">小红</span></fmt:param>
		<fmt:param>
			<span style="color:blue">
				<fmt:formatDate value="<%=new Date() %>" type="both" dateStyle="full" timeStyle="full" />
			</span>
		</fmt:param>
	</fmt:message>
	<br/>
	<fmt:message key="welcome"/>
	<fmt:formatDate value="<%=new Date() %>" type="both" dateStyle="full" timeStyle="full" />
</h3>
<form action="">
	<fmt:message key="username"/><input name="username"/>
	<br/>
	<fmt:message key="password"/><input name="password" type="password"/>
	<br/>
	<button><fmt:message key="login"/></button>
</form>
<a href="index2.jsp?lang=zh_CN">中文</a> | <a href="index2.jsp?lang=en_US">English</a>
</body>
</html>