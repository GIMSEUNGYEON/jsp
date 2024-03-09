<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<form method="post" enctype="application/x-www-form-urlencoded">
	<ul>
		<li>
			<input type="text" name="mtType" placeholder="새유형코드" value="${mbti.mtType }"/>
			<span class="text-danger">${errors.mtType }</span>
		</li>
		<li>
			<input type="text" name="mtTitle" placeholder="새유형타이틀" value="${mbti.mtTitle }"/>
			<span class="text-danger">${errors.mtTitle }</span>
		</li>
		<li>
			<textarea name="mtContent" placeholder="새유형내용">${mbti.mtContent }</textarea>
			<span class="text-danger">${errors.mtContent }</span>
		</li>
		<li>
			<button type="submit">전송</button>
			<button type="reset">취소</button>
		</li>
	</ul>
</form>