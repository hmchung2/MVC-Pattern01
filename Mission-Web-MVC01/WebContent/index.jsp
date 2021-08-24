<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<%-- <script src="<%=request.getContextPath() %>/resources/js/jquery-3.6.0.min.js"></script>		
<script>
	window.onload = function(){
		if('${sessionScope.msg}' != '')
			alert('${sessionScope.msg}')
	}
</script> --%>

</head>
<body>
	<a href="<%=request.getContextPath()%>/board/list.do"> 게시판 </a>
	<br>
	<a href="<%=request.getContextPath()%>/writeForm.do">글등록 </a>
	<br>
	<c:if test="${empty sessionScope.userVO }">
		<a href="<%=request.getContextPath()%>/login.do"> 로그인 </a>
		<br>
	</c:if>
	<c:if test="${not empty sessionScope.userVO }">
		<a href="<%=request.getContextPath()%>/member/memberList.do">멤버</a>
		<a href="<%=request.getContextPath()%>/logout.do">로그아웃</a>
		<br>
	</c:if>
</body>
</html>

