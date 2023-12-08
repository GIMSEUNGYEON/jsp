<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>07/responseDesc.jsp</title>
</head>
<body>
	<h4>서버에서 클라이언트로 전송되는 응답 형태 : HttpServletResponse</h4>
<pre>
	1. Response Line
		status code : 요청 처리의 성공/실패 여부를 표현할 수 있는 세자리 숫자.
		
		
		1) 100~ : Http 프로토콜(Connect-Less, State-Less)
				  ING..., WebSocket 프로토콜에서 사용되고, 주로 양방향 실시간 통신이나 push 메시지 서비스에 활용됨.
		
		2) 200~ : OK(<%=HttpServletResponse.SC_OK %>)
		
		3) 300~ : response body가 없기 때문에 클라이언트가 응답을 받은 후 추가 액션을 행하게 됨.
			304 : Not Modified(<%=HttpServletResponse.SC_NOT_MODIFIED %>) : 브라우저는 정적 자원에 대한 응답을 받으면 해당 응답 데이터를 캐싱하여 저장하는데, 브라우저가 저장된 데이터를 서버에게 변경 여부를 요청할 때 변경된적이 없으면 보내는 상태 코드
								 변경 여부만 확인하기 때문에 해당 요청과 응답에는 바디가 없으며, 이 상태 코드에 의해 캐시를 탐색함
			302/307 : Moved : 자원의 새로운 위치를 대상으로 요청을 전송함.
			캐시에 해당하는 데이터의 위치가 변경되었을 때 데이터의 새로운 위치와 함께 전송되는 상태 코드(역시 바디가 없음, 위치를 보내주므로 이 위치를 통해 재탐색을 할 수 있음)(자리가 계속 변함 - 302, 자리가 한번만 바뀌고 바뀐 그자리에 고정될거임 - 307)
			바디가 없기 때문에 최종 응답이 될 수 없음, 클라이언트는 300번대 상태 코드를 받은 후 다음 액션을 취해야함.
		
		4) 400~ : client side error : 응답을 처리해주기 위해 클라이언트가 올바른 요청을 보낼 수 있도록 상세한 정보를 제공함
			400 : <%=HttpServletResponse.SC_BAD_REQUEST %> : 필수 파라미터 누락, 요청 데이터 타입 문제, 요청 데이터 길이가 너무 길 때...(요청 검증 시 의도적으로 전송)
			401/403 :<%=HttpServletResponse.SC_UNAUTHORIZED%> / <%=HttpServletResponse.SC_FORBIDDEN %> : 보안 처리에 대한 상태코드 : 사용자의 신원을 확인하는 과정 - 인증 (통과 실패 - 401)/ 권한을 확인하는 과정 - 인가 (통과 실패 - 403)
			404 : <%=HttpServletResponse.SC_NOT_FOUND %> : 서버가 소유하지 않은 리소스를 요청했을 때(찾을 수 없음)
			405 : <%=HttpServletResponse.SC_METHOD_NOT_ALLOWED %> : 서버가 허용하지 않은 메서드를 요청
			406 : <%=HttpServletResponse.SC_NOT_ACCEPTABLE %> : 서버에서 클라이언트가 요청한 request header에서의 response를 제어하는 accept 속성에 대한 마셜링을 할 수 없을 때
				requst Accept header (response Content-Type) 헤더를 처리할 수 없음(답장을 쓸 수 없음)
			415 : <%=HttpServletResponse.SC_UNSUPPORTED_MEDIA_TYPE %> : request body에 해당하는 mime을 읽을 수 없을 때
				request Content-Type 헤더를 처리할 수 없음(편지를 읽을 수 없음)
		
		5) 500~ : server side error : 서버의 정보가 노출되는걸 막기 위해 상세한 정보를 보이지 않음
		
	2. Response Header(name/value)
		Content-*
		Content-Length : response body의 길이
		Content-Type : response body Content's MIME
		
		1) Content-Type : response content MIME
		2) Cache-Control : 캐시 데이터 직접 제어
		3) Refresh : auto-request
		4) Location : 자원의 위치가 새로운 곳으로 이동한 경우, 새로운 위치 정보를 제공하는 헤더(sendRedirect)
		
	3. Response Body(Content Body, Message Body) : 응답 컨텐츠 영역
</pre>	
</body>
</html>