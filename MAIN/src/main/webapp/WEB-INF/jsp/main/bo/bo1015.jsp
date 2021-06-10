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
						<th>채널</th>
						<th>제목</th>
						<th>아이디</th>
						<th>작성일</th>
						<th class="right aligned">조회수</th>
						<th>게시글</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="dto" items="${scrContentList}" varStatus="status">
						<tr>
							<td style="width:160px;">${dto.chName}</td>
							<td style="width:200px;">${dto.title}</td>
							<td style="width:100px;">${dto.userId}</td>
							<td style="width:120px;">${dto.regDate}</td>
							<td class="right aligned" style="width:80px;">${dto.inCheck}</td>
							<td style="width:100px;">${dto.boardClick}</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
		<jsp:include page="/common/pageInclude/mainDownPage.jsp" flush="false"/>
	</div>
	
</body>
</html>