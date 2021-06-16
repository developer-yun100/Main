<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c"      uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form"   uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="ui"     uri="http://egovframework.gov/ctl/ui"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>
	<jsp:include page="/common/include.jsp" flush="false"/>
<title>친구 목록</title>
</head>
<body>
	<br />
	<div class="ui text container">
		<div class="ui one column grid">
		<div class="column">
			<h3 class="ui header">
				친구목록
				<div class="sub header">친구들</div>
			</h3>
		</div>
			<div class="column">
				<table class="ui celled table">
					<thead>
						<tr>
							<th>닉네임</th>
							<th>쪽지쓰기</th>
							<th>채팅하기</th>
						</tr>
					</thead>
					<tbody>
						<tr>
							<td data-label="Name">아무개</td>
							<td data-label="Age">쪽지</td>
							<td data-label="Age">채팅</td>
						</tr>
						<tr>
							<td data-label="Name">이쑤시개</td>
							<td data-label="Age">쪽지</td>
							<td data-label="Age">채팅</td>
						</tr>
						<tr>
							<td data-label="Name">시계바늘만처다보는개</td>
							<td data-label="Age">쪽지</td>
							<td data-label="Age">채팅</td>
						</tr>
					</tbody>
				</table>
			</div>
		</div>
	</div>

</body>
</html>