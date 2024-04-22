<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%@ include file="/WEB-INF/views/includes/header.jsp" %>
    <link rel="stylesheet" href="/resources/css/personalmanagement.css" />

    <div id="title">
        <h1>인사관리</h1>
    </div>

    <div id="box">
        <div id="innerbox">
            <div id="titles1">
                <table>
                    <tr>
                        <th>사원 번호</th>
                        <th>사원명</th>
                        <th>전화번호</th>
                        <th>주소</th>
                        <th>email</th>
                        <th>부서</th>
                        <th>직급</th>
                        <th>수정</th>
                        <th>저장</th>
                        <th>삭제</th>
                        <th>추가</th>
                    </tr>
                    <tr class="registration">
                        <td class="empId"></td>
                        <td><input type='text1' name='empName' id='empName' placeholder='사원명'></td>
                        <td><input type='text2' name='phone' id='phone' placeholder='전화번호'></td>
                        <td><input type='text3' name='address' id='address' placeholder='주소'></td>
                        <td><input type='text4' name='email' id='email' placeholder='email'></td>
                        <td><input type='text5' name='depId' id='depId' placeholder='부서'></td>
                        <td><input type='text6' name='position' id='position' placeholder='직급'></td>
                        <td class="button1"></td>
                        <td class="button2"></td>
                        <td class="button3"></td>
                        <td><input type='button' id='insertEmployee' value='추가'></td>
                    </tr>
                </table>
            </div>
            <div id="employee_tbody">
                <table>
                </table>
            </div>
        </div>
    </div>

    <script src="https://code.jquery.com/jquery-latest.min.js"></script>
    <script type="text/javascript" src="/resources/js/employee.js"></script>
    <%@ include file="/WEB-INF/views/includes/footer.jsp" %>
