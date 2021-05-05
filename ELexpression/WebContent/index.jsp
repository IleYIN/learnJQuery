<%@page import="bean.Student"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<!-- jsp脚本片段 pageContext, request, session, application 在资源之间共享数据 -->
<%
	Student student = new Student("小明", 18);
//	pageContext.setAttribute("pageAttr", student);
//	request.setAttribute("requestAttr", "requestValue");
	pageContext.setAttribute("stu", student);
	request.setAttribute("stu", "requestValue");
	//request.setAttribute("stu-x", "requestValue111");
	request.setAttribute("stu-y", student);
	session.setAttribute("sessionAttr", "sessionValue");
	application.setAttribute("stu", "appValue222");
	
	String str = "你好";
%>
<%-- <hr/>
JSP表达式取出四个域中的内容：<br/>
page:<%=((Student)pageContext.getAttribute("pageAttr")).getName() %><br/>
request:<%=request.getAttribute("requestAttr") %><br/>
session:<%=session.getAttribute("sessionAttr") %><br/>
application:<%=application.getAttribute("appAttr") %><br/>
<hr/> --%>
<%-- JSP表达式获取str:<%=str %><br/>
el表达式无法获取str:${str}<br/> --%>
JSP表达式获取:<%=request.getAttribute("stu-x") %><br/>
el表达式获取:${requestScope['stu-x']}<br/>
el表达式获取2:${requestScope['stu-y'].name}<br/>
el表达式获取3:${requestScope['stu-y']['name']}<br/>

使用el表达式获取域内容 <br/>
<!-- 语法格式${表达式内容} -->
<%-- page:${pageAttr.name}<br/> --%>
<%-- request:${requestAttr}<br/> --%>
<%-- page:${stu}<br/> --%>
<%-- request:${stu}<br/> --%>
page:${pageScope.stu.name}<br/>
request:${requestScope.stu}<br/>
session:${sessionAttr}<br/>
application:${applicationScope.stu}<br/>


<!-- el中的其它对象 pageContext可以取出jsp页面其它的隐含对象,可以取出所以隐含对象中的属性 -->
${pageContext.request.scheme}
<%=pageContext.getRequest().getScheme() %>

<!-- 和HTTP协议有关 5个 -->
param (封装了所有的请求参数的key-value) 对应一个请求参数 request.getParameter("username")<br>
paramValues对应一组请求参数<br>
header 请求头 request.getHeader("User-Agent") <br>
headervalues 请求头返回字符数组 <br>
cookie 获取某个cookie对象 取出cookie的值<br>
<!-- http://localhost:8080/ELexpression/index.jsp?username=hihihi -->
<!-- http://localhost:8080/ELexpression/index.jsp?username=hihihi&hobby=a&hobby=b -->
请求参数： ${param.username }<br>
获取多个请求参数：${paramValues.hobby[0]},${paramValues.hobby[1]}<br>

获取请求头：${header['User-Agent'] }
获取请求头：${header['Host'] }<br>
<hr/>
${pageScope.stu.flag}
<br/><br/>
<!-- cookie是一个对象，是和session会话有关，不同浏览器不一样 -->
获取Cookie：${cookie.JSESSIONID.name } || ${cookie.JSESSIONID.value }<br>
<!-- initParam获取web的初始化参数而不是整个servlet的初始化参数 -->
初始化参数：${initParam.user}
</body>
</html>