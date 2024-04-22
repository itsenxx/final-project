<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ include file="/WEB-INF/views/includes/header.jsp" %>
<link rel="stylesheet" href="/resources/css/sales.css" />
<script type="text/javascript" src="/resources/js/juso.js"></script>

    <div id="box">
        <div id="innerbox">
        <!--
           고객 관리 페이지, 고객 정보 확인 및 등록
           <p>수정 필요 사항</p>
           <p>*값이 비어있을 때 등록 X</p>
           <p>**수정은 업데이트로 처리</p>
           <p>***수정 눌렀을 때 등록버튼 사라지고, 수정 버튼 나타내기</p>
           <p>****고객 정보에 담당자 정보 입력</p>
        -->
     <caption><h2>고객 등록</h2></caption>
     <form method="post" action="insertCustomer" id="insertForm">
         <div class="container">
            <div class="insert">
                <table>
                        <tr>
                            <td class="col1">고객 ID</td>
                            <td class="col2"><input type="text" name="custId">
                            <input class='but1' type="button" value="중복확인" onclick="check()">
                            </td>
                            <td class="col1">이름</td>
                            <td class="col2">
                            <input type="text" name="custName">
                        </tr>
                        <tr>
                            <td class="col1">비밀번호</td>
                            <td class="col2">
                                <input type="text" name="password">
                               <p>※비밀번호는 <span class="num">숫자(0~9)</span>만 사용해주세요.</p>
                           </td>
                           <td class="col1">주소</td>
                           <td class="col2">
                               <input type="text" id="roadAddrPart1" name="roadAddr" onClick="goPopup();" readonly style="width:250px;" placeholder="검색">
                           </td>
                        </tr>
                       <tr>
                           <td class="col1">전화번호</td>
                           <td class="col2">
                               <input type="text" name="phoneNum">
                           </td>
                           <td class="col1">상세주소</td>
                           <td class="col2">
                           <input type="text" name="detailAddr" id="addrDetail" style="width:250px;">
                       </tr>

                </table>
            </div>

            <div class="create">

                <input class="but3" type="submit" value="등록" onclick="">
                <input class="but3" type="submit" value="수정" onclick="">
            </div>
        </div>
     </form>
              <table id="datatablesSimple">
                    <thead>
                        <tr>
                            <th>고객 ID</th>
                            <th>이름</th>
                            <th>전화번호</th>
                            <th>주소</th>
                            <th>생성일</th>
                            <th>수정일</th>
                            <th></th>
                        </tr>
                    </thead>

                    <tbody>
                        <c:forEach items="${customers}" var="customer">
                        <tr>
                            <td><c:out value="${customer.custId}" /></td>
                            <td><c:out value="${customer.custName}" /></td>
                            <td><c:out value="${customer.phoneNum}" /></td>
                            <td><c:out value="${customer.roadAddr}, ${customer.detailAddr}" /></td>
                            <td><c:out value="${customer.createDate}" /></td>
                            <td><c:out value="${customer.updateDate}" /></td>
                            <td><input class='but1' type="button" value="수정" onclick="setValues('${customer.custId}')"></td>
                        </tr>
                         </c:forEach>
                    </tbody>
                </table>
        </div>
    </div>



<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script>

function setValues(custId) {
    $.ajax({
        url: '/getCustomerInfo',
        type: 'GET',
        data: { custId: custId },
        success: function(response) {
            document.getElementsByName("custId")[0].value = response.custId;
            document.getElementsByName("custName")[0].value = response.custName;
            document.getElementsByName("roadAddr")[0].value = response.roadAddr;
            document.getElementsByName("phoneNum")[0].value = response.phoneNum;
            document.getElementsByName("detailAddr")[0].value = response.detailAddr;

            document.getElementsByName("custId")[0].focus();
        },
        error: function(xhr, status, error) {
            console.error(error);
        }
    });
}

</script>

<%@ include file="/WEB-INF/views/includes/footer.jsp" %>