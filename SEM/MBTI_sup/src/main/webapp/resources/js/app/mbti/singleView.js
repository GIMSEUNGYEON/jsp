/**
 * 
 */
const fnMakeTr = (mbti)=>{
	return $("<tr>").append(
		$("<td>").html(mbti.mtSort)
		, $("<td class='mtType'>").html(mbti.mtType)
		, $('<td data-bs-toggle="modal" data-bs-target="#exampleModal">').html(mbti.mtTitle)
	);
};

const cPath = $("body").data("contextPath");

exampleModal.addEventListener("show.bs.modal", (event)=>{
	let targetModal = event.target;
	let $targetTable = $(targetModal).find("table");
	let mtTitleTag = event.relatedTarget;
	let mtType = $(mtTitleTag).siblings(".mtType").html();
	console.log(mtTitleTag.innerHTML, mtType);
	$.ajax({
		url:`${cPath}/mbti/ajax/mbtiView.do`,
		method:"get",
		data:{
			what:mtType
		},
		dataType:"json",
		success:function(resp){
			let mbti = resp.mbti;
			$.each(mbti, function(pn, pv){
				let $dataTag = $targetTable.find(`.${pn}`);
				$dataTag.html(pv);
				console.log(pn, pv, $dataTag);
			});
		}
	});
});
document.addEventListener("DOMContentLoaded", ()=>{
	// UI 요청(동기)과 Data 요청(ajax 비동기)의 분리
	$.ajax({
		url:`${cPath}/mbti/ajax/mbtiList.do`,
		method:"get",
		dataType:"json",
		success:function(resp){
			let mbtiList = resp.mbtiList;
			let trTags = [];
			if(mbtiList.length > 0){
				$.each(mbtiList, function(index, mbti){
					trTags.push( fnMakeTr(mbti) );
				});
			}else{
				let tr = $("<tr>").html(
					$("<td>").attr("colspan", "3")
							.html("등록된 mbti가 없음.")
				);	
				trTags.push(tr);
			}
			$(listBody).html(trTags);
		}
	});
});