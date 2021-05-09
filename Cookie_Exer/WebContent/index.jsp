<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%-- <%
	Cookie[] cookies = request.getCookies();
	String value = "";
	if(cookies != null){
		for(Cookie c:cookies){
			if("username".equals(c.getName())){
				value = c.getValue();
			}
		}
	}
%> --%>
<form action="login">
<%-- 	用户名：<input name="username" value="<%=value %>" type="text"/> --%>
	<!-- 只取出名为username的cookie ${cookie.username} -->
	用户名：<input name="username" value="${cookie.username.value}" type="text"/>
	密码：<input name="pwd" value="" type="password"/>
	<button>登录</button>
</form>
</body>
</html>