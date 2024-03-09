<%@page import="kr.or.ddit.vo.MemberVO"%>
<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<main class="container-fluid">
<c:set var="memberWrapper" value="${pageContext.request.userPrincipal }"/>
	<h4>welcome page 웰컴 : 누적 방문자 수 ${userCount }명</h4>
	<c:if test="${empty authMember }">
		<a href="${pageContext.request.contextPath }/login/loginForm.jsp">로그인</a>
		<a href="${pageContext.request.contextPath }/member/memberInsert.do">회원가입</a>
	
	</c:if>
	<c:if test="${not empty authMember }">
	<c:set var="authMember" value="${memberWrapper.realUser }"/>
		<a href="${pageContext.request.contextPath }/mypage">${authMember.memName }[${authMember.memRole }]</a>
		<form method="post" id="logoutForm" action="${pageContext.request.contextPath }/login/logOut.do"></form>
		<a href="javascript:;" data-log-out="#logoutForm">로그아웃</a>		
	</c:if>
	
<dl>
	<dt>JDBC 프로그래밍</dt>
	<dd>
	 	java로 구현된 클라이언트 앱에서 데이터베이스에 연결하는 방법 : JDBC 드라이버를 이용한 연결 단계는 일정한 절차가 반복되는 패턴으로 중복되는 문제.
	</dd>
	<dt>Mybatis</dt>
	<dd>
		Persistence Framework : DAO 에서 발생하는 중복 패턴을 template method pattern / reflection을 기반으로 하는 프레임워크.
		SQL Mapper : mapper 파일을 통해 등록된 쿼리문으로 쿼리 객체를 생성하고 관리함.(PreparedStatement)
		Data Mapper : 객체 형태로 전달된 쿼리 실행 파라미터를 인덱스를 가진 쿼리 파라미터로 전환 + 쿼리의 실행 결과(cursor)를 객체로 전환.
	</dd>
	<dt>EL</dt>
	<dd>
		scope 내에 속성의 형태로 공유(저장)된 데이터를 일관된 방법${attribute_name }으로 출력하기 위한 스크립트 형태 언어.
		<pre>
			scope : 속성의 형태(name-value)로 공유 가능한 데이터가 저장된 공간.
				- pageScope 현재 페이지를 벗어나면 사라짐
				- requestScope 요청에 응답이 생성되면 사라짐
				- sessionScope 사용자의 사용이 멈추면 사라짐
				- applicationScope 어플리케이션이 종료될때 사라짐
				jsp의 기본객체에 기반하여 생성된 scope
		</pre>
	</dd>
</dl>
</main>
<script src="${pageContext.request.contextPath}/resources/js/app/index.js"></script>