<%@page import="db.Wifi"%>
<%@page import="java.util.List"%>
<%@page import="db.WifiServices"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<style type="text/css">

		table {
			border:solid 1px #000;
			border-collapse: collapse;
			width: 100%;
		}
				tr:nth-child(even) {background-color: #f2f2f2;}
		
		th {
		background-color: #04AA6D;
		border:solid 1px white;
		color: white;
		padding: 7px;
		text-align: center;
		font-size: 12px;
		width: auto;
		
		
		}
		td {
			padding: 20px;
			text-align: center;
			font-size: 12px;
			width: auto;
			border:solid 1px #ddd;
		}
		
	</style>
</head>
<body>
	<h1>와이파이 정보 구하기</h1>
	<table>
		<thead>
			<tr>
				<th>거리(Km)</th>
				<th>실내외구분</th>
				<th>설치위치(층)</th>
				<th>설치기관</th>
				<th>와이파이접속환경</th>
				<th>설치유형</th>
				<th>관리번호</th>
				<th>자치구</th>
				<th>도로명주소</th>
				<th>상세주소</th>
				<th>망종류</th>
				<th>작업일자</th>
				<th>서비스구분</th>
				<th>와이파이명</th>
				<th>X좌표</th>
				<th>설치년도</th>
				<th>Y좌표</th>
			</tr>
		</thead>
		<tbody>
		<t>
			<p><a href="http://localhost:8081/home.jsp">홈</a> | <a href="http://localhost:8081/history.jsp">위치 히스토리 목록</a> |<a href="http://localhost:8081/openAPI.jsp">Open API와이파이 정보 가져오기</a></p>
			<p>
				<form method="post" action="response.jsp">
				LAT: <input type="text" name="lat"> LNT: <input type="text" name="lnt"> <input type="submit" value="근처WIFI정보 보기">
				</form>
			</p>
		</t>
			<tr>
				
					<td colspan='17'>위치 정보를 입력한 후에 조회해 주세요.</td>
							
			</tr>
		</tbody>
	</table>

</body>
</html>