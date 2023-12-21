<%@page import="java.time.LocalDateTime"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>11/before.jsp</title>
</head>
<body>
	<%
		LocalDateTime processTime = LocalDateTime.now();
		// case 1 - state less
		request.setAttribute("processTime", processTime);
		// case 2 - state full(session)
		session.setAttribute("processTime", processTime);	
		//맵 형태의 데이터 저장방식(저장 위치만 다름, 저장 가능 타입에 제한이 없음)
		
		// case 3 - state full(cookie) 클라이언트사이드 저장 데이터
		Cookie customCookie = new Cookie("processTime", processTime.toString());
		// 데이터의 타입에 제한이 있음(문자열만 저장 가능)
		response.addCookie(customCookie);
		%>
	<a href="afterCase1.jsp">이후 발생하는 새로운 요청(request scope)</a> <br>
	<a href="afterCase2.jsp">이후 발생하는 새로운 요청(session scope)</a> <br>
	<a href="afterCase3.jsp">이후 발생하는 새로운 요청(Cookie)</a>
</body>
</html>