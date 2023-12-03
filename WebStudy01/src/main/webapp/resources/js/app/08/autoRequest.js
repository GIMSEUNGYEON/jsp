/**
 * 
 */

document.addEventListener("DOMContentLoaded",()=>{
	setInterval(()=>{
		fetch("serverTime.do", {
			headers:{
				"Accept":"application/json"
			}
		}).then(resp=>{
			return resp.json();
		}).then(jsonObj=>{
			timeArea.innerHTML=jsonObj.now;
		})		
	}, 1000) //반복 주기(밀리세컨드)와 행하는 행위 설정
});

//timeout  : 지연 시간 설정 
//interval : 반복 요청 설정