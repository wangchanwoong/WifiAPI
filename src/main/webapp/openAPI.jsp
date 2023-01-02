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
		h1 {
			text-align: center;
		}
		p {
			text-align: center;
		}
		
	</style>

</head>
<body>
	<%
		WifiServices wifiService = new WifiServices();
		wifiService.insert();
		List<Wifi> wifiList = wifiService.list();
	%>
	<h1><%out.write(Integer.toString(wifiList.size()));%> 개의 WIFI정보를 정상적으로 저장하였습니다.</h1>
	<table>
		
		<t><p><a href="http://localhost:8081/home.jsp">홈으로 돌아가기</a></p></t>
	</table>

</body>
</html>