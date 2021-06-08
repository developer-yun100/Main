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
	var jsonData ={};
    jsonData["form"] = $('form[name="pageForm"]').serializeObject();
    searchData(jsonData, "/bo/searchTitle.act");
});

function pageLocation(param){
	location.href="/bo/bo1011.yh?chId="+param;
}

function channelInsert(){
	var sessionId = $("#sessionId").val();
	if(sessionId == "00000AHMS"){
		window.open("/bo/bo1014pop.yh", "채널개설", op1);
	} else {
		alert("권한이 없습니다.");
		return false;
	}
}


function searchTitle(){
    var searchtitle = $("#searchtitlev").val();
	$("#chName").val(searchtitle);
	
	var jsonData ={};
    jsonData["form"] = $('form[name="pageForm"]').serializeObject();
    searchData(jsonData, "/bo/searchTitle.act");
	
}

</script>
<title>채널 목록</title>
</head>
<body>
<form name="pageForm">
	<input type="hidden" id="chName" name="chName" />
</form>
	<input type="hidden" id="sessionId" value="${sessionScope.S_USERINFO.authCode}" />
	
	<jsp:include page="/common/pageInclude/mainMenu.jsp" flush="false"/>
	
	<div class="pusher">
		<jsp:include page="/common/pageInclude/mainUpPage.jsp" flush="false"/>
			<div class="ui text container">
				<h3>채널검색</h3>
				<div class="ui inverted segment">
				<div class="ui action input">
					<input type="text" id="searchtitlev" placeholder="Search..." />
					<button class="ui icon button" onclick="searchTitle();">
						<i class="search icon"></i>
					</button>
					<c:if test="${sessionScope.S_USERINFO.authCode eq '00000AHMS'}">
						&nbsp;&nbsp;&nbsp;&nbsp;
						<button class="ui inverted red button" onclick="channelInsert();">채널 개설</button>
					</c:if>
					&nbsp;&nbsp;&nbsp;&nbsp;
					<button class="ui inverted blue button">채널 가이드</button>
					</div>
				</div>
				<h3>채널 목록</h3>
				<table class="ui selectable inverted table" id="tableData">
					<thead>
						<tr>
							<th>개설자</th>
							<th>채널이름</th>
							<th class="right aligned">구독자 수</th>
						</tr>
					</thead>
					<tbody>
					</tbody>
				</table>
			</div>
			
			<br />
			<br />
			<br />
			<br />
			<br />
			<br />
			<br />
			<br />
			<br />
			<br />
			<br />
		<jsp:include page="/common/pageInclude/mainDownPage.jsp" flush="false"/>
	</div>
</body>
</html>