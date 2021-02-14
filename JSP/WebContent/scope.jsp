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
	//pageContext.getSession();
	
	//给pageContext域中设置内容
	pageContext.setAttribute("pageUsername", "mingzi");
	//给request域中设置内容
	request.setAttribute("reqUser","reqName");
	//给session域中设置内容
	session.setAttribute("sessionUser", "sessionName");
	//给application域设置内容
	application.setAttribute("appUser","appName");
	
%>
<jsp:forward page="scope2.jsp"></jsp:forward>
<h1>scope1</h1>
pageContext:<%=pageContext.getAttribute("pageUsername")%><br/>
request:<%=request.getAttribute("reqUser")%><br/>
session:<%=session.getAttribute("sessionUser")%><br/>
application:<%=application.getAttribute("appUser")%><br/>

<a href="scope2.jsp">去scope2看效果</a>
</body>
</html>