<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>로그인</title>
</head>
<body>
    <h1>로그인</h1>
    <form id='loginForm' method='post' action="/home/login">
        <div>
            <label for='employeeId'>아이디: </label>
            <input type='text' id='employeeId' name='employeeId' value=''>
        </div>
        <div>
            <label for='password'>비밀번호: </label>
            <input type='password' id='password' name='password' value=''>
        </div>
        <div>
            <input type='checkbox' id='rememberId' name='rememberId'> 아이디 저장
        </div>
            <input type="hidden" name="remember-me" value="true">
            <input type='submit' value='로그인'>
    </form>
    <script src="https://code.jquery.com/jquery-latest.min.js"></script>
    <script type="text/javascript" src="/resources/js/login.js"></script>
</body>
</html>
