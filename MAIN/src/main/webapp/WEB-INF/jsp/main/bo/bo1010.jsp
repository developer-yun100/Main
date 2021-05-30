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
	
});

function pageLocation(param){
	location.href="/bo/bo1011.yh?chId="+param;
}


</script>
<title>채널 목록</title>
</head>
<body>

	<jsp:include page="/common/pageInclude/mainUpPage.jsp" flush="false"/>
	<div class="ui text container">
		<h3>채널검색</h3>
		<div class="ui inverted segment">
		<div class="ui action input">
			<input type="text" id="" name="" placeholder="Search..." />
			<button class="ui icon button">
				<i class="search icon"></i>
			</button>
			&nbsp;&nbsp;&nbsp;&nbsp;
			<button class="ui inverted red button">채널 개설</button>
			&nbsp;&nbsp;&nbsp;&nbsp;
			<button class="ui inverted blue button">채널 가이드</button>
			</div>
		</div>
		<h3>채널 목록</h3>
		<table class="ui selectable inverted table">
			<thead>
				<tr>
					<th>개설자</th>
					<th>채널이름</th>
					<th class="right aligned">구독자 수</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="dto" items="${channelList}" varStatus="status">
					<tr onclick="pageLocation('${dto.chId}');">
						<td>${dto.chOpenName}</td>
						<td>${dto.chName}</td>
						<td class="right aligned">${dto.chUserCount}</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>



	<jsp:include page="/common/pageInclude/mainDownPage.jsp" flush="false"/>
	
	
</body>
</html>