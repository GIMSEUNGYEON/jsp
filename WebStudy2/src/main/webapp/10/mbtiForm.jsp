<%@page import="java.util.Objects"%>
<%@page import="kr.or.ddit.utils.CookieUtils"%>
<%@page import="java.util.Arrays"%>
<%@page import="java.util.stream.Stream"%>
<%@page import="java.util.Optional"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>MBTI</title>
</head>
<body data-context-path="<%=request.getContextPath()%>">
      <%
		String mbtiCookieValue = CookieUtils.findCookieValue(request, "mbtiCookie");
		
		
      %>
    <form action="<%=request.getContextPath()%>/10/mbti" onchange="this.requestSubmit();">
        <select name="type" data-init-value="<%=Objects.toString(mbtiCookieValue, "")%>">
<!--             <option value="istj">1. ISTJ 소금형</option> -->
<!--             <option value="isfj">2. ISFJ 권력형</option> -->
<!--             <option value="infj">3. INFJ 예언자형</option> -->
<!--             <option value="intj">4. INTJ 과학자형</option> -->
<!--             <option value="istp">5. ISTP 백과사전형</option> -->
<!--             <option value="isfp">6. ISFP 성인군자형</option> -->
<!--             <option value="infp">7. INFP 잔다르크형</option> -->
<!--             <option value="intp">8. INTP 아이디어형</option> -->
<!--             <option value="estp">9. ESTP 활동가형</option> -->
<!--             <option value="esfp">10. ESFP 사교형</option> -->
<!--             <option value="enfp">11. ENFP 스파크형</option> -->
<!--             <option value="entp">12. ENTP 발명가형</option> -->
<!--             <option value="estj">13. ESTJ 사업가형</option> -->
<!--             <option value="esfj">14. ESFJ 친선도모형</option> -->
<!--             <option value="enfj">15. ENFJ 언변능숙형</option> -->
<!--             <option value="entj">16. ENTJ 지도자형</option> -->
        </select>
    <input class="form-check-input" type="hidden" name="remember" value="remember" id="flexCheckDefault">
        
    </form>
    <script type="text/javascript" src="<%=request.getContextPath() %>/resources/js/app/10/mbtiForm.js">
    				
    </script>
</body>
</html>