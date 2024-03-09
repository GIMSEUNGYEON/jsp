/**
 * data-spa-role="ajaxform" 속성을 가진 form 을 대상으로 비동기 처리를 하고, backward와 forward 를 지원함.
 */

$.fn.spaForm = function(fnSuccess){
	if(!fnSuccess) return this;
	
	this.get(0).fnSuccess = fnSuccess.bind(this.get(0));
	
	this.on("submit", function(event){
		event.preventDefault();
		
		let url = this.action;
		let method = this.method;
		let queryString = $(this).serialize();
		let dataType = this.dataset.spaDataType ?? "json";
		let form = this;
		let formId = this.id??`form_${Date.now()}`;
		this.id = formId;
		
		let settings = {
				url : url,
				method : method,
				data : queryString,
				dataType : dataType,
				targetForm : formId,
				success:function(resp){
					fnSuccess.call(form, resp);
				},
				global : true // ajaxSend, ajaxStop, ajaxComplete 사용 여부 
			};
		
		$.ajax(settings);
		
		return false;
	})
	
	return this;
};


$(document).on('ajaxComplete', function(event, jqXHR, settings){
	console.log("ajax complete");
	if(jqXHR.state()=='rejected') return false;
	
	history.pushState({
		response : jqXHR.responseJSON
		, targetForm : settings.targetForm
		, href : settings.url
	}, '', '');
});

window.addEventListener('popstate', function(event){
	if(event.state && event.state.response && event.state.targetForm && event.state.href){
		let resp = event.state.response;
		let formId = event.state.targetForm;
		let href = event.state.href;
		
		let $targetForm = $(`#${formId}`);
		let $searchUI = $(`[data-pg-target="#${formId}"]`);
		
		let successFunc = $targetForm.get(0).fnSuccess;
		let searchParams = new URL(href).searchParams;
		
		for(let name of searchParams.keys()){
			let values = searchParams.getAll(name);
			let iptsTarget = $targetForm.find(`[name="${name}"]`);
			let iptsSearch = $searchUI.find(`[name="${name}"]`);
			for(let idx in values){
				$(iptsTarget[idx]).val(values[0]);
				$(iptsSearch[idx]).val(values[0]);
			}
		}
		successFunc(resp);
	}
	return false;
});
