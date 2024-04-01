<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>직원 인사</title>
</head>
<body>
    <h1>직원 인사</h1>
    <div class="">
        <div class="employee">
            <div class="t_head">
                <table border="1">
                    <tr>
                        <th>사원 번호</th>
                        <th>사원명</th>
                        <th>전화번호</th>
                        <th>주소</th>
                        <th>email</th>
                        <th>부서</th>
                        <th>직책</th>
                        <th>수정</th>
                        <th>삭제</th>
                    </tr>
                </table>
            </div>
            <div class="t_body">
                <table border="1">
                </table>
            </div>
        </div>
    </div>
    <script src="https://code.jquery.com/jquery-latest.min.js"></script>
    <script type="text/javascript" src="/resources/js/employee.js"></script>
</body>
</html>
