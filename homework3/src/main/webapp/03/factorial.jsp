<%@page import="java.text.MessageFormat"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%!
long factorial(int operand){
	
	if(operand < 1){
		throw new IllegalArgumentException("팩토리얼 연산은 양수만 처리 가능");
	}
	if(operand==1){
		return 1;		
	}else{
		return operand*factorial(operand-1);
	}
	
}
%>
    	<%
		int status = 200;
		String param = request.getParameter("operand");
			
		if(param == null || param.trim().isEmpty() || !param.matches("\\d{1,3}")){
			response.sendError(HttpServletResponse.SC_BAD_REQUEST,"필수 파라미터가 누락되었거나 파라미터의 데이터형이 잘못되었습니다.");
			return;
		}
		
		int operand = Integer.parseInt(param);
// 		for(int i = operand; i > 0 ; i--){
// 			answer*=i;
// 		}
		
		
// 		request.setAttribute("operand", operand);
// 		request.setAttribute("answer", answer);
// 		RequestDispatcher dispatcher = request.getRequestDispatcher("/factorialForm.jsp");
// 		dispatcher.forward(request, response);
		try{
			
		long answer = factorial(operand);
		String expression = MessageFormat.format("{0}! = {1}", operand, answer);
		request.setAttribute("expression", expression);
		} catch(IllegalArgumentException e){
			response.sendError(HttpServletResponse.SC_BAD_REQUEST,e.getMessage());			
		}
		
		if(status != 200){
			response.sendError(status);
			return;
		}
	%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h4><%=request.getAttribute("expression") %></h4>
</body>
</html>