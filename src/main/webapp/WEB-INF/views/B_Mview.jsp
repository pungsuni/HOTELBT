<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="zxx" class="no-js">

<head>
<!-- Mobile Specific Meta -->
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<!-- Favicon-->
<link rel="shortcut icon" href="img/fav.png">
<!-- Author Meta -->
<meta name="author" content="colorlib">
<!-- Meta Description -->
<meta name="description" content="">
<!-- Meta Keyword -->
<meta name="keywords" content="">
<!-- meta character set -->
<meta charset="UTF-8">
<!-- Site Title -->
<title>Spring_예약상세보기</title>

<link
	href="https://fonts.googleapis.com/css?family=Roboto+Condensed:300,400,700|Roboto:400,500"
	rel="stylesheet">
<!--
			CSS
			============================================= -->
<link rel="stylesheet" href="resources/css/linearicons.css">
<link rel="stylesheet" href="resources/css/font-awesome.min.css">
<link rel="stylesheet" href="resources/css/bootstrap.css">
<link rel="stylesheet" href="resources/css/owl.carousel.css">
<link rel="stylesheet" href="resources/css/magnific-popup.css">
<link rel="stylesheet" href="resources/css/nice-select.css">
<link rel="stylesheet" href="resources/css/main.css">
</head>

<body>

	<!-- Start Header Area -->
	<header class="default-header">
		<nav class="navbar navbar-expand-lg navbar-light">
			<div class="container">
				<a class="navbar-brand" href="index.html"> </a>
				<button class="navbar-toggler" type="button" data-toggle="collapse"
					data-target="#navbarSupportedContent"
					aria-controls="navbarSupportedContent" aria-expanded="false"
					aria-label="Toggle navigation">
					<span class="fa fa-bars"></span>
				</button>

				<div
					class="collapse navbar-collapse justify-content-end align-items-center"
					id="navbarSupportedContent">
					<ul class="navbar-nav">
						<li><a class="active" href="M_logout">로그아웃</a></li>
						<li><a href="R_list">객실</a></li>
						<li><a href="R_around">주변시설소개</a></li>
						<li><a href="B_bookform">예약</a></li>
						<li class="dropdown"><a class="dropdown-toggle" href="#"
							id="navbardrop" data-toggle="dropdown"> Board </a>
							<div class="dropdown-menu">
								<a class="dropdown-item" href="R_notice">공지사항</a> <a
									class="dropdown-item" href="Q_writeForm">문의</a> <a
									class="dropdown-item" href="RV_list">후기목록</a>
							</div></li>
						<li class="dropdown"><a class="dropdown-toggle" href="#"
							id="navbardrop" data-toggle="dropdown"> Mypage </a>
							<div class="dropdown-menu">
								<a class="dropdown-item" href="M_modiform">회원수정</a> <a
									class="dropdown-item" href="B_mlist">예약목록</a> <a
									class="dropdown-item"
									href="M_qlist?QId=${sessionScope.loginId}">문의목록</a>
							</div></li>
					</ul>
				</div>
			</div>
		</nav>
	</header>
	<!-- End Header Area -->

	<!-- Start top-section Area -->
	<section class="banner-area relative">
		<div class="overlay overlay-bg"></div>
		<div class="container">
			<div
				class="row justify-content-between align-items-center text-center banner-content">
				<div class="col-lg-12">
					<h1 class="text-white">예약상세보기</h1>
					<p>This is the reservation detail page.</p>
				</div>
			</div>
		</div>
	</section>
	<!-- End top-section Area -->

	<div class="section-top-border align-items-center text-center">
		<h3 class="mb-30">예약상세보기</h3>
		<div class="progress-table-wrap">
			<div class="progress-table">
				<div class="table-head align-items-center text-center">
					<div class="serial">객실 번호</div>
					<div class="serial">고객 아이디</div>
					<div class="serial">객실명</div>
					<div class="serial">기간</div>
					<div class="serial">가격</div>
				</div>
					<div class="table-row align-items-center text-center">
						<div class="serial">${view.BNo}</div>
						<div class="serial">${view.BId}</div>
						<div class="serial">${view.BName}</div>
						<div class="serial">${view.BPeriod}</div>
						<div class="serial">${view.BPrice}</div>
					</div>
				<c:if test="${view.BId eq sessionScope.loginId}">
					<tr>
						<td colspan="2">
							<a href="#" class="genric-btn success-border circle arrow">수정<span class="lnr lnr-arrow-right" onclick="location.href='B_modiForm?BNo=${view.BNo}&page=${page}'"></span></a>
							<a href="#" class="genric-btn danger-border circle arrow">삭제<span class="lnr lnr-arrow-right" onclick="location.href='B_cancle?BNo=${view.BNo}&page=${page}'"></span></a>
						</td>
					</tr>
				</c:if>

			</div>

		</div>

	</div>
	
	<script src="resources/js/vendor/jquery-2.2.4.min.js"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.11.0/umd/popper.min.js" integrity="sha384-b/U6ypiBEHpOf/4+1nzFpr53nxSS+GLCkfwBdFNTxtclqqenISfwAzpKaMNFNmj4"
	 crossorigin="anonymous"></script>
	<script src="resources/js/vendor/bootstrap.min.js"></script>
	<script src="resources/js/jquery.ajaxchimp.min.js"></script>
	<script src="resources/js/parallax.min.js"></script>
	<script src="resources/js/owl.carousel.min.js"></script>
	<script src="resources/js/isotope.pkgd.min.js"></script>
	<script src="resources/js/jquery.nice-select.min.js"></script>
	<script src="resources/js/jquery.magnific-popup.min.js"></script>
	<script src="resources/js/jquery.sticky.js"></script>
	<script src="resources/js/main.js"></script>
</body>
</html>