<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>mission/fileForm.jsp</title>
</head>
<body>
	<form method="post" enctype="multipart/form-data">
		<input type="file" name="uploadFile"/>
		<button type="submit">업로드</button>
	</form>
	
	<select id="imgList">
		<c:forEach items="${fileList }" var="file">
			<option value="${file }">${file }</option>
		</c:forEach>
	</select>
<div id="resultArea"></div>	
</body>
<script>

	imgList.addEventListener("change", (event)=>{
		let option = event.target.value;
		console.log(option);
		fetch('/mission/files', {
		 method: 'POST',
		        headers: {
		            'Content-Type': 'application/json'
		        },
		        body: JSON.stringify({ selectedOption: selectedOption })
		}).then(resp=>{
			if(resp.ok){
				return resp.json();
			}else{
				throw new Error({cause:resp});
			}
		}).then(jsonObj=>{
			resultArea.innerHTML = jsonObj;
		}).catch(err=>{
			console.error(err);
		});
		
	});
</script>
</html>