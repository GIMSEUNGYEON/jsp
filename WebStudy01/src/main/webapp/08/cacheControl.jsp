<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>08. Cache Control Test</title>
</head>
<body>
<h4>캐시 제어</h4>
<pre>
	Cache : 자원이 네트워크를 통해 전송되는 동안 발생하는 부하와 latency time을 줄이기 위한 저장 데이터 형태.
	
	: Pragma(Http 1.0버전), Cache-Control(Http 1.1버전), (앞 두개는 캐시를 남길지 여부 설정) Expires(버전 무관, 캐시의 지속 시간을 설정(Date(long)))...응답 헤더로 캐시 제어
	response.setHeader(name, value), setIntHeader(name, int value), setDateHeader(name, long value)(에포크 타임 이용/ 1970년대 이후로 경과한 시간 이용)
	response.addHeader(name, value), addIntHeader(name, int value), addDateHeader(name, long value) set으로 설정하면 같은 이름의 이전 설정을 덮어씌우므로 add 이용으로 추가
	
	클라이언트의 버전을 알 수 없으므로 모든 클라이언트의 요청을 감당할 수 있도록 표준화 -> 웹 표준화
	w3c의 web validate를 이용하여 웹 표준화에 의해 만들어진 어플리케이션인지 확인 가능
	<%
		response.setHeader("Pragma", "no-cache");
		response.setHeader("Cache-Control", "no-cache");
		response.addHeader("Cache-Control", "no-store");
		response.setDateHeader("Expires", 0);
	%>
	
	pragma 
	public : 어디에나 남기며 모두가 사용 가능
	no-cache : 안남김
	
	Cache-Control
	no-store : 혹시 남길거면 물어보고 남겨
</pre>
</body>
</html>