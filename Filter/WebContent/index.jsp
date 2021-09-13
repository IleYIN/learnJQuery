<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<a href="hello.jsp">去hello.jsp 没带上条件</a>
<a href="hello.jsp?condition=1">去hello.jsp 带上条件</a>
<a href="TestServlet1">过servlet去test.jsp</a>
<!-- 静态包含 -->
<%-- <%@include file="test.jsp" %> --%>
<!-- 动态包含 filter dispatcher 能拦截动态包含，静态不行-->
<jsp:include page="test.jsp"></jsp:include>
</body>
</html>