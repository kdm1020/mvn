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
				<th>작성자</th>
				<th>제목</th>
				<th>내용</th>
				<th>이미지1</th>
				<th>이미지2</th>
				<th>작성일</th>
			</tr>
		</thead>
		<tbody id="tBody">
		</tbody>
	</table>
	<a href="/pb/pbinsert.jsp"><button>리스트 추가</button></a>
</div>
<script>
window.onload = function(){
	var xhr = new XMLHttpRequest();
	xhr.open('GET','/pb/pblist');
	xhr.onreadystatechange = function(){
		if(xhr.readyState==4){
			if(xhr.status==200){
				var pbList=JSON.parse(xhr.responseText);
				console.log(pbList);
				var html='';
				for(var pb of pbList){
					html += '<tr>';
					html += '<td>'+pb.pbNum+'</td>';
					html += '<td>'+pb.creusr+'</td>';		
					html += '<td>'+pb.pbTitle+'</td>';
					html += '<td>'+pb.pbContent+'</td>';
					html += '<td><img src="'+pb.pbImg1+'"></td>';
					html += '<td><img src="'+pb.pbImg2+'"></td>';
					html += '<td>'+pb.credat+'</td>';
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