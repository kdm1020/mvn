<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<jsp:include page="/WEB-INF/views/common/head.jsp"></jsp:include>
</head>
<body>
<div class="container">
		<h3>회원 가입</h3>
		<table class="table table-bordered">
			<tr>
				<th>아이디</th>
				<td><input type="text" id="uiId" ></td>
			</tr>
			<tr>
				<th>비밀번호</th>
				<td><input type="password" id="uiPwd" ></td>
			</tr>
			<tr>
				<th>이름</th>
				<td><input type="text" id="uiName" ></td>
			</tr>
			<tr>
				<th colspan="2"><button onclick="signup()">회원가입</button></th>
			</tr>
		</table>
	</div>

<script>
function signup() {
	var xhr = new XMLHttpRequest();
	xhr.open('POST', '/user/insert');
	xhr.onreadystatechange = function() {
		if (xhr.readyState == 4) {
			if (xhr.status == 200) {
				var res = JSON.parse(xhr.responseText);
				alert(res.msg);
				if(res.result=='true'){
					goPage('/user/userlist');
				}
			}
		}
	}
	var param = {
		uiName : document.querySelector('#uiName').value,
		uiId : document.querySelector('#uiId').value,
		uiPwd : document.querySelector('#uiPwd').value
	}
	//param을 객체에서 구조체로 바꾸는중.
	param = JSON.stringify(param);
	xhr.send(param);
}
</script>
</body>
</html>