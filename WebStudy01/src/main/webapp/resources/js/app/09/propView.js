/**
	1. document 완성 이벤트 처리
	2. 비동기 요청
	3. json content 수신
	4. ul태그 구성
 */

const cPath = document.body.dataset.contextPath;

const baseURI = `${cPath}/09/property`;
function fnCommFetch(url, options, fnResolve){
	fetch(url,options)
		.then(resp=>{
			if(resp.ok){
				return resp.json()
			}else{
				throw new Error(`상태코드 ${resp.status} 수신`, {cause:resp})
			}
		}).then(fnResolve).catch(err=>console.error(err));
}

var fnRefreshDataLiTags = jsonObj=>{
		let keyArray = jsonObj.keySet;
		/*<ul>
			<li><span>property name</span></li>
		</ul>*/
		
		let ultag = document.createElement("ul");
		ultag.classList.add("list-group");
		/*let litags = "";
		keyArray.forEach((k, i)=>{
			litags+=`
				<li><span>${k}</span></li>
			`;
		});*/
		let litags = keyArray.map(k=>`
		<li class='list-group-item'>
			<span class="delBtn" >삭제</span>
			<span class="property-name" data-bs-toggle="modal" data-bs-target="#exampleModal">${k}</span>
		</li>
		`).join("\n");
		ultag.innerHTML = litags;
		document.body.append(ultag);
		
	};

var fnReadProperties = (event)=>{
	fnCommFetch(baseURI,{
		headers:{
			"Accept":"application/json"
		}
	},fnRefreshDataLiTags)
};

var fnReadProperty = (event)=>{
	if(!event.relatedTarget.classList.contains("property-name")) return false;
	
	let propertyNameTag = event.relatedTarget;
	let propertyName = propertyNameTag.innerHTML;
	let modal = event.target;
	fnCommFetch(`${baseURI}/${propertyName}`,{
		headers:{
			"Accept":"application/json"
		}
	},(jsonObj)=>{
		let propertyValue = jsonObj.propertyValue;
		let description = jsonObj.description;
		updateForm.propertyName.value = propertyName;
		updateForm.propertyValue.value = propertyValue;
		updateForm.description.value = description;
	})
	document.querySelector("li.active")?.classList.toggle("active");
	propertyNameTag.parentElement.classList.toggle("active");
};

var fnAddProperty = (event)=>{
	event.preventDefault();
	
	let form = event.target;
	let data = {
		propertyName:form.propertyName.value,
		propertyValue:form.propertyValue.value,
		description:form.description.value
	};
	let body = JSON.stringify(data);
	fnCommFetch(baseURI,{
		method:"POST",
		headers:{
			"Accept":"application/json",	
			"Content-Type":"application/json"
		},
		body:body
	},jsonObj=>{
		document.querySelector("ul").remove();
		fnRefreshDataLiTags(jsonObj);
		form.reset();
	});
	return false;
};

var fnRemoveProperty = (event) => {
	if(!event.target.classList.contains("delBtn")) return false;
	
	let delBtn = event.target;
	let propertyNameTag = delBtn.nextElementSibling;
	let propertyName = propertyNameTag.innerHTML;
	
	fnCommFetch(`${baseURI}/${propertyName}`,{
		method:"DELETE",
		headers:{
			"Accept":"application/json"
		}
	},jsonObj=>{
		if(jsonObj.success){
			propertyNameTag.parentElement.remove();
		}
	});
};


var fnModifyProperty = (event)=>{
	event.preventDefault();
	
	let form = event.target;
	let data = {
		propertyName:form.propertyName.value,
		propertyValue:form.propertyValue.value,
		description:form.description.value
	};
	let body = JSON.stringify(data);
	fnCommFetch(`${baseURI}/${data.propertyName}`,{
		method:"PUT",
		headers:{
			"Accept":"application/json",	
			"Content-Type":"application/json"
		},
		body:body
	},jsonObj=>{
		if(jsonObj.success){
			let modalInstance = bootstrap.Modal.getInstance(exampleModal);
			modalInstance.hide();
			let modalToggler = document.querySelector("li.active").children[1];
			setTimeout(()=>{
				modalInstance.show(modalToggler);
			},1000);
		}else{
			
		}
	});
	return false;
}

document.addEventListener("DOMContentLoaded", fnReadProperties);

document.addEventListener("show.bs.modal", fnReadProperty);

document.addEventListener("hidden.bs.modal", (event)=>{
	event.target.querySelector("form")?.reset();
});

insertForm.addEventListener("submit", fnAddProperty);

document.addEventListener("click", fnRemoveProperty);

updateForm.addEventListener("submit", fnModifyProperty);
