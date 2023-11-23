<%@page import="enumPck.MimeType"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
</head>
<body>
<!-- 비동기 처리 기반의 사칙연산기. -->
<form action="<%=request.getContextPath() %>/calculate.do">
	<label><input type="radio" name="dataType" value="APPLICATION_JSON" />JSON</label>
	<label><input type="radio" name="dataType" value="APPLICATION_XML" />XML</label>
	<label><input type="radio" name="dataType" value="TEXT_HTML" checked="checked"/>HTML</label>
	<br>
	<input type="number" name="leftOp" />
	<select name="operator">
		<option value="operator">연산자</option>
		<option value="PLUS">+</option>
		<option value="MINUS">-</option>
		<option value="MULTIPLY">*</option>
		<option value="DIVIDE">/</option>
	</select>
	<input type="number" name="rightOp" />
	<input type="submit" value="="/>
</form>
<div id="resultArea">
	ex) 2 * 2 = 4
</div>
<script type="text/javascript">
	
	$("form:first").on("submit", function(event){
		event.preventDefault();
		let url = this.action;
		let method = this.method;
		let queryString = $(this).serialize();
		let aType = $('input[name=dataType]:checked').val();
		console.log(aType)
		let $resultArea = $("#resultArea");
		let type = "";

		if (aType === "APPLICATION_JSON"){
			console.log("json확인")
				type = "json"
			function fn_atype(resp){
				$resultArea.html(resp.expression)
			
			}
		}else if(aType == "TEXT_HTML"){
				console.log("html확인")
				type = "html"
			function fn_atype(resp){
				let respObj = JSON.parse(resp)
				console.log("함수 호출 확인")
				$resultArea.html(respObj.expression);
			}
		}
		
		let settings = {
				url:url,
				method:method,
				data:queryString,
				dataType:type,
				success:function(resp){
					console.log("응답 성공 확인")
					fn_atype(resp);
				},
				error:function(jqXHR, status, err){
					console.log("응답 실패 확인")
				}
			}
		
		$.ajax(settings);
			
		return false;
	});
</script>
</body>
</html>