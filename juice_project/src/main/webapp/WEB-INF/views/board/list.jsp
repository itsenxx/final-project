<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%@ include file="/WEB-INF/views/includes/header.jsp" %>
    <link rel="stylesheet" href="/resources/css/board.css"/>
    <body>
    <div id="box1">
        <div id="innerbox">
            <div id="title">
                <h1>공지사항</h1>
                <button class="btn btn-secondary" type="button" onClick='location.href="/board/register"'>등록하기</button>
            </div>
            <div id="board">
                <table>
                    <tr bgcolor= 'gray'>
                        <th id="td1">번호</th>
                        <th id="td2">작성자</th>
                        <th id="td3">제목</th>
                        <th id="td4">작성일</th>
                    </tr>
                    <c:forEach var="board" items="${board}">
                        <tr>
                            <td><a href="/board/get?board_id=${board.boardId}">${board.boardId}</a></td>
                            <td>${board.empName}</td>
                            <td>${board.title}</td>
                            <td>${board.boardDate}</td>
                        </tr>
                    </c:forEach>
                </table>
            </div>
            <div id="pagination">
                <a href="?page=1"><<</a>
                <a href="?page=${currentPage - 1}"><</a>
                <c:forEach begin="1" end="10" var="pageNum">
                    <a href="?page=${pageNum}">${pageNum}</a>
                </c:forEach>
                <a href="?page=${currentPage + 1}">></a>
                <a href="?page=${totalPages}">>></a>
            </div>
        </div>
    </div>
<%@ include file="/WEB-INF/views/includes/footer.jsp" %>
<body>