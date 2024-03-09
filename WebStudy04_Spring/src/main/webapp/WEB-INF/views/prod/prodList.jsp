<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<a href="javascript:;" data-go-link="/prod/prodInsert.do">신규상품 등록</a>
<table class="table table-bordered">
	<thead>
		<tr>
			<th>일련번호</th>
			<th>상품명</th>
			<th>상품분류</th>
			<th>제조사</th>
			<th>판매가</th>
			<th>마일리지</th>
		</tr>
	</thead>
	<tbody>
		<c:if test="${not empty prodList }">
			<c:forEach items="${prodList }" var="prod">
				<tr>
					<td>${prod.rnum }</td>
					<td><c:url value="/prod/prodView.do" var="viewUrl">
							<c:param name="what" value="${prod.prodId }" />
							<c:param name="param" value="paramValue" />
						</c:url> <a href="${viewUrl }">${prod.prodName }</a></td>
					<td>${prod.prodLgu }</td>
					<td>${prod.prodBuyer }</td>
					<td>${prod.prodPrice }</td>
					<td>${prod.prodMileage }</td>
				</tr>
			</c:forEach>
		</c:if>
		<c:if test="${empty prodList }">
			<tr>
				<td colspan="6">상품없음.</td>
			</tr>
		</c:if>
	</tbody>
	<tfoot>
		<tr>
			<td colspan="6">
				<form id="searchForm" action='<c:url value="/prod/prodList.do"/>'>
					<input type="text" name="page" /> 
					<input type="text" name="prodLgu" value="${condition.prodLgu }" /> 
					<input type="text" name="prodBuyer" value="${condition.prodBuyer }" /> 
					<input type="text" name="prodName" value="${condition.prodName }" />
				</form>
				<div data-pg-role="searchUI" data-pg-target="#searchForm">
					<select name="prodLgu" data-pg-init-value="${condition.prodLgu }">
						<option value>분류 선택</option>
						<c:forEach items="${lprodList }" var="lprod">
							<option value="${lprod.lprodGu }">${lprod.lprodNm }</option>
						</c:forEach>
					</select> <select name="prodBuyer"
						data-pg-init-value="${condition.prodBuyer }">
						<option value>분류 선택</option>
						<c:forEach items="${buyerList }" var="buyer">
							<option value="${buyer.buyerId }" class="${buyer.buyerLgu }">${buyer.buyerName }</option>
						</c:forEach>
					</select> 
					<input type="text" name="prodName" value="${condition.prodName }" />
					<button type="button" data-pg-role="searchBtn">검색</button>
				</div> ${pagingHTML }
			</td>
		</tr>
	</tfoot>
</table>
<script>
	let $prodBuyer = $('select[name="prodBuyer"]');
	
	$('select[name="prodLgu"]').on("change", (event)=>{
		let $prodLgu = $(event.target);
		let selectedLgu = $prodLgu.val();
		
		$prodBuyer.find("option:gt(0)").each((i,o)=>{
			let $o = $(o);
			let showFlag = selectedLgu && $(o).hasClass(selectedLgu) || (!selectedLgu);
			$o.toggle(showFlag);
		});
		//$prodBuyer.find(`option.\${selectedLgu}`).show();
	
		/* 
			$('option').show();
			let lprod = $("select[name='prodLgu']").val();
			console.log(lprod);
			$('option[class]').not('.'+lprod).hide();
		*/
		
	})
	
</script>
<script src="<c:url value='/resources/js/app/common/paging.js'/>">
	
	
</script>
