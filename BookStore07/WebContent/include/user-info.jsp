<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="/include/base.jsp" %>
   <!-- 用户未登录时显示 -->
<c:if test="${empty user}">
<div>
	<a href="pages/user/login.jsp">登录</a> | 
	<a href="pages/user/regist.jsp">注册</a> &nbsp;&nbsp;
	<a href="pages/cart/cart.jsp">购物车</a>
	<a href="pages/manager/manager.jsp">后台管理</a>
</div>	
</c:if>
	<!-- 用户登录成功显示下面这个 -->
<c:if test="${!empty user}">
<div>
	<span>欢迎<span class="um_span">${user.username}</span>光临尚硅谷书城</span>
	<a href="pages/cart/cart.jsp">购物车</a>
	<a href="client/OrderClientServlet?method=list">我的订单</a>
	<a href="UserServlet?method=logout">注销</a>&nbsp;&nbsp;
	<a href="index.jsp">返回</a>
</div>
</c:if>