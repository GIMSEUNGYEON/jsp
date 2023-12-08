/**
 * 
1. 페이지가 완성되면,
2. 비동기 요청(/10/mbti)을 전송하고
3. json 컨텐츠를 수신한 이후
4. select 옵션을 동적으로 구성

MBTI 유형을 선택하면, 해당 MBTI의 컨텐츠를 현재 페이지의 하단에 출력.
1. select change 이벤트 처리, -> submit 이벤트 트리거시키고 있음.
2. submit 이벤트의 고유 액션 중단
3. 동기를 비동기로 전환하여 전송(나머지 모든 조건(form)은 동일)
4. HTML 컨텐츠 수신
5. div 생성하고 form next sibling 으로 추가
6. div의 children으로 수신한 HTML 컨텐츠를 출력.

 */

/*function resolve(){
	
}
var resolve = function(){
	
}
*/
var fnResolveEntrySet = jsonObj=>{
	let mapArray = jsonObj.entrySet;
	let options = "";
	options += mapArray.map((associativeArray)=>{
		let option = "";
		for(let propName in associativeArray){ // 1번 실행됨
			let entryKey = propName;
			let entryValue = associativeArray[entryKey];
			option += `<option value="${entryKey}">${entryValue}</option>`		
		}
		return option;
	}).join("\n");
	document.querySelector("[name='type']").innerHTML = options;
	};

var fnResolveEntryMap = jsonObj=>{
	let associativeArray = jsonObj.entryMap;
	let options = "";
	for(let propName in associativeArray){
		let entryKey = propName;
		let entryValue = associativeArray[entryKey];
		options += `<option value="${entryKey}">${entryValue}</option>`
	}
	document.querySelector("[name='type']").innerHTML = options;	
};
document.addEventListener("DOMContentLoaded", event=>{
	cPath = document.body.dataset.contextPath;
	// 윈도우 객체에 바인딩한 전역변수
	fetch(`${cPath}/10/mbti`,{
		headers:{
			"Accept":"application/json"
		}
	}).then((resp)=>{
		if(resp.ok){
			return resp.json();	
		}else{
			throw new Error(`상태코드 ${resp.status} 수신`, {cause:resp})	
		}
	}).then(fnResolveEntryMap).catch((err)=>{
		console.error(err);
	});
	
	mbtiForm.addEventListener("submit", event=>{
		if(event.target.tagName !== "FORM")	return false;
		let form = event.target;
		let formData = new FormData(form);
		let urlSearchParams = new URLSearchParams(formData);
		
		event.preventDefault();
		
		let url = `${event.target.action}?${urlSearchParams}`
		
		fetch(url,{
			headers:{
				"Accept":"text/html"
			}
			}).then((resp)=>{
				if(resp.ok){
					return resp.text();	
				}else{
					throw new Error(`상태코드 ${resp.status} 수신`, {cause:resp})	
				}
			}).then(html=>{
				if(!window['resultArea']){				
					div = document.createElement("div");
					div.setAttribute("id", "resultArea");
					form.after(div);
				}
				let parser = new DOMParser();
				
				let newDoc = parser.parseFromString(html,'text/html');
				let preTag = newDoc.body.children[0]
				resultArea.replaceChildren()
				resultArea.appendChild(preTag)
			}).catch((err)=>{
				console.error(err);
			});
		return false;
	});
});


