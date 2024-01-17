/**
 * case2
1. DOM(body를 포함) 트리 구조가 완성된 이후 실행되는 코드 : DOMContentLoaded
2. calForm submit 이벤트 중단 
3. 비동기 요청 전송
	line : action, method
	header : accept, content-type
	body : form's inputs(parameter : queryString)
	
동기 방식 -> 비동기 방식 전환

body 태그가 생성되기 전에 스크립트 파일 호출하기 -> onload function 사용

submit 이벤트 가로채기 -> form 태그에서 submit이벤트(button의 type = submit) (form => submit function) 에서 preventDefault 사용

fetchpromise 이용하기 -> url(폼태그의 액션대상), method(form 태그의 메소드), headers : post 방식이니까 content-type,
body : 폼태그의 파라미터들
	
	case1 : parameter 전송 후 HTML 응답 수신
	case2 : parameter 전송 후 JSON 응답 수신
 */
document.addEventListener("DOMContentLoaded", function(){
	calForm.addEventListener("submit", function(event){
		event.preventDefault();
		let url = event.target.action;
		let method = event.target.method;
		let formData = new FormData(calForm); //키-밸류 쌍
		let urlSearchParams = new URLSearchParams(formData); //쿼리스트링 형태
		
		let fetchPromise = fetch(url,{
			method:method,
			headers :{
				"Content-Type":event.target.enctype,
				"Accept":"application/json"
			},
			body:urlSearchParams
		});
		
		fetchPromise.then((resp)=>{
			if(resp.ok){
				return resp.json(); //다시 돌아오는건 promise 객체이기 때문에 이 객체에 then연결
			}else{
				throw new Error(`상태코드:\${resp.status}`, {cause:resp})//catch로 가는 cause
			}
		}).then((jsonObj)=>{
			calculateBody.innerHTML = jsonObj.expression;
		}).catch((err)=>{
			if(err.cause){				
				let resp = err.cause;
				resp.text().then((ep)=>{
					calculateBody.innerHTML = ep;					
				});
			}
		})
		
	})
	
	return false;
});
