<%@page import="kr.or.ddit.vo.MemberVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%-- <c:if test="${sessionScope.message ne null and message.length() gt 0}">  --%>
<c:if test="${not empty sessionScope.message}"> 
<!-- 
	not equal = ne
	equal = eq
	> 0 = gt
	>= 0 = ge
	< 0 = lt
	<= 0 = le
 -->
	<span class="text-danger">${sessionScope.message}</span>
	<c:remove scope="session" var="message"/>
	
</c:if>

<%-- session.removeAttribute("message"); //flash attribute --%>

<table class="table table-bordered">	
	<tr>
		<th>프로필</th>
		<td>
			<img src="data:image/*;base64,${member.base64Img }"/>
		</td>
	</tr>
	<tr>
		<th>회원아이디</th>
		<td>${requestScope.member.memId}</td>
	</tr>
	<tr>
		<th>비밀번호</th>
		<td>${requestScope.member.memPass}</td>
	</tr>
	<tr>
		<th>이름</th>
		<td>${requestScope.member.memName}</td>
	</tr>
	<tr>
		<th>주민번호1</th>
		<td>${requestScope.member.memRegno1}</td>
	</tr>
	<tr>
		<th>주민번호2</th>
		<td>${requestScope.member.memRegno2}</td>
	</tr>
	<tr>
		<th>생일</th>
		<td>${requestScope.member.memBir}</td>
	</tr>
	<tr>
		<th>우편주소</th>
		<td>${requestScope.member.memZip}</td>
	</tr>
	<tr>
		<th>주소1</th>
		<td>${requestScope.member.memAdd1}</td>
	</tr>
	<tr>
		<th>주소2</th>
		<td>${requestScope.member.memAdd2}</td>
	</tr>
	<tr>
		<th>집전화번호</th>
		<td>${requestScope.member.memHometel}</td>
	</tr>
	<tr>
		<th>회사전화번호</th>
		<td>${requestScope.member.memComtel}</td>
	</tr>
	<tr>
		<th>휴대폰번호</th>
		<td>${requestScope.member.memHp}</td>
	</tr>
	<tr>
		<th>이메일</th>
		<td>${requestScope.member.memMail}</td>
	</tr>
	<tr>
		<th>직업</th>
		<td>${requestScope.member.memJob}</td>
	</tr>
	<tr>
		<th>취미</th>
		<td>${requestScope.member.memLike}</td>
	</tr>
	<tr>
		<th>기념일</th>
		<td>${requestScope.member.memMemorial}</td>
	</tr>
	<tr>
		<th>기념일자</th>
		<td>${requestScope.member.memMemorialday}</td>
	</tr>
	<tr>
		<th>마일리지</th>
		<td>${requestScope.member.memMileage}</td>
	</tr>
	<tr>
		<th>탈퇴여부</th>
		<td>${requestScope.member.memDelete}</td>
	</tr>
	<tr>
		<td colspan="2">
			<button class="btn btn-danger" id="delBtn">탈퇴</button>
			<a class="btn btn-primary" href='<c:url value="/member/memberUpdate.do"/>' >개인정보수정</a>
		</td>
	</tr>
</table>
<c:set var="cartList" value="${member.cartList }"/>
<c:if test="${not empty cartList }">
	<table class="table table-bordered">
		<thead>
			<tr>
				<th>상품명</th>
				<th>판매가</th>
				<th>마일리지</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${cartList }" var="cart">
				<tr>
					<td><c:url value="/prod/prodView.do" var="viewUrl">
							<c:param name="what" value="${cart.prod.prodId }" />
							<c:param name="param" value="paramValue" />
						</c:url> <a href="${viewUrl }">${cart.prod.prodName }</a></td>
					<td>${cart.prod.prodPrice}</td>
					<td>${cart.prod.prodMileage}</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</c:if>

<form name="deleteForm" method="post" action="${pageContext.request.contextPath}/member/memberDelete.do">
	<input type="hidden" name="password"/>
</form>
<script>
	$(delBtn).on("click", function(){
		let password = prompt("비밀번호 입력 ");
		if(password.length > 0){
			document.deleteForm.password.value = password;
			$(document.deleteForm).submit();
		}
		
	});
</script>