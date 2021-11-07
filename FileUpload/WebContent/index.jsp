<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<!-- 
	enctype 设置或返回用于编码表单内容的MIME类型
	默认的enctype为在发送前编码所有字符  enctype="application/x-www-form-urlencoded"
	查找W3C文档 <form>属性
	enctype="multipart/form-data" 表示不对字符编码，在使用包含文件上传的表单时，必须使用该值
	enctype="text/plain" 表示空格转换为"+"加号，但不对特殊字符编码 
 -->
 
<form action="FileUploadServlet" method="post" enctype="multipart/form-data" >
	用户名：<input name="username"/>
	头像：<input name="headerImg" type="file"/>
<button>上传</button>
</form>
</body>
</html>