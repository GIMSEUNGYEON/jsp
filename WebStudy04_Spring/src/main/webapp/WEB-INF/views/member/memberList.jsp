<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<table class="table table-bordered">
	<thead>
		<tr>
			<th>일련번호</th>
			<th>회원명</th>
			<th>이메일</th>
			<th>휴대폰</th>
			<th>주소1</th>
			<th>마일리지</th>
		</tr>
	</thead>
	<tbody>
		<!-- screen size : 3, block size : 3 -->
		<c:choose>
			<c:when test="${not empty memList }">
				<c:forEach items="${memList }" var="mem">
					<tr>
						<td>${mem.rnum }</td>
						<td>${mem.memName }</td>
						<td>${mem.memMail }</td>
						<td>${mem.memHp }</td>
						<td>${mem.memAdd1 }</td>
						<td>${mem.memMileage }</td>
					</tr>
				</c:forEach>
			</c:when>
			<c:otherwise>
				<tr>
					<td colspan="6">회원없음.</td>
				</tr>
			</c:otherwise>
		</c:choose>
	</tbody>
	<tfoot>
		<tr>
			<td colspan="6">
				<form:form id="submitForm" modelAttribute="paging" method="get">
					<input name="page" type="text"/>
					<form:input path="simpleCondition.searchType" placeholder="searchType" />
					<form:input path="simpleCondition.searchWord" placeholder="searchWord" />
				</form:form>
				<div data-pg-role="searchUI" data-pg-target="#submitForm">
					<form:select path="paging.simpleCondition.searchType">
						<form:option value="" label="전체" />
						<form:option value="name" label="이름"/>
						<form:option value="address" label="주소"/>
					</form:select>
					<form:input path="paging.simpleCondition.searchWord" />
					<button type="button" data-pg-role="searchBtn">검색</button>
				</div>
				${pagingHTML}
			</td>
		</tr>
	</tfoot>
</table>

<script src="<c:url value='/resources/js/app/common/paging.js'/>"></script>