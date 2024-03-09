<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="security" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	로그아웃 하시겠습니까?
	<form:form method="post" action="${pageContext.request.contextPath }/logout">
		<input type="submit" value="로그아웃"/>
		<input type="button" value="아니" 
			onclick="history.back()"
		/>
	</form:form>
</body>
</html>