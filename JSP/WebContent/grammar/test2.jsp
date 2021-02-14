<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" errorPage="/grammar/error.jsp"
    session="true" isELIgnored="true" info="test2.jsp info"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<!--工作镜像路径 D:\informatique\JavaWebWS\.metadata\.plugins\org.eclipse.wst.server.core\tmp0\work\Catalina\localhost\JSP\org\apache\jsp\grammar -->
<%! private String name="username";
	public void test(){
		System.out.println("我是test方法");
	}
%>
<% test();
	//int i = 10/0;
	session.setAttribute("msg","你好");
%>
<% 
%>

${sessionScope.msg}
<h1>test2.jsp</h1>
<%= name %>

<!-- html注释 -->
<%-- JSP注释 --%>
<% //java注释 %>
</body>
</html>