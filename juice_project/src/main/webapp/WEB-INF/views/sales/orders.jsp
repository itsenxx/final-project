<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ include file="/WEB-INF/views/includes/header.jsp" %>
<link rel="stylesheet" href="/resources/css/sales.css" />
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<script src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.9.3/Chart.min.js"></script>
<script src="https://code.jquery.com/jquery-latest.min.js"></script>

<script>
    $(document).ready(function() {
        $('#datatablesSimple').on('click', 'tr',function(){
            var orderId = $(this).find('td:first').text();
            console.log(orderId);
            var isDetailShown = $(this).hasClass('showingDetails');
            console.log(isDetailShown);
            toggleOrderDetails(orderId, this, isDetailShown);

            var imgIcon = $(this).find('img.icon');
            if (imgIcon.attr('src') === '/resources/css/images/caret-right-fill.svg') {
                imgIcon.attr('src', '/resources/css/images/caret-down-fill.svg');
            } else {
                imgIcon.attr('src', '/resources/css/images/caret-right-fill.svg');
            }
        });

        $('#datatablesSimple').on('click', '#sendOrder', function() {
            var orderId = $(this).closest('tr').data('order-id');
            console.log("셋오더",orderId);


            $.ajax({
                url: '/sales/orderUpdate',
                type: 'POST',
                contentType: 'application/json',
                data: JSON.stringify({ orderId: orderId }),
                success: function(response) {
                    console.log("쿼리가 업데이트되었습니다.");
                    alert(orderId + "발주 처리되었습니다.");
                    location.reload();
                },
                error: function(xhr, status, error) {
                    console.error("오류가 발생했습니다:", error);

                }
            });

        });

    });

    function toggleOrderDetails(orderId, button, isDetailShown) {
        var clickedRow = $(button);

        if(isDetailShown) {
            $(clickedRow).removeClass('showingDetails');
            var detailsRow = $('tr[data-order-id="' + orderId + '"]');
            detailsRow.remove(); // 주문 세부 정보 제거

            var additionalButtonsRow = $('tr.additional-buttons[data-order-id="' + orderId + '"]');
            additionalButtonsRow.remove(); // 해당 주문 ID를 가진 버튼 행 제거
            return;
        }

        $.ajax({
            url: '/sales/detailOrder',
            type: 'get',
            data: {orderId: orderId},
            success: function(response) {
                var detailsRow = '';
                var totalQuantity = 0; // 상품 수량의 합계를 저장할 변수
                var status = 0;        // 주문 상태 변수

                $.each(response, function(index, detail) {
                    console.log(detail);
                    totalQuantity += parseInt(detail.prodQuan);
                    status = detail.orderStatus;
                    sendDate = detail.saleDate;

                    detailsRow += '<tr data-order-id="' + orderId + '" class="orderRow">' +
                                      '<td style="text-align:right"> 상품명 </td>' +
                                      '<td style="text-align:right">' + detail.prodName + '</td>' +
                                      '<td style="text-align:right">'+ detail.prodQuan + 'EA</td>' +
                                      '<td></td>' +
                                  '</tr>';


                });
                clickedRow.after(detailsRow);
                $(clickedRow).addClass('showingDetails');

                if(status == 1) {
                    var buttonsRow = '<tr class="additional-buttons" data-order-id="' + orderId + '">' +
                                         '<td colspan="3" style="text-align:right">합계 수량 ' + totalQuantity +'EA</td>' +
                                         '<td>' +
                                             '<input class="but1" id="sendOrder" type="button" value="요청처리" onclick="">' +
                                             '<input class="but1" id="cancelOrder" type="button" value="주문취소">' +
                                         '</td>' +
                                     '</tr>';
                } else if(status == 2) {
                     var buttonsRow = '<tr class="additional-buttons" data-order-id="' + orderId + '">' +
                                          '<td colspan="3" style="text-align:right">합계 수량 ' + totalQuantity +'EA</td>' +
                                          '<td>' +
                                              '처리일자: ' + sendDate +
                                          '</td>' +
                                      '</tr>';
                    } else {
                  var buttonsRow = '<tr class="additional-buttons" data-order-id="' + orderId + '">' +
                                       '<td colspan="3" style="text-align:right">합계 수량 ' + totalQuantity +'EA</td>' +
                                       '<td>' +
                                           '처리일자: ' + sendDate +
                                       '</td>' +
                                   '</tr>';
                    }


                clickedRow.after(buttonsRow);

            },
            error: function(xhr, status, er) {
                console.log(er);
            }
        });
    }
</script>

<div id="box">
    <div id="innerbox">
    <h1>주문확인</h1>
        <!-- 여기 안에 작성 -->

        <table id="datatablesSimple">
            <thead>
                <tr>
                    <th>주문번호</th>
                    <th>고객명</th>
                    <th>주문일자</th>
                    <th>주문상태</th>

                </tr>
            </thead>

            <tbody>
                <c:set var="prevOrderId" value="" />
                <c:forEach items="${orders}" var="order">
                    <c:if test="${order.orderId ne prevOrderId}">
                        <tr class="detailOrder">
                            <td><img class="icon" src="/resources/css/images/caret-right-fill.svg" alt="arrow">${order.orderId}</td>
                            <td>${order.custName}</td>
                            <td>${order.orderDate}</td>
                            <td>
                                <c:choose>
                                    <c:when test="${order.orderStatus eq 1}">
                                        발주 대기
                                    </c:when>
                                    <c:when test="${order.orderStatus eq 2}">
                                        발주 완료
                                    </c:when>
                                    <c:when test="${order.orderStatus eq 3}">
                                        주문 취소
                                    </c:when>
                                </c:choose>
                            </td>
                        </tr>
                        <c:set var="prevOrderId" value="${order.orderId}" />
                    </c:if>
                </c:forEach>
            </tbody>
        </table>

    </div>
</div>


<%@ include file="/WEB-INF/views/includes/footer.jsp" %>