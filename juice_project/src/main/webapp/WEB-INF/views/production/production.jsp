<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>production</title>
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
	<link rel="stylesheet" href="/resources/css/production.css" />
</head>
<body>
<%@ include file="/WEB-INF/views/includes/header.jsp" %>
<div id="outer">

	<div class="headerM">
		<p>제조기록서</p>
	</div>

	<div class="table1">
		<div>
			<table class="titles">
				<tr>
					<th>Lot 번호</th>
					<th>생산 제품</th>
					<th>지시 수량</th>
					<th>생산 수량</th>
					<th>지시 일자</th>
					<th>생산 일자</th>
					<th>담당자 ID</th>
					<th>완료</th>
				</tr>
			</table>
		</div>
		<div class="content_box">
			<table class="contentM">
			</table>
		</div>
	</div>

	<div class="headerM">
		<p>자재현황</p>
	</div>

	<div class="table2">

		<div class="T2_title">
			<ul>
				<li>Lot 번호: </li>
				<li>생산 제품: </li>
				<li>지시 수량: </li>
			</ul>
		</div>
		<div class="T2_content">
			<div id="d1"></div>
			<div id="d2"></div>
			<div id="d3"></div>
		</div>

		<div class="table3">
			<table class="T3_title">
				<tr>
					<th>자재 번호</th>
					<th>투입 자재</th>
					<th>표준 수량</th>
					<th>자재 재고</th>
				</tr>
			</table>
			<table class="T3_content">
			</table>
		</div> <!--table3 닫기-->

	</div> <!--table2 닫기-->

</div> <!--outer 닫기-->

  <script src="/resources/js/production.js"></script>
  <script src="/resources/js/login.js"></script>
  <%@ include file="/WEB-INF/views/includes/footer.jsp" %>
</body>
</html>
