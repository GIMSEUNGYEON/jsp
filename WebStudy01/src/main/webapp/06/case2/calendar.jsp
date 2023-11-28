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

	Locale locale =	Optional.ofNullable(request.getParameter("locale"))
							.filter(l->!l.trim().isEmpty())
							.map(l->Locale.forLanguageTag(l))
							.orElse(Locale.getDefault());

	ZoneId zone = ZoneId.systemDefault();
// 	LocalDateTime current = LocalDateTime.now(zone);
	ZonedDateTime current = ZonedDateTime.now(zone);
	FormatStyle fullStyle = FormatStyle.FULL;
	
	 

	int targetYear = Optional.ofNullable(request.getParameter("year"))
			.map(y->new Integer(y))
			.orElse(YearMonth.from(current).getYear());
	
	YearMonth thisMonth = Optional.ofNullable(request.getParameter("month"))
	        						.map((m)->YearMonth.of(targetYear, Integer.parseInt(m)))
	        						.orElse(YearMonth.from(current));
	
	YearMonth beforeMonth = thisMonth.minusMonths(1);
	YearMonth afterMonth = thisMonth.plusMonths(1);

	WeekFields weekFields = WeekFields.of(locale);
	DayOfWeek firstDOW = weekFields.getFirstDayOfWeek();
	LocalDate firstDate = thisMonth.atDay(1);
	int firstDateDOW = firstDate.get(weekFields.dayOfWeek());
	int offset = firstDateDOW - 1;
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