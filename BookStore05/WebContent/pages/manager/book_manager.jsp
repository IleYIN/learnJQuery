<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>图书管理</title>

<!-- 头部共享信息的引入。包含jquery，base标签，以及css样式 --> 
<%@ include file="/pages/common/header.jsp" %>
<script type="text/javascript">
	$(function(){
		$(".delBtn").click(function(){
			//alert("删除");
			//this代表当前被点击的a
			//$(this).parent() -> td .parent() -> tr
			var td = $(this).parent().parent().children(":first");
			//alert(td.text());
			if(!confirm("确认删除【"+td.text()+"】吗？")){
				//不删除
				return false;
			}
		});
	});
/* 	$(function(){
		$(".delBtn").on("click",function(){
			alert("删除");
			return false;
		});
	}); */
</script>
</head>
<body>
	
	<div id="header">
			<img class="logo_img" alt="" src="static/img/logo.gif" >
			<span class="wel_word">图书管理系统</span>
		
		<!-- 这是manager管理模块的共同菜单  -->
		<%@ include file="/pages/common/manager_menu.jsp" %>
	</div>
	<!-- 所有图书的集合 -->
<!--	${requestScope.list } -->
	<div id="main">
		<table>
			<tr>
				<td>名称</td>
				<td>价格</td>
				<td>作者</td>
				<td>销量</td>
				<td>库存</td>
				<td colspan="2">操作</td>
			</tr>		
			<%-- <c:forEach items="${requestScope.list }" var="book"> --%>
			<c:forEach items="${requestScope.page.pageData }" var="book">
				<!-- 每一本图书的详细信息 -->
				<tr>
					<td>${book.title}</td>
					<td>${book.price}</td>
					<td>${book.author}</td>
					<td>${book.sales}</td>
					<td>${book.stock}</td>
					<!-- <td><a href="pages/manager/book_edit.jsp">修改</a></td> -->
					<!-- <td><a href="pages/manager/book_edit.jsp?id=${book.id}&price=${book.price}">修改</a></td> -->
					<!-- <td><a class="delBtn" href="#" onclick="alert('删除');return false;">删除</a></td> -->
					<%-- <td><a href="manager/BookManagerServlet?method=getBook&id=${book.id }&m=update">修改</a></td> --%>
					<td><a href="manager/BookManagerServlet?method=getBook&id=${book.id }&pn=${page.pageNo}">修改</a></td>
					<td><a class="delBtn" href="manager/BookManagerServlet?method=delete&id=${book.id }&pn=${page.pageNo}">删除</a></td>
				</tr>
			</c:forEach>
	<!-- 		<tr>
				<td>时间简史</td>
				<td>20.00</td>
				<td>霍金</td>
				<td>200</td>
				<td>400</td>
				<td><a href="pages/manager/book_edit.jsp">修改</a></td>
				<td><a href="#">删除</a></td>
			</tr>	 -->
			
			<tr>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<!-- <td><a href="pages/manager/book_edit.jsp?&m=add">添加图书</a></td> -->
				<td><a href="pages/manager/book_edit.jsp?pn=${page.totalPage }">添加图书</a></td>
			</tr>	
		</table>
		
		<%@include file="/include/page.jsp" %>
					
	</div>
	
	
	<!-- 这是页脚的引入 -->
	<%@ include file="/pages/common/footer.jsp" %>

</body>
</html>