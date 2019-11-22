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
				<th>번호</th>
				<th>아이디</th>
				<th>이름</th>
				<th>이미지</th>
			</tr>
		</thead>
		<tbody id="tBody">
		</tbody>
	</table>
	<button>리스트 추가</button>
</div>
<script>
window.onload = function(){
	var xhr = new XMLHttpRequest();
	xhr.open('GET','/file/list');
	xhr.onreadystatechange = function(){
		if(xhr.readyState==4){
			if(xhr.status==200){
				var ftList=JSON.parse(xhr.responseText);
				console.log(ftList);
				var html='';
				for(var ft of ftList){
					html += '<tr>';
					html += '<td>'+ft.FT_NUM+'</td>';
					html += '<td>'+ft.FT_ID+'</td>';		
					html += '<td>'+ft.FT_NAME+'</td>';
					html += '<td><img src="'+ft.FI_FILE+'"></td>';
					html += '</tr>';			
				}
				document.querySelector('#tBody').innerHTML = html;
			}
		}
	}
	xhr.send();
}
</script>
	
</body>
</html>