<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>购物车</title>

<!-- 头部共享信息的引入。包含jquery，base标签，以及css样式 --> 
<%@ include file="/pages/common/header.jsp" %>
<script type="text/javascript">
	$(function(){
		$(".delBtn").click(function(){
			var textEle = $(this).parents("tr").children(":first").text();
			if(!confirm("确认删除【"+textEle+"】吗？")){
				return false;//不确认则取消
			}
		});
		//当input框内容发生变化时执行代码
		$(".changeinput").change(function(){
			//获取到修改的数量
			var count = $(this).val();
			//获取要修改的id
			var id = $(this).attr("updateid");
			//发请求修改数量
			location.href = "client/CartServlet?method=update&id="+id+"&count="+count;
		});
		//layerui
		$("#clearBtn").click(function(){
			if(!confirm("确认清空购物车吗？")){
				return false;//不确认则取消
			}
		});
	});
</script>
</head>
<body>
	
	<div id="header">
			<img class="logo_img" alt="" src="static/img/logo.gif" >
			<span class="wel_word">购物车</span>
				
		<!-- 登录成功之后所有相同的菜单  -->
		<%@ include file="/include/user-info.jsp" %>

	</div>
	
	<div id="main">
		<c:if test="${empty cart.allItems}">
			<div style="position:absolute;left:400px;">
				<h1>购物车为空，请<a href="index.jsp">购买</a></h1>
			</div>
		</c:if>
		<c:if test="${!empty cart.allItems}">
			<table>
				<tr>
					<td>商品名称</td>
					<td>数量</td>
					<td>单价</td>
					<td>金额</td>
					<td>操作</td>
				</tr>		
				<c:forEach items="${cart.allItems }" var="item">
				<tr>
					<td>${item.book.title }</td>
					<td>
						<input updateid="${item.book.id }" class="changeinput" type="text" style="width:30px" name="count" value="${item.count }"/>
					</td>
					<td>${item.book.price }</td>
					<td>${item.totalPrice }</td>
					<td><a class="delBtn" href="client/CartServlet?method=delete&id=${item.book.id }">删除</a></td>
				</tr>		
				</c:forEach>
			</table>
			<div class="cart_info">
				<span class="cart_span">购物车中共有<span class="b_count">${cart.totalCount }</span>件商品</span>
				<span class="cart_span">总金额<span class="b_price">${cart.totalMoney }</span>元</span>
				<span class="cart_span"><a id="clearBtn" href="client/CartServlet?method=clear">清空购物车</a></span>
				<span class="cart_span"><a href="pages/cart/checkout.jsp">去结账</a></span>
			</div>
		</c:if>
	</div>
	
	
	<!-- 这是页脚的引入 -->
	<%@ include file="/pages/common/footer.jsp" %>

</body>
</html>