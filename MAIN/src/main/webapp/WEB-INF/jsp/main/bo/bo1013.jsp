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

$(document).ready(function() {
	
	CKEDITOR.replace('contentArea', {
		width: 670
	   ,height: 500
	   ,filebrowserUploadUrl : "${pageContext.request.contextPath}/bo/fileUpload.act"
	});

});


function insertContent(){
	
	var titlev = $("#titlev").val();
	var contentArea = CKEDITOR.instances.contentArea.getData();
	
	if(titlev == null || titlev == ""){
		alert("제목을 입력 해 주세요.");
		return false;
	}
	
	if(contentArea == null || contentArea == ""){
		alert("게시글을 입력 해 주세요.");
		return false;
	}
	
	$("#title").val(titlev);
	$("#content").val(contentArea);
	
	var chId = $("#chId").val();
	
	var jsonData ={};
    jsonData["form"] = $('form[name="pageForm"]').serializeObject();
	
    $.ajax({
		url : '/bo/contentInsert.act',
		type : "post",
		async : true,
		dataType : 'json',
		contentType : "application/json; charset=UTF-8",
		data : JSON.stringify(jsonData),
		success : function(response) {
			var result = JSON.parse(response.data);
			if(result.data == 0000){
				alert("게시글이 작성 되었습니다.");
				location.href="/bo/bo1011.yh?chId="+chId;
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

	
<title>게시글 작성</title>
</head>
<body>
<form name="pageForm">
	<input type="hidden" id="title" name="title" />
	<input type="hidden" id="content" name="content" />
	<input type="hidden" id="chId" name="chId" value="${channelHeader.chId}" />
	<input type="hidden" id="chName" name="chName" value="${channelHeader.chName}"/>
	<input type="hidden" id="regUserId" name="regUserId" value="${sessionScope.S_USERINFO.userId}" />
	<input type="hidden" id="regNickName" name="regNickName" value="${sessionScope.S_USERINFO.nickName}" />
</form>
	
	<jsp:include page="/common/pageInclude/mainUpPage.jsp" flush="false"/>
	
	<div class="ui text container">
		<h3 class="ui top attached header">게시글 작성 : ${channelHeader.chName} 채널</h3>
		<div class="ui attached segment">
			<div class="ui three column doubling grid container">
				<div class="column">
					<form class="ui form">
						<div class="field">
							<label>제목</label> 
							<input type="text" id="titlev" style="width:650px;" />
						</div>
					</form>
				</div>
			</div>
			<br />
			<textarea class="form-control" id="contentArea" name="contentArea"></textarea>
		</div>
		<br />
		<button class="ui primary button" onclick="insertContent();">작성</button>
		<button class="ui button" onclick="javascript:history.back();">취소</button>
	</div>
	
	
	<jsp:include page="/common/pageInclude/mainDownPage.jsp" flush="false"/>
	
</body>
</html>