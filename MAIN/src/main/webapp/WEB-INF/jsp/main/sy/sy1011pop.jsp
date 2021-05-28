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
	
function loginCheck(){
	
	var userId = $("#userIdv").val();
	var passWord = $("#passWordv").val();
	
	$("#userId").val(userId);
	$("#passWord").val(passWord);
	
	var jsonData ={};
	jsonData["form"] = $('form[name="pageForm"]').serializeObject();

	$.ajax({
		url : '/sy/loginCheck.act',
		type : "post",
		async : true,
		dataType : 'json',
		contentType : "application/json; charset=UTF-8",
		data : JSON.stringify(jsonData),
		success : function(response) {
			var result = JSON.parse(response.data);
			if(result.data == 0000){
				alert("로그인 되었습니다.");
				opener.location.reload();
				window.close();
			} else {
				alert("로그인 되지 않았습니다.");
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
<title>로그인</title>
</head>
<body>
<form name="pageForm">
	<input type="hidden" id="userId" name="userId" />
	<input type="hidden" id="passWord" name="passWord" />
</form>
	<br />
	<br />
	<div class="ui text container">
		<div class="ui middle aligned center aligned grid">
			<div class="column">
				<h2 class="ui teal image header">
					<img src="<c:url value='/images/egovframework/indexImage/bleakbelra.png'/>" class="image" />
						<div class="content">반갑습니다.</div>
				</h2>
				<form class="ui large form">
					<div class="ui stacked segment">
						<div class="field">
							<div class="ui left icon input">
								<i class="user icon"></i> 
								<input type="text" id="userIdv" placeholder="아이디" />
							</div>
						</div>
						<div class="field">
							<div class="ui left icon input">
								<i class="lock icon"></i> 
								<input type="password" id="passWordv" placeholder="비밀번호" />
							</div>
						</div>
						<div class="ui fluid large teal submit button" onclick="loginCheck();">Login</div>
					</div>
	
					<div class="ui error message"></div>
	
				</form>
	
				<div class="ui message">
					아직도 회원이 아니신가요? <a href="/sy/sy1010.yh">회원가입</a>
				</div>
			</div>
		</div>
	</div>
</body>
</html>