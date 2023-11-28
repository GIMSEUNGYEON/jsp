<%@page import="kr.or.ddit.CalendarVO"%>
<%@page import="java.util.Arrays"%>
<%@page import="java.util.stream.Collectors"%>
<%@page import="java.util.stream.Collector"%>
<%@page import="java.util.stream.Stream"%>
<%@page import="java.time.Month"%>
<%@page import="java.util.Optional"%>
<%@page import="javax.swing.plaf.basic.BasicInternalFrameTitlePane.SystemMenuBar"%>
<%@page import="java.time.LocalDate"%>
<%@page import="java.time.format.TextStyle"%>
<%@page import="java.time.DayOfWeek"%>
<%@page import="java.time.temporal.WeekFields"%>
<%@page import="java.time.YearMonth"%>
<%@page import="java.util.Locale"%>
<%@page import="java.time.ZonedDateTime"%>
<%@page import="java.time.format.FormatStyle"%>
<%@page import="java.time.format.DateTimeFormatter"%>
<%@page import="java.time.ZoneId"%>
<%@page import="java.time.LocalDateTime"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	CalendarVO calVO = (CalendarVO)request.getAttribute("calendar");
	YearMonth beforeMonth = calVO.getBeforeMonth();
	ZonedDateTime current = calVO.getCurrent();
	LocalDate firstDate = calVO.getFirstDate();
	DayOfWeek firstDOW = calVO.getFirstDOW();
	FormatStyle fullStyle = calVO.getFormatStyle();
	Locale locale = calVO.getLocale();
	YearMonth afterMonth = calVO.getAfterMonth();
	int offset = calVO.getOffset();
	YearMonth thisMonth = calVO.getThisMonth();
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
	th, td{
		border:1px solid black;
	}
	table{
		border-collapse: collapse;
	}
	.sunday{
		color:red;
	}
	.saturday{
		color:blue;
	}
	.before, .after{
		color:silver;
	}
	
</style>
</head>
<body>
<h4><%=current.format(DateTimeFormatter.ofLocalizedDateTime(fullStyle, fullStyle).withLocale(locale)) %></h4>
<h4>
<a class="control-a" href="javascript:;" data-year="<%=beforeMonth.getYear() %>" data-month="<%=beforeMonth.getMonthValue() %>">◀◀◀</a>
<%=thisMonth.format(DateTimeFormatter.ofPattern("yyyy, MMMM", locale)) %>

<a class="control-a" href="javascript:;" data-year="<%=afterMonth.getYear() %>" data-month="<%=afterMonth.getMonthValue() %>">▶▶▶</a>
</h4>
	
	<table>
		<%		
			out.println("<thead>");
			for(int col = 0; col < 7; col++){
				DayOfWeek tmp = firstDOW.plus(col);
				
				out.println(
					String.format("<th>%s</th>", tmp.getDisplayName(TextStyle.FULL, locale))		
				);
			}
			out.println("</thead>");
			out.println("<tbody>");
			LocalDate tmpDate = firstDate.minusDays(offset);
			for(int row = 1; row<=6; row++){
				out.println("<tr>");
				for(int col = 1; col<=7; col++){
					YearMonth tmpMonth = YearMonth.from(tmpDate);
					
					String clz = tmpMonth.isBefore(thisMonth) ? "before" : tmpMonth.isAfter(thisMonth) ? "after" : "this-month";
										
					clz += " " + tmpDate.getDayOfWeek().name().toLowerCase();
					
// 					if(tmpDate.getDayOfWeek().name().equals("SUNDAY") && clz.equals("this-month")){
// 						clz = "sunday";
// 					}
					
// 					if( tmpDate.getDayOfWeek().name().equals("SATURDAY") && clz.equals("this-month")){
// 						clz = "saturday";
// 					}
						
					out.println(
						String.format("<td class='%2$s'>%1$d</td>", tmpDate.getDayOfMonth(), clz)		
					);	
					tmpDate = tmpDate.plusDays(1);
				}
				out.println("</tr>");
			}
			out.println("</tbody>");
		%>
	</table>

</body>
</html>