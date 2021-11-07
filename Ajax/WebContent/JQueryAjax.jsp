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
		//jQuery.ajax(url,[settings]) url也可以做在setting里
		$("#btn01").click(function(){
			$.ajax({
				url:"JQueryGetServlet?method=getUrlData&id="+Math.random(),
				//data:{"name":"名字2","age":18},
				data:"name=名字2&age=18",
				type:"POST",
				async:true,
				success:function(data){
					//data接收相应数据 默认是string
					alert(data);
				},
				error:function(){//function(XMLHttpRequest,textStatus,errorThrown)
					alert("发生错误了...");
				}
			});
		});
		
		$("#btn02").click(function(){
		/* 	var name = $("#input1").val();
			var age = $("#input2").val(); */
			//可以直接将表单数据序列化
			var datas = $("#formSubmit").serialize();
			$.ajax({
				url:"JQueryGetServlet?method=getUrlData&id="+Math.random(),
				//data:"name="+name+"&age="+age,
				data:datas,
				type:"POST",
				async:true,
				success:function(data){
					//data接收相应数据 默认是string
					alert(data);
				},
				error:function(){//function(XMLHttpRequest,textStatus,errorThrown)
					alert("发生错误了...");
				}
			});
		});
	});
</script>
</head>
<body>
<button id="btn01">JQueryAjax请求，携带参数url中,type默认是text</button>
<div style="border:1px solid; width:300px; height:200px" id="divShow">
<!-- 显示学生详细信息 -->
</div>
<form id="formSubmit" action="">
	姓名：<input name="name" id="input1"/> 年龄：<input name="age" id="input2"/>
</form>
<button id="btn02">ajax提交表单数据</button>
</body>
</html>