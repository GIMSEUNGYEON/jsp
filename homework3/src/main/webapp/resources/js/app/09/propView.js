/**
	1. document 완성 이벤트 처리
	2. 비동기 요청
	3. json content 수신
	4. ul태그 구성
 */
var fnRefreshDataLiTags = jsonObj=>{
		let keyArray = jsonObj.keySet;
		/*<ul>
			<li><span>property name</span></li>
		</ul>*/
		
		let ultag = document.createElement("ul");
		/*let litags = "";
		keyArray.forEach((k, i)=>{
			litags+=`
				<li><span>${k}</span></li>
			`;
		});*/
		let litags = keyArray.map(k=>`<li><span class="delBtn">삭제</span><span class="property-name">${k}</span></li>`).join("\n");
		ultag.innerHTML = litags;
		document.body.append(ultag);
		
	};

var fnReadProperties = (event)=>{fetch(`${cPath}/09/property`,{
	headers:{
		"Accept":"application/json"
	}
	}).then((resp)=>{
		if(resp.ok){
			return resp.json();	
		}else{
			throw new Error(`상태코드 ${resp.status} 수신`, {cause:resp})	
		}
	}).then(fnRefreshDataLiTags).catch((err)=>{
		console.error(err);
	});
};

var fnReadProperty = (event)=>{
	if(!event.target.classList.contains("property-name")) return false;
	
	let propertyNameTag = event.target;
	let propertyName = propertyNameTag.innerHTML;
	
	if(! propertyNameTag.nextElementSibling?.classList.contains("property-value")){
		fetch(`${cPath}/09/property/${propertyName}`,{
			headers:{
				"Accept":"application/json"
			}
		}).then(resp=>{
			if(resp.ok){
				return resp.json();	
			}else{
				throw new Error(`상태코드 ${resp.status} 수신`, {cause:resp});	
			}
		}).then((jsonObj)=>{
			let propertyValue = jsonObj.propertyValue;
			let propertyValueTag = document.createElement("span");
			propertyValueTag.classList.add("property-value");
			propertyValueTag.innerHTML=propertyValue;
			propertyNameTag.after(propertyValueTag)

		})
		
	} // if end
};

var fnDelProperty = (event) => {
	if(!event.target.classList.contains("delBtn")) return false;
	
	let delBtn = event.target;
	let delTarget = delBtn.nextSibling.innerHTML;
	
	console.log(delTarget)
	
	console.log(`${cPath}/09/property/${delTarget}`)
	fetch(`${cPath}/09/property/${delTarget}`,{
		method:"DELETE",
		headers:{
			"Accept":"application/json"
		}
	}).then((resp)=>{
		if(resp.ok){
			return resp.json();	
		}else{
			throw new Error(`상태코드 ${resp.status} 수신`, {cause:resp})	
		}
	}).then(jsonObj=>{
		
		document.querySelector("ul").remove();
		fnRefreshDataLiTags(jsonObj);
	}).catch((err)=>{
		console.error(err);
	});
}

var fnAddProperty = (event)=>{
	if(event.target.tagName !== "FORM")	return false;
	
	event.preventDefault();
	
	let form = event.target;
	let data = {
		propertyName:form.propertyName.value,
		propertyValue:form.propertyValue.value
	};
	let body = JSON.stringify(data);
	fetch(form.action,{
		method:"POST",
		headers:{
			"Accept":"application/json",	
			"Content-Type":"application/json"
		},
		body:body
	}).then((resp)=>{
		if(resp.ok){
			return resp.json();	
		}else{
			throw new Error(`상태코드 ${resp.status} 수신`, {cause:resp})	
		}
	}).then(jsonObj=>{
		document.querySelector("ul").remove();
		fnRefreshDataLiTags(jsonObj);
		form.reset();
	}).catch((err)=>{
		console.error(err);
	});
	return false;
};
const cPath = document.body.dataset.contextPath;

document.addEventListener("DOMContentLoaded", fnReadProperties);

document.addEventListener("click", fnReadProperty);

document.addEventListener("submit", fnAddProperty);

document.addEventListener("click", fnDelProperty);