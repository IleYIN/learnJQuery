<%@page import="java.util.Map"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="bean.Student"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<!-- el表达式中又一个empty运算符 
就是判断一个对象是否为空 返回true或false-->
<%
	Student stu = new Student("小红",18);
	pageContext.setAttribute("stu", stu);
	Student stu3 = null;
	List<Student> list = new ArrayList<Student>();
	list.add(null);
	Map<String,Object> map = new HashMap<String,Object>();
	int[] array = new int[5];	
	int[] array2 = new int[0];	
	int[] array3 = null;	
	//System.out.println(list.size());
	pageContext.setAttribute("list", list);
	pageContext.setAttribute("map", map);
	pageContext.setAttribute("array", array);
	pageContext.setAttribute("array2", array2);
	pageContext.setAttribute("array3", array3);
	//System.out.println(array.length);
	//System.out.println(array2.length);
	pageContext.setAttribute("str", "");
	pageContext.setAttribute("str2", "  ");
	pageContext.setAttribute("num", 15);
	pageContext.setAttribute("num2", "15");
%>
${empty pageScope.stu}
${empty pageScope.stu2}
${empty pageScope.stu3}
${empty pageScope.list}
${empty pageScope.map}
${empty pageScope.array}
${empty pageScope.array2}
${empty pageScope.str}
${pageScope.str == null}
${empty pageScope.str2}
${empty pageScope.str?"我是空串":pageScope.str}
${pageScope.num+20}
${pageScope.num2+20}
<!-- +-x/ 在el表达式里只是算术运算 不能拼串 -->
${pageScope.num2+""+"20"}<br>
<%=request.getContextPath()%>
${pageContext.request.contextPath }<br>
el存在的意义：
1.简化操作
2.友好显示
<%
	pageContext.setAttribute("req",request);
%>
<span>${msg}</span>
${req.scheme}://${req.serverName}
<base href="${req.scheme}://${req.serverName}/static/img/abc.jpg"/>
</body>
</html>