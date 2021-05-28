<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c"         uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form"      uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring"    uri="http://www.springframework.org/tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>
	<jsp:include page="/common/include.jsp" flush="false"/>
<title></title>
</head>
<body>
<br />
<br />
	<!-- 하단 알림   -->
	<div class="ui inverted vertical footer segment">
		<div class="ui container">
			<div class="ui stackable inverted divided equal height stackable grid">
				<div class="three wide column">
					<h4 class="ui inverted header">서비스 알림</h4>
					<div class="ui inverted link list">
						<a href="#" class="item">Company CEO</a>
						<a href="#" class="item">Developer</a>
						<a href="#" class="item">Service Event</a>
						<a href="#" class="item">Plans</a>
					</div>
				</div>
				<div class="three wide column">
					<h4 class="ui inverted header">광고문의</h4>
					<div class="ui inverted link list">
						<a href="#" class="item">광고주 문의</a>
						<a href="#" class="item">광고 이벤트 개설</a>
						<a href="#" class="item">부적절 광고 신고</a>
					</div>
				</div>
				<div class="seven wide column">
					<h4 class="ui inverted header">오시는길</h4>
					<p>서울특별시 서초구 서초동 강남대로 381 두산베어스텔 2021호 Team 'YH' Company</p>
				</div>
			</div>
		</div>
	</div>
	<!-- 하단 알림  -->
</body>
</html>