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

	window.onload = function(){

		if('${msg}' !=  "")
			alert('${msg}')
	}
	function isNull(obj ,str){
		if(obj.value ==""){
			alert(str)
			obj.focus()
			return true
		}
		return false
	}
	
	function checkForm(){
		let f = document.loginForm
		if(isNull(f.id , "아이디를 입력하세요")){
			return false
		}			
		if(isNull(f.password , "비밀번호를 입력하세요")){
			return false
		}				
		return true
	}
</script>

</head>


<body>
	<header>
		<%-- 	<jsp:include page="/jsp/include/topMenu.jsp" /> --%>
	</header>
	<section>
		<div align="center">
			<hr>
			<h2>로그인</h2>
			<hr>
			<br>
			<form name="loginForm"
				action="<%=request.getContextPath() %>/loginProcess.do"
				method="post" onsubmit="return checkForm()">
				<table>
					<tr>
						<th>ID</th>
						<td><input type="text" name="id"></td>
					</tr>
					<tr>
						<th>PASSWORD</th>
						<td><input type="password" name="password"></td>
					</tr>

				</table>
				<br> <input type="submit" value="로그인">
			</form>
		</div>
	</section>
	<footer>
		<%-- 		<%@ include file="/jsp/include/bottom.jsp" %>		 --%>
	</footer>
</body>
</html>