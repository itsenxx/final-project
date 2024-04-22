<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>prdInventory</title>
	<link rel="stylesheet" href="/resources/css/production.css" />
</head>
<body>
<%@ include file="/WEB-INF/views/includes/header.jsp" %>
<div id="outer">
	<div class="headerM">
		<p>월별 자재재고현황</p>
	</div>
	<div class="">
  			<table class="titles">
  				<tr>
  				  <th>월별</th>
  					<th>자재 번호</th>
  					<th>자재 이름</th>
  					<th>전월 재고</th>
  					<th>입고 수량</th>
  					<th>출고 수량</th>
  					<th>당월 재고</th>
  				</tr>
  			</table>
		      <table class="contentI">
              <tr>
                  <td>2024-04</td>
                  <td>300001</td>
                  <td>오랜지</td>
                  <td>0</td>
                  <td>10000</td>
                  <td>5000</td>
                  <td>5000</td>
              </tr>
              <tr>
                  <td>2024-04</td>
                  <td>300002</td>
                  <td>포도</td>
                  <td>0</td>
                  <td>10000</td>
                  <td>5000</td>
                  <td>5000</td>
              </tr>
              <tr>
                  <td>2024-04</td>
                  <td>300003</td>
                  <td>토마토</td>
                  <td>0</td>
                  <td>10000</td>
                  <td>5000</td>
                  <td>5000</td>
              </tr>
              <tr>
                  <td>2024-04</td>
                  <td>300004</td>
                  <td>알로에</td>
                  <td>0</td>
                  <td>10000</td>
                  <td>5000</td>
                  <td>5000</td>
              </tr>
              <tr>
                  <td>2024-04</td>
                  <td>300005</td>
                  <td>쌀</td>
                  <td>0</td>
                  <td>10000</td>
                  <td>5000</td>
                  <td>5000</td>
              </tr>
               <tr>
                   <td>2024-04</td>
                   <td>300006</td>
                   <td>비타민C</td>
                   <td>0</td>
                   <td>3000</td>
                   <td>1000</td>
                   <td>2000</td>
               </tr>
              <tr>
                  <td>2024-04</td>
                  <td>300007</td>
                  <td>향료</td>
                  <td>0</td>
                  <td>3000</td>
                  <td>1000</td>
                  <td>2000</td>
              </tr>
              <tr>
                  <td>2024-04</td>
                  <td>300008</td>
                  <td>정제수</td>
                  <td>0</td>
                  <td>3000</td>
                  <td>1000</td>
                  <td>2000</td>
              </tr>
		      </table>
  		</div> <br>
  			<div class="headerM">
      		<p>월별 제품재고현황</p>
      	</div>
  		<div class="">
		      <table class="titles">
		        <tr>
		          <th>월별</th>
		          <th>제품 번호</th>
		          <th>제품 이름</th>
		          <th>전월 재고</th>
		          <th>입고 수량</th>
		          <th>출고 수량</th>
		          <th>당월 재고</th>
		        </tr>
		      </table>
		      <table class="contentI">
              <tr>
                  <td>2024-04</td>
                  <td>100001</td>
                  <td>Ya-!! Orange</td>
                  <td>0</td>
                  <td>10000</td>
                  <td>8000</td>
                  <td>3000</td>
              </tr>
              <tr>
                  <td>2024-04</td>
                  <td>100002</td>
                  <td>Ya-!! Grape</td>
                  <td>0</td>
                  <td>10000</td>
                  <td>8000</td>
                  <td>3000</td>
              </tr>
              <tr>
                  <td>2024-04</td>
                  <td>100003</td>
                  <td>Ya-!! Tomato</td>
                  <td>0</td>
                  <td>10000</td>
                  <td>8000</td>
                  <td>3000</td>
              </tr>
              <tr>
                  <td>2024-04</td>
                  <td>100004</td>
                  <td>Ya-!! Aloe</td>
                  <td>0</td>
                  <td>10000</td>
                  <td>8000</td>
                  <td>3000</td>
              </tr>
              <tr>
                  <td>2024-04</td>
                  <td>100005</td>
                  <td>Ya-!! Morning</td>
                  <td>0</td>
                  <td>10000</td>
                  <td>8000</td>
                  <td>3000</td>
              </tr>
		      </table>
		      </table>
		    </div> <br>
</div>
<%@ include file="/WEB-INF/views/includes/footer.jsp" %>
</body>
</html>