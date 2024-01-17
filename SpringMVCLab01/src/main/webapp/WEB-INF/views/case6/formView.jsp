<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>case6/formView.jsp</title>
</head>
<body>
	<form method="post">
		<input type="number" name="left" value="${object.left }"/>
		<input type="number" name="right" value="${object.right }"/>
		<button type="submit">전송</button>
	</form>
	연산 결과 : ${object.result }
	${object }
</body>
</html>