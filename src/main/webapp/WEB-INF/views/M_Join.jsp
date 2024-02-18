<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Spring_회원가입</title>
</head>
<body>
	<form action="M_join" method="POST" enctype="multipart/form-data"
		id="joinForm">
		<table>
			<caption>회원가입</caption>
			<tr>
				<th>아이디</th>
				<td><input type="text" name="MId" id="MId"
					onkeyup="idOverlap()"></td>
			</tr>
			<tr>
				<td colspan="2"><span id="confirmId"></span></td>
			</tr>
			<tr>
				<th>패스워드</th>
				<td><input type="password" name="MPw" id="MPw"
					onkeyup="pwRegExp()"> <br />
				<span id="pwRegExp"></span></td>
			</tr>
			<tr>
				<th>패스워드 확인</th>
				<td><input type="password" id="checkPw" onkeyup="pwOverlap()">
					<br />
				<span id="confirmPw"></span></td>
			</tr>
			<tr>
				<th>이름</th>
				<td><input type="text" name="MName"></td>
			</tr>

			<tr>
				<th>연락처</th>
				<td><input type="text" name="MPhone"></td>
			</tr>

			<tr>
				<th>이메일</th>
				<td><input type="email" name="MEmail" id="MEmail"> <span
					id="emailConfirmText"><input type="button" value="인증"
						onclick="confirmEmail()"></span></td>
			</tr>

			<tr>
				<td colspan="2"><input type="button" value="가입"
					onclick="mJoin()"></td>
			</tr>

		</table>
	</form>
</body>

<!-- <script type="text/javascript" src="resources/js/jquery3.6.0.js"></script> -->
<script src="https://code.jquery.com/jquery-3.6.0.js"
	integrity="sha256-H+K7U5CnXl1h5ywQfKtSj8PCmoN9aaq30gDh27Xc0jk="
	crossorigin="anonymous"></script>
<script type="text/javascript">

   // 아이디 중복체크
   function idOverlap(){
      let idCheck = document.getElementById("MId").value;
      let confirmId = document.getElementById("confirmId");
      let idPass = false;
      
      $.ajax({
         type : "POST" ,
         url : "A_idoverlap" ,
         data : { "MId" : idCheck } ,
         async : false,
         dataType : "text" ,
         success : function(data){
            // 성공시
            if(data=="OK"){
               confirmId.style.color="#0000ff";
               confirmId.innerHTML = "사용 가능한 아이디";
               idPass = true;
            } else {
               confirmId.style.color="#ff0000";
               confirmId.innerHTML = "사용 불가능한 아이디";
               return false;
            }
         },
         error : function(){
            // 실패시
            alert("idOverlap함수 통신실패");
         }
      });
      
      return idPass;
   }
   
   // 비밀번호 정규식
   function pwRegExp(){
      let MPw = document.getElementById("MPw").value;
      let pwRegExp = document.getElementById("pwRegExp");
      let pwPass = false;
      
      let num = MPw.search(/[0-9]/g);
      let eng = MPw.search(/[a-z]/ig);
      let spe = MPw.search(/[`~!@#$%^&*|\\\'\";:\/?]/gi);
      
      if(MPw.length < 8 || MPw.length > 15){
         pwRegExp.style.color="#ff0000";
         pwRegExp.innerHTML = "8자리 ~ 15자리 이내로 입력해주세요!";
      } else if(MPw.search(/\s/) != -1) {
         pwRegExp.style.color="#ff0000";
         pwRegExp.innerHTML = "비밀번호는 공백 없이 입력해주세요!";
      } else if(num < 0 || eng < 0 || spe < 0) {
         pwRegExp.style.color="#ff0000";
         pwRegExp.innerHTML = "영문, 숫자, 특수문자를 혼합하여 입력해주세요!";
      } else {
         pwRegExp.style.color="#0000ff";
         pwRegExp.innerHTML = "적절한 비밀번호 입니다!";
         pwPass = true;
      }
      
      return pwPass;
      
   }
   
   // 비밀번호 일치여부 확인
   function pwOverlap(){
      let MPw = document.getElementById("MPw").value;
      let pwRegExp = document.getElementById("pwRegExp");
      
      let checkPw = document.getElementById("checkPw").value;
      let confirmPw = document.getElementById("confirmPw");
      
      let pwPass = false;
      
      pwRegExp.innerHTML = "";
      
      if(MPw==checkPw){
         confirmPw.style.color = "#0000ff";
         confirmPw.innerHTML = "비밀번호가 일치합니다!";
         pwPass = true;
      } else {
         confirmPw.style.color = "#ff0000";
         confirmPw.innerHTML = "비밀번호를 확인해주세요!";
      }
      return pwPass;
   }
   
   // 이메일 인증
   function confirmEmail() {
      let MEmail = document.getElementById("MEmail").value;
      let emailConfirmText = document.getElementById("emailConfirmText");
      
      
      $.ajax({
         type : "GET" ,
         url : "A_emailConfirm" ,
         data : {"MEmail" : MEmail} ,
         dataType : "text" ,
         success : function(data){
            alert("입력하신 이메일로 인증번호가 발송됐습니다!");
            emailConfirmText.innerHTML = "<input type='hidden' id='check2' value='" + data + "'>"
                                 + "<br/><input type='text' placeholder='인증번호 입력' id='emailKey'>"
                                 + " <input type='button' value='확인' onclick='keyCheck()'>"
                                 + "<br/><span id='check1'></span>";
         } ,
         error : function(){
            alert("인증번호 발송에 실패했습니다!");
         }
      });
      
   }
   
   
   
   // 인증번호 확인
   function keyCheck(){
      let emailKey = document.getElementById("emailKey").value;
      let check2 = document.getElementById("check2").value;
      let check1 = document.getElementById("check1");
      
      let emailPass = false;
      
      if(emailKey==check2){
    	 check1.style.color = "#0000ff";
    	 check1.innerHTML = "인증번호가 일치합니다.";
         emailPass = true;
      } else {
    	 check1.style.color = "#ff0000";
     	 check1.innerHTML = "인증번호가 일치하지 않습니다.";
      }
      return emailPass;
   }

</script>

<script
	src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
<script>
   
    // 회원가입 버튼
    function mJoin() {
    	console.log("아이디 체크 : " + idOverlap());
    	console.log("비밀번호 체크1 : " + pwRegExp());
    	console.log("비밀번호 체크2 : " + pwOverlap());
    	console.log("이메일 체크 : " + keyCheck());
    	
    	if(!idOverlap()) {
    		alert("아이디 중복체크를 진행해주세요");
    	} else if(!pwRegExp()) {
    		alert("비밀번호를 규칙에 맞게 입력해주세요");
    	} else if(!pwOverlap()) {
    		alert("비밀번호가 일치하지 않습니다");
    	} else if(!keyCheck()) {
    		alert("이메일 인증을 진행해주세요");
    	} else {
    		joinForm.submit();
    	}
    }
</script>

</html>