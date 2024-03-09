

document.addEventListener("DOMContentLoaded", event => {
	function fn_fetch(){
		let form = document.querySelector("form");
		let url = form.action;
		let method = form.method;
		let settings = {
			method:method,
			headers:{
				"accept":"application/json"
			}
		}
		fetch(url, settings)
		.then(resp=>{
			if(resp.ok){
				return resp.json();
			}else{
				throw new Error("오류 발생", {cause:resp});
			}
		}).then(jsonObj=>{
			
			let trTag= "";
			
			jsonObj['memList'].forEach(j=>{
				trTag += `<tr>
					<td>${j.rnum}</td>
					<td>${j.memName}</td>
					<td>${j.memMail}</td>
					<td>${j.memHp}</td>
					<td>${j.memAdd1}</td>
					<td>${j.memMileage}</td>
				</tr>
				`
			})
			
			document.querySelector("tbody").innerHTML = trTag;
			pagingArea.innerHTML = (jsonObj['pagingHTML'])
		}).catch(err=>{
			console.error(err);
		});
	}
	
	fn_fetch();
	
	$(submitForm).addEventListener("submit", function(event){
		
		event.preventDefault();
		fn_fetch();
	})

	
	
	$(document).on("click", "a[data-pg-role='pageLink']", function(event){
		
		event.preventDefault();
		let page = $(this).data("pgPage");
		//location.href = "?page="+page;
		let targetFormSelector = $(this).data("pgTarget")
		let $targetForm = $(targetFormSelector);
		$targetForm.find('[name="page"]').val(page);
		$targetForm.submit();
		return false;
	});
	
})


