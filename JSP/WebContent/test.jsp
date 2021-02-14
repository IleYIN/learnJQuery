<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isErrorPage="true"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%=
	config.getServletName()
%>
<% 
	out.write("你好"); 
	//out.flush();
%>
<%
	response.getWriter().write("我是中文");
//out.write写在JspWriter对象的缓冲区，缓冲完会放进response的缓冲区里面
//可以使用out.flush()来使其立刻缓冲完放进response里面
//reponse.getWriter().write()是直接写在response的缓冲区
//最后Servlet引擎写的都是response缓冲区里的东西
%>
<%=pageContext.getAttribute("username")%>
</body>
</html>