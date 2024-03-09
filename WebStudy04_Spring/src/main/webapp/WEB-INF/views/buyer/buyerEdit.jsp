<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<form:form method="post" modelAttribute="buyer">
	<table class="table table-bordered">
		<form:input path="buyerId" type="hidden" />
		<form:input path="buyerLgu" type="hidden" />
		<tr>
			<th>제조사명</th>
			<td><form:input path="buyerName" type="text"
					class="form-control" />
				<form:errors path="buyerName" element="span" cssClass="text-danger" /></td>
		</tr>
		<tr>
			<th>은행</th>
			<td><form:input path="buyerBank" type="text"
					class="form-control" />
				<form:errors path="buyerBank" element="span" cssClass="text-danger" /></td>
		</tr>
		<tr>
			<th>계좌번호</th>
			<td><form:input path="buyerBankno" type="text"
					class="form-control" />
				<form:errors path="buyerBankno" element="span"
					cssClass="text-danger" /></td>
		</tr>
		<tr>
			<th>계좌주</th>
			<td><form:input path="buyerBankname" type="text"
					class="form-control" />
				<form:errors path="buyerBankname" element="span"
					cssClass="text-danger" /></td>
		</tr>
		<tr>
			<th>우편번호</th>
			<td><form:input path="buyerZip" type="text" class="form-control" />
				<form:errors path="buyerZip" element="span" cssClass="text-danger" /></td>
		</tr>
		<tr>
			<th>주소1</th>
			<td><form:input path="buyerAdd1" type="text"
					class="form-control" />
				<form:errors path="buyerAdd1" element="span" cssClass="text-danger" /></td>
		</tr>
		<tr>
			<th>주소2</th>
			<td><form:input path="buyerAdd2" type="text"
					class="form-control" />
				<form:errors path="buyerAdd2" element="span" cssClass="text-danger" /></td>
		</tr>
		<tr>
			<th>전화번호</th>
			<td><form:input path="buyerComtel" type="text"
					class="form-control" />
				<form:errors path="buyerComtel" element="span"
					cssClass="text-danger" /></td>
		</tr>
		<tr>
			<th>팩스번호</th>
			<td><form:input path="buyerFax" type="text" class="form-control" />
				<form:errors path="buyerFax" element="span" cssClass="text-danger" /></td>
		</tr>
		<tr>
			<th>이메일</th>
			<td><form:input path="buyerMail" type="text"
					class="form-control" />
				<form:errors path="buyerMail" element="span" cssClass="text-danger" /></td>
		</tr>
		<tr>
			<th>담당자</th>
			<td><form:input path="buyerCharger" type="text"
					class="form-control" />
				<form:errors path="buyerCharger" element="span"
					cssClass="text-danger" /></td>
		</tr>
		<tr>
			<th>내선번호</th>
			<td><form:input path="buyerTelext" type="text"
					class="form-control" />
				<form:errors path="buyerTelext" element="span"
					cssClass="text-danger" /></td>
		</tr>
		<tr>
			<th>이메일2</th>
			<td><form:input path="buyerMail2" type="text"
					class="form-control" />
				<form:errors path="buyerMail2" element="span" cssClass="text-danger" /></td>
		</tr>
		<tr>
			<th>담당자2</th>
			<td><form:input path="buyerCharger2" type="text"
					class="form-control" />
				<form:errors path="buyerCharger2" element="span"
					cssClass="text-danger" /></td>
		</tr>
		<tr>
			<th>내선번호2</th>
			<td><form:input path="buyerTelext2" type="text"
					class="form-control" />
				<form:errors path="buyerTelext2" element="span"
					cssClass="text-danger" /></td>
		</tr>
		<tr>
			<td colspan="2">
				<button type="submit" class="btn btn-primary">전송</button>
				<button type="reset" class="btn btn-danger">취소</button>
			</td>
		</tr>
	</table>
</form:form>