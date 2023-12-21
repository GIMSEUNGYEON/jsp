<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html>
<head>
<meta charset='UTF-8'>
<title>Insert title here</title>
<style>
	form{
		background-color: yellow;
	}
</style>
<script
  src="https://code.jquery.com/jquery-3.7.1.min.js"
  integrity="sha256-/JqT3SQfawRcv/BIHPThkBvs0OEvtFFmqPF/lYI/Cxo="
  crossorigin="anonymous">
  
  </script>
</head>

<body>

	
	<form action="<%=request.getContextPath() %>/image.do">
<!-- 	<select name='image' onchange="changeEvent()"> -->
	<select name='image'>
			${options}
		</select>
	<input type='submit' value='전송'/>
	</form>
	<div id="imageArea">
		
	</div>
	<script>
// 		jQuery();
		let $imageArea = $("#imageArea");
		
		$("select[name='image']").on("change", function(event){
// 			this  //htmlElement
// 			$(this) //jQuery
// 			$(this).[0] //HtmlElement
// 			this.form.submit(); //HtmlElement.submit()
			$(this.form).submit(); //jQuery.submit()
		});
		
		$("form:first").on("submit", function(event){
		    event.preventDefault();
		    
		    let imageName = $(this.image).val()
			let $imgTag = $("<img>").addClass("imgArea").attr("src", `http://localhost/WebStudy01/image.do?image=\${imageName}`); 
		    //이미지 태그를 새로 생성
// 			$(".imgArea").remove();
			$imageArea.empty();
			$imageArea.append($imgTag)
			
		    return false;
		});
	
	</script>

</body>
</html>
    