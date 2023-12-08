<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form method="post" action="<%=request.getContextPath()%>/login/loginProcess.do" enctype="application/x-www-form-urlencoded">
	<ul>
		<li>
			아이디 : <input type="text" name="memId">
		</li>
		<li>
			비밀번호 : <input type="text" name="memPass">
			<button type="submit">로그인</button>
		</li>
	</ul>
</form>
</body>
</html>