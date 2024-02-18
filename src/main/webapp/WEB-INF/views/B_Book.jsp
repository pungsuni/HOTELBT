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
<link rel="shortcut icon" href="resources/img/fav.png">
<!-- Author Meta -->
<meta name="author" content="colorlib">
<!-- Meta Description -->
<meta name="description" content="">
<!-- Meta Keyword -->
<meta name="keywords" content="">
<!-- meta character set -->
<meta charset="UTF-8">
<!-- Site Title -->
<title>Spring_예약하기</title>

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
	<c:if test="${empty sessionScope.loginId}">
		<script>
			alert('로그인 후 사용가능!');
			location.href = "M_loginForm";
		</script>
	</c:if>

	<!-- Start Header Area -->
	<header class="default-header">
		<nav class="navbar navbar-expand-lg navbar-light">
			<div class="container">
				<a class="navbar-brand" href="indexForm" style="color:white"> 
				ICIA Hotel
				</a>
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
					<h1 class="text-white">객실예약</h1>
					<p>If you want to reserve a room, please fill out the part
						below.</p>
				</div>
			</div>
		</div>
	</section>
	<!-- End top-section Area -->

	<!-- Start Align Area -->
	<section class="whole-wrap">
		<div class="container">
			<div class="section-top-border">
				<div class="row">
					<div class="col-lg-8 col-md-8">
						<h3 class="mb-30">객실 예약</h3>
						<form action="B_book" method="POST" enctype="multipart/form-data">
							<!-- <div class="mt-10">
								<input type="text" name="first_name" placeholder="객실번호"
									onfocus="this.placeholder = '번호를 입력해주세요'"
									onblur="this.placeholder = '객실번호'" required
									class="single-input">
							</div> -->
							<div class="mt-10 single-input">
								<td>고객 아이디: ${sessionScope.loginId}<input type="hidden"
									name="BId" value="${sessionScope.loginId}"></td>
							</div>
							<div class="mt-10 single-input">
								<a>입실일 : <input type="date" id="date1" onchange="cc()"></a>
								<a>퇴실일 : <input type="date" id="date2" onchange="dd()"></a>
								<input type="hidden" name="BPeriod" id="BPeriod">
							</div>
							<div class="mt-10 single-input">
								<div class="container">
									<button type="button" class="btn_choose_sent bg_btn_chose_1">
										<input type="radio" name="selectOption1" onchange="aa()"
											value="스탠다드" />스탠다드
									</button>
									<button type="button" class="btn_choose_sent bg_btn_chose_2">
										<input type="radio" name="selectOption1" onchange="aa()"
											value="이그제큐티브" />이그제큐티브
									</button>
									<button type="button" class="btn_choose_sent bg_btn_chose_3">
										<input type="radio" name="selectOption1" onchange="aa()"
											value="스위트" />스위트
									</button>
								</div>
							</div>
							<div class="input-group-icon mt-10 single-input">
								<br />
								<h6 class="mb-30">객실을 선택해주세요.</h6>
								<div class="icon">
									<i class="fa fa-globe" aria-hidden="true"></i>
								</div>
								<div id="resultOutput">

									<div class="form-select" id="default-select2">
										<select name="selectOption1">
											<option value="option1">----------------------</option>
										</select>
									</div>
								</div>
							</div>


							<div class="input-group-icon mt-10 single-input">
								<div class="icon">
									<i class="fa fa-thumb-tack" aria-hidden="true"></i>
								</div>
								<br /> <span id="RP">0</span>원 <input type="hidden"
									name="BPrice" id="BPrice" placeholder="price"
									onfocus="this.placeholder = ''"
									onblur="this.placeholder = 'price'" required
									class="single-input" />
							</div>

							<div class="mt-10 single-input">
							<input type="submit" class="genric-btn primary small" value="객실예약" />
								<!-- <a class="genric-btn primary small" input type="submit">객실예약</a>
									<input type="submit" value="객실예약"> -->
							</div>
						</form>
					</div>



				</div>

			</div>
		</div>
		</div>
	</section>

	<script src="resources/js/vendor/jquery-2.2.4.min.js"></script>
	<!-- 이 부분 jquery 버전 문제 roomPrice메소드 -->
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.11.0/umd/popper.min.js"
		integrity="sha384-b/U6ypiBEHpOf/4+1nzFpr53nxSS+GLCkfwBdFNTxtclqqenISfwAzpKaMNFNmj4"
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

	<script>
		function aa() {
			let listVar = $('input[name=selectOption1]:checked').val();

			let output = "";

			/* <div class="form-select" id="default-select2">
					<select name="selectOption1">
						<option value="option1">----------------------</option>
					</select>
				</div> */

			/* if (listVar == "스탠다드") {
				output += "<div class=\"form-select\" id=\"default-select2\">";
				output += "<select name=\"BName\"  onchange=\"bb()\">";
				output += "<option value=\"\">----------------------</option>";
				output += "</select>";
				output += "<div class=\"nice-select\" tabindex=\"0\">";
				output += "<span class=\"current\">----------------------</span>";
				output += "<ul class=\"list\">";
				/* output += "<li data-value=\"\" class=\"option selected\">"; */
			/* output += "<option value=\"\">----------------------</option>";
			output += "<li name=\"BName\" id=\"SO2\" onchange=\"bb()\" data-value=\"디럭스\" class=\"option\">디럭스</li>";
			output += "<li data-value=\"비즈니스 디럭스\" class=\"option\">비즈니스 디럭스</li>"; 
			output += "<li data-value=\"그랜드 코너 디럭스\" class=\"option\">그랜드 코너 디럭스</li>";
			output += "</ul>"; 
			output +="</div>";
			output += "<input type=\"hidden\" value=\"스탠다드\" id=\"SO1\">";*/

			if (listVar == "스탠다드") {
				output += "<select name=\"BName\" id=\"SO2\" onchange=\"bb()\">";
				output += "<option value=\"\">----------------------</option>";
				output += "<option value=\"디럭스\">디럭스</option>";
				output += "<option value=\"비즈니스 디럭스\">비즈니스 디럭스</option>"; //오류
				output += "<option value=\"그랜드 코너 디럭스\">그랜드 코너 디럭스</option>";
				output += "</select>";
				output += "<input type=\"hidden\" value=\"스탠다드\" id=\"SO1\">";

			} else if (listVar == "이그제큐티브") {
				output += "<select name=\"BName\" id=\"SO2\" onchange=\"bb()\">";
				output += "<option value=\"\">----------------------</option>";
				output += "<option value=\"이그제큐티브 비즈니스 디럭스\">이그제큐티브 비즈니스 디럭스</option>";//오류수정완료
				output += "<option value=\"이그제큐티브 그랜드 디럭스\">이그제큐티브 그랜드 디럭스</option>";
				output += "</select>";
				output += "<input type=\"hidden\" value=\"이그제큐티브\" id=\"SO1\">";

			} else if (listVar == "스위트") {
				output += "<select name=\"BName\" id=\"SO2\" onchange=\"bb()\">";
				output += "<option value=\"\">----------------------</option>"
				output += "<option value=\"수페리어 스위트\">수페리어 스위트</option>"
				output += "<option value=\"코리안 스위트\">코리안 스위트</option>"
				output += "<option value=\"코너 스위트\">코너 스위트</option>"
				output += "<option value=\"프리미어 스위트\">프리미어 스위트</option>"
				output += "<option value=\"로열 스위트\">로열 스위트</option>"
				output += "<option value=\"신라 스위트\">신라 스위트</option>"
				output += "<option value=\"프레지덴셜 스위트\">프레지덴셜 스위트</option>"
				output += "</select>";
				output += "<input type=\"hidden\" value=\"스위트\" id=\"SO1\">";
			}

			document.getElementById('resultOutput').innerHTML = output;
		}

		/* function onClickOption(e) {
			SO2 = e.currentTarget;
			alert("!!SO2 : " + SO2);
		} */

		function bb() {
			/* alert("bb실행!"); */
			let SO1 = document.getElementById("SO1").value;
			let SO2 = document.getElementById("SO2").value;

			/* let vv = $('.list').attr('value');
			alert("vv : " + vv); */

			/* alert("SO1 : " + SO1);
			alert("SO2 : " + SO2); */
			console.log("SO1 : " + SO1);
			console.log("SO2 : " + SO2);

			let RP = document.getElementById("RP");

			let days = dd();

			$.ajax({
				type : "GET",
				url : "roomPrice",
				data : {
					"SO2" : SO2
				},
				dataType : "text",
				success : function(data) {
					// 성공시
					if (data != null) {
						RP.innerHTML = data * days;
					} else {
						RP.innerHTML = "error!";
					}

					document.getElementById("BPrice").value = data * days;
				},
				error : function() {
					// 실패시
					alert("roomPrice함수 통신실패!");
				}
			});

		}

		let date1;

		function cc() {
			date1 = document.getElementById("date1").value;

		}

		function dd() {

			cc();
			console.log("date1 : " + date1);
			//let date4 = date1;
			//console.log("date4 : " + date4);
			let date2 = document.getElementById("date2").value;
			let date3 = 0;

			if (date1 != "") {
				console.log("date1 : " + date1);
				console.log("date2 : " + date2);

				//let startDate = new Date(date4);
				let startDate = new Date(date1);
				let endDate = new Date(date2);
				date3 = (endDate.getTime() - startDate.getTime())
						/ (1000 * 60 * 60 * 24);

				console.log(date3 + "박");

			} else {
				alert('입실일을 선택해주세요!');
			}
			document.getElementById("BPeriod").value = date3 + "박"
					+ (date3 + 1) + "일";
			return date3;
		}
	</script>


</body>





</html>