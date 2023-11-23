<%@page import="kr.or.ddit.servlet05.BrowserType"%>
<%@page import="java.util.Map.Entry"%>
<%@page import="java.util.LinkedHashMap"%>
<%@page import="java.util.Map"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<!-- 클라이언트의 브라우저 종류를 확인하고 다음과 같은 메시지를 출력할 것. -->
<!-- 메시지의 형식은 <h4> 태그를 이용하여 당신의 브라우저는 "브라우저명"입니다. 와 같은 형식을 이용함.</h4> -->

<%
	String userAgent = request.getHeader("user-agent").toUpperCase();
	
	String name = "";
	if (userAgent.contains("WHALE")) {
		name = "Naver Whale";
	} else if (userAgent.indexOf("EDG") > -1) {
		name = "Microsoft Edge";
	} else if (userAgent.indexOf("CHROME") > -1) {
		name = "Google chrome";
	} else if (userAgent.indexOf("SAFARI") > -1) {
		name = "Safari";
	}else{
		name = "기타";
	}
%>

<%
// 	Map<String, String> browser = new LinkedHashMap<>();

// 	browser.put("EDG", "엣지");
// 	browser.put("WHALE", "웨일");
// 	browser.put("CHROME", "크롬");
// 	browser.put("SAFARI", "사파리");
// 	browser.put("OTHER", "기타");
	
// 	String browerName = browser.get("OTHER");

// 	for(Entry<String, String> entry : browser.entrySet()){
// 		if(userAgent.contains(entry.getKey())){
// 			browerName = entry.getValue();
// 			break;
// 		}
// 	}
	
%>

<%
	String browerName = BrowserType.OTHER.getBrowseName();

	for( BrowserType tmp : BrowserType.values() ){
// 		System.out.println(tmp);
		if(userAgent.contains(tmp.name())){	
			browerName = tmp.getBrowseName();
			break;
		}
	}
	
%>

<h4>당신의 브라우저는 <%=name %> 입니다.</h4>
<h4>당신의 브라우저는 <%=browerName %> 입니다.</h4>
<h4>당신의 브라우저는 <%=BrowserType.findBrowserName(userAgent) %> 입니다.</h4>
</body>
</html>