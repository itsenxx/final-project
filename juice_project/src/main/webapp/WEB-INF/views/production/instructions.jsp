<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>instructions</title>
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
	<link rel="stylesheet" href="/css/production.css" />
</head>
<body>
<%@ include file="/WEB-INF/views/includes/header.jsp" %>
<div id="outer">
	<div class="headerM">
		<p>제조지시서</p>
	</div>
	<div class="instructions">
		<div>
		<form action="instructions_btn" method="post">
			<table class="titles">
				<tr>
					<th>Lot 번호</th>
					<th>제품 번호</th>
					<th>지시 수량</th>
					<th>생산 수량</th>
					<th>지시 일자</th>
					<th>생산 일자</th>
					<th>담당자 ID</th>
					<th>전송</th>
				</tr>
			</table>
			<table class="contentI">
				<tr>
					<td></td> <!--lot 번호-->
					<td><input type="text" id="prod_id" class="inputField" name="prod_id" placeholder="제품번호"></td>
					<td><input type="text" id="inst_amt" class="inputField" name="inst_amt" placeholder="지시수량"></td>
					<td></td> <!--생산 수량-->
					<td class="dates"><input type="date" id="inst_date" class="inputField" name="inst_date" placeholder="지시일자"></td>
					<td class="dates"></td> <!--생산 일자-->
					<td></td>  <!--생산 담당-->
					<td><button id="submitBtn">전송</button></td>
				</tr>
			</table>
		</form>
		</div>

		<div>
    		<table class="titles">
    			<tr>
    				<th>Lot 번호</th>
    				<th>생산 제품</th>
    				<th>지시 수량</th>
    				<th>생산 수량</th>
    				<th>지시 일자</th>
    				<th>생산 일자</th>
    				<th>생산 담당</th>
    				<th>상태</th>
    			</tr>
    		</table>

        <table class="contentI">
        <c:forEach items="${instructionsVOList}" var="instructions">
          <tr>
            <td><c:out value="${instructions.lotNum}"/></td>
            <td><c:out value="${instructions.prodName}"/></td>
            <td><c:out value="${instructions.instAmt}"/></td>
            <td><c:out value="${instructions.prodAmt}"/></td>
            <td class="dates"><c:out value="${instructions.instDate}"/></td>
            <td class="dates"><c:out value="${instructions.prodDate}"/></td>
            <td><c:out value="${instructions.empName}"/></td>
            <td><c:out value="${instructions.completion}"/></td>
          </tr>
        </c:forEach>
        </table>

    </div>
	</div>
</div>
<script src="/resources/js/instructions.js"></script>
<script src="/resources/js/login.js"></script>
<%@ include file="/WEB-INF/views/includes/footer.jsp" %>
</body>
</html>