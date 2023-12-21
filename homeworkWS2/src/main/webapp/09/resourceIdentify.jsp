<%@page import="kr.or.ddit.servlet08.ServerTimeServlet"%>
<%@page import="java.net.URL"%>
<%@page import="java.io.File"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h4>자원의 종류와 종류에 따른 식별 방법</h4>
<pre>
	자원의 위치와 접근 방법에 따라 3가지로 분류
	1. file system resource // 물리 경로에 저장된 파일 : 파일 시스템 상의 절대 경로(물리 경로)를 사용해서 접근 가능.
		ex) D:\01.medias\img\rabbit.jpg 
		<%
			File fsRes = new File("D:\\01.medias\\img\\whitefox.jpg");
			out.println(fsRes.length());
		%>
		
	2. web resource // webapp에 존재하는 논리 경로에 의한 파일 : URL(논리 주소)의 형태로 접근 가능한 웹 자원 (서버에 따라 달라지는 자원 서블릿 컨텍스트가 필요함(그래서 application이용(톰캣에게 직접 요청)))
		ex) https://www.google.com/images/branding/googlelogo/1x/googlelogo_color_272x92dp.png
		ex) http://localhost/WebStudy01/resources/images/whitefox.jpg
			                           /resources/images/whitefox.jpg
		<%
			String logicalPath = "/resources/images/whitefox.jpg";
			String realPath = application.getRealPath(logicalPath);
			File webRes = new File(realPath);
			out.println(realPath);
			out.println(webRes.length());
		%>
		
	3. classpath resource // : contextclasspath 이후의 경로(qualified name)에서 접근 가능. (클래스패스의 위치(클래스패스를 관리하는 주체 : 클래스 로더))
		ex) kr.or.ddit.images.whitefox.jpg //: classloader : 클래스의 quallifiedName을 찾아줌
		<%
// 			ClassLoader classLoader = ClassLoader.getSystemClassLoader();
// 			ClassLoader classLoader = ServerTimeServlet.class.getClassLoader();
			
// 			logicalPath = "kr/or/ddit/images/whitefox.jpg"; //그래서 경로에 / 필요없음!
// 			URL url = classLoader.getResource(logicalPath); //classloader가 최상위로부터 경로를 찾아감 

			logicalPath = "/kr/or/ddit/images/whitefox.jpg"; //그래서 경로에 / 있어야함!
			URL url = ServerTimeServlet.class.getResource(logicalPath); //본인위치 기준에서 찾음
			out.println(url);
			File cpRes = new File(url.toURI());
			out.println(cpRes.length());
		%>
</pre>
<h4> URI vs URL </h4>
<pre>
	URI(Uniform Resource Identifier) : 자원의 식별방법(통틀어서)
	URL(Uniform Resource Locator) : 범용 자원 등록자 (자원을 식별할 때 위치를 기준으로 식별) : 위치 변경시 문제 발생(상태코드 300~)
	URN(Uniform Resource Naming) : 이름으로 자원 식별(명명된 이름) : 유일성 담보 불가
	URC(Uniform Resource Content) : 해당 자원이 가진 컨텐츠의 특성으로 식별 : 유일성 담보 불가
	Uniform : 웹을 통해 접근, 이용이 가능한 
	
	URL 규칙성 - 절대경로(window.location의 속성들은 생략 가능)
	protocol://ip[domain]:port/context/depth.../resourceName
	프로토콜 : 여기까지가 프로토콜이라는 뜻으로 콜론
	// 여기부터 경로가 시작됨
	ip : 80일 시 생략 가능
	
	client side : context path를 포함한 경로형태여야함
	server side : context path 이후 경로만 사용함.
	리다이렉션 이후의 경로는 클라이언트가 사용함~~~~~
</pre>
<img src="http://localhost/WebStudy01/resources/images/whitefox.jpg"/>
<img src="//localhost/WebStudy01/resources/images/whitefox.jpg"/>
<img src="/WebStudy01/resources/images/whitefox.jpg"/>
<img src="/resources/images/whitefox.jpg"/>
<img src="<%=request.getContextPath() %>/resources/images/whitefox.jpg"/>

<!-- 윈도우의 로케이션이 가지고 있는 경로는 빼도 됨 (프로로토콜 같은) -->
콘솔에서 window.location이용 - 가지고 있는 객체 확인하기

<br>
상대경로 : 현재 위치를 기준으로 자원의 위치가 상대적으로 표현됨.
<img src="../resources/images/whitefox.jpg"/>

</body>
</html>