<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<main class="container-fluid">
<h4>웰컴 페이지</h4>
<c:if test="${empty authMember }">
	<a href="<c:url value='/login/loginForm.jsp'/>">로그인</a>
</c:if>
<c:if test="${not empty authMember }">
	<a href="<c:url value='/mypage'/>">${authMember.memName}</a> 
	<form method="post" id="logoutForm" action="<c:url value='/login/logOut.do'/>"></form>
	<a href="javascript:;" data-log-out="#logoutForm">로그아웃</a>
</c:if>
</main>
<script src="<%=request.getContextPath() %>/resources/js/app/index.js"></script>