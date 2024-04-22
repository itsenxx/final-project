<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%@ include file="/WEB-INF/views/includes/header.jsp" %>
    <link rel="stylesheet" href="/resources/css/product.css"/>
        <div id="title">
            <h1>상품관리</h1>
        </div>

    <div id="box">
        <div id="innerbox">
            <div id="registration">
                <table>
                    <tr>
                        <th>상품명</th>
                        <th>최소생산수량</th>
                        <th>규격</th>
                        <th></th>
                    </tr>
                    <tr>
                        <td>
                            <input type="text" id="insertProdName" placeholder="상품명">
                        </td>
                        <td>
                            <input type="number" id="insertLotSize" placeholder="최소생산수량">
                        </td>
                        <td>
                            <input type="text" id="insertUnit" placeholder="규격">
                        </td>
                        <td>
                            <input type="submit" id="insertProduct" value="등록">
                        </td>
                    </tr>
                </table>
            </div>
            <div id="selectProduct">
                <div id="selectProduct_thead">
                    <table>
                        <tr>
                            <th>상품번호</th>
                            <th>상품명</th>
                            <th>재고</th>
                            <th>최소생산수량</th>
                            <th>관리</th>
                        </tr>
                    </table>
                </div>
                <div id="selectProduct_tbody">
                    <table>
                    </table>
                </div>
            </div>
        </div>
    </div>
    <script src="https://code.jquery.com/jquery-latest.min.js"></script>
    <script type="text/javascript" src="/resources/js/product.js"></script>
    <%@ include file="/WEB-INF/views/includes/footer.jsp" %>
