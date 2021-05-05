<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="bean.Student"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	pageContext.setAttribute("msg","你好");
	pageContext.setAttribute("msg2","<h1>hi</h1>");
%>
<c:out value="${msg}" default="hello" escapeXml=""></c:out><br>
<c:out value="${msg1}" default="hello" escapeXml=""></c:out><br>
<c:out value="${msg2}" default="hello" escapeXml="true"></c:out><br>
<c:out value="${msg2}" default="hello" escapeXml="false"></c:out>
<br>
<c:set var="tip" scope="page" value="我是tip,${pageScope.msg}"></c:set>
${pageScope.tip}

<hr/>
<%
	Student stu = new Student("tomcat",18);
	pageContext.setAttribute("stu", stu);
	request.setAttribute("stu", stu);
	session.setAttribute("stu", stu);
	application.setAttribute("stu", stu);
%>
<c:set property="username" value="apache" target="<%=stu%>"></c:set>
<c:set property="username" value="apache2" target="${stu}"></c:set>
<%=stu.getUsername() %>

<hr>
<c:remove var="stu" scope="page"/>
page:${pageScope.stu.username }<br>
request:${requestScope.stu.username }<br>
session:${sessionScope.stu.username }<br>
application:${applicationScope.stu.username }<br>

<hr>
<c:if test="${5>6}">我是c:if里面的1</c:if>
<c:if test="${5>3}">我是c:if里面的2</c:if>
<c:if test="${stu.username=='apache2'}" scope="page" var="flag">
	我是c:if里面的3
	<c:if test="${5<6 }">我是嵌套if里面的</c:if>
</c:if>
${pageScope.flag}
<br>
<c:if test="${stu.age>=18 }">补办身份证</c:if>
<c:if test="${stu.age<18 }">还未成年</c:if>

<hr>
<c:choose>
	<c:when test="${stu.age>18}">
	补办身份证，年龄是${stu.age }
	</c:when>
	<c:when test="${stu.age==18}">
	刚成年，年龄是${stu.age }
	</c:when>
	<c:otherwise>
	未成年
	</c:otherwise>
</c:choose>
<hr>
<c:forEach begin="0" end="10" var="num">
	${num }
</c:forEach>
<br>
<c:forEach begin="0" end="10" var="num" step="2">
	${num }
</c:forEach>
<br>
<%
	List<Student> list = new ArrayList<Student>();
	list.add(new Student("小明",5));
	list.add(new Student("小红",15));
	list.add(new Student("小光",25));
	list.add(new Student("小东",25));
	list.add(new Student("小南",25));
	request.setAttribute("list", list);
%>
<c:forEach var="stu" items="<%=list %>">
	${stu.username }-->${stu.age }
<%-- 实际上把这个对象放进page域中了	page:${pageScope.stu.username } --%>
</c:forEach>
<hr>
<table>
	<tr>
		<th>用户名</th>
		<th>年龄</th>
		<th>status.begin</th>
		<th>status.end</th>
		<th>status.step</th>
		<th>status.count</th>
		<th>status.index</th>
		<th>status.last</th>
	</tr>
<c:forEach begin="0" end="4" step="1" var="stu" items="${requestScope.list }" varStatus="status">
	<tr>
		<td>
			${stu.username}
		</td>
		<td>
			${stu.age}
		</td>
		<td>
			${status.begin}
		</td>
		<td>
			${status.end}
		</td>
		<td>
			${status.step}
		</td>
		<td>
			${status.count}
		</td>
		<td>
			${status.index}
		</td>
		<td>
			${status.last}
		</td>
	</tr>
</c:forEach>
</table>
<hr>
<a href="/index.jsp">你好</a><!-- http://localhost:8080/index.jsp -->
<c:url value="/index.jsp" var="uri" scope="request"></c:url>
<!-- /JSTL/index.jsp  c:url里加上/会自动加上项目名 -->
${uri }
<a href="${url}">你好2</a>
<hr>
<%-- <c:if test="${msg }">
	<c:redirect url="/index.jsp"></c:redirect>
</c:if> --%>
</body>
</html>