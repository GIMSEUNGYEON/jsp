<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<input type="radio" name="contentType" value="application/x-www-form-urlencoded"/>parameter
<input type="radio" name="contentType" value="application/json"/>json
<form method="post" id="insertForm" >
	<input type="text" name="propertyName" required placeholder="property name"/>
	<input type="text" name="propertyValue" required placeholder="property value"/>
	<input type="text" name="description" placeholder="description"/>
	<input type="date" name="propDate" placeholder="propDate"/>
	<input type="datetime-local" name="propTimestamp" placeholder="propTimestamp"/>
	<button type="submit">전송</button>
</form>

<!-- 1. 등록의 모든 절차는 비동기로 처리할 것. -->
<!-- 2. 등록에 사용되는 모든 컨텐츠는 json 송수신할 것. -->
<!-- 3. contentType 라디오버튼에 따라 전송 컨텐츠의 종류가 달라짐. -->

이벤트를 핸들링하는 네단계
1. 타겟을 정한다.(insertForm)
2. 이벤트의 종류를 정한다.(submit)
3. 핸들러를 구현한다.()
4. 타겟과 이벤트를 연결한다.(addEventListener)

<script>
	insertForm.addEventListener("submit", (event)=>{
		
		event.preventDefault();
		let form = event.target;
		
		console.log(form);
		
 		let contentType = document.querySelector('[name="contentType"]:checked')?.value ?? form.enctype;

		let url = form.action;
		let formData = new FormData(form);
		let body = null;
		
		if(contentType.indexOf("json")>=0){
			let data = {};
			for(let k of formData.keys()){
				data[k] = formData.get(k);
			}
			body = JSON.stringify(data);
			
// 			읽을 수 있는 데이터 => json : stringify
// 			json 데이터 => 읽을 수 있는 데이터 : parse
			
		}else{
			body = new URLSearchParams(formData).toString();
		}
		let options = {
			method:form.method
			, headers:{
				"content-type":contentType,
				"accept":"application/json"
			},
			body:body
		};
		
		fetch(url, options)
			.then(resp=>{
				if(resp.ok){
					return resp.json();
				}else{
					throw new Error(`\${url}처리 중 에러 발생`, {cause:resp});
				}
			}).then(jsonObj=>{
				console.log(jsonObj);
			}).catch(err=>console.error(err));
	});
</script>
</body>
</html>















