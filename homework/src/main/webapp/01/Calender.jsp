<%@page import="java.util.Calendar"%>
<%@page import="java.time.LocalDate"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	int status = 200;
	String message = null;
	Calendar cal = Calendar.getInstance();

	int todayYear = cal.get(Calendar.YEAR);
	int todayMonth = cal.get(Calendar.MONTH) + 1;
	int today = cal.get(Calendar.DATE);
	
	String selectYearStr = request.getParameter("year");
 	System.out.println(selectYearStr);
//  	System.out.println((request.getParameter("month")));
	int selectMonth = 7;//Integer.parseInt(request.getParameter("month"));
	
	if(selectYearStr == null || selectYearStr.trim().isEmpty() || !selectYearStr.matches("\\d{1,4}")){
		status = 400;
		message = "입력한 파라미터가 올바르지 않거나 입력되지 않았습니다.";
	}
	
	int selectYear = 2023;// Integer.parseInt(selectYearStr);
	
// 	cal.set(selectYear, selectMonth-1, 1);
	
	int week = cal.get(Calendar.DAY_OF_WEEK);
	
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
	h1{
		text-align:center;
	}
	
	div{
		contents-align:center;
	}
	
	table {
		margin:auto;
		border-collapse: collapse;
	}

	td {
		border:1px solid black;
		width:100px;
		height:30px;
		text-align:center;
	}
	
	td.sunday{
		color:red;
	}
	
	td.saturday{
		color:blue;		
	}
	
	td.preMonth{
		color:grey;
	}
	
</style>
<script type="text/javascript">
document.addEventListener("DOMContentLoaded", function () {

	var months = [
		"January", "February", "March", "April", "May", "June", 
		"July", "August", "September", "October", "November", "December"
			
	];
	var monthSelect = document.getElementById("month");
	let selectMonth = <%=selectMonth%>
	for(var i = 0; i < months.length; i++){
		 var option = document.createElement("option");
	     option.value = i + 1; 
	     option.text = months[i];
 	     if((i+1)==selectMonth)
 	     option.setAttribute("selected", true);
	     monthSelect.add(option);
	}	

	document.getElementById('month').addEventListener('change', function(){
		document.getElementById('selectDay').submit();
	})
	
});


</script>
</head>

<body>
	<h1>
		<a href="">◀◀◀</a>
		2023, November
		<a href="">▶▶▶</a>
	</h1>
	
	<form id="selectDay">
		<div>
			YEAR : 
			<input type="number" value="2023" id="year" name="year"/>
			MONTH : 
			<select id="month" name="month"> </select>
		</div>
	</form>
	
	<br>
	
	<table>
		<ta>
			<td class="sunday">Sunday</td>
			<td>Monday</td>
			<td>Tuesday</td>
			<td>Wednseday</td>
			<td>Thursday</td>
			<td>Friday</td>
			<td class="saturday">Saturday</td>
		</ta>
		<tbody>
<%
	Calendar preCal = Calendar.getInstance();
// 	preCal.set(Calendar.MONTH, selectMonth - 1);
// 	preCal.add(Calendar.MONTH, -1);
	
// 	int preDate = preCal.getActualMaximum(Calendar.DAY_OF_MONTH);	
	
// 	out.println("<tr>");
// 	for(int i = 1; i < week; i++){
// 		out.println("<td class='preMonth'>" + (preDate++) + "</td>");
// 	}
	
	
%>
		</tbody>
	</table>
	
</body>
</html>