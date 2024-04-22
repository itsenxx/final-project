<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%@ include file="/WEB-INF/views/includes/header.jsp" %>
<link rel="stylesheet" href="/resources/css/board.css"/>
    <div id="box">
            <div id="innerbox">
                <div id="title">
                <h1>게시판 등록</h1>
            </div>
            <form action="/board/register" method="post">
            <div id="board">
                <div class="form-group">
                    <h2>제목</h2>
                    <input type="text" class="form-control" id="title" name="title" placeholder="제목">
                </div>
                <div class="form-group">
                    <h2>내용</h2>
                    <textarea rows="10" class="form-control" id="content"  name="content"placeholder="내용"></textarea>
                </div>
                <h2>등록자</h2>
                <div class="form-group">
                <select id="forWho" name="forWho">
                		<option id="forWho" name="forWho" value="1"  style= "text-align:center">직원</option>
                		<option id="forWho" name="forWho" value="2" style= "text-align:center">손님</option>
                </select>
                </div>
                <button type="submit" class="btn btn-primary" type="button">등록하기</button>
            </form>
            <script src="script.js"></script>
            </div>
        </div>


<%@ include file="/WEB-INF/views/includes/footer.jsp" %>