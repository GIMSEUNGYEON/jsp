/**
 * 
 */
$(submitForm).spaForm(function(resp){
	let $listBody = $(listBody);
	let $pagingArea = $(pagingArea);
	
	this.page.value = "";
	$listBody.empty();
	$pagingArea.empty();
	
	let dataList = resp.memberList;
	let pagingHTML = resp.pagingHTML;
	
	let trTags = null;
	
	if(dataList.length > 0){
		$.each(dataList, function(index, member){
			trTags += `
				<tr>
					<td>${member.rnum }</td>
					<td>${member.memName }</td>
					<td>${member.memMail }</td>
					<td>${member.memHp }</td>
					<td>${member.memAdd1 }</td>
					<td>${member.memMileage }</td>
				</tr>
			`;
		});
	}else{
		trTags = `
			<tr>
				<td colspan="6">조건에 맞는 회원이 없음.</td>
			</tr>
		`;
	}
	
	$listBody.append(trTags);
	if(pagingHTML)
		$pagingArea.append(pagingHTML);
}).submit();
