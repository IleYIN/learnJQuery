<%@page import="java.text.SimpleDateFormat"%>
<%@page import="servlet.Student"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<style type="text/css">
	table{
		border: 1px solid;
		border-collapse: collapse;
	}
	th,td{
		border: 1px solid;
	}
</style>
<title>Insert title here</title>
</head>
<body>
<%-- <%=request.getAttribute("list") %> --%>
<%
	List<Student> all = (List<Student>)request.getAttribute("list");
%>
<%
	if(all != null) {
%>	
<!-- 整理格式  -->
	<table>
		<tr>
			<th>#</th>
			<th>姓名</th>
			<th>性别</th>
			<th>年级</th>
			<th>创建日期</th>
		</tr>
		<%
			for(int i=0; i<all.size(); i++) {
				Student stu = all.get(i);
		%>
		<tr>
			<td><%=stu.getId() %></td>
			<td><%=stu.getName() %></td>
			<td><%=stu.getGender() %></td>
			<td><%=stu.getGrade() %></td>
			<%-- <td><%=stu.getCreateDate() %></td> --%>
			<td>
				<%=new SimpleDateFormat("yyyy-MM-dd").format(stu.getCreateDate())%>
			</td>
		</tr>
		<%
			}
		%>
	</table>
<%	
	} else {
%>
		<h1>当前没有学生列表</h1>
<%
	}
%>
</body>
</html>