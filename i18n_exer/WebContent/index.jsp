<%@page import="java.util.Locale"%>
<%@page import="java.util.ResourceBundle"%>
<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	Locale locale = request.getLocale();
	String lang = request.getParameter("lang");
	String country = request.getParameter("country");
	if (lang != null && !"".equals(lang) 
			&& country != null && !"".equals(country)) {
		//动态创建Locale对象
		locale = new Locale(lang, country);
		System.out.println(locale);
	}
	ResourceBundle bundle = ResourceBundle.getBundle("bookstore", locale);
%>
<h3><%=bundle.getString("welcome")%> <%=new Date() %></h3>
<form action="">
	<%=bundle.getString("username")%><input name="username"/>
	<br/>
	<%=bundle.getString("password")%><input name="password" type="password"/>
	<br/>
	<button><%=bundle.getString("login")%></button>
</form>
<a href="index.jsp?lang=zh&country=CN">中文</a> | <a href="index.jsp?lang=en&country=US">English</a>
</body>
</html>