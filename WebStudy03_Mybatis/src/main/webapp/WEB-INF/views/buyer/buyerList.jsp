<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<a href="javascript:;" data-go-link="/buyer/buyerInsert.do">신규상품 등록</a>
<
<table class="table table-bordered">
	<thead>
		<tr>
			<th>일련번호</th>
			<th>제조사명</th>
			<th>제조사분류명</th>
			<th>소재지</th>
			<th>전화번호</th>
			<th>담당자</th>
		</tr>
	</thead>
	<tbody>
		<c:if test="${not empty buyerList }">
			<c:forEach items="${buyerList }" var="buyer">
				<tr>
					<td>${buyer.rnum }</td>
					<c:url value="/buyer/buyerView.do" var="viewUrl">
						<c:param name="what" value="${buyer.buyerId }"/>
					</c:url>	
					<td><a href="${viewUrl }">${buyer.buyerName}</a></td>
					<td>${buyer.lprod.lprodNm }</td>
					<td>${buyer.buyerAdd1}</td>
					<td>${buyer.buyerComtel}</td>
					<td>${buyer.buyerCharger}</td>
				</tr>
			</c:forEach>
		</c:if>
		<c:if test="${empty buyerList }">
			<tr>
				<td colspan="6">조회할 수 있는 제조사 없음</td>
			</tr>
		</c:if>
	</tbody>
	<tfoot>
		<tr>
			<td colspan="6">
				<form id="buyerSearchForm" action='<c:url value="/buyer/buyerList.do"/>'>
					<input type="text" name="page"/>
					<input type="text" name="buyerLgu" value="${condition.buyerLgu }"/>
					<input type="text" name="buyerAdd1" value="${condition.buyerAdd1 }"/>
					<input type="text" name="buyerName" value="${condition.buyerName }"/>
				</form>
				<div data-pg-role="searchUI" data-pg-target="#buyerSearchForm">
					<select name="buyerLgu" data-pg-init-value="${condition.buyerLgu }">
						<option value>분류 선택</option>
						<c:forEach items="${lprodList }" var="lprod">
							<option value="${lprod.lprodGu }">${lprod.lprodNm } </option>
						</c:forEach>
					</select>
					<input type="text" name="buyerAdd1" value="${condition.buyerAdd1 }">
					<input type="text" name="buyerName" value="${condition.buyerName }">
					<button type="button" data-pg-role="searchBtn">검색</button>
				</div> ${pagingHTML }
			</td>
		</tr>
	</tfoot>
</table>
<script src="<c:url value='/resources/js/app/common/paging.js'/>"></script>