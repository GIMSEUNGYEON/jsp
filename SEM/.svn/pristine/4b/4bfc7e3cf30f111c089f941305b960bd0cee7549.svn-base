<%@page import="kr.or.ddit.vo.MbtiDescVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
	List<MbtiDescVO> list = (List) request.getAttribute("mbtiList");

%>
<a href="${pageContext.request.contextPath }/mbti/sync/mbtiInsert.do">새MBTI추가</a>
<table class="table table-bordered">
	<thead>
		<tr>
			<th>순서</th>
			<th>유형</th>
			<th>타이틀</th>
		</tr>
	</thead>
	<tbody>
		<%
			for(MbtiDescVO single : list){
				%>
				<tr>
					<td><%=single.getMtSort() %></td>
					<td><%=single.getMtType() %></td>
					<td><a href="<%=request.getContextPath() %>/mbti/sync/mbtiView.do?what=<%=single.getMtType()%>"><%=single.getMtTitle() %></a></td>
				</tr>
				<%
			}
		%>
	</tbody>
</table>











