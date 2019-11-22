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
		<table class="table table-bordered">
			<tbody id="tBody"></tbody>
		</table>
		<button>수정</button>
		<button>리스트로 돌아가기.</button>
	</div>
	<script>
		window.onload = function() {
			var xhr = new XMLHttpRequest();
			xhr.open('GET', '/pb/pbview=?cmd=view&pbNum=${param.pbNum}');
			xhr.onreadystatechange = function() {
				if (xhr.readyState == 4) {
					if (xhr.status == 200) {
						var board = JSON.parse(xhr.responseText);
						var tBody = document.getElementById('tBody');
						var html = '';
						html += '<tr>';
						html += '<th>제목</th>';
						html += '<td>' + board.biTitle + '</td>'
						html += '</tr>';
						html += '<tr>';
						html += '<th>내용</th>';
						html += '<td>' + board.biContent + '</td>'
						html += '</tr>';
						html += '<tr>';
						html += '<th>작성자</th>';
						html += '<td>' + board.uiNum + '</td>'
						html += '</tr>';
					}
					tBody.innerHTML = html;

				}
			}
			xhr.send();
		}
	</script>
</body>
</html>