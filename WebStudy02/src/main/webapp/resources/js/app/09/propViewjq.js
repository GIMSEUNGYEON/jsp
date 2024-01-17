
const cPath = $("body").data("contextPath");

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
		var ultag = $("<ul>").addClass("list-group");

		let litags = keyArray.map(k=>`
		<li class='list-group-item'>
			<span class="delBtn" >삭제</span>
			<span class="property-name" data-bs-toggle="modal" data-bs-target="#exampleModal">${k}</span>
		</li>
		`).join("\n");
		ultag.html(litags);
		$("body").append(ultag);

		
	};

var fnReadProperties = (event)=>{
	fnCommFetch(baseURI,{
		headers:{
			"Accept":"application/json"
		}
	},fnRefreshDataLiTags)
};

var fnReadProperty = (event)=>{
	if(!$(event.relatedTarget).hasClass("property-name")) return false;

	let propertyNameTag = $(event.relatedTarget);
	let propertyName = propertyNameTag.html();
	
	let modal = $(event.target);
	
	fnCommFetch(`${baseURI}/${propertyName}`,{
		headers:{
			"Accept":"application/json"
		}
	},(jsonObj)=>{
		let propertyValue = jsonObj.propertyValue;
		$('#updateForm input[name="propertyName"]').val(propertyName);
		$('#updateForm input[name="propertyValue"]').val(propertyValue);
	})
	$("li.active").toggleClass("active");

	$(propertyNameTag).parent().toggleClass("active");

};

var fnAddProperty = (event)=>{
	event.preventDefault();
	
	let form = $(event.target);
	let data = {
	    propertyName: form.find('[name="propertyName"]').val(),
	    propertyValue: form.find('[name="propertyValue"]').val()
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
		$("ul").remove();
		fnRefreshDataLiTags(jsonObj);
		form.reset();
	});
	return false;
};

var fnRemoveProperty = (event) => {
	if (!$(event.target).hasClass("delBtn")) return false;
		
	let delBtn = $(event.target);
	let propertyNameTag = delBtn.next();
	let propertyName = propertyNameTag.html();
	
	fnCommFetch(`${baseURI}/${propertyName}`,{
		method:"DELETE",
		headers:{
			"Accept":"application/json"
		}
	},jsonObj=>{
		if(jsonObj.success){
			propertyNameTag.parent.remove();
		}
	});
};


var fnModifyProperty = (event)=>{
	event.preventDefault();
	
	let form = $(event.target);
	let data = {
	    propertyName: form.find('[name="propertyName"]').val(),
	    propertyValue: form.find('[name="propertyValue"]').val()
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
			let modalToggler = $("li.active").children().eq(1);
			setTimeout(()=>{
				modalInstance.show(modalToggler);
			},1000);
		}else{
			
		}
	});
	return false;
}

$(document).ready(fnReadProperties);

$(document).on("show.bs.modal", fnReadProperty);

$(document).on("hidden.bs.modal", function(event) {
    $(event.target).find("form").trigger("reset");
});

$("#insertForm").on("submit", fnAddProperty);

$(document).on("click", fnRemoveProperty);

$("#updateForm").on("submit", fnModifyProperty);
