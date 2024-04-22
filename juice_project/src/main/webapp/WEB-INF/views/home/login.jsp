<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>

<html lang="en">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link rel="stylesheet" href="/resources/css/login.css" type="text/css">
    <title>로그인</title>


</head>
<body>


    <section id="sub_content" class="sub10">
        <div class="cont01">
          <div class="login-title black">

          </div>
          <div class="login-cont2">
            <img src="/resources/css/images/loginimg.png" alt="login" class="cols-100">
          </div>
          	<div class="login-cont1 center">
          		<form name="LogFrm" method="post" class="form form-inline" action="/home/login">
          			<div class="cols-100 login-cont1-form">
          				<div class="login-cont1-txt">
          					<input type="text" name="employeeId" id="employeeId" maxlength="20" style="width: 95%;margin-bottom: 3px;" class="form-control hid50" placeholder="아이디" tabindex="" title="아이디" value="">
                            <input type="password" name="password" id="password" maxlength="100" style="width:95%;" class="form-control hid50 mgt5" tabindex="" onkeydown="if(event.keyCode == 13) sendIt();" placeholder="비밀번호" title="비밀번호" value="">
                            <input type='checkbox' id='rememberId' name='rememberId'> 아이디 저장
          				</div>
          				<div class="login-cont1-btn">
          					<input type="submit" value="로그인" class="btn btn-warning bold title1" style="height: 121px;">
          				</div>
          			</div>
          			<input type="hidden" name="secure_code" value="OOXOEGGNNSEUK6L0PN00">
          		</form>
              </a>
          	</div>
          </div>
        </section>



    <script src="https://code.jquery.com/jquery-latest.min.js"></script>
    <script type="text/javascript" src="/resources/js/login.js"></script>
</body>
</html>
