<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@include file="/include/base.jsp" %>   
<html>
<head>
<meta charset="UTF-8">
<title>订单管理</title>

<!-- 头部共享信息的引入。包含jquery，base标签，以及css样式 --> 
<%@ include file="/pages/common/header.jsp" %>

</head>
<body>
	
	<div id="header">
			<img class="logo_img" alt="" src="static/img/logo.gif" >
			<span class="wel_word">订单管理系统</span>
		
		<!-- 这是manager管理模块的共同菜单  -->
		<%@ include file="/pages/common/manager_menu.jsp" %>


	</div>
	
	<div id="main">
		<table>
			<tr>
				<td>订单号</td>
				<td>日期</td>
				<td>金额</td>
				<td>详情</td>
				<td>发货</td>
			</tr>	
			<c:forEach items="${orders}" var="order">	
				<tr>
					<td>${order.orderId}</td>
					<td>${order.createDate}</td>
					<td>${order.totalMoney}</td>
					<td><a href="#">查看详情</a></td>
					<td>
						<c:choose>
							<c:when test="${order.status==0}">
								<a href="manager/OrderManagerServlet?method=deliver&orderId=${order.orderId}">点击发货</a>
							</c:when>
							<c:when test="${order.status==1}">
								等待收货
							</c:when>
							<c:when test="${order.status==2}">
								交易完成
							</c:when>
						</c:choose>
					</td>
				</tr>	
			</c:forEach>
		</table>
	</div>
	
	
	<!-- 这是页脚的引入 -->
	<%@ include file="/pages/common/footer.jsp" %>

</body>
</html>