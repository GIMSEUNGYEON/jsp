<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<div class="row mt-3">
	<pre>
		SPA 기반의 페이징  처리 예제 테스트시 브라우저의 backward/forward 기능으로 테스틓할 것.
	</pre>
	<table class="table table-bordered">
	    <thead>
	        <tr>
	            <th>상품명</th>
	            <th>상품분류</th>
	            <th>거래처명</th>
	            <th>소재지</th>
	            <th>구매가</th>
	            <th>판매가</th>
	            <th>마일리지</th>
	        </tr>
	    </thead>
		<tbody id="listBody">
		
		</tbody>	
		<tfoot>
			<tr>
				<td colspan="7">
					<form id="searchForm" action="<c:url value='/paging/spa'/>" 
						class="border border-danger m-3 p-3"
					>
						<h6>전송UI</h6>
						<input type="number" name="page" />
						<input type="text" name="prodLgu" value="${condition.prodLgu }"/>
						<input type="text" name="prodBuyer"  value="${condition.prodBuyer }"/>
						<input type="text" name="prodName"  value="${condition.prodName }"/>
					</form>
					<div id="pagingArea"></div>
					<div data-pg-role="searchUI" data-pg-target="#searchForm"  
						class="m-3 p-3 border border-primary row justify-content-center">
						<h6>입력 UI</h6>	
						<div class="col-auto">	
							<select name="prodLgu">
								<option value>분류선택</option>
								<c:forEach items="${lprodList }" var="lprod">
									<option value="${lprod.lprodGu }">${lprod.lprodNm }</option>
								</c:forEach>
							</select>
						</div>
						<div class="col-auto">
							<select name="prodBuyer">
								<option value>제조사선택</option>
								<c:forEach items="${buyerList }" var="buyer">
									<option value="${buyer.buyerId }" class="${buyer.buyerLgu }">${buyer.buyerName }</option>
								</c:forEach>
							</select>
						</div>
						<div class="col-auto">
							<input type="text" name="prodName" />
						</div>
						<div class="col-auto">
							<button data-pg-role="searchBtn">검색</button>
						</div>
					</div>
				</td>
			</tr>
		</tfoot>  
	</table>
</div>
<script src="<c:url value='/resources/js/app/common/paging.js'/>"></script>
<script src="<c:url value='/resources/js/app/common/backForward.js'/>"></script>
<script>
let $prodBuyer = $('select[name="prodBuyer"]');
$('select[name="prodLgu"]').on("change", (event)=>{
	let $prodLgu = $(event.target);
	let selectedLgu = $prodLgu.val();
	$prodBuyer.find("option:gt(0)").each((i,o)=>{
		let $o = $(o);
		let showFlag = (selectedLgu && $o.hasClass(selectedLgu)) || (!selectedLgu);
		$o.toggle(showFlag);
	});
});

let fnMakeTrTag = function(prod){
	return $("<tr>").append(
				$("<td>").html(prod.prodName)
				, $("<td>").html(prod.lprodGu)
				, $("<td>").html(prod.buyer.buyerName)
				, $("<td>").html(prod.prodAdd1)
				, $("<td>").html(prod.prodCost)
				, $("<td>").html(prod.prodPrice)
				, $("<td>").html(prod.prodMileage)
				
			);
}

$(searchForm).spaForm(function(resp){
	let $listBody = $(listBody);
	let $pagingArea = $(pagingArea);
	
	this.page.value="";
	$listBody.empty();
	$pagingArea.empty();
	
	let dataList = resp.prodList;
	let trTags = [];
	if(dataList){
		$.each(dataList, function(index, prod){
			trTags.push(fnMakeTrTag(prod));
		});
	}else{
		let tr = $("<tr>").html(
			$("<td>").attr("colspan", "7")
					.html("조건에 맞는 상품 없음.")
		);	
		trTags.push(tr);
	}
	
	$listBody.html(trTags);
	if(resp.pagingHTML)
		$pagingArea.html(resp.pagingHTML);
}).submit();


</script>

