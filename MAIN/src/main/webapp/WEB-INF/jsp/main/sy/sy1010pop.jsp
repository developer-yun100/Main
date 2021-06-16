<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c"      uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form"   uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="ui"     uri="http://egovframework.gov/ctl/ui"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>
	<jsp:include page="/common/include.jsp" flush="false"/>
<script type="text/javascript">
	$(document).ready(function() {
		/* 비밀번호 입력 제한  */
		$("input[name=passWord]").keyup(function(event) {
			if (!(event.keyCode >= 37 && event.keyCode <= 40)) {
				var inputVal = $(this).val();
				$(this).val(inputVal.replace(/[^a-z0-9]/gi, ''));
			}
		});
		
		$("input[name=passWordCheck]").keyup(function(event) {
			if (!(event.keyCode >= 37 && event.keyCode <= 40)) {
				var inputVal = $(this).val();
				$(this).val(inputVal.replace(/[^a-z0-9]/gi, ''));
			}
		});
		
	});
	
function signUp(){
	
	var userId = $("#userIdv").val();
	var email = $("#emailv").val();
	var nickName = $("#nickNamev").val();
	var passWord = $("#passWordv").val();
	var passWordCheck = $("#passWordCheckv").val();
	
	var idCheck = /^[A-Za-z0-9+]*$/;
	
	// 아이디 체크
	if(userId == null || userId == ""){
		alert("아이디를 입력 해 주세요.");
		return false;
	}
	
	if(!idCheck.test(userId)){
		alert("영문 및 숫자만 입력 가능합니다.")
		return false;
	}
	
	// 이메일 체크
	if(email == null || email == ""){
		alert("이메일을 입력 해 주세요.");
		return false;
	}
	
	// 닉네임 체크
	if(nickName == null || nickName == ""){
		alert("닉네임을 입력 해 주세요.");
		return false;
	}
	
	// 패스워드 체크
	if(passWord == null || passWord == ""){
		alert("비밀번호를 입력 해 주세요.");
		return false;
	} else {
		if(passWord != passWordCheck){
			alert("비밀번호와 비밀번호 확인이 다릅니다.");
			return false;
		}
	}
	
	 $("#userId").val(userId);
	 $("#email").val(email);
	 $("#nickName").val(nickName);
	 $("#passWord").val(passWord);
	 
	var jsonData ={};
    jsonData["form"] = $('form[name="pageForm"]').serializeObject();
	
    $.ajax({
		url : '/sy/signUp.act',
		type : "post",
		async : true,
		dataType : 'json',
		contentType : "application/json; charset=UTF-8",
		data : JSON.stringify(jsonData),
		success : function(response) {
			var result = JSON.parse(response.data);
			if(result.data == "0000"){
				alert("회원가입을 축하 합니다.");
				window.close();
			} else if(result.data == "000B"){
				alert("이미 사용중인 아이디 입니다.");
			} else if(result.data == "000C"){
				alert("이미 사용중인 닉네임 입니다.");
			} else {
				alert("정상 처리하지 못했습니다. \n현상이 지속되면 관리자에게 문의 바랍니다.");
			}
			
			/* for (var i = 0; i< result.length; i++) {
			    console.log(result[i]);
			}  */
			
		},
		error : function(request, status, error) {
			console.log("일시적인 장애로 인한 처리불가");
		}
	});
	
	
}

</script>
<title>회원가입</title>
</head>
<body>
<form name="pageForm">
	<input type="hidden" id="userId" name="userId" />
	<input type="hidden" id="email" name="email" />
	<input type="hidden" id="nickName" name="nickName" />
	<input type="hidden" id="passWord" name="passWord" />
</form>
	<br />
	<br />
	<div class="ui text container">
		<form class="ui form" id="viewForm" name="viewForm">
			<div class="field">
				<div class="ui middle aligned center aligned grid">
					<img src="<c:url value='/images/egovframework/indexImage/bleakbelra.png'/>" class="image" style="width:70px; height:70px;" />
					<h2 class="ui teal image header">
						<label>회원가입</label>
					</h2>
				</div>
			</div>
			<br />
			<br />
			
			<div class="field">
				<label>아이디</label> 
				<input type="text" id="userIdv" />
			</div>
			<div class="field">
				<label>이메일</label> 
				<input type="text" id="emailv" />
			</div>
			<div class="field">
				<label>닉네임</label> 
				<input type="text" id="nickNamev" />
			</div>
			<div class="field">
				<label>비밀번호</label> 
				<input type="password" id="passWordv" />
			</div>
			<div class="field">
				<label>비밀번호 확인</label> 
				<input type="password" id="passWordCheckv" />
			</div>
			<div class="field">
				<div class="ui fluid large teal submit button" onclick="signUp();">회원가입</div>
				<div class="ui message">
					지금 바로 가입하여 컨텐츠를 이용 해 보세요!
				</div>
			</div>
			</form>
	</div>
</body>
</html>