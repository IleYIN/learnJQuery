<%@page import="java.util.UUID"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<%@include file="/include/base.jsp" %>
<script type="text/javascript">

//实际项目里，前端验证密码后，应该在后端再验证一次，因为js可能被禁用，也可能造假
	// 页面加载完成之后
 	$(function(){
		// 1.给注册按钮添加事件
		$("#sub_btn").click(function(){
			
 		 	// 获取用户名
			var usernameValue = $("#username").val();
			// 验证用户名是否合法,规则如下：必须由字母，数字，下划线组成，并且长度为5到15位。
			var usernameReg = /^\w{5,15}$/;
			// 验证用户信息
			if (!usernameReg.test(usernameValue)) {
				// 提示用户
				alert("用户名不合法！");
				return false;
			}
			
			// 获取密码
			var passwordValue = $("#password").val();
			// 验证密码是否合法,规则如下：必须由字母，数字，下划线组成，并且长度为5到15位。
			var passwordReg = /^\w{5,15}$/;
			// 验证用户信息
			if (!passwordReg.test(passwordValue)) {
				// 提示用户
				alert("密码不合法！");
				return false;
			}
			
			// 获取确认密码
			var repwdValue = $("#repwd").val();
			// 验证确认密码和密码一致
			if (passwordValue != repwdValue) {
				// 提示用户
				alert("确认密码和密码不一致！");
				return false;
			}
			
			// 获取用户名
			var emailValue = $("#email").val();
			// 验证邮件输入是否合法。
			var emailReg = /^([a-z0-9_\.-]+)@([\da-z\.-]+)\.([a-z\.]{2,6})$/;
			
			if (!emailReg.test(emailValue)) {
				// 提示用户
				alert("邮件输入不合法！");
				return false;
			}
		
			
			// 获取验证码信息
			var codeValue = $("#code").val();
			// 验证验证码不为空！
			if (codeValue == "") {
				alert("验证码不能为空！");
				return false;
			}
			
			$(this).prop("disabled",true);
			return true;
		});
		
		//2. 点击图片更换验证码
		$("#codeImg").click(function(){
			//改变src,要让浏览器知道这是新请求，有些浏览器如果是统一请求会直接从缓存中加载
			var url = "code.jpg?t="+Math.random();//t是时间戳
			//$(this).prop("src","code.jpg");
			$(this).prop("src",url);
		});
		
	});  

/*  	window.onload = function(){
		var btn = document.getElementById("sub_btn");
		btn.onclick = function(){
			//避免重复提交
			this.disabled = true;
			//提交表单
			var formEle = document.getElementsByTagName("form")[0];
			formEle.submit();
		};
	}  */
</script>
</head>
<body>
	<!-- <form action="user/RegistServlet" method="post"> -->
	<!-- 可以为post请求添加一个method字段，提交的时候，带上method值  -->
<!-- 	<form action="UserServlet?method=regist" method="post"> -->
<%
	//产生一个不重复的令牌
	String uuid = UUID.randomUUID().toString();
	session.setAttribute("token", uuid);
%>
<form action="UserServlet" method="get">
	<input type="hidden" name="method" value="regist">
	<input type="hidden" name="token" value="<%=uuid%>"/>
		<table>
			<tr>
				<td colspan="2">
					<h1>欢迎注册</h1>
					<span>
						<%-- <%=request.getAttribute("msg")==null?"请输入用户名":request.getAttribute("msg") %> --%>
						${msg==null?"请输入用户名":msg}
					</span>
				</td>
			</tr>
			<tr>
				<td>用户名：</td>
				<td><input type="text" name="username" id="username" value="${param.username}<%-- <%=request.getParameter("username")==null?"":request.getParameter("username")%> --%>"/></td>
			</tr>
			<tr>
				<td>密码：</td>
				<td><input type="password" name="password" id="password"/></td>
			</tr>
			<tr>
				<td>确认密码：</td>
				<td><input type="password" name="repwd" id="repwd"/></td>
			</tr>
			<tr>
				<td>邮箱：</td>
				<td><input type="text" name="email" id="email" value="${param.email}<%-- <%=request.getParameter("email")==null?"":request.getParameter("email")%> --%>"/></td>
			</tr>
			<tr>
				<td>验证码：</td>
				<td><input type="text" name="code" id="code"/><img alt="" src="code.jpg" id="codeImg" style="float:right;margin-right:40px;width:80px;height:22px;"></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" value="注册" id="sub_btn"/></td>
			</tr>
		</table>
	</form>
</body>
</html>