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

<div class= "container">
<table class="table">
		<thead class="thead-dark">
			<tr>
				<th scope="col">번호</th>
				<th scope="col">아이디</th>
				<th scope="col">이름</th>
			</tr>
		</thead>
		<tbody id="tBody">
		</tbody>
	</table>
	<button onclick="goPage('/user/insert')">회원가입.</button>
</div>
<script>
window.onload = function(){
	var xhr = new XMLHttpRequest();
	xhr.open('GET','/user/list');
	xhr.onreadystatechange = function(){
		if(xhr.readyState==4){
			if(xhr.status==200){
				var userList=JSON.parse(xhr.responseText);
				var html='';
				for(var user of userList){
					html += '<tr onclick="goPage(\'/user/userview?uiNum='+user.uiNum+'\')">';
					html += '<td>'+user.uiNum+'</td>';
					html += '<td>'+user.uiId+'</td>';		
					html += '<td>'+user.uiName+'</td>';
					html += '</tr>';			
				}
				tBody.innerHTML = html;
			}
		}
	}
	xhr.send();
}
</script>
	
</body>
</html>