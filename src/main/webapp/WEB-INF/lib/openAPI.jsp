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
			text-align: left;
			font-size: 12px;
			width: auto;
		}
		tr:nth-child(even) {background-color: #f2f2f2;}
		
		th {
		background-color: #04AA6D;
		color: white;
		}
		
	</style>
</head>
<body>
	<%
		WifiServices wifiService = new WifiServices();
		List<Wifi> wifiList = wifiService.list();

	%>
	<h1>와이파이 정보 구하기</h1>
	<table>
		<thead>
			<tr>
				<th>거리</th>
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
			<p><a href="http://localhost:8081/main.jsp">홈</a> | <a href="http://localhost:8081/history.jsp">위치 히스토리 목록</a> |<a href="http://localhost:8081/list.jsp">Open API와이파이 정보 가져오기</a></p>
			<p>
				LAT: <input type="text"> LNT: <input type="text"> <button>근처 WIFI정보 보기</button>
			</p>
		</t>
			<tr>
				<%
				for(Wifi wifi : wifiList) {
				%>
					<tr>
						<td> <%=wifi.getDistance()%></td>
						<td> <%=wifi.getX_swifi_inout_door()%> </td>
						<td> <%=wifi.getX_swifi_instl_floor()%> </td>
						<td> <%=wifi.getX_swifi_instl_mby()%> </td>
						<td> <%=wifi.getX_swifi_remars3()%> </td>
						<td> <%=wifi.getX_swifi_instl_ty()%> </td> 
						<td> <%=wifi.getX_swifi_mgr_no()%> </td> 
						<td> <%=wifi.getX_swifi_wrdofc()%> </td> 
						<td> <%=wifi.getX_swifi_adres1()%> </td> 
						<td> <%=wifi.getX_swifi_adres2()%> </td> 
						<td> <%=wifi.getX_swifi_cmcwr()%> </td> 
						<td> <%=wifi.getWork_dttm()%> </td> 
						<td> <%=wifi.getX_swifi_svc_se()%> </td> 
						<td> <%=wifi.getX_swifi_main_nm()%> </td> 
						<td> <%=wifi.getLnt()%> </td> 
						<td> <%=wifi.getX_swifi_cnstc_year()%> </td> 
						<td> <%=wifi.getLat()%> </td> 
					</tr>
				<%
				}
				%>
				
			</tr>
		</tbody>
	</table>

</body>
</html>