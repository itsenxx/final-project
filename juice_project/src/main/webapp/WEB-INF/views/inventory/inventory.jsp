<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Inventory</title>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
    <link rel="stylesheet" href="/resources/css/production.css" />
</head>
<body>
<%@ include file="/WEB-INF/views/includes/header.jsp" %>
<div id="outer">
    <div class="headerM">
        <p>월별 자재재고현황</p>
    </div>
    <div class="">
        <table class="titles">
            <tr>
                <th>월별</th>
                <th>자재 번호</th>
                <th>자재 이름</th>
                <th>전월 재고</th>
                <th>입고 수량</th>
                <th>출고 수량</th>
                <th>당월 재고</th>
            </tr>
        </table>
        <table class="contentI">
            <c:forEach items="${materInventoryVOList}" var="materInventory">
                <tr>
                    <td><c:out value="${materInventory.transMonth}"></c:out></td>
                    <td><c:out value="${materInventory.materId}"></c:out></td>
                    <td><c:out value="${materInventory.materName}"></c:out></td>
                    <td><c:out value="${materInventory.prevInventory}"></c:out></td>
                    <td><c:out value="${materInventory.input}"></c:out></td>
                    <td><c:out value="${materInventory.output}"></c:out></td>
                    <td><c:out value="${materInventory.inventory}"></c:out></td>
                </tr>
            </c:forEach>
        </table>
    </div> <br>
    <div class="headerM">
        <p>월별 제품재고현황</p>
    </div>
    <div class="">
        <table class="titles">
            <tr>
                <th>월별</th>
                <th>제품 번호</th>
                <th>제품 이름</th>
                <th>전월 재고</th>
                <th>입고 수량</th>
                <th>출고 수량</th>
                <th>당월 재고</th>
            </tr>
        </table>
        <table class="contentI">
            <c:forEach items="${prodInventoryVOList}" var="prodInventory">
                <tr>
                    <td><c:out value="${prodInventory.transMonth}"></c:out></td>
                    <td><c:out value="${prodInventory.prodId}"></c:out></td>
                    <td><c:out value="${prodInventory.prodName}"></c:out></td>
                    <td><c:out value="${prodInventory.prevInventory}"></c:out></td>
                    <td><c:out value="${prodInventory.input}"></c:out></td>
                    <td><c:out value="${prodInventory.output}"></c:out></td>
                    <td><c:out value="${prodInventory.inventory}"></c:out></td>
                </tr>
            </c:forEach>
        </table>
    </div> <br>
</div>
<%@ include file="/WEB-INF/views/includes/footer.jsp" %>
</body>
</html>