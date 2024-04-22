<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%@ include file="/WEB-INF/views/includes/header.jsp" %>
        <link rel="stylesheet" href="/resources/css/salesStatus.css"/>
    <div id="box">
    <h1>판매현황</h1>
        <div id="innerbox">
            <button id="monthlySales">월별 판매량</button>
            <button id="salesByProduct">상품별 판매량</button>
            <button id="salesByCustomer">고객별 판매량</button>
            <select id="month" style="display:none;">
                <option value="1">1월</option>
                <option value="2">2월</option>
                <option value="3">3월</option>
                <option value="4">4월</option>
                <option value="5">5월</option>
                <option value="6">6월</option>
                <option value="7">7월</option>
                <option value="8">8월</option>
                <option value="9">9월</option>
                <option value="10">10월</option>
                <option value="11">11월</option>
                <option value="12">12월</option>
            </select>
            <canvas id="salesChart"></canvas>
        </div>
    </div>
    <script src="https://code.jquery.com/jquery-latest.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/chart.js@3.7.1/dist/chart.min.js"></script>
    <script type="text/javascript" src="/resources/js/salesStatus.js"></script>
    <%@ include file="/WEB-INF/views/includes/footer.jsp" %>
