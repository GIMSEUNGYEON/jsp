<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>BTS</title>
</head>
<body data-context-path="<%=request.getContextPath()%>">
	<form id="btsForm" action="<%=request.getContextPath()%>/bts" onchange="this.requestSubmit();">
		<select name="name">
			
		</select>
	</form>
	<script type="text/javascript" src="<%=request.getContextPath()%>/resources/js/app/bts/bts.js"></script>
</body>
</html>