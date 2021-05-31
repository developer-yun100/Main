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

function contentDetail(param){
	location.href="/bo/bo1012.yh?chDeId="+param;
}

function contentPush(param){
	location.href="/bo/bo1013.yh?chId="+param;
}

</script>
<title>채널 상세</title>
</head>
<body>
	
	<jsp:include page="/common/pageInclude/mainUpPage.jsp" flush="false"/>
	
		<div class="ui text container">
		<h3>게시글 검색</h3>
		<div class="ui inverted segment">
		<div class="ui action input">
			<input type="text" id="" name="" placeholder="Search..." />
			<button class="ui icon button">
				<i class="search icon"></i>
			</button>
			&nbsp;&nbsp;&nbsp;&nbsp;
			<button class="ui inverted red button" onClick="contentPush('${channelHeader.chId}');">글쓰기</button>
			&nbsp;&nbsp;&nbsp;&nbsp;
			<button class="ui inverted blue button">구독</button>
			</div>
		</div>
		<h3>${channelHeader.chName} 채널</h3>
		<table class="ui selectable inverted table">
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
				<c:forEach var="dto" items="${channelDetailList}" varStatus="status">
					<tr onclick="contentDetail('${dto.chDeId}');">
						<td>${dto.chDeNo}</td>
						<td>${dto.chName}</td>
						<td>${dto.title}</td>
						<td>${dto.regNickName}</td>
						<td>${dto.regDate}</td>
						<td class="right aligned">${dto.inCheck}</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
	
	<jsp:include page="/common/pageInclude/mainDownPage.jsp" flush="false"/>
	
</body>
</html>