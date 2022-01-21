<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
	<title>Insert title here</title>
	<link rel="stylesheet" href="//code.jquery.com/ui/1.13.0/themes/base/jquery-ui.css">
	<!-- date picker-->
  	<script src="https://code.jquery.com/ui/1.13.0/jquery-ui.js"></script>
	<!-- 우편번호-->
	<script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
</head>
<body>
	<div class="body">
		<form class="container signup" action="<%=request.getContextPath()%>/signup" method="post">
			<h1 class="title text-center">회원가입</h1>
			<div class="box" style="height: 100px; border: 1px solid black;">약관내용</div>
			<div class="form-group">
				<div class="form-check-inline">
					<label class="form-check-label">
						<input type="radio" class="form-check-input" name="agree">동의
					</label>
				</div>
			</div>
			<div class="form-group">
				<input type="text" class="form-control" placeholder="아이디" name="me_id" value="${user.me_id}">
				<button id="idCheck" type="button" class="btn btn-outline-success col-12">중복체크</button>
			</div>
			<div class="form-group">
				<input type="password" class="form-control" placeholder="비밀번호" name="me_pw" value="${user.me_pw}">
			</div>
			<div class="form-group">
				<input type="password" class="form-control" placeholder="비밀번호확인" name="me_pw2">
			</div>
			<div class="form-group">
				<input type="text" class="form-control" placeholder="이름" name="me_name" value="${user.me_name}">
			</div>
			<div class="form-group">
				<input type="text" class="form-control" placeholder="생년월일" name="me_birth" id="birth">
			</div>
			<div class="form-group">
				<div class="form-check-inline">
					<label class="form-check-label">
						<input type="radio" class="form-check-input" name="me_gender" value="male">남성
					</label>
				</div>
				<div class="form-check-inline">
					<label class="form-check-label">
						<input type="radio" class="form-check-input" name="me_gender" value="female">여성
					</label>
				</div>
			</div>
			<div class="form-group">
				<div class="form-inline">
					<input type="text" id="postcode" placeholder="우편번호" class="form-control col-6 mb-2">
					<input type="button" onclick="execDaumPostcode()" value="우편번호 찾기" class="form-control col-6 mb-2"><br>		
				</div>
				<input type="text" id="address" placeholder="주소" class="form-control mb-2">
				<input type="text" id="detailAddress" placeholder="상세주소" class="form-control mb-2">
				<input type="hidden" name="me_address">
				<div id="wrap" style="display:none;border:1px solid;width:500px;height:300px;margin:5px 0;position:relative">
					<img src="//t1.daumcdn.net/postcode/resource/images/close.png" id="btnFoldWrap" style="cursor:pointer;position:absolute;right:0px;top:-1px;z-index:1" onclick="foldDaumPostcode()" alt="접기 버튼">
				</div>
			</div>
			<div class="form-group">
				<input type="text" class="form-control" placeholder="전화번호(-를 포함하여 입력하세요.)" name="me_phone">
			</div>
			<button class="btn btn-outline-success col-12">회원가입</button>
		</form>
	</div>
	<script>
	var idCheck = false;
	
	$('#idCheck').click(function(){
		var id = $('[name=me_id]').val();
		$.ajax({
	        async:false,
	        type:'POST',
	        data:{id : id},
	        url:"<%=request.getContextPath()%>/idCheck",
	        success : function(res){
	            console.log(res);
	            if(res == 'ok')
	            	idCheck = true;
	            else 
	            	idCheck = false;
	            //idCheck = res == 'ok' ? true : false;
	            if(idCheck)
	            	alert('사용 가능한 아이디입니다.');
	            else
	            	alert('이미 사용 중인 아이디입니다.')
	        }
	    });
	});
	
	$('[name=id]').change(function() {
		idCheck = false;
	});
	
    $( "#birth" ).datepicker();
	$( "#birth" ).datepicker( "option", "dateFormat", 'yy-mm-dd' );

	// 회원가입 전송
	$('form').submit(function(){
		var agree = $('input[name=agree').is(':checked');
		if(!agree){
			alert('약관동의를 선택하세요. ')
			$('[name=agree]').focus();
			return false; 
		}
		if(idCheck){
			alert('아이디 중복검사를 하세요.')
			return false;
		}
		var address = $('#address').val() + $('#detailAddress').val();
		$('[name=me_address]').val(address);
		return true;
	});

		// 우편번호 찾기 찾기 화면을 넣을 element
    var element_wrap = document.getElementById('wrap');
    function foldDaumPostcode() {
			// iframe을 넣은 element를 안보이게 한다.
			element_wrap.style.display = 'none';
    }
    function execDaumPostcode() {
			// 현재 scroll 위치를 저장해놓는다.
			var currentScroll = Math.max(document.body.scrollTop, document.documentElement.scrollTop);
			new daum.Postcode({
				oncomplete: function(data) {
					// 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분.
					// 각 주소의 노출 규칙에 따라 주소를 조합한다.
					// 내려오는 변수가 값이 없는 경우엔 공백('')값을 가지므로, 이를 참고하여 분기 한다.
					var addr = ''; // 주소 변수
					var extraAddr = ''; // 참고항목 변수
					//사용자가 선택한 주소 타입에 따라 해당 주소 값을 가져온다.
					if (data.userSelectedType === 'R') { // 사용자가 도로명 주소를 선택했을 경우
						addr = data.roadAddress;
					} else { // 사용자가 지번 주소를 선택했을 경우(J)
						addr = data.jibunAddress;
					}
					// 사용자가 선택한 주소가 도로명 타입일때 참고항목을 조합한다.
					if(data.userSelectedType === 'R'){
						// 법정동명이 있을 경우 추가한다. (법정리는 제외)
						// 법정동의 경우 마지막 문자가 "동/로/가"로 끝난다.
						if(data.bname !== '' && /[동|로|가]$/g.test(data.bname)){
							extraAddr += data.bname;
						}
						// 건물명이 있고, 공동주택일 경우 추가한다.
						if(data.buildingName !== '' && data.apartment === 'Y'){
							extraAddr += (extraAddr !== '' ? ', ' + data.buildingName : data.buildingName);
						}
						// 표시할 참고항목이 있을 경우, 괄호까지 추가한 최종 문자열을 만든다.
						if(extraAddr !== ''){
							extraAddr = ' (' + extraAddr + ')';
						}		
					}
					// 우편번호와 주소 정보를 해당 필드에 넣는다.
					document.getElementById('postcode').value = data.zonecode;
					document.getElementById("address").value = addr;
					// 커서를 상세주소 필드로 이동한다.
					document.getElementById("detailAddress").focus();
					// iframe을 넣은 element를 안보이게 한다.
					// (autoClose:false 기능을 이용한다면, 아래 코드를 제거해야 화면에서 사라지지 않는다.)
					element_wrap.style.display = 'none';
					// 우편번호 찾기 화면이 보이기 이전으로 scroll 위치를 되돌린다.
					document.body.scrollTop = currentScroll;
				},
				// 우편번호 찾기 화면 크기가 조정되었을때 실행할 코드를 작성하는 부분. iframe을 넣은 element의 높이값을 조정한다.
				onresize : function(size) {
						element_wrap.style.height = size.height+'px';
				},
				width : '100%',
				height : '100%'
			}).embed(element_wrap);
			// iframe을 넣은 element를 보이게 한다.
			element_wrap.style.display = 'block';
    }
	</script>
</body>
</html>