<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

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
/* 	if ('${ userVO }' == '') {
		alert("로그인이 필요합니다.")
		location.href = "/Mission-Web/jsp/login/login.jsp"
	} */

	$(document).ready(function() {
		$('#goback').click(function() {
			location.href = "memberlist.jsp"
		})
	})
</script>
</head>
<body>

	<div align="center">
		<hr width="80%">
		<h2>회원 상세</h2>
		<hr width="80%">
		<br>
		<table border="1" style="width: 80%">
			<tr>
				<th width="25%">이름</th>
				<%-- <td><%= rs.getString("NAME") %></td> --%>
				<td><c:out value="${member.name}" /></td>

			</tr>
			<tr>
				<th width="25%">아이디</th>
				<%-- <td><%= rs.getString("ID") %></td> --%>
				<td>${member.id}<c:out value="" />
				</td>
			</tr>
			<tr>
				<th width="25%">이메일</th>
				<%-- <td><%= rs.getString("EMAIL_DOMAIN") %>@<%= rs.getString("EMAIL_ID") %> </td> --%>
				<td><c:out value=" ${member.emailDomain } @ ${member.emailId }" />
			</tr>
			<tr>
				<th width="25%">전화번호</th>
				<%-- <td><%= rs.getString("TEL1") %> - <%= rs.getString("TEL2") %> - <%= rs.getString("TEL3") %> </td> --%>
				<td><c:out
						value="${member.tel1 } -${member.tel2 }  -${member.tel3 }" /></td>
			</tr>
			<tr>
				<th width="25%">주소</th>
				<%-- <td><%= rs.getString("BASIC_ADDR") %> - <%= rs.getString("DETAIL_ADDR")%> - <%= rs.getString("POST") %> </td> --%>
				<td><c:out
						value="${member.basicAddr} - ${member.detailAddr} - ${member.post}" />
				</td>
			</tr>
			<tr>
				<th width="25%">등록일</th>
				<%-- <td><%= rs.getString("reg_date") %></td> --%>
				<td><c:out value="${member.regDate}" /></td>

			</tr>
		</table>
	</div>
	<div align="center">
		<button value="뒤로" id="goback">뒤로</button>
	</div>


</body>
</html>

