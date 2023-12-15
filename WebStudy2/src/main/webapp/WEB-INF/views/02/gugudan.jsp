<%@page import="java.io.Console"%>
<%@page import="java.text.MessageFormat"%>
<%@page import="java.util.Arrays"%>
<%@page import="java.util.stream.Collectors"%>
<%@page import="java.util.stream.IntStream"%>
<%@page import="java.util.stream.Stream"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%!
StringBuffer gugudan(int min, int max){
	
	StringBuffer trTags = new StringBuffer();		
	for(int i = min; i <= max; i++){
		trTags.append("<tr>");
		for(int j = 1; j < 10; j++){
			trTags.append(MessageFormat.format("<td> {0} * {1} = {2} </td>", i, j, i*j));
		}
		trTags.append("</tr>");
	}
	return trTags;
}
%>
<%
	int minDan = (Integer)request.getAttribute("minDan");
	int maxDan = (Integer)request.getAttribute("maxDan");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
	table {
		border-collapse: collapse;
	}
	td {
		border:1px solid black;		
	}
</style>
</head>
<body>
	2단부터 9단까지의 구구단을 테이블 태그를 이용해서 만들어보기
	단, 하나의 tr 태그에서는 하나의 단만 출력
	
	<form name="gugudanForm">
		<input type="number" name="minDan" min="2" max="13" placeholder="최소단" />
		<select name="maxDan">
			<%
				for(int i = 2; i <= 13; i++){
					out.println(
						MessageFormat.format("<option value=''{0}''>{0}단</option>", i)		
					);
				}
			%>
		</select>
		<button type="submit">구구단줫!</button>
	</form>
	<table>
		<%
			StringBuffer trTags = new StringBuffer();		
			for(int i = 2; i < 10; i++){
				trTags.append("<tr>");
				for(int j = 1; j < 10; j++){
					trTags.append(MessageFormat.format("<td> {0} * {1} = {2} </td>", i, j, i*j));
				}
				trTags.append("</tr>");
			}
			out.println(trTags);
		%>
		
	</table>
	
	<br>
	
	<table>
		<%=gugudan(minDan,maxDan) %>
	</table>
	<br>
	is mine
	<table>
		<%=gugudan2(minDan,maxDan) %>
	</table>
	
	<%!
		StringBuffer gugudan2(int f, int l){
			IntStream danStream = IntStream.range(f, l);
			IntStream mulStream = IntStream.range(1, 10);
			
			StringBuffer gugudan = new StringBuffer();
			
			int [] dan = danStream.toArray();
			int [] mul = mulStream.toArray();
			
			Arrays.stream(dan).forEach(i->{
				gugudan.append("<tr>");
				Arrays.stream(mul).forEach(j->{
					gugudan.append(String.format("<td>%d * %d = %d</td>", i, j, i*j));
				});
				gugudan.append("</tr>");
			});
			
			return gugudan;
		}
	%>
	
<script type="text/javascript">
	document.gugudanForm.minDan.value = <%=minDan%>;
	document.gugudanForm.maxDan.value = <%=maxDan%>;
</script>
</body>
</html>