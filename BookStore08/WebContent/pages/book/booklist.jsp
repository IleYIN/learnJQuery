<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>书城首页</title>

<!-- 头部共享信息的引入。包含jquery，base标签，以及css样式 --> 
<%@include file="/pages/common/header.jsp" %>
<script type="text/javascript">
	$(function(){
		//加入购物车ajax
		$(".addCartBtn").click(function(){
			//url, [data], function(data){}
			//获取当前btn自定义的updateId, attr
			var bookId = $(this).attr("updateId");
			$.getJSON("client/CartServlet?method=addAjax&id=${book.id}"+bookId, function(data){
				console.log(data.title);
				//将数据的内容放在相应区域
				$("#totalCountTip").text(data.totalCount);
				$("#bookTitleTip").text("您刚刚将【"+data.title+"】加入购物车");
			});
		});
	});
</script>
</head>
<body>
	<div id="header">
			<img class="logo_img" alt="" src="static/img/logo.gif" >
			<span class="wel_word">网上书城</span>
			<%@include file="/include/user-info.jsp" %>	
	</div>
	<div id="main">
		<div id="book">
			<div class="book_cond">
			<!--<form action="client/BookClientServlet?method=pageByPrice" method="post">  -->	
				<form action="client/BookClientServlet" method="get">
					<input type="hidden" name="method" value="pageByPrice"/>
					<!-- //refer（请求地址）只是指上次的请求行
					//get 请求地址包括请求数据
					//post 请求地址不包括请求数据 
					//为了refer带上请求数据 可以用get而不是post
					//但是get会覆盖?后的东西（如方法），所以要把方法放隐藏域中
					 -->
					价格：<input id="min" type="text" name="min" value="${param.min }"> 元 - 
						<input id="max" type="text" name="max" value="${param.max }"> 元 
						<input type="submit" value="查询" />
				</form>
			</div>
			<div style="text-align: center">
				<%-- <span>您的购物车中有${empty cart.totalCount ? 0 : cart.totalCount}件商品</span> --%>
				<span>
				<!-- 翻页后的购物车中的图书总量应该先从session中获取
						在页面发送ajax请求再动态修改图书总量
				  -->
					当前购物车中有<span id="totalCountTip">
					<c:out value="${cart.totalCount }" default="0"></c:out>
					</span> 件商品
					<%--您的购物车中有 <c:out value="${cart.totalCount}" default="0"></c:out> 件商品--%>
				</span>
<%-- 				<c:if test="${empty title }">
				<div>
					<span> &nbsp; </span>
				</div>
				</c:if>
				<c:if test="${!empty title }"> --%>
				<div>
					<%-- 您刚刚将<span style="color: red">${title }</span>加入到了购物车中
					<c:remove var="title" scope="session"/> --%>
					<!-- 提示图书名的span -->
					<span id="bookTitleTip"> &nbsp; </span>
				</div>
			<%-- 	</c:if> --%>
			</div>
			<c:forEach items="${page.pageData }" var="book" >
			<div class="b_list">
				<div class="img_div">
					<img class="book_img" alt="" src="${book.imgPath }" />
				</div>
				<div class="book_info">
					<div class="book_name">
						<span class="sp1">书名:</span>
						<span class="sp2">${book.title }</span>
					</div>
					<div class="book_author">
						<span class="sp1">作者:</span>
						<span class="sp2">${book.author }</span>
					</div>
					<div class="book_price">
						<span class="sp1">价格:</span>
						<span class="sp2">￥${book.price }</span>
					</div>
					<div class="book_sales">
						<span class="sp1">销量:</span>
						<span class="sp2">${book.sales }</span>
					</div>
					<div class="book_amount">
						<span class="sp1">库存:</span>
						<span class="sp2">${book.stock }</span>
					</div>
					<div class="book_add">
						<button updateId="${book.id }" class="addCartBtn">加入购物车</button>
						<%-- <a style="color:blue;" href="client/CartServlet?method=add&id=${book.id }">加入购物车</a> --%>
					</div>
				</div>
			</div>
		</c:forEach>
		</div>
		
		<%@include file="/include/page.jsp" %>		
	
	</div>

</body>
</html>