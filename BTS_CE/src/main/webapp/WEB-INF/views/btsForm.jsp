<%@page import="java.util.stream.Collectors"%>
<%@page import="java.util.Map"%>
<%@ page contentType="text/html; charset=UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>BTS</title>
    
</head>
<body data-context-path="<%=request.getContextPath() %>">
    <form action="<%=request.getContextPath()%>/10/bts" onchange="this.requestSubmit();">
        <select name="name">
        	
        	<%
        		Map<String,String> btsModel = (Map) request.getAttribute("btsModel");
        		String options = btsModel.entrySet().stream()
		        				 	    .map(en->String.format("<option value='%s'>%s</option>", en.getKey(), en.getValue()))
		        				    	.collect(Collectors.joining("\n"));
        		
		       out.println(options);
        	%>
        </select>
    </form>
    <script type="text/javascript" src="<%=request.getContextPath() %>/resources/js/app/10/btsForm.js"></script>
</body>
</html>