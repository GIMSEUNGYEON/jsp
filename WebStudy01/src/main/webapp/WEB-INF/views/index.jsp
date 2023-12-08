<%@ page contentType="text/html; charset=UTF-8" %>
<main class="container-fluid">
	<h4>welcome page 웰컴</h4>
	<%
		Object authId = session.getAttribute("authId");
		if(authId == null){
	%>
	<a href="<%=request.getContextPath()%>/login/loginForm.jsp">로그인</a>
	<%
		}else{
			out.println(authId+"님 로그인 성공");			
		}
	%>
</main>
<script>
// 	console.log(bootstrap); //1은 실행 안됨
	$(function(){ //페이지가 완성된 후에 로딩되어 실행됨
		console.log(bootstrap); //2는 실행 가능
	});
</script>