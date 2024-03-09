<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<table>
	<tr>
		<c:forEach items="${topMenuList }" var="menu">
			<td>
				<a href="javascript:;" data-go-link="${menu.menuUrl }">${menu.menuText }</a>
			</td>
		</c:forEach>
	</tr>
	<c:if test="${not empty subMenuList }">
		<tr>
		<c:forEach items="${subMenuList }" var="menu">
			<td>
				<a href="javascript:;" data-go-link="${menu.menuUrl }">${menu.menuText }</a>
			</td>
		</c:forEach>
		</tr>
	</c:if>
</table>
