<%@page import="db.Wifi"%>
<%@page import="java.util.List"%>
<%@page import="db.History"%>
<%@page import="db.HistoryList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<style type="text/css">
		table th, td {
			border:solid 1px #000;

			
		}
		table {
			border:solid 1px #000;
			border-collapse: collapse;
			width: 100%;
		}
		th, td {
			padding: 5px;
			text-align: center;
			font-size: 12px;
			width: auto;
		}
		tr:nth-child(even) {background-color: #f2f2f2;}
		
		th {
		background-color: #04AA6D;
		color: white;
		}
		td {
			text-align: left;
		}
		
	</style>
</head>
<body>
	<%
		String lat = request.getParameter(lat);
		String lnt = request.getParameter(lnt);
		HistoryList historyList = new HistoryList();
		History history = new History();
		history.insert(lat, lnt);
		history.list();

	%>
	<h1>와이파이 정보 구하기</h1>
	<table>
		<thead>
			<tr>
				<th>ID</th>
				<th>X좌표</th>
				<th>Y좌표</th>
				<th>검색일자</th>
			</tr>
		</thead>
		<tbody>
		<t>
			<p><a href="http://localhost:8081/main.jsp">홈</a> | <a href="http://localhost:8081/history.jsp">위치 히스토리 목록</a> |<a href="http://localhost:8081/list.jsp">Open API와이파이 정보 가져오기</a></p>
			<p>
				LAT: <input type="text" name="lat"> LNT: <input type="text" name="lnt"> <button>근처 WIFI정보 보기</button>
			</p>
		</t>
			<tr>
				<%
				for(HistoryList hL : historyList) {
				%>
					<tr>
						<td> <%=hL.getLnt()%> </td> 
						<td> <%=hL.getLat()%> </td> 
					</tr>
				<%
				}
				%>
				
			</tr>
		</tbody>
	</table>

</body>
</html>