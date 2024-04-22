<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%@ include file="/WEB-INF/views/includes/header.jsp" %>
    <link rel="stylesheet" href="/resources/css/supplier.css"/>

    <div id="box">
    <h1>공급업체</h1>
        <div id="innerbox">
            <div id="registration">
                <table>
                    <tr>
                        <th>업체명</th>
                        <th>전화번호</th>
                        <th>주소</th>
                        <th>이메일</th>
                        <th></th>
                    </tr>
                    <tr>
                        <td>
                            <input type="text" id="insertSuppName" placeholder="업체명">
                        </td>
                        <td>
                            <input type="text" id="insertPhoneNum" placeholder="전화번호">
                        </td>
                        <td>
                            <input type="text" id="insertAddress" placeholder="주소">
                        </td>
                        <td>
                            <input type="text" id="insertEmail" placeholder="이메일">
                        </td>
                        <td>
                            <input type="submit" id="insertSuppliers" value="등록"disabled='disabled'>
                        </td>
                    </tr>
                </table>
            </div>
            <div id="purchase">
                <table>
                    <tr>
                        <th>업체명</th>
                        <th>자재명</th>
                        <th></th>
                    </tr>
                    <tr>
                        <td>
                            <select id="selectSuppliers">
                            </select>
                        </td>
                        <td>
                            <select id="selectMaterial">
                            </select>
                        </td>
                        <td>
                            <input type="submit" id="insertSuppMater" placeholder="등록">
                        </td>
                    </tr>
                </table>
            </div>
            <div id="manager">
                <div id="manager_thead">
                    <table>
                        <tr>
                            <th class="suppId1">업체ID</th>
                            <th class="suppName1">업체명</th>
                            <th class="phoneNum1">전화번호</th>
                            <th class="address1">주소</th>
                            <th class="email1">이메일</th>
                            <th class="selectSupp1">자재명</th>
                            <th class="createDate1">등록일</th>
                            <th class="deleteSuppMater1"></th>
                        </tr>
                    </table>
                </div>
                <div id="manager_tbody">
                    <table>
                    </table>
                </div>
            </div>
        </div>
    </div>
    <script src="https://code.jquery.com/jquery-latest.min.js"></script>
    <script type="text/javascript" src="/resources/js/supplier.js"></script>
    <%@ include file="/WEB-INF/views/includes/footer.jsp" %>
