<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
수업 목록
<table class="table table-bordered">
	<thead>
		<tr>
			<th>과목코드</th>
			<th>과목명</th>
			<th>과목분류</th>
			<th>과목학점</th>
			<th>강의실</th>
			<th>강의날</th>
			<th>강의시간</th>
		</tr>
	</thead>
	<c:forEach items="${lectureList}" var="lect">
		<tr>
			<td><a href="${pageContext.request.contextPath}/professor/lecture?subCd=${lect.subCd }">${lect.subCd }</a></td>
			<td>${lect.subName }</td>
			<td>${lect.subType }</td>
			<td>${lect.subCredit }</td>
			<td>${lect.lecRoom }</td>
			<td>${lect.lecDay }</td>
			<td>${lect.lecTime }</td>
		</tr>
	</c:forEach>

</table>