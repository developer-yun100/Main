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
<script type="text/javascript">

function chatPop(){
	window.open("/us/us1013pop.yh", "채팅", "width=650px, height=750px, resizable=no, scrollbars=yes, location=no, left=-30, top=-50");
}

</script>


<body>
	<br />
	<div class="ui text container">
		<div class="ui one column grid">
		<div class="column">
			<h3 class="ui header">
				친구목록
			</h3>
		</div>
			<div class="column">
				<table class="ui celled table">
					<thead>
						<tr>
							<th>방 이름</th>
							<th>관리자 쪽지</th>
							<th>채팅하기</th>
						</tr>
					</thead>
					<tbody>
						<tr>
							<td data-label="Name">오픈 채팅</td>
							<td data-label="Age" style="cursor:pointer; color:#5882FA;" onClick="alert('준비중 입니다.');">쪽지</td>
							<td data-label="Age" style="cursor:pointer; color:#5882FA;" onClick="chatPop();">접속</td>
						</tr>
					</tbody>
				</table>
			</div>
		</div>

	</div>

</body>
</html>