<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!-- 头部共享信息的引入。包含jquery，base标签，以及css样式 --> 
<%@include file="/pages/common/header.jsp" %>
<script type="text/javascript">
	$(function(){
      $("#gotopage").click(function(){
			//用户输入了要去第几页
			//获取输入值
			var pn = $("#pn_input").val();
			//发送分页请求 注意el表达式在javascript里面要加双引号！
			//window.location.href = "page/BookManagerServlet?method=page&pn="+pn;
			var base = "<%=request.getScheme()%>://<%=request.getServerName()%>:<%=request.getServerPort()%><%=request.getContextPath()%>/";
			window.location.href = base + "${page.url}&pn="+pn;
		});
	});
</script>
<div id="page_nav">
<!-- 分页的详细信息 page -->
	<a href="${page.url }&pn=1">首页</a>
	<c:if test="${page.hasPrev }">
		<%-- <a href="manager/BookManagerServlet?method=page&pn=${page.pageNo-1 }">上一页</a> --%>
		<a href="${page.url }&pn=${page.pageNo-1 }">上一页</a>
	</c:if>
	
	<!-- 当前页 前后各显示2页页码 -->
	<!-- 显示所有页码 总页码 - totalPage begin -->
	<c:if test="${page.totalPage<=5 }">
		<c:set var="begin" value="1" scope="page"></c:set>
		<c:set var="end" value="${page.totalPage }" scope="page"></c:set>
	</c:if>
	<c:if test="${page.totalPage>5 }">
		<c:if test="${page.pageNo<=3 }">
			<c:set var="begin" value="1" scope="page"></c:set>
			<c:set var="end" value="5" scope="page"></c:set>
		</c:if>
		<c:if test="${(page.pageNo>3) && (page.pageNo<=page.totalPage-2) }">
			<c:set var="begin" value="${page.pageNo-2 }" scope="page"></c:set>
			<c:set var="end" value="${page.pageNo+2}" scope="page"></c:set>
		</c:if>
		<c:if test="${page.pageNo>page.totalPage-2 }">
			<c:set var="begin" value="${page.totalPage-4 }" scope="page"></c:set>
			<c:set var="end" value="${page.totalPage}" scope="page"></c:set>
		</c:if>
	</c:if>
	
	<c:forEach begin="${begin }" end="${end}" var="pnum">
		<c:if test="${pnum == page.pageNo }">
			<span style="color:blue">【${page.pageNo }】</span>
		</c:if>	
		<c:if test="${pnum != page.pageNo }">
			<a href="${page.url }&pn=${pnum}">${pnum }</a>
		</c:if>	
	</c:forEach>
		
	<c:if test="${page.hasNext }">
		<a href="${page.url }&pn=${page.pageNo+1 }">下一页</a>
	</c:if>
	<a href="${page.url }&pn=${page.totalPage}">末页</a>
	共${page.totalPage}页，${page.totalCount}条记录 到第<input value="${page.pageNo}" name="pn" id="pn_input"/>页
	<input type="button" value="确定" id="gotopage">
</div>