<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
    <meta name="description" content="" />
    <meta name="author" content="" />
    <link href="https://cdn.jsdelivr.net/npm/simple-datatables@7.1.2/dist/style.min.css" rel="stylesheet" />
    <link rel="stylesheet" href="/resources/css/styles.css" />
    <script src="https://use.fontawesome.com/releases/v6.3.0/js/all.js" crossorigin="anonymous"></script>
    <script src="/resources/js/scripts.js"></script>
    <script src="https://code.jquery.com/jquery-latest.min.js"></script>
    <title>Hi Life Bridge</title>
</head>
<body class="sb-nav-fixed">
    <nav class="sb-topnav navbar navbar-expand navbar-dark bg-dark">
        <!-- Navbar Brand-->
        <a class="navbar-brand ps-3" href="/board/list"><img src="/resources/css/images/cici.png" alt="logo" style="width:180px; padding-top: 20px;"></a>
        <!-- Navbar Search-->
        <form class="d-none d-md-inline-block form-inline ms-auto me-0 me-md-3 my-2 my-md-0">
            <div class="input-group"></div>
        </form>
        <!-- Navbar-->
        <ul class="navbar-nav ms-auto ms-md-0 me-3 me-lg-4">
            <li class="nav-item dropdown">
                <a class="nav-link dropdown-toggle" id="navbarDropdown" href="#" role="button" data-bs-toggle="dropdown" aria-expanded="false">
                    <c:if test="${not empty sessionScope.empName}">
                        ${sessionScope.empName} <i class="fas fa-user fa-fw"></i>
                    </c:if>
                </a>
                <ul class="dropdown-menu dropdown-menu-end" aria-labelledby="navbarDropdown">
                    <li><a class="dropdown-item" href="/personnel/mypage">My page</a></li>
                    <li><hr class="dropdown-divider" /></li>
                    <li><a class="dropdown-item" href="/home/login">Logout</a></li>
                </ul>
            </li>
        </ul>
    </nav>
    <div id="layoutSidenav">
        <div id="layoutSidenav_nav">
            <nav class="sb-sidenav accordion sb-sidenav-dark" id="sidenavAccordion">
                <div class="sb-sidenav-menu">
                    <div class="nav">
                        <a class="nav-link" href="/board/list">
                           공지사항
                        </a>
                        <c:choose>
                            <c:when test="${sessionScope.dep_id == 500001}">
                                <a class="nav-link collapsed" href="/personnel/personalmanagement" data-bs-toggle="collapse" data-bs-target="#collapsePages" aria-expanded="false" aria-controls="collapsePages">
                                    인사 관리
                                </a>
                                <a class="nav-link collapsed" href="/com/com" data-bs-toggle="collapse" data-bs-target="#collapsePages" aria-expanded="false" aria-controls="collapsePages">
                                    채용 관리
                                </a>
                                <a class="nav-link collapsed" href="/development/salesStatus">
                                    판매 현황
                                </a>
                                <a class="nav-link" href="/inventory/inventory">
                                    재고
                                </a>
                            </c:when>
                            <c:when test="${sessionScope.dep_id == 500002}">
                                <a class="nav-link collapsed" href="/production/instructions" data-bs-toggle="collapse" data-bs-target="#collapsePages" aria-expanded="false" aria-controls="collapsePages">
                                    생산 지시
                                </a>
                                <a class="nav-link collapsed" href="/production/production" data-bs-toggle="collapse" data-bs-target="#collapsePages" aria-expanded="false" aria-controls="collapsePages">
                                    생산 관리
                                </a>
                                <a class="nav-link collapsed" href="/development/salesStatus">
                                    판매 현황
                                </a>
                                <a class="nav-link" href="/inventory/inventory">
                                    재고
                                </a>
                            </c:when>
                            <c:when test="${sessionScope.dep_id == 500003}">
                                <a class="nav-link collapsed" href="/purchase/material" data-bs-toggle="collapse" data-bs-target="#collapsePages" aria-expanded="false" aria-controls="collapsePages">
                                    자재 관리
                                </a>
                                <a class="nav-link collapsed" href="/purchase/supplier" data-bs-toggle="collapse" data-bs-target="#collapsePages" aria-expanded="false" aria-controls="collapsePages">
                                    공급 업체
                                </a>
                                <a class="nav-link collapsed" href="/development/salesStatus">
                                    판매 현황
                                </a>
                                <a class="nav-link" href="/inventory/inventory">
                                    재고
                                </a>
                            </c:when>
                            <c:when test="${sessionScope.dep_id == 500004}">
                                <a class="nav-link collapsed" href="/sales/orders" data-bs-toggle="collapse" data-bs-target="#collapsePages" aria-expanded="false" aria-controls="collapsePages">
                                    주문 관리
                                </a>
                                <a class="nav-link collapsed" href="/sales/management" data-bs-toggle="collapse" data-bs-target="#collapsePages" aria-expanded="false" aria-controls="collapsePages">
                                    고객 관리
                                </a>
                                <a class="nav-link collapsed" href="/development/salesStatus">
                                    판매 현황
                                </a>
                                <a class="nav-link" href="/inventory/inventory">
                                    재고
                                </a>
                            </c:when>
                            <c:when test="${sessionScope.dep_id == 500005}">
                                <a class="nav-link collapsed" href="/development/product">
                                    상품 관리
                                </a>
                                <a class="nav-link collapsed" href="/development/bom" data-bs-toggle="collapse" data-bs-target="#collapsePages" aria-expanded="false" aria-controls="collapsePages">
                                    BOM
                                </a>
                                <a class="nav-link collapsed" href="/development/salesStatus" data-bs-toggle="collapse" data-bs-target="#collapsePages" aria-expanded="false" aria-controls="collapsePages">
                                    판매 현황
                                </a>
                                <a class="nav-link" href="/inventory/inventory">
                                    재고
                                </a>
                            </c:when>
                            <c:when test="${sessionScope.dep_id == 500006}">
                                <a class="nav-link collapsed" href="/personnel/personalmanagement">
                                    인사 관리
                                </a>
                                <a class="nav-link collapsed" href="/com/com">
                                    채용 관리
                                </a>
                                <a class="nav-link collapsed" href="/production/instructions">
                                    생산 지시
                                </a>
                                <a class="nav-link collapsed" href="/production/production">
                                    생산 관리
                                </a>
                                <a class="nav-link collapsed" href="/purchase/material">
                                    자재 관리
                                </a>
                                <a class="nav-link collapsed" href="/purchase/supplier">
                                    공급 업체
                                </a>
                                <a class="nav-link collapsed" href="/sales/orders">
                                    주문 확인
                                </a>
                                <a class="nav-link collapsed" href="/sales/management">
                                    고객 관리
                                </a>
                                <a class="nav-link collapsed" href="/development/product">
                                    상품 관리
                                </a>
                                <a class="nav-link collapsed" href="/development/bom">
                                    BOM
                                </a>
                                <a class="nav-link collapsed" href="/development/salesStatus">
                                    판매 현황
                                </a>
                                <a class="nav-link" href="/inventory/inventory">
                                    재고
                                </a>
                            </c:when>
                        </c:choose>
                    </div>
                </div>
            </nav>
        </div>
        <div id="layoutSidenav_content">
            <main class="main-container">
