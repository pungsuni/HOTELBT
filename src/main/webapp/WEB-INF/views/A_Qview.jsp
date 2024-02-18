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
<title>Arclabs Architecture</title>

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
	<c:choose>
		<c:when test="${sessionScope.loginId eq 'admin'}">
			<header class="default-header">
				<nav class="navbar navbar-expand-lg navbar-light">
					<div class="container">
						<a class="navbar-brand" href="indexForm" style="color:white;">
							ICIA Hotel
						</a>
						<button class="navbar-toggler" type="button"
							data-toggle="collapse" data-target="#navbarSupportedContent"
							aria-controls="navbarSupportedContent" aria-expanded="false"
							aria-label="Toggle navigation">
							<span class="fa fa-bars"></span>
						</button>

						<div
							class="collapse navbar-collapse justify-content-end align-items-center"
							id="navbarSupportedContent">
							<ul class="navbar-nav">
								<li><a class="active" href="A_mlist">회원 목록 조회</a></li>
								<li><a href="A_nwriteForm">공지사항 작성</a></li>
								<li><a href="A_qlist">문의 목록 조회</a></li>
								<li><a href="M_logout">로그아웃</a></li>
							</ul>
						</div>
					</div>
				</nav>
			</header>
		</c:when>

		<c:when test="${not empty sessionScope.loginId}">
			<header class="default-header">
				<nav class="navbar navbar-expand-lg navbar-light">
					<div class="container">
						<a class="navbar-brand" href="indexForm" style="color:white;">
							ICIA Hotel
						</a>
						<button class="navbar-toggler" type="button"
							data-toggle="collapse" data-target="#navbarSupportedContent"
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
		</c:when>

		<c:otherwise>
			<header class="default-header">
				<nav class="navbar navbar-expand-lg navbar-light">
					<div class="container">
						<a class="navbar-brand" href="indexForm" style="color:white;">
							ICIA Hotel
						</a>
						<button class="navbar-toggler" type="button"
							data-toggle="collapse" data-target="#navbarSupportedContent"
							aria-controls="navbarSupportedContent" aria-expanded="false"
							aria-label="Toggle navigation">
							<span class="fa fa-bars"></span>
						</button>

						<div
							class="collapse navbar-collapse justify-content-end align-items-center"
							id="navbarSupportedContent">
							<ul class="navbar-nav">
								<li><a class="active" href="M_loginForm">로그인</a></li>
								<li><a href="M_joinForm">회원가입</a></li>
								<li><a href="R_list">객실</a></li>
								<li><a href="R_around">주변시설소개</a></li>
								<li><a href="B_bookform">예약</a></li>
								<li class="dropdown"><a class="dropdown-toggle" href="#"
									id="navbardrop" data-toggle="dropdown"> Blog </a>
									<div class="dropdown-menu">
										<a class="dropdown-item" href="R_notice">공지사항</a> <a
											class="dropdown-item" href="Q_writeForm">문의</a> <a
											class="dropdown-item" href="RV_list">후기목록</a>
									</div></li>

							</ul>
						</div>
					</div>
				</nav>
			</header>
		</c:otherwise>
	</c:choose>
	<!-- Start top-section Area -->
	<section class="banner-area relative">
		<div class="overlay overlay-bg"></div>
		<div class="container">
			<div
				class="row justify-content-between align-items-center text-center banner-content">
				<div class="col-lg-12">
					<h1 class="text-white">HOTEL</h1>
					<p>Days so us evening for herb bearing lesser man female night</p>
				</div>
			</div>
		</div>
	</section>



	<!-- End top-section Area -->
	<!-- Start Align Area -->
	<section class="whole-wrap">
		<div class="container">
			<div class="section-top-border">
				<h3 class="mb-30">관리자_문의내역</h3>
				<div class="progress-table-wrap">
					<div class="progress-table">

						<table>
							<tr>
								<th>　번호</th>
								<td>${view.QNo}</td>
							</tr>
							<tr>
								<th>　ID</th>
								<td>${view.QId}</td>
							</tr>
							<tr>
								<th>　제목</th>
								<td>${view.QTitle}</td>
							</tr>
							<tr>
								<th>　내용</th>
								<td>${view.QContent}</td>
							</tr>
						</table>

						<br />
						<c:if test="${sessionScope.loginId eq 'admin'}">
							<div>
								<textarea rows="10" cols="50" id="CContent"></textarea>
								<button id="cmtBtn" class="genric-btn primary-border small">확인</button>
							</div>
						</c:if>

						<div id="commentArea"></div>

					</div>
				</div>
			</div>
		</div>
	</section>


	<script src="resources/js/vendor/jquery-2.2.4.min.js"></script>
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
</body>


<script type="text/javascript" src="resources/js/jquery3.6.0.js"></script>
<script type="text/javascript">

   $(document).ready(function(){
      let CBNo = ${view.QNo};
      let CWrite = "${sessionScope.loginId}";
      
      $.ajax({
         type : "POST" ,
         url : "C_list" ,
         data : {"CBNo" : CBNo } ,
         dataType : "json",
         success : function(result){
               commentList(result);
         },
         error : function(){
            alert("댓글 리스트 불러오기 실패!");
         }
      });
      
      $("#cmtBtn").click(function(){
    	 let CWriter = '${sessionScope.loginId}';
    	 let CContent = $("#CContent").val();
    	 let CBNo = ${view.QNo};
    	 
    	 $.ajax({
    		 type : "POST" ,
    		 url : "C_write" ,
    		 data : {
    			 "CWriter" : CWriter ,
    			 "CContent" : CContent ,
    			 "CBNo" : CBNo 
    		 } ,
    		 dataType : "json" ,
    		 success : function(result) {
    			 commentList(result);
    			 $("CWriter").val("");
    			 $("CContent").val("");
    		 } ,
    		 error : function() {
    			 alert("문의 답변 실패!");
    		 }
    		 
    	 });
      });
   });
   
   function commentList(result){
      let output = "";
      
      output += "<br/>";
      output += "<table>";
      output += "<tr>";
      output += "<th>　문의 답변 내용</th>";
      output += "</tr>";
      
      for(var i in result){
         output += "<tr>";
         output += "<td>　"+result[i].CContent+"</td>";
         output += "<td><button class='genric-btn primary-border small' onclick='cmtDelete("+result[i].CNo+")' >삭제</button></td>";
         output += "</tr>";
      }
      
      output += "</table>";
      
      $("#commentArea").html(output);
      
   }
   
   
   function cmtDelete(CNo){
	   
	   $.ajax({
		   type : "GET" ,
		   url : "C_delete" ,
		   data : {
			   "CNo" : CNo,
			   "CBNo" : ${view.QNo}
		   },
		   dataType : "json" ,
		   success : function(result){
			   commentList(result);
		   },
		   error : function() {
			   alert("댓글 삭제 실패!");
		   }
		   
	   });
	   
   }

</script>

</html>