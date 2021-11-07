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
		//如何发送post请求 post(url,data,callback,type)
		//url请求地址,data请求参数,callback请求成功的回调函数,
		//type设置返回响应的内容类型 xml, html, script, json, text, _default
		
		//post的data是放在请求体form data里而不是url里，可携带大量数据
		$("#btn01").click(function(){
			$.post("JQueryGetServlet?method=getUrlData&id="+Math.random(),
					{name:"名字2",age:18},
					function(data){
					//data接收相应数据 默认是string
					//alert(typeof data);
					var obj = JSON.parse(data);
					var str = "学生名："+obj.name;
					str += "<br/>学生年龄："+obj.age;
					$("#divShow").html(str);
			});
		});
	});
</script>
</head>
<body>
<button id="btn01">JQueryPost请求，携带参数url中,type默认是text</button>
<div style="border:1px solid; width:300px; height:200px" id="divShow">
<!-- 显示学生详细信息 -->
</div>
</body>
</html>