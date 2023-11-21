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
<!-- ex) 3! = 6 -->
<!-- 1. operand라는 유일 파라미터(1이상의 양수)를 입력받고(factorialForm.jsp), -->
<!--    유효하지 않는 파라미터에 대해서는 bad request를 응답으로 전송함. -->
<!-- 2. factorial.jsp를 이용해 파라미터를 받고 재귛소출(recursive call) 구조를 활용하여팩토리얼 연산 처리. -->
<!-- 3. 해당 연산의 결과는 다음과 같은 메시지로 출력 -->
<!-- 	<h4>3! = 6</h4> -->
<form action="<%=request.getContextPath()%>/case2/factorial.do" method="get">
	<input type="number" name="operand" min="1" placeholder="1 이상의 정수 입력"/>
	<button type="submit">숫자 제출</button>
</form>
<div id="resultArea"> </div>
<script type="text/javascript">
// 	function submitHandler(event){
// 		event.preventDefault();
// 		return false;
// 	}
	let $resultArea = $(resultArea);
	$("form:first").on("submit", function(event){
		event.preventDefault();
		// 동기 요청을 비동기 요청으로 전환
		let url = this.action; // form  action; 여기서 this를 쓰면 form태그를 뜻함
		let method = this.method;
		let queryString = $(this).serialize();
		console.log("serialize query string : " , queryString);
		let settings = {
				//근데 여기서 this를 쓰면 settings가 대상이 됨
				url:url,
				method:method,
				data:queryString, // ==> 쿼리 스트링으로 변환됨.(serializing)
				dataType:"json",
				success:function(resp){
					$resultArea.html(resp);
				},
				error:function(jqXHR, status, err){
					
				}
			}		
		
		$.ajax(settings);
			
		return false;
	});
</script>
</body>
</html>