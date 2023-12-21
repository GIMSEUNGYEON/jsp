<%@page import="java.util.Arrays"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>11/afterCase2.jsp</title>
</head>
<body>
<%
	Cookie [] cookies = request.getCookies();
	String processTime = Arrays.stream(cookies)
		.filter((c)->"processTime".equals(c.getName()))
		.findFirst()
		.map(Cookie::getValue)
		.orElse(null);
%>
	<h4>before process time(Cookie) : <%=processTime%></h4>
</body>
</html>