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
<!-- jsp模板元素：jsp页面中的静态HTML内容 
	HTML写页面结构，定义页面结构
	
	就是被原封不动的翻译到java代码里，按顺序翻译
	
	找工作空间的镜像文件：D:\informatique\JavaWebWS\.metadata\.plugins\org.eclipse.wst.server.core\tmp0\work\Catalina\localhost\JSP\org\apache\jsp
-->
	<h1>你好</h1>
	<script type="text/javascript">
		//alert("你好吗");
	</script>
	
<!-- jsp表达式 
	在页面输出内容
	注意：表达式里面的所有内容都是被传参进out.print(new Date())
		  = 后面的参数该怎么写就怎么写，不能写分号
-->
<%= new Date() %>
<%="hiiiiiii!" %>

<!-- jsp脚本片段
	在脚本片段里编写java代码
	脚本片段会被原封不动地逐行复制到.java文件里
	脚本片段可以写多个
	还可以拆分写多个-合起来必须是合法且完整的
	脚本片段的代码都放在service方法里面
	所以里面不能定义方法
 -->
<% 
	int age = 20;
	if(age >= 18){
%>
	<h1>>18</h1>
<%
	//	out.print("<br/>>=18<br/>");
	} else {
		out.print("<br/><18<br/>");
	}
%>

<%
	out.print("hooo</br>");
%>
</body>
</html>