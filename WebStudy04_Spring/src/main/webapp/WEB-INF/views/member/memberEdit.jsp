<%@page import="kr.or.ddit.vo.MemberVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<form:form method="post" modelAttribute="member">
	<table>
		<form:input path="memId" type="hidden"/>
	
		<tr>
			<th>비밀번호</th>
			<td>
				<form:input path="memPass" class="form-control" />
				<form:errors path="memPass" element="span" cssClass="text-danger"/>
			</td>
		</tr>
		<tr>
			<th>이름</th>
			<td>
				<form:input path="memName" class="form-control" />
				<form:errors path="memName" element="span" cssClass="text-danger"/>
			</td>
		</tr>
		<tr>
			<th>주민번호1</th>
			<td>
				<form:input path="memRegno1" class="form-control" />
				<form:errors path="memRegno1" element="span" cssClass="text-danger"/>
			</td>
		</tr>
		<tr>
			<th>주민번호2</th>
			<td>
				<form:input path="memRegno2" class="form-control" />
				<form:errors path="memRegno2" element="span" cssClass="text-danger"/>
			</td>
		</tr>
		<tr>
			<th>생일</th>
			<td>
				<form:input path="memBir" class="form-control" type="datetime-local"/>
				<form:errors path="memBir" element="span" cssClass="text-danger"/>
			</td>
		</tr>
		<tr>
			<th>우편주소</th>
			<td>
				<form:input path="memZip" class="form-control" />
				<form:errors path="memZip" element="span" cssClass="text-danger"/>
			</td>
		</tr>
		<tr>
			<th>주소1</th>
			<td>
				<form:input path="memAdd1" class="form-control" />
				<form:errors path="memAdd1" element="span" cssClass="text-danger"/>
			</td>
		</tr>
		<tr>
			<th>주소2</th>
			<td>
				<form:input path="memAdd2" class="form-control" />
				<form:errors path="memAdd2" element="span" cssClass="text-danger"/>
			</td>
		</tr>
		<tr>
			<th>집전화번호</th>
			<td>
				<form:input path="memHometel" class="form-control" />
				<form:errors path="memHometel" element="span" cssClass="text-danger"/>
			</td>
		</tr>
		<tr>
			<th>회사전화번호</th>
			<td>
				<form:input path="memComtel" class="form-control" />
				<form:errors path="memComtel" element="span" cssClass="text-danger"/>
			</td>
		</tr>
		<tr>
			<th>휴대폰번호</th>
			<td>
				<form:input path="memHp" class="form-control" />
				<form:errors path="memHp" element="span" cssClass="text-danger"/>
			</td>
		</tr>
		<tr>
			<th>이메일</th>
			<td>
				<form:input path="memMail" class="form-control" />
				<form:errors path="memMail" element="span" cssClass="text-danger"/>
			</td>
		</tr>
		<tr>
			<th>직업</th>
			<td>
				<form:input path="memJob" class="form-control" />
				<form:errors path="memJob" element="span" cssClass="text-danger"/>
			</td>
		</tr>
		<tr>
			<th>취미</th>
			<td>
				<form:input path="memLike" class="form-control" />
				<form:errors path="memLike" element="span" cssClass="text-danger"/>
			</td>
		</tr>
		<tr>
			<th>기념일</th>
			<td>
				<form:input path="memMemorial" class="form-control" />
				<form:errors path="memMemorial" element="span" cssClass="text-danger"/>
			</td>
		</tr>
		<tr>
			<th>기념일자</th>
			<td>
				<form:input path="memMemorialday" class="form-control" type="date"/>
				<form:errors path="memMemorialday" element="span" cssClass="text-danger"/>
			</td>
		</tr>
		<tr>
			<th>마일리지</th>
			<td>1000</td>
		</tr>
		<tr>
			<td colspan="2">
				<button type="submit" class="btn btn-primary">전송</button>
				<button type="reset" class="btn btn-danger">취소</button>
			</td>
		</tr>
	</table>
</form:form>