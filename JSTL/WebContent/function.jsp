<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	request.setAttribute("msg2","Hello");
%>
${fn:contains(msg2,"H") }
${fn:containsIgnoreCase(msg2,"h") }
${fn:startsWith(msg2,"He") }
${fn:endsWith(msg2,"o") }
${fn:indexOf(msg2,"el") }
${fn:replace(msg2,"llo","lloooo") }
${fn:substring(msg2,1,3) }
</body>
</html>