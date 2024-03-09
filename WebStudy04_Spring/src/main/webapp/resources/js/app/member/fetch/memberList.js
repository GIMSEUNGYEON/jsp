/**
 * 
 */

let form = document.querySelector("#submitForm")
$("#submitForm").on("submit", (event)=>{
	event.preventDefault();
	let url = form.action;
	let method = form.method;
	
	let formData = new FormData(form);
	let jsonData = {};
		formData.forEach((value, key) => {
		    jsonData[key] = value;
	});
	console.log(jsonData)
	fetch(url, {
		method:method,
		headers:{
			"Content-Type": "application/json",
       		"Accept": "application/json"
		},
		body: JSON.stringify(jsonData)
		
	}).then(resp=>{
		console.log(resp)
		if(resp.ok){
			return resp.json();
		}else{
			throw new Error("오류발생", {cause:resp})
		}
	}).then(jsonObj=>{
		console.log(jsonObj)
	}).catch(err=>{
		console.error(err)
	}).finally(()=>{
		
	})
	
	return false;
	
})

$("#submitForm").submit();