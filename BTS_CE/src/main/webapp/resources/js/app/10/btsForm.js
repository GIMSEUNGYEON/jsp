/**
 * 
 */

var fnBtsLoad = (event)=>{
	if(event.target.tagName !== "FORM") return false;
	
	let form = event.target;
	event.preventDefault();
	let formData = new FormData(form);
	let urlSearchParams = new URLSearchParams(formData);
	
	fetch(`${form.action}?${urlSearchParams}`,{
		method:form.method,
		headers:{
			"Accept":"text/html"
		}
	}).then(resp=>{
		if(resp.ok){
			return resp.text();
		}else{
			throw new Error('상태코드 ${resp.status}',{cause:resp});
		}
	}).then(html=>{
		if(!window['resultArea']){
			let div = document.createElement("div");
			div.id = "resultArea";
			form.after(div)
		}
		let parser = new DOMParser();
		let newDoc=parser.parseFromString(html, "text/html");
		let preTag=newDoc.body.innerHTML;
		resultArea.innerHTML = preTag;
	}).catch(err=>console.error(err));
	
};

/*document.addEventListener("submit", fnBtsLoad);*/

$(document).on("submit", "form", (event)=>{ //타겟을 폼으로 제한
	event.preventDefault();
	let form = event.target;
	let queryString = $(form).serialize();
	
	$.ajax({
		url:form.action,
		method:form.method,
		data:queryString,
		dataType:"html",
		success:function(html){
			let $div = $("#resultArea");
			if($div.length == 0){
				$div = $("<div>").prop("id", "resultArea");
				$(form).after($div);
			}
			let elementArray = $.parseHTML(html);
			let $elementArray = $(html);
			
			let $filteredElements = $elementArray.filter((idx, ele)=>{
									//ele.classList.contains("people_info")
									return $(ele).hasClass("people_info");
								});
			$div.html($filteredElements);
		},
		error:function(){
			
		}
			
	});
	
	return false;
});
