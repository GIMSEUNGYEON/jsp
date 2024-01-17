<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<span class="text-danger">
	${message}
</span>

<form id="insertAddressForm" method="post" >
	<div class="col-auto">
		<label for="propertyName" class="form-label">Property Name</label> 
		<input type="text" name="propertyName" id="propertyName"
			placeholder="propertyName" class="form-control">
	</div>
	<div class="col-auto">
		<label for="propertyValue" class="form-label">Property Value</label>
		<input type="text" name="propertyValue" id="propertyValue"
			placeholder="propertyValue" class="form-control">
	</div>
	<div class="col-auto">
		<label for="description" class="form-label">Description</label> 
		<input type="text" name="description" id="description"
			placeholder="description" class="form-control">
	</div>
	<div class="col-auto">
		<button type="submit" class="btn btn-primary">신규 등록</button>
	</div>
</form>

<table class="table table-bordered">
	<tr>
		<th>이름</th>
		<th>전화번호</th>
		<th>우편번호</th>
		<th>주소1</th>
		<th>주소2</th>
		<th>삭제</th>
		
	</tr>
	<c:forEach var="vo" items="${requestScope.addresses}">
	<tr>
		<td>
    		${vo.adrsName}
		</td>
		<td>
    		${vo.adrsHp}
		</td>
		<td>
    		${vo.adrsZip}
		</td>
		<td>
    		${vo.adrsAdd1}
		</td>
		<td>
    		${vo.adrsAdd2}
		</td>
		<td>
			<button class="btn btn-danger" id="${vo.adrsNo}">
				삭제
			</button>
		</td>
	</tr>
	</c:forEach>
	
	
</table>