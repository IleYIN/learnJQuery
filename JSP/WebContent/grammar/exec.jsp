<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	List<String> str = new ArrayList<String>();
	str.add("str1");
	str.add("str2");
	str.add("str3");
%>
<table>
	<%
		for(int i=0;i<str.size();i++){
	%>
		<tr><td>name</td><td><%=str.get(i) %></td></tr>
	<% 
		}
	%>
</table>
</body>
</html>