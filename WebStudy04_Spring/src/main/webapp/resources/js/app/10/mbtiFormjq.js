
var fnResolveEntrySet = jsonObj=>{
	let mapArray = jsonObj.entrySet;
	let options = "";
	options += mapArray.map((associativeArray)=>{
		let option = "";
		for(let propName in associativeArray){
			let entryKey = propName;
			let entryValue = associativeArray[entryKey];
			option += `<option value="${entryKey}">${entryValue}</option>`		
		}
		return option;
	}).join("\n");
	$("[name='type']").html(options);
	};

var fnResolveEntryMap = jsonObj=>{
	let associativeArray = jsonObj.entryMap;
	let options = "";
	for(let propName in associativeArray){
		let entryKey = propName;
		let entryValue = associativeArray[entryKey];
		options += `<option value="${entryKey}">${entryValue}</option>`
	}
	$("[name='type']").html(options);
};
document.addEventListener("DOMContentLoaded", event=>{
	cPath = $("body").data("contextPath");
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
		if($(event.target).prop("tagName") !== "FORM")	return false;
		let form = $(event.target);
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
					var div = $("<div>").attr("id", "resultArea");
					form.after(div);
				}
				let parser = new DOMParser();
				
				let newDoc = parser.parseFromString(html,'text/html');
				let preTag = newDoc.body.children[0]
				
				resultArea.empty().append(preTag);

			}).catch((err)=>{
				console.error(err);
			});
		return false;
	});
});


