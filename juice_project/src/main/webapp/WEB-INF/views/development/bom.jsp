<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%@ include file="/WEB-INF/views/includes/header.jsp" %>
        <link rel="stylesheet" href="/resources/css/bom.css"/>

    <div id="box">
       <h1> Bom </h1>
        <div id="innerbox">
            <div id="updateBom">

                <div id="selectProductDiv">
                    <select id="selectProduct"></select>
                    <input id="updateBomBtn" type="submit" value="등록">
                </div>

                <div id="selectMaterial">
                    <div id="selectMaterial_thead">
                        <table>
                            <tr>
                                <th id="check"></th>
                                <th id="num">번호</th>
                                <th id="name">자재명</th>
                                <th id="content">수량</th>
                            </tr>
                        </table>
                    </div>
                    <div id="selectMaterial_tbody">
                        <table>
                        </table>
                    </div>
                </div>
            </div>

            <div id="selectBom">
                <div id="selectBom_thead">
                    <table>
                        <tr>
                            <th>상품명</th>
                            <th>TURN</th>
                            <th>자재명</th>
                            <th>수량</th>
                        </tr>
                    </table>
                </div>
                <div id="selectBom_tbody">
                    <table>
                    </table>
                </div>
            </div>
        </div>
    </div>
    <script src="https://code.jquery.com/jquery-latest.min.js"></script>
    <script type="text/javascript" src="/resources/js/bom.js"></script>
    <%@ include file="/WEB-INF/views/includes/footer.jsp" %>
