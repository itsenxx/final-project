<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%@ include file="/WEB-INF/views/includes/header.jsp" %>
    <link rel="stylesheet" href="/resources/css/myPage.css"/>

        <div class="materialContainer">
            <div id="box">
                <div id="innerbox">
                    <div id="title">
                        <h1>My Page</h1>
                    </div>
                    <div id="MyPage">
                        <div id="empName">
                            <h3>이름: ${empName}</h3>
                        </div>
                        <div id="empId">
                            <h3>아이디: ${empId}</h3>
                        </div>
                        <div id="password">
                            <h3>비밀번호: ${password}</h3>
                        </div>
                        <form action="changePassword" method="post">
                            <div id="newPasswordDiv">
                                <div class="input-group">
                                    <input type="hidden" name="empId" value="${empId}">
                                    <h3>새 비밀번호:</h3>
                                    <input type="text" id="newPassword" name="newPassword" required>
                                </div>
                                <div class="button-group">
                                    <input type="submit" value="비밀번호 변경">
                                </div>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
        </div>
  <%@ include file="/WEB-INF/views/includes/footer.jsp"%>



