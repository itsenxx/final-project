<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

    <%@ include file="/WEB-INF/views/includes/header.jsp" %>
<link rel="stylesheet" href="/resources/css/material.css"/>

    <div id="box">
        <h1>자재관리</h1>
        <div id="innerbox">
            <div id="registration">
                <table>
                    <tr>
                        <th>자재명</th>
                        <th>규격</th>
                        <th></th>
                    </tr>
                    <tr>
                        <td>
                            <input type="text" id="insertMaterName" placeholder="자재명">
                        </td>
                        <td>
                            <input type="text" id="insertUnit" placeholder="규격">
                        </td>
                        <td>
                            <input type="submit" id="insertMaterial" value="등록" disabled='disabled'>
                        </td>
                    </tr>
                </table>
            </div>
        </div>

        <div id="purchase">
            <table>
                <tr>
                    <th>자재명</th>
                    <th>개수</th>
                    <th>거래처</th>
                    <th></th>
                </tr>
                <tr>
                    <td>
                        <select id="selectMaterial">
                        </select>
                    </td>
                    <td>
                        <input type="number" id="quantity" placeholder="개수">
                    </td>
                    <td>
                        <select id="selectSuppliers">
                        </select>
                    </td>
                    <td>
                        <input type="submit" id="insertBuy" placeholder="구매">
                    </td>
                </tr>
            </table>
        </div>

        <div id="manager">
            <div id="manager_thead">
                <table>
                    <tr>
                        <th class="materId1" >자재번호</th>
                        <th class="materName1">자재명</th>
                        <th class="inventory1">재고</th>
                        <th class="buttonClass1">관리</th>
                    </tr>
                </table>
            </div>
        </div>

        <div id="manager_tbody">
            <table>
            </table>
        </div>
    </div>

<script src="https://code.jquery.com/jquery-latest.min.js"></script>
<script type="text/javascript" src="/resources/js/material.js"></script>
<%@ include file="/WEB-INF/views/includes/footer.jsp" %>
