/**
 * 
 */

const cPath = document.body.dataset.contextPath;

document.addEventListener("DOMContentLoaded", (event)=>{

	const refreshFileArea = jsonObj=>{
		let ulTag = document.createElement("ul");
		ulTag.innerHTML = jsonObj.map(n=>`
								<li><a href="${cPath}/mission/file/${n}">${n}</a></li>
							`).join("\n");
							
		document.querySelector('#fileArea').replaceChildren(ulTag);
	}
	
	fetch(location.href,{
		headers:{
			"accept":"application/json"
		}
	}).then(resp=>{
		if(resp.ok){
			return resp.json();
		}else{
			throw new Error("요청 처리 과정에서 문제 발생",{cause:resp});
		}
	}).then(refreshFileArea)
	.catch(err=>{
		console.error(err);
	});
	
	fileForm.addEventListener("submit", (event)=>{
		event.preventDefault();
		let form = event.target;
		let formData = new FormData(form);
		fetch(form.action,{
			method:form.method,
			headers:{
				"accept":"application/json"
				/* json payload를 넘길 때만 컨텐트타입 이용 */
			},
			body:formData
		}).then(resp=>{
			if(resp.ok){
				return resp.json();
			}else{
				throw new Error("요청 처리 과정에서 문제 발생",{cause:resp});
			}
			}).then(refreshFileArea)
			.catch(err=>{
				console.error(err);
			});	
		fileForm.querySelector("input").value = "";
	});
});
