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

function boPage(param){
	location.href="/bo/bo1011.yh?chId="+param;
}

</script>

<title>채널 구독 목록</title>
</head>
<body>
	
	<jsp:include page="/common/pageInclude/mainMenu.jsp" flush="false"/>
	<div class="pusher">
		<jsp:include page="/common/pageInclude/mainUpPage.jsp" flush="false"/>
		<div class="ui text container">
			<h3>구독 채널</h3>
			<table class="ui selectable inverted table">
				<thead>
					<tr>
						<th style="width:160px;">채널</th>
						<th style="width:100px;">채널 개설자</th>
						<th class="center aligned" style="width:70px;">구독자</th>
						<th style="width:100px;">개설 날짜</th>
						<th style="width:100px;">채널 바로가기</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="dto" items="${scrContentList}" varStatus="status">
						<tr>
							<td style="width:160px;">${dto.chName}</td>
							<td style="width:100px;">${dto.chOpenName}</td>
							<td class="center aligned" style="width:70px;">${dto.chUserCount}</td>
							<td style="width:100px;">${dto.regDate}</td>
							<td style="width:100px; cursor:pointer;" onClick="boPage('${dto.chId}');"><a>${dto.boardClick}</a></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
		<jsp:include page="/common/pageInclude/mainDownPage.jsp" flush="false"/>
	</div>
	
</body>
</html>