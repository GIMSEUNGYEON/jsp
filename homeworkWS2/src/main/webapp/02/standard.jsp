<%@page import="java.time.LocalDate"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>02/standard.jsp</title>
</head>
<body>
	<h4>JSP(Java Server Page)</h4>
	<h4>모델 : <%=request.getAttribute("sampleAttr") %></h4>
	<pre>
		: 서블릿의 하위 스펙으로 동작하는 템플릿 엔진(View layer).
		
		소스 구성 요소(토큰의 종류)
		1. 정적 요소(Front-End) : HTMNL, CSS, JavaScript... 정적 텍스트(가공하기 전의 단순한 텍스트)
		2. 동적 요소(Back-End)  가공한 후의 컨텐츠
			1) scriptlet : <% // java code %>
				<%
					String sample = "Test";
					 
					
				%> 
			2) directive : <%--@--%>  ( 지시자 ) 지시자를 사용하면 웹에서 소스코드에 공백이 발생하기 때문에 trimDirectiveWhitespaces 속성을 부여하여 공백을 없앨 수 있음
				컨텐트타입 중에선 application/octex-stream이 있기 때문에 스트리밍 서비스에서 공백은 컨텐츠의 끊김을 의미하기 때문에 공백을 제어해야하는 경우가 생김
				page(required) 필수 요소 : jsp 페이지에 대한 구체적인 설정을 표현(속성으로 표현).
				tablib(optional)  : 커스텀 태그 로딩
				include(optional) : 정적 include를 통해 2개 이상의 jsp 소스를 하나로 합칠 때
			3) expression : <%=sample %>, <%=LocalDate.now() %> ( 표현식 )
			4) declaration : 
					<%!
						private StringBuffer globalBuffer;					
						void test(){
							
						}
					%>( 선언부 ) : 변수나 메서드를 선언할 때 사용
			5) comment : <%-- jsp 주석--%> <!-- HTML 주석 --> (주석)
				<script type="text/javascript">
					//javascript 주석				
				</script> 
				<style type="text/css">
					/* css 주석*/
				</style>
				-client side(Front-End) html, css, script 주석 페이지 소스 코드에서 보임
				-server side(Back-End) jsp, java 주석 페이지 소스 코드에서 안보임
			6) EL(Expression Language)
			7) JSTL
			8) 기본객체(내장객체)
			
			
			ex) Tomcat
			1. WAS (Web Application Server) : 로직의 실행으로 생성되는 동적 컨텐츠를 서비스하는 어플리케이션 서버. 
			   WS  (Web Server) 		    : 이미지 파일, 동영상 파일, html, css, javascript... 등의 정적 자원 서버. 
			2. Middel Tier (N-Tier 구조)     : client와 raw 데이터 서버 사이의 어플리케이션이 운영되는 중간 티어.
			3. Servlet Container			: 서블릿의 생명주기 관리자, 서블릿의 싱글턴 인스턴스를 생성하고,
											  해당 요청이 발생한 경우 그 요청을 처리할 수 있는 callback 메서드를 실행함.
			4. JSP Container				: 서블릿의 생명주기 관리자, *.jsp 템플릿 파일을 파싱하고, 서블릿 소스를 생성한 후 해당 서블릿을 컴파일한다. 
											  해당 서블릿의 싱글턴 인스턴스를 생성하고 요청이 발생한 경우 callback 메서드 실행함.
			컨테이너의 전재조건 : 컨테이너 안에 객체가 존재할 것, 컨테이너와 객체는 라이프 사이클이 같을 것
	</pre>
</body>
</html>