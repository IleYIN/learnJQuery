<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" session="false"%><!-- 禁用session 则jsp不自动获取session对象-->
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html;charset=UTF-8">
<title>Insert title here</title>
<style type="text/css">
	ul{
		float:left;
	}
	iframe{
		float:left;
	}
	div{
		width:600px;
		height:500px;
		margin-left:auto;
		margin-right:auto;
		/* border: 1px solid black; */
	}
</style>
</head>
<body>
<div>
	<iframe name="sessionFrame">
	</iframe>
	<ul>
		<li><a target="sessionFrame" href="SessionServlet?method=get">获取session对象</a></li>
		<li><a target="sessionFrame" href="SessionServlet?method=save">给session中保存内容</a></li>
		<li><a target="sessionFrame" href="SessionServlet?method=getvalue">获取session中内容</a></li>
		<li><a target="sessionFrame" href="SessionServlet?method=time">获取session有效时间</a></li>
		<li><a target="sessionFrame" href="SessionServlet?method=updatetime">修改session的有效时间</a></li>
		<li><a target="sessionFrame" href="SessionServlet?method=invalid">强制session失效</a></li>
		<li><a target="sessionFrame" href="SessionServlet?method=persist">关闭浏览器保持session持久化</a></li>
		<li><a href="s.jsp">去其他页面取数据</a></li>
	</ul>
</div>
</body>
</html>