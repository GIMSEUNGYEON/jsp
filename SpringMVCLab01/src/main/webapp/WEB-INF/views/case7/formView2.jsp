<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<div style="border: 1px solid red;">
	${org.springframework.validation.BindingResult.sample }
</div>
	<form:form method="post" modelAttribute="sample">
		<pre>
<%-- 			<input type="text" name="strParam" value="${sample.strParam }"/> --%>
			<form:input path="strParam"/>
			<span>${errors.strParam }</span>
			<form:errors path="strParam" element="span" cssClass="error"/>
			
<%-- 			<input type="number" name="numParam" value="${sample.numParam }"/> --%>
			<form:input path="numParam" type="number"/>
			<form:errors path="numParam" element="span" cssClass="error"/>
			
<%-- 			<input type="text" name="chParam" value="${sample.chParam }"/> --%>
			<form:input path="chParam" />
			<form:errors path="chParam" element="span" cssClass="error"/>
			
<%-- 			<input type="date" name="dateParam" value="${sample.dateParam }"/> --%>
			<form:input path="dateParam" type="date"/>
			<form:errors path="dateParam" element="span" cssClass="error"/>
			
<%-- 			<input type="datetime-local" name="dateTimeParam" value="${sample.dateTimeParam }"/> --%>
			<form:input path="dateTimeParam" type="datetime-Local"/>
			<form:errors path="dateTimeParam" element="span" cssClass="error"/>
			
<%-- 			<input type="number" name="optionParam" value="${sample.optionParam }"/> --%>
			<form:input path="optionParam" type="number"/>
			<form:errors path="optionParam" element="span" cssClass="error"/>

<!-- 			<button type="submit">전송</button> -->
			<form:button type="submit">전송</form:button>
			<form:button type="reset">취소</form:button>
			
<!-- 			<input type="text" name="innerParam1"/>  -->
			<form:input path="inner.innerParam1"/>
			<form:errors path="inner.innerParam1"/>
<!-- 			<input type="number" name="innerParam2"/>  -->
			<form:input path="inner.innerParam2"/>
			<form:errors path="inner.innerParam2"/>
			
			<form:input path="innerList[0].innerParam3"/>
			<form:errors path="innerList[0].innerParam3"/>
			<form:input path="innerList[0].innerParam4"/>
			<form:errors path="innerList[0].innerParam4"/>
			<form:input path="innerList[1].innerParam3"/>
			<form:errors path="innerList[1].innerParam3"/>
			<form:input path="innerList[1].innerParam4"/>
			<form:errors path="innerList[1].innerParam4"/>
		
		</pre>
			
	</form:form>
		
<!-- 	private String strParam; -->
<!-- 	private int numParam; -->
<!-- 	private char chParam; -->
<!-- 	private LocalDate dataParam; -->
<!-- 	private LocalDateTime dateTimeParam; -->
	
<!-- 	private Integer optionParam; -->
