<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>메인</title>
</head>
<body>
    <a href='/home/home'>main</a>
    <c:if test="${not empty employee}">
        <p>사원번호: ${employee.empId}</p>
        <p>이름: ${employee.empName}</p>
        <p>전화번호: ${employee.phone}</p>
        <p>주소: ${employee.address}<p>
        <p>Email: ${employee.email}</p>
        <p>직급: ${employee.position}</p>
    </c:if>
    <a href="/home/logout">Logout</a>
    <a href="/personnel/employee">직원 관리</a>
</body>
</html>
