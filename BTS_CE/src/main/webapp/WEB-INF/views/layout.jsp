<%@ page contentType="text/html; charset=UTF-8" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<jsp:include page="/WEB-INF/includee/preScript.jsp" />
</head>
<body data-context-path="<%=request.getContextPath()%>">
<h4><%=request.getHeader("user-agent")%></h4>
<h4>jQuery와 bootstrap 사용 가능 페이지</h4>
<%
	
	String contentPage = (String) request.getAttribute("contentPage");
%>
<jsp:include page="<%=contentPage %>" />

<jsp:include page="/WEB-INF/includee/postScript.jsp" />
</body>
</html>