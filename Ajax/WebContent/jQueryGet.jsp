<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="jquery-1.12.4.js"></script>
<script type="text/javascript">
	$(function(){
		//如何发送get请求 get(url,data,callback,type)
		//url请求地址,data请求参数,callback请求成功的回调函数,
		//type设置返回响应的内容类型 xml, html, script, json, text, _default
		
		$("#btn01").click(function(){
			$.get("JQueryGetServlet?method=getUrlParam&id="+Math.random(),
					function(data){
					//data接收相应数据 默认是string
					//alert(typeof data);
					var obj = JSON.parse(data);
					var str = "学生名："+obj.name;
					str += "<br/>学生年龄："+obj.age;
					$("#divShow").html(str);
			});
		});

		$("#btn02").click(function(){
			$.get("JQueryGetServlet?method=getUrlParam&id="+Math.random(),
					function(data){
					//data接收相应数据 默认是string
					//alert(typeof data);
					//get方法中声明为json时会自动转化为json对象
					var obj = data;
					var str = "学生名："+obj.name;
					str += "<br/>学生年龄："+obj.age;
					$("#divShow").html(str);
			},"json");
		});
		
		$("#btn03").click(function(){
				//发送请求携带数据
			$.get("JQueryGetServlet?method=getUrlData&id="+Math.random(),
					{name:"名字3",age:12},
					function(data){
					//data接收相应数据 默认是string
					//alert(typeof data);
					//get方法中声明为json时会自动转化为json对象
					var obj = data;
					var str = "学生名："+obj.name;
					str += "<br/>学生年龄："+obj.age;
					$("#divShow").html(str);
			},"json");
		});
		$("#btn04").click(function(){
				//只传url
			$.get("JQueryGetServlet?method=getUrlData&id="+Math.random());
		});
	});
	
	// $.getJSON() 相当于 $.get(...,"json")
</script>
</head>
<body>
<button id="btn01">JQueryGet请求，携带参数url中,type默认是text</button>
<button id="btn02">JQueryGet请求，携带参数url中,type是json</button>
<button id="btn03">JQueryGet请求，携带参数在data中</button>
<button id="btn04">JQueryGet请求，只传url</button>
<div style="border:1px solid; width:300px; height:200px" id="divShow">
<!-- 显示学生详细信息 -->
</div>
</body>
</html>