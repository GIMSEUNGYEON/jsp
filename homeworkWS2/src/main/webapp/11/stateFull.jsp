<%@page import="java.io.UnsupportedEncodingException"%>
<%@page import="java.net.URLDecoder"%>
<%@page import="java.util.stream.Stream"%>
<%@page import="java.util.Arrays"%>
<%@page import="java.util.Optional"%>
<%@page import="java.net.URLEncoder"%>
<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>11/stateFull.jsp</title>
</head>
<body>
	<h4>HTTP(ConnectLss, StateLess)를 보완하고, 상태를 유지하기 위한(StateFull) 저장 구조</h4>
	<pre>
		1. session : 상태 유지를 위한 정보가 서버측에 저장되는 개념.
			세션(HttpSession)
				database -> connectFull --> connection == session
				http -> connectLess --> 시간(웹앱을 사용하기 시작하는 순간부터 종료 이벤트가 발생하기까지의 기간)의 의미로 세션을 표현함.
				해당 기간 동안 새로운 요청이 발생하지 않을 때 세션이 사라지는 시간 => 타임아웃
				
			세션의 생명주기
				생성 : 한 클라이언트가 사용하고 있는 하나의 에이전트(브라우저)에 대해 최초의 요청이 발생했을 때 세션이 생성됨.
					  각 세션은 식별자로 세션 아이디를 발급받음.
					  세션 아이디 : <%=session.getId() %>
					  세션 생성 시점 : <%=new Date(session.getCreationTime()) %>
				유지 방법 : 서버와 클라이언트가 동일한 세션 아이디를 공유하고 있는 상황.(tracking mode) 
					세션 timeout : <%=session.getMaxInactiveInterval() %>s
					<%
						session.setMaxInactiveInterval(240);
					%>
					세션 timeout : <%=session.getMaxInactiveInterval() %>s
					마지막 접속 시간 : <%=new Date(session.getLastAccessedTime())%>
					1) COOKIE(***) : request / response 헤더를 통해 세션 아이디 공유
					2) URL : request line을 통해 세션 아이디 공유(보안에 취약함)
						<a href="stateFull.jsp;jsessionid=<%=session.getId()%>">세션 파라미터를 통한 세션 유지</a>
					3) SSL : Secure Socket Layer(Https) 보안 소켓 계층을 통해 암호화 전송 구조를 이용한 공유.
				소멸 : 만료 시간(TimeOut) 이내에 새로운 요청이 발생하지 않는 경우.
					1) 브라우저 종료
					2) 쿠키 삭제
					3) 직접 로그아웃(session invalidation) : 세션이 직접 만료되어 실제로 삭제되기 때문에 가비지 세션이 쌓이지 않는다.
					<%
// 						session.invalidate();
					%>
		2. cookie : 상태 유지를 위한 정보가 클라이언트측에 저장되는 개념. 서버의 부하를 분산하기 위해 사용함
			1) 쿠키 객체 생성(name/value 필요) value에 한글을 비롯한 특수문자가 포함된 경우 %encoding(URLencoding 과정이 필요함.)
			2) 쿠키의 optional 속성 설정(부가 속성)
				- name/value(required)
				
				- domain : 생략한 경우, 쿠키를 생성할 때 도메인에 반영됨. 쿠키의 재전송 여부를 결정하는 조건.
						   ex) www.naver.com : www.naver.com을 대상으로 한 요청에만 재전송
						   		  .naver.com : *.naver.com에 대한 모든 요청에 대해 재전송
				
				- path : 생략한 경우, 쿠키를 생성할 때 경로가 반영됨.
						 쿠키의 재전송 여부를 결정하는 조건.
						 ex) / : 특정 도메인 이후의 모든 경로로 발생한 요청에 재전송됨.
						 		 request.getContextPath() : 특정 도메인의 해당 컨텍스트로 발생한 요청에 재전송됨.		   		  
						 		 request.getContextPath()/10 : 특정 도메인의 해당 컨텍스트 "/10" 경로로 발생한 요청에 재전송됨.		   		  
				
				- maxAge : 쿠키의 저장 시한 결정(초 단위)
						   ex) 60 * 60 * 24 * 7 일주일
						   		0  : 저장된 쿠키가 있을시 삭제하거나 쿠키를 저장하지 않는 역할
						   	   -1 : 브라우저 종료시 쿠키 삭제
				
				- httpOnly : client 사이트 모듈에서의 접근을 허용하지 않는 속성 그러나 클라이언트에서 속성을 임의로 바꿀 수 있어 보호되지는 않음
				 
				- secure : SSL(Https) 프로토콜에서만 쿠키를 재전송하는 구조.
				
			3) response.addCookie : 응답 헤더(set-cookie)를 통해 클라이언트로 전송
			
			4) 응답에 포함된 쿠키를 브라우저의 쿠키 저장소에 저장
			5) 다음번 요청에 요청 헤더(cookie)를 통해에 쿠키 재전송
			
			6) 요청에 포함된 쿠키를 확보하고 상태를 복원 : request.getCookies
			
			
			<%
// 			 	String encodedValue = URLEncoder.encode("한글값","UTF-8");
// 				Cookie firstCookie = new Cookie("fistCookie", encodedValue);
// 				response.addCookie(firstCookie);
				
				String firstCookieValue = Optional.ofNullable(request.getCookies())
							.map((ca)->Arrays.stream(ca))
							.orElse(Stream.empty())
							.filter(c->"fistCookie".equals(c.getName()))
							.findFirst()
							.map(c->{
								try{
									
									return URLDecoder.decode(c.getValue(),"UTF-8");
									
								} catch(UnsupportedEncodingException e){
									
									throw new RuntimeException(e);								
								}
							})
						.orElse(null);
			%>
			상태를 복원한 firstCookie 값 : <%=firstCookieValue %>
	</pre>	
</body>
</html>