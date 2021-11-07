<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="jquery-1.12.4.js"></script>
<script type="text/javascript">
	window.onload = function(){
		
	}; 
	
	function ajaxRequest()  {
		//如何发送ajax请求 异步请求
		//异步通信：通信之间没有任何优先级关系
		//同步通信：上一次通信完成，下一次才能继续
		//如果是异步请求，那么发送请求后，后面的代码不用等待请求完成（接收到来自服务器的数据）
		//如果是同步请求，那么发送请求后，后面的代码需要等待请求完成再执行
		
		
		// 1. 创建xhr对象，用这个对象来想服务器发送请求
		//var xhr = new XMLHttpRequest();
		var xhr = getXMLHttpRequest();
		
	/* 	xhr.onreadystatechange = function(){
			console.log(xhr.readyState);
		} */
		
		// 2. 发送请求 open() send()
		// method请求类型 GET POST
		// url 请求地址
		// async 是否为异步 默认true是异步
		
		// username, password 验证权限 可以不带
		//xhr.open(method,url,async,username,password)
		// 3. open只是设置请求信息的，可以将请求参数
		//xhr.open("GET","AJAXServlet?username=abc&pwd=123",false);
		//加一个随机数可以避免浏览器从缓存里加载而不是重新加载
		xhr.open("GET","AJAXServlet?username=abc&pwd=123&t="+Math.random(),true);
		// 4. Object body 请求体，把要发送的数据放在请求体
		/*
			form method=get 请求体会把url覆盖掉
			body 是给post用的
		*/
		// xhr.send(body);
		
		// 6. 必须接收相应的数据
		// xhr对象有两个属性
		// responseText获取字符串形式的响应数据
		// responseXML 获取XML形式的响应数据
		// alert(xhr.reponseText);
		// 必须在响应完成的时候才能接收到, 需要监控请求状态 readyState
		// onreadystatechange 每当请求状态改变时就会执行
		// 0 请求初始化； 1 服务器连接已经建立；2 请求已接收；
		// 3 请求处理中；4 请求已完成，且响应已就绪
	
		xhr.onreadystatechange = function(){
			// 当请求已经完成时
			if(xhr.readyState == 4 && xhr.status == 200 ) {
				// 获取数据
				//console.log(xhr.responseText);
				var divEle = document.getElementById("div_time");
				divEle.innerHTML = xhr.responseText;
			}
		}
		// 5. 调用send方法将请求发出去
		xhr.send();
		
		alert("wait end");
	}
	
	function getXMLHttpRequest() {
		var xhr;
		try{
			//大部分浏览器都支持
			xhr = new XMLHttpRequest();
		} catch (e) {
			try{
				//如果不支持，在这里捕获异常并且采用IE6支持的方式
				xhr = new ActiveXObject("Msxml2.XMLHTTP");
			} catch (e) {
				//如果还不支持，在这里捕获异常并且采用IE5支持的方式
				xhr = new ActiveXObject("Microsoft.XMLHTTP");
			}
		}
		return xhr;
	}
	/* js发送ajax请求很麻烦不同浏览器可能不一样，使用jquery发请求	*/
	
</script>
<script type="text/javascript">
	function ajaxRequest2(){
		//jQuery.get(url,data,callback,type) 
		// type表示返回内容的格式 xml html script json text _default（浏览器默认值）
		//jQuery接收参数只需要在回调函数中定义一个接收响应参数
		$.get("AJAXServlet?username=abc&pwd=123",function(data){
			console.log("请求成功");
			console.log(data);
			var obj = JSON.parse(data);
			$("#div_time").text(obj.name);
		},"text");
	}
</script>
</head>
<body>
<iframe name="ajaxframe">
</iframe>
<a href="AJAXServlet" target="ajaxframe">发送请求，获取服务器时间</a>
<button onclick="ajaxRequest();">发送ajax请求</button>
<button onclick="ajaxRequest2();">发送ajax2请求</button>
<div id="div_time"></div>
</body>
</html>