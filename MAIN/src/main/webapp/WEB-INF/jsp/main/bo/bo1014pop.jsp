<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c"      uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form"   uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="ui"     uri="http://egovframework.gov/ctl/ui"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<jsp:include page="/common/include.jsp" flush="false"/>
<script type="text/javascript">
function channelInsert(){
	var check = $('input[name="check"]:checked').val();
	var chName = $("#chNamev").val();
	var chOp =  $("#chOp").val();
	
	if(chName == null || chName == ""){
		alert("채널 이름을 입력해 주세요.");
		return false;
	}
	
	if(chOp == null || chOp == ""){
		alert("채널 설명을 입력해 주세요.");
		return false;
	}
	
	if(check != "on"){
		alert("채널 개설 약관에 체크 해 주세요.");
		return false;
	}
	
	$("#chName").val(chName);
	
	var jsonData ={};
    jsonData["form"] = $('form[name="pageForm"]').serializeObject();
	
    $.ajax({
		url : '/bo/channelInsert.act',
		type : "post",
		async : true,
		dataType : 'json',
		contentType : "application/json; charset=UTF-8",
		data : JSON.stringify(jsonData),
		success : function(response) {
			var result = JSON.parse(response.data);
			if(result.data == 0000){
				alert("채널이 생성 되었습니다.");
				opener.location.reload();
				window.close();
			} else {
				alert("일시적인 장애로 인한 처리불가");
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
	
<title>채널 개설</title>
</head>
<body>
<form name="pageForm">
	<input type="hidden" id="chName" name="chName" />
	<input type="hidden" id="chOpenName" name="chOpenName" value="${sessionScope.S_USERINFO.userId}" />
</form>	
	<br />
	<br />
	<div class="ui text container">
		<h3>채널 개설</h3>
		<div class="ui inverted segment">
			<div class="ui inverted form">
				<div class="two fields">
					<div class="field">
						<label>채널 이름</label> 
						<input type="text" id="chNamev" />
					</div>
					<div class="field">
						<label>채널 설명</label> 
						<input type="text" id="chOp">
					</div>
				</div>
				<div class="inline field">
					<div class="ui checkbox">
						<input type="checkbox" name="check">
						<label>채널 개설 약관</label>
					</div>
				</div>
				<div class="ui submit button" onclick="channelInsert();">개설</div>
			</div>
		</div>
	</div>

</body>
</html>