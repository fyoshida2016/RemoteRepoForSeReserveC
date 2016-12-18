<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page session="true"%>
<%@ page import="model.Reservation"%>
<%@ page import="model.User"%>
<%@ page import="model.Room"%>
<%@ page import="java.util.LinkedList"%>

<%
	LinkedList<Reservation> ReservationList = (LinkedList<Reservation>) request.getAttribute("Reservations");
%>

<!DOCTYPE html>
<html lang="ja">
<head>
	<meta charset="UTF-8">
	<link rel="stylesheet" type="text/css" href="story09.css">
	<title id="title">会議室一覧表示</title>
</head>
<body>
	<table id="root_table" border="1" align="center">
		<caption>予約一覧</caption>
		<thead>
		<tr>
		<td class="place">場所</td>
		<td class="start_time">利用開始時間</td>
		<td class="use_time">利用時間</td>
		<td class="name">予約者</td>
		<td></td>
		</tr>
		</thead>
		<!-- 以降に予約情報を出力 -->
		<tbody>
		<% for(Reservation RList : ReservationList){ %>
		<tr>
		<td><%= RList.getRoom().getName() %></td>
		<td><%= RList.getStartYear()%>年<%= RList.getStartMonth() %>月<%= RList.getStartDay() %>日<%= RList.getStartHour() %>時<%= RList.getStartMinute() %>分</td>
		<td><%= RList.getPeriodHour() %>時<%= RList.getPeriodMinute() %>分</td>
		<td><%= RList.getUser().getName() %></td>
		<td>
			<form method="post" action="ReservationDetailsServlet">
			<input type="hidden" name="RID" value="<%= RList.getRid() %>">
			<input type="submit" value="詳細">
			</form>
		</td>
		</tr>
		<%} %>
		</tbody>
		<!-- ここまで -->
	</table>
</body>
</html>