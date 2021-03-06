<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
	<style>
		.find ul{
			list-style : none; padding : 0; margin : 0;
		}
		.find .box-tabs li{
			border : 1px solid #dee2e6; border-top : none;
			min-height : 300px;
		}
		.spinner-box{
			position : absolute; top : calc(50vh - 16px); 
			left : calc(50vw - 16px); width : 32px; height : 32px;
			display: none;
		}
	</style>
</head>
<body>
	<div class="body find">
		<ul class="nav nav-tabs">
			<li class="nav-item">
			  <a class="nav-link" href="javascript:;" data-target=".idBox">아이디 찾기</a>
			</li>
			<li class="nav-item">
			  <a class="nav-link" href="javascript:;" data-target=".pwBox">비밀번호 찾기</a>
			</li>
		</ul>
		<ul class="box-tabs">
			<li class="idBox">
			  <h1>아이디 찾기</h1>
			  <div class="form-group">
			  	<input type="text" class="form-control" placeholder="이메일" name="me_email">
			  </div>
			  <div class="form-group">
			  	<input type="text" class="form-control" placeholder="이름" name="me_name">
			  </div>
			  <button class="btn btn-outline-success col-12 btn-find-id">찾기</button>
			</li>
			<li class="pwBox">
			  <h1>비밀번호 찾기</h1>
			  <div class="form-group">
			  	<input type="text" class="form-control" placeholder="이메일" name="me_email">
			  </div>
			  <div class="form-group">
			  	<input type="text" class="form-control" placeholder="아이디" name="me_id">
			  </div>
			  <button class="btn btn-outline-success col-12 btn-find-pw">찾기</button>
			</li>
		</ul>
	</div>
	<div class="spinner-box">
		<div class="spinner-border"></div>
	</div>
	<script>
		$('.nav-tabs a').click(function() {
			$('.nav-tabs a').removeClass('active');
			$(this).addClass('active');
			var target = $(this).data('target');
			$('.box-tabs li').hide();
			$(target).show();
		});
		$('.nav-tabs a').first().click();
		//아이디 찾기 클릭
		$('.btn-find-id').click(function() {
			var me_email = $(this).parent().find('[name=me_email]').val();
			var me_name = $(this).parent().find('[name=me_name]').val();
			var member = {
				me_email : me_email,
				me_name : me_name
			}
			$.ajax({
		        async:false,
		        type:'POST',
		        data:JSON.stringify(member),
		        url: '<%=request.getContextPath()%>/member/find/id',
		        contentType:"application/json; charset=UTF-8",
		        success : function(res){
		        	if(res == ''){
		        		alert('일치하는 아이디가 없습니다.');
		        	}else{
		        		alert('회원님의 아이디는 '+res+'입니다.' );
		        	}
		        }
		    });
		});
		//비밀번호 찾기 클릭
		$('.btn-find-pw').click(function() {
			var me_email = $(this).parent().find('[name=me_email]').val();
			var me_id = $(this).parent().find('[name=me_id]').val();
			var member = {
				me_email : me_email,
				me_id : me_id
			}
			$('.spinner-box').show();
			setTimeout(() => {
				$.ajax({
			        async:false,
			        type:'POST',
			        data:JSON.stringify(member),
			        url: '<%=request.getContextPath()%>/member/find/pw',
			        contentType:"application/json; charset=UTF-8",
			        success : function(res){
			        	$('.spinner-box').hide();
			        	if(res == "true"){
							alert('새 비밀번호가 발급 되었습니다. 입력한 메일에서 확인하세요.');
						}else if(res == "false"){
							alert('입력한 정보가 잘못됐습니다.');
						}else if(res == 'error'){
							alert('메일 전송에 실패했습니다. 관리자에게 문의하세요.')
						}
			        }
			    });
			}, 100);
		});
	</script>
</body>
</html>