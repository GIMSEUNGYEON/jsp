<%@ page contentType="text/html; charset=UTF-8" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h4>welcome page 웰컴</h4>
	<%
		Object authId = session.getAttribute("authId");
		if(authId == null){
	%>
	<a href="<%=request.getContextPath()%>/login/loginForm.jsp">로그인</a>
	<%
		}else{
			out.println(authId+"님 로그인 성공");			
		}
	%>
</body>
</html>