/**
 * 
 */

document.addEventListener("DOMContentLoaded",()=>{
	empTel.addEventListener("keyup", function(e){
		convertPhoneNumber(e.target);
	});
	empHomeTel.addEventListener("keyup", function(e){
		convertPhoneNumber(e.target);
	});
});

let myInfoUpdateInfoForm = document.getElementById("myInfoUpdateInfoForm");

myInfoUpdateInfoForm.addEventListener("submit", ()=>{
	event.preventDefault();
	
	let url = myInfoUpdateInfoForm.action;
	let method = myInfoUpdateInfoForm.method;
	
	let formData = new FormData(myInfoUpdateInfoForm)
	
	fetch(url, {
		method:method,
		headers:{
			"Accept":"application/json"
		},
		body:formData
	}).then(resp=>{
		if(resp.ok){
			return resp.json();
		}else{
			throw Error("오류 발생", {cause:resp});
		}
	}).then(jsonObj=>{
		console.log(jsonObj);
	})
	
	
	return false;
});


myinfoChangePwdForm.addEventListener("submit", ()=>{
	event.preventDefault();
	if(newPwd.value != newPwdChk.value){
		dismatch.style.display = "block";
	}else {
		
		let url = myinfoChangePwdForm.action;
		let method = myinfoChangePwdForm.method;
		
		let formData = new FormData(myinfoChangePwdForm);
		let jsonData = {};
		
		formData.forEach((value, key)=>{
			jsonData[key] = value;
		})
		console.log(jsonData);
		
		fetch(url,{
			method:method,
			headers:{
				"Content-Type":"application/json",
				"Accept":"application/json"
			},
			body:JSON.stringify(jsonData)
		}).then(resp=>{
			if(resp.ok){
				return resp.json();
			}else{
				throw new Error("오류 발생", {cause:resp})
			}
		}).then(jsonObj=>{
			console.log(jsonObj);
			if(jsonObj['message'].includes("error")){
				let errorMessage = jsonObj['errorMessage']
				errorMessageField.innerHTML = errorMessage;
				
			} else if(jsonObj['message'].includes("ok")){
				Swal.fire({
					title:"비밀번호 변경이 완료되었습니다",
					icon:"success"
				})
				empPw.value = "";
				newPwd.value = "";
				newPwdChk.value = "";
			}
		})
	}
	
	return false;
});

