/**
 * 
 */
// 	console.log(bootstrap); //1은 실행 안됨
document.addEventListener("DOMContentLoaded", ()=>{
	console.log(bootstrap); //2는 실행 가능
	$("[data-log-out]").on("click", (event)=>{
		let $aTag = $(event.target);
		let formSelector = $aTag.data("logOut");
		$(formSelector).submit();
		
	});
});