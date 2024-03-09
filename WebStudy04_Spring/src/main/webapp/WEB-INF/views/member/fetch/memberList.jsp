<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
	<tbody id="listBody">
		
	</tbody>
	<tfoot>
		<tr>
			<td colspan="6">
				<form id="submitForm" method="post">
					<input name="page" type="text"/>
					<input type="text" name="condition.searchType" placeholder="searchType" />
					<input type="text" name="condition.searchWord" placeholder="searchWord" />
				</form>
				<div data-pg-role="searchUI" data-pg-target="#submitForm">
					<select name="condition.searchType">
						<option value="">전체</option>
						<option value="name">이름</option>
						<option value="address">주소</option>
					</select>
					<input name="condition.searchWord" />
					<button type="button" data-pg-role="searchBtn">검색</button>
				</div>
				<div id="pagingArea"></div>
			</td>
		</tr>
	</tfoot>
</table>

<script src="<c:url value='/resources/js/app/common/paging.js'/>"></script>
<script src="<c:url value='/resources/js/app/member/fetch/memberList.js'/>"></script>

