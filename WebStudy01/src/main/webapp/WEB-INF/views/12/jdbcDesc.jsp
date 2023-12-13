<%@page import="java.util.stream.Collectors"%>
<%@page import="java.util.stream.Stream"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="kr.or.ddit.vo.PropertyVO"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

	<h4>JDBC(Java DataBase Connectivity)</h4>
	<pre>
		1. 드라이버를 찾아서 빌드패스(classpath)에 추가
		2. 드라이버 로딩(driver class loading)
		3. 드라이버를 통해 Connection 수립
		4. 쿼리 객체(statement)를 이용하여 sql 쿼리를 컴파일하고 데이터베이스에 전송 및 결과를 가져온다.
			- Statement : 
			- PreparedStatement : 미리 컴파일이 된 쿼리(실행 시 동적으로 쿼리문을 바꾸지 못함, 정적)(객체를 생성할 때 sql 쿼리를 받아 컴파일과 동시에 객체 생성)
			- CallableStatement : 프로시저나 function을 호출하여 사용할 수 있게 해주는 객체
		5. 쿼리문 작성(DDL, DML, TCL), 실행
			- ResultSet => executeQuery
			- int => executeUpdate
		6. 실행 결과 집합의 사용 : cursor 기반의 데이터(record, tuple)를 포인터를 통해 접근함.
		사용한 모든 자원의 release
	</pre>

	<table class="table table-bordered">
		<thead>
			<tr>
				<th>PROPERTY_NAME</th>
				<th>PROPERTY_VALUE</th>
				<th>DESCRIPTION</th>
			</tr>
		</thead>
		<%
			List<PropertyVO> propList = (List)request.getAttribute("propList");
		%>
		<tbody>
			<%=
				propList.stream()
				.map(p->String.format("<tr><td>%s</td><td>%s</td><td>%s</td></tr>", p.getPropertyName(), p.getPropertyValue(), p.getDescription()))
				.collect(Collectors.joining("\n"))
			%>
		</tbody>
	</table>
<script>
	console.log($)
</script>