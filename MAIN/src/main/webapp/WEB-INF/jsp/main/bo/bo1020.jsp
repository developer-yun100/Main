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

function contentDetail(param){
	location.href="/bo/bo1012.yh?chDeId="+param;
}

</script>

<title>내가 쓴 게시글</title>
</head>
<body>

	<jsp:include page="/common/pageInclude/mainMenu.jsp" flush="false"/>
	<div class="pusher">
		<jsp:include page="/common/pageInclude/mainUpPage.jsp" flush="false"/>
		<div class="ui text container">
			<h3>내가 쓴 글</h3>
			<table class="ui selectable inverted table">
				<thead>
					<tr>
						<th>채널</th>
						<th>제목</th>
						<th>작성자</th>
						<th>작성일</th>
						<th class="right aligned">조회수</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="dto" items="${contentMyList}" varStatus="status">
						<tr onclick="contentDetail('${dto.chDeId}');">
							<td style="width:300px;">${dto.chName}</td>
							<td style="width:400px;">${dto.title}</td>
							<td style="width:250px;">${dto.regNickName}</td>
							<td style="width:250px;">${dto.regDate}</td>
							<td class="right aligned">${dto.inCheck}</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
		<jsp:include page="/common/pageInclude/mainDownPage.jsp" flush="false"/>
	</div>
	
	
	
</body>
</html>