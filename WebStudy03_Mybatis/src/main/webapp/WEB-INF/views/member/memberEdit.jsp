<%@page import="kr.or.ddit.vo.MemberVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:choose>
	<c:when test="${not empty message}">
		<pre>
			message = ${message}
			errors = ${errors}
			<c:remove var="message" scope="session"/>
		</pre>	
	</c:when>
	<c:otherwise>
		전달된 메시지 없음
	</c:otherwise>
</c:choose>
<form method="post">
	<table>
		<tr>
			<th>비밀번호</th>
			<td><input type="text" name="memPass" required
				class="form-control" /><span
				class="text-danger">${errors.memPass}</span></td>
		</tr>
		<tr>
			<th>우편주소</th>
			<td><input type="text" name="memZip" required
				value="${member.memZip}" class="form-control" /><span
				class="text-danger">${errors.memZip}</span></td>
		</tr>
		<tr>
			<th>주소1</th>
			<td><input type="text" name="memAdd1" required
				value="${member.memAdd1}" class="form-control" /><span
				class="text-danger">${errors.memAdd1}</span></td>
		</tr>
		<tr>
			<th>주소2</th>
			<td><input type="text" name="memAdd2" required
				value="${member.memAdd2}" class="form-control" /><span
				class="text-danger">${errors.memAdd2}</span></td>
		</tr>
		<tr>
			<th>집전화번호</th>
			<td><input type="text" name="memHometel"
				value="${member.memHometel}" class="form-control" /><span
				class="text-danger">${errors.memHometel}</span></td>
		</tr>
		<tr>
			<th>회사전화번호</th>
			<td><input type="text" name="memComtel"
				value="${member.memComtel}" class="form-control" /><span
				class="text-danger">${errors.memComtel}</span></td>
		</tr>
		<tr>
			<th>휴대폰번호</th>
			<td><input type="text" name="memHp" required
				value="${member.memHp}" class="form-control" /><span
				class="text-danger">${errors.memHp}</span></td>
		</tr>
		<tr>
			<th>이메일</th>
			<td><input type="text" name="memMail" value="${member.memMail}"
				class="form-control" /><span class="text-danger">${errors.memMail}</span></td>
		</tr>
		<tr>
			<th>직업</th>
			<td><input type="text" name="memJob" value="${member.memJob}"
				class="form-control" /><span class="text-danger">${errors.memJob}</span></td>
		</tr>
		<tr>
			<th>취미</th>
			<td><input type="text" name="memLike" value="${member.memLike}"
				class="form-control" /><span class="text-danger">${errors.memLike}</span></td>
		</tr>
		<tr>
			<th>기념일</th>
			<td><input type="text" name="memMemorial"
				value="${member.memMemorial}" class="form-control" /><span
				class="text-danger">${errors.memMemorial}</span></td>
		</tr>
		<tr>
			<th>기념일자</th>
			<td><input type="date" name="memMemorialday"
				value="${member.memMemorialday}" class="form-control" /><span
				class="text-danger">${errors.memMemorialday}</span></td>
		</tr>
		<tr>
			<td colspan="2">
				<button type="submit" class="btn btn-primary">전송</button>
				<button type="button" class="btn btn-danger">취소</button>
			</td>
		</tr>
	</table>
</form>