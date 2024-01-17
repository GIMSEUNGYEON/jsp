<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

	과목 : 
${stuList[0].subName}
<table class="table table-bordered">
	<thead>
		<tr>
			<th>학번</th>
			<th>학생 이름</th>
			<th>학생 연락처</th>
			<th>해당 과목 점수</th>
		</tr>
	</thead>
	<c:forEach items="${stuList}" var="stu">
		<tr>
			<td>${stu.stdNo }</td>
			<td>${stu.stdName }</td>
			<td>${stu.stdTelno }</td>
			<td>${stu.clsScore }</td>
		</tr>
	</c:forEach>

</table>
