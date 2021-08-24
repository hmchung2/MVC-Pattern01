<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet"
	href="<%=request.getContextPath() %>/resources/css/layout.css" />
<link rel="stylesheet"
	href="<%=request.getContextPath() %>/resources/css/board.css" />
<script
	src="<%=request.getContextPath() %>/resources/js/jquery-3.6.0.min.js"></script>

<script>
/* 	function doAction(name){
		<c:choose>
			<c:when test="${ not empty userVO}">
				location.href = "memberdetail.jsp?name=" + name
			</c:when>
			<c:otherwise>
				if (confirm('로그인이 필요한 서비스입니다\n로그인페이지로 이동하시겠습니까?'))
					location.href = "/Mission-Web/jsp/login/login.jsp"
			</c:otherwise>
		</c:choose>
	} */

	$(document).ready(function() {
		$('#gotosignin').click(function() {
			location.href = "/Mission-Web/jsp/login/login.jsp"
		})
	})
</script>

</head>
<body>
	<header>
		<%-- 		<jsp:include page="/jsp/include/topMenu.jsp" /> --%>
	</header>

	<div align="center">
		<hr width="80%">
		<br>
		<table border="1" style="width: 80%">
			<tr>
				<th width="17%">이름</th>
				<th>이메일</th>
				<th width="17%">계급</th>
			</tr>
			<c:forEach items="${list}" var="member" varStatus="loop">
				<tr <c:if test="${ loop.index mod 2 ne 0 }"> class="odd" </c:if>>
					<td><a
						href="<%=request.getContextPath() %>/member/memberDetail.do?name=${member.name }"><c:out
								value="${member.name }" /> </a>
					<td>${member.emailDomain }@${member.emailId }</td>
					<td>${member.type }</td>

				</tr>
			</c:forEach>
		</table>
	</div>
	<%-- 	<c:if test="${ empty userVO }">
		<div align="center">		
			<button value="로그인" id="gotosignin"> 로그인 </button>	
		</div>	
	 </c:if> --%>
</body>
</html>

