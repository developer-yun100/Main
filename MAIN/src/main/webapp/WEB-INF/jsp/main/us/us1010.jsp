<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c"      uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form"   uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="ui"     uri="http://egovframework.gov/ctl/ui"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>
	<jsp:include page="/common/include.jsp" flush="false"/>

<style>

.inputfile {
	width: 0.1px;
	height: 0.1px;
	opacity: 0;
	overflow: hidden;
	position: absolute;
	z-index: -1;
}

</style>

<script type="text/javascript">

function proFileChange(){
	
    // 파일 체크
	var fileNameCheck = $("#embedpollfileinput").val().toLowerCase().split('.');
	var fileExten = fileNameCheck[fileNameCheck.length - 1];
    var fileNameArray = ['jpg', 'png', 'jpeg', 'bmp', 'rle', 'dib', 'gif'];
    var fileIsOk = false;
    
    for(var i = 0; i <= fileNameArray.length; i++){
    	if(fileExten == fileNameArray[i]){
    		fileIsOk = true;
    	}
    }
    
    if(!fileIsOk){
    	alert("이미지 파일만 업로드 가능합니다.");
    	return false;
    }
    
    var file = $("#fileForm")[0];
    var formDate = new FormData(file);
    
    
	$.ajax({
		url : '/us/proFileChange.act',
		type : "post",
		async : true,
		enctype: 'multipart/form-data',
		processData : false,
		contentType : false,
		data : formDate,
		success : function(response) {
			var result = JSON.parse(response.data);
			if(result.data == 0000){
				alert("프로필 이미지가 변경 되었습니다.");
				location.reload();
			} else {
				alert("일시적인 장애로 인한 처리불가");
			}
			
			/* for (var i = 0; i< result.length; i++) {
			    console.log(result[i]);
			}  */
			
		},
		error : function(request, status, error) {
			alert("일시적인 장애로 처리 불가.");
			console.log("내부 오류");
		}
	});
}


function message(){
	window.open("/us/us1011.yh", "쪽지목록", op4);
}

function friend(){
	window.open("/us/us1012.yh", "친구목록", op4);
}

</script>
<title>계정 설정</title>
</head>
<body>

	<jsp:include page="/common/pageInclude/mainMenu.jsp" flush="false"/>
	<div class="pusher">
		<jsp:include page="/common/pageInclude/mainUpPage.jsp" flush="false"/>

		<div class="ui text container">
		
			<h3>계정 관리</h3>
			<div class="ui attached message">
				<div class="header">내계정</div>
			</div>
			<form class="ui form attached fluid segment">
				<div class="two fields">
					<div class="field">
						<label>아이디</label> 
						<input type="text" value="${usDto.userId}" readonly />
					</div>
					<div class="field">
						<label>닉네임</label> 
						<input type="text" value="${usDto.nickName}" readonly />
					</div>
				</div>
				<div class="field">
					<label>이메일</label> 
					<input type="text" value="${usDto.email}" readonly />
				</div>
				<button type="button" class="ui blue button" onclick="alert('이메일');">이메일 수정</button>
				<button type="button" class="ui red button" onclick="alert('비번');">비밀번호 변경</button>
			</form>
	
			<!-- 프로필 이미지  -->
			<h3>프로필 이미지</h3>
			<c:if test="${empty usDto.proFileImgUrl or usDto.proFileImgUrl eq ''}">
				<img class="ui medium rounded image" style="width:400px; height:300px;" src="<c:url value='/images/profile/noImage.png'/>" />
			</c:if>
			<c:if test="${not empty usDto.proFileImgUrl and usDto.proFileImgUrl ne ''}">
				<img class="ui medium rounded image" style="width:400px; height:300px;" src="<c:url value='${usDto.proFileImgUrl}'/>" />
			</c:if>
			<br />
			<!-- <input type="file" class="ui primary button" onclick="alert('프로필');" value="프로필 변경" /> -->
				
      		<!-- <input type="file" class="inputfile" onclick="alert('프로필');" value="프로필 변경" /> -->
			<form id ="fileForm" name="fileForm" enctype="multipart/form-data">
				<input type="file" class="inputfile" onchange="proFileChange();" id="embedpollfileinput" name="file" /> 
				<label for="embedpollfileinput" class="ui huge blue reft floated button"> 
					<i class="ui upload icon"></i> 
					프로필 변경
				</label> 
			</form>
			<h3>친구 정보</h3>
			<div class="ui compact menu">
				<a class="item" onclick="message();"> 
					<i class="icon mail"></i> 
					쪽지목록
					<div class="floating ui red label">1</div>
				</a> 
				<a class="item" onclick="friend();"> 
					<i class="icon users"></i> 
					친구목록
					<div class="floating ui teal label">10</div>
				</a>
			</div>
		</div>
		
		<jsp:include page="/common/pageInclude/mainDownPage.jsp" flush="false"/>
		
	</div>
	
</body>
</html>