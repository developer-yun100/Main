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
	var jsonData ={};
    jsonData["form"] = $('form[name="pageForm"]').serializeObject();
    searchDataDetail(jsonData, "/bo/searchDetail.act");
});

function searchTitle(){
    var searchtitle = $("#searchtitlev").val();
	$("#title").val(searchtitle);
	
	var jsonData ={};
    jsonData["form"] = $('form[name="pageForm"]').serializeObject();
    searchDataDetail(jsonData, "/bo/searchDetail.act");
	
}

function pageNumbers(param){
	$("#rownum").val(param);
	var jsonData ={};
    jsonData["form"] = $('form[name="pageForm"]').serializeObject();
    searchDataDetail(jsonData, "/bo/searchDetail.act");
}


function contentDetail(param){
	location.href="/bo/bo1012.yh?chDeId="+param;
}

function contentPush(param){
	location.href="/bo/bo1013.yh?chId="+param;
}

function subScribe(){
	
	var jsonData ={};
    jsonData["form"] = $('form[name="pageForm"]').serializeObject();
	
    $.ajax({
		url : '/bo/subScribe.act',
		type : "post",
		async : true,
		dataType : 'json',
		contentType : "application/json; charset=UTF-8",
		data : JSON.stringify(jsonData),
		success : function(response) {
			var result = JSON.parse(response.data);
			if(result.data == 0000){
				alert("해당 채널을 구독하였습니다.");
				location.reload();
			} else {
				alert("일시적인 장애로 인한 처리불가");
			}
			
			
		},
		error : function(request, status, error) {
			console.log("일시적인 장애로 인한 처리불가");
		}
	});
	
}

function subScribeCancel(){
	var jsonData ={};
    jsonData["form"] = $('form[name="pageForm"]').serializeObject();
    
    $.ajax({
		url : '/bo/subScribeCancel.act',
		type : "post",
		async : true,
		dataType : 'json',
		contentType : "application/json; charset=UTF-8",
		data : JSON.stringify(jsonData),
		success : function(response) {
			var result = JSON.parse(response.data);
			if(result.data == 0000){
				alert("해당 채널을 구독 취소 하였습니다.");
				location.reload();
			} else {
				alert("일시적인 장애로 인한 처리불가");
			}
		},
		error : function(request, status, error) {
			console.log("일시적인 장애로 인한 처리불가");
		}
	});
}

</script>
<title>채널 상세</title>
</head>
<body>
<form name="pageForm">
	<input type="hidden" id="deComment" name="deComment" />
	<input type="hidden" id="rownum" name="rownum" />
	<input type="hidden" id="title" name="title" />
	<input type="hidden" id="chId" name="chId" value="${channelHeader.chId}" />
	<input type="hidden" id="userId" name="userId" value="${sessionScope.S_USERINFO.userId}"/>
	<input type="hidden" id="chName" name="chName" value="${channelHeader.chName}" />
</form>

	
	<jsp:include page="/common/pageInclude/mainMenu.jsp" flush="false"/>
	
	<div class="pusher">
		<jsp:include page="/common/pageInclude/mainUpPage.jsp" flush="false"/>
		
			<div class="ui text container">
			<h3>게시글 검색</h3>
			<div class="ui inverted segment">
			<div class="ui action input">
				<input type="text" id="searchtitlev" />
				<button class="ui icon button">
					<i class="search icon" onclick="searchTitle();"></i>
				</button>
				&nbsp;&nbsp;&nbsp;&nbsp;
				<button class="ui inverted red button" onclick="contentPush('${channelHeader.chId}');">글쓰기</button>
				&nbsp;&nbsp;&nbsp;&nbsp;
				<c:if test="${subScrYn.subScrYn eq 'N'}">
					<button class="ui inverted blue button" onclick="subScribe();">구독</button>
				</c:if>
				<c:if test="${subScrYn.subScrYn eq 'Y'}">
					<button class="ui inverted red button" onclick="subScribeCancel();">구독취소</button>
				</c:if>
				</div>
			</div>
			<h3>${channelHeader.chName} 채널</h3>
			<table class="ui selectable inverted table" id="tableDataDe">
				<thead>
					<tr>
						<th>No</th>
						<th>채널</th>
						<th>제목</th>
						<th>작성자</th>
						<th>작성일</th>
						<th class="right aligned">조회수</th>
					</tr>
				</thead>
				<tbody>
					
				</tbody>
			</table>
			<div class="ui borderless menu">
				<a class="item" onclick="pageNumbers('1');">1</a> 
				<a class="item" onclick="pageNumbers('2');">2</a> 
				<a class="item">3</a> 
				<a class="item">4</a> 
				<a class="item">5</a> 
				<a class="item active">6</a>
			</div>
		</div>
		
		<jsp:include page="/common/pageInclude/mainDownPage.jsp" flush="false"/>
	</div>
</body>
</html>