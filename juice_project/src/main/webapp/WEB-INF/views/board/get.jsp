<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ include file="/WEB-INF/views/includes/header.jsp" %>
<link rel="stylesheet" href="/resources/css/board.css"/>
    <div id="box">
        <div id="innerbox">
            <div id="title">
                <h1>게시판 상세조회</h1>
            </div>
                <form action="/board/remove" method="post" id="form1" onSubmit="return false">
                    <div class="form-group">
                        <h2>번호</h2>
                        <input type="text" class="form-control" id="bno" name="boardId" value='<c:out value="${board.boardId}" />' readonly />
                    </div>
                    <div class="form-group">
                        <h2>제목</h2>
                        <input type="text" class="form-control" id="title" name="title" value='<c:out value="${board.title}" />' />
                    </div>
                    <div class="form-group">
                        <h2>내용</h2>
                        <textarea rows="5" class="form-control" id="content"  name="content" /><c:out value="${board.content}" /></textarea>
                    </div>
                    <div class="form-group">
                        <h2>작성번호(1: 직원 2:손님)</h2>
                        <input type="number" class="form-control" id="writer"  name="for_who" value='<c:out value="${board.forWho}" />' readonly />
                    </div>
                    <button class="btn btn-primary" type="button" onClick='javascript: boardModify();'>
                        수정하기
                    </button>
                    <button class="btn btn-info" type="button" onClick='location.href="/board/list"'>
                        목록
                    </button>
                    <button class="btn btn-danger" type="button" onClick='javascript: boardDelete();'>
                        삭제하기
                    </button>
                </form>
            <script src="script.js"></script>
        </div>
    </div>


<script>
    function boardModify() {
        const form1 = document.getElementById('form1');
        form1.action = "/board/modify";

        form1.submit();
    }

    function boardDelete() {
        const form1 = document.getElementById('form1');
        form1.action = "/board/remove";

        form1.submit();
    }
</script>
<%@ include file="/WEB-INF/views/includes/footer.jsp" %>