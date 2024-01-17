/**
 * 
 */

var fnResolveEntryMap = jsonObj =>{
	let asArray = jsonObj.entryMap;
	let options = "";
	for(let propName in asArray){
		
		let entryKey = propName;
		let entryValue = asArray[entryKey];

		options += `<option value=${entryKey}>${entryValue}</option>`
	}
	document.querySelector("[name='name']").innerHTML = options;
};

var fnOptionLoad = (event)=>{
	cPath = document.body.dataset.contextPath;
	
	fetch(`${cPath}/bts`,{
		method:"get",
		headers:{
			"Accept":"application/json"
		}
	}).then((resp)=>{
		if(resp.ok){
			return resp.json();
		}else{
			throw new Error(`상태코드 ${resp.status}`, {cause:resp})
		}
	}).then(fnResolveEntryMap).catch((err)=>{
		console.error(err);
	});
	
};

var fnBtsLoad = (event)=>{
	if(event.target.tagName !== "FORM") return false;
	
	event.preventDefault();

	let form = event.target;
	let formData = new FormData(form);
	let urlSerchParams = new URLSearchParams(formData);
	
	let url = `${form.action}?${urlSerchParams}`
	
	fetch(url,{
		method:form.method,
		headers:{
			"Accept":"text/html"
		}
	}).then((resp)=>{
		if(resp.ok){
			return resp.text();
		}else{
			throw new Error(`상태코드 ${resp.status}`, {cause:resp})
		}
	}).then((html)=>{
		if(!window['resultArea']){
			div = document.createElement("div");
			div.setAttribute("id","resultArea");
			form.after(div);
		}
		let parser = new DOMParser();
		
		let newDoc = parser.parseFromString(html, 'text/html');
		let preTag = newDoc.body.innerHTML;
		resultArea.innerHTML = preTag;
	}).catch((err)=>{
		console.error(err);
	});		
	return false;
};

document.addEventListener("DOMContentLoaded", fnOptionLoad);

document.addEventListener("submit", fnBtsLoad);












