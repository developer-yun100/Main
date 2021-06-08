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
	
	<!-- side menu  -->
	<div class="ui vertical inverted sidebar menu left" id="toc" style="">
		<div class="item">
			<div class="ui text container">
			<img src="<c:url value='/images/egovframework/indexImage/bleakbelra.png'/>" style="width:40px; height:60px" />
			 &nbsp;&nbsp;&nbsp;
			<b style="font-size:2.8em; color:#2E9AFE;">MENU</b>
			<c:if test="${not empty sessionScope.S_USERINFO.userId and sessionScope.S_USERINFO.userId ne ''}">
				<h4 style="margin-top: 10px;">로그인 - ${sessionScope.S_USERINFO.nickName} 님</h4>
			</c:if>
			</div>
		</div>
		
		<c:if test="${empty sessionScope.S_USERINFO.userId or sessionScope.S_USERINFO.userId eq ''}">
			<div class="item">
				<div class="header">로그인 필수!!</div>
				<div class="menu">
					<a class="item">로그인 후 사용가능!!</a>
				</div>
			</div>
		</c:if>
		
		<c:if test="${not empty sessionScope.S_USERINFO.userId and sessionScope.S_USERINFO.userId ne ''}">
			<c:if test="${sessionScope.S_USERINFO.authCode eq '00000AHMS'}">
				<!-- 관리자 권한 영역  -->
				<div class="item">
					<div class="header">시스템 관리</div>
					<div class="menu">
						<a class="item" href="/sy/sy2010.yh">사용자 관리</a>
						<a class="item" href="/sy/construct.yh">데이터 관리</a>
						<a class="item" href="/sy/construct.yh">화면 관리</a> 
						<a class="item" href="/sy/construct.yh">화면 권한 관리</a>
					</div>
				</div>
			</c:if>
			
			<!-- 사용자 영역  -->
			<div class="item">
				<div class="header">채널</div>
				<div class="menu">
					<a class="item" href="/bo/bo1010.yh">채널 목록</a>
					<a class="item" href="/sy/construct.yh">채널 구독 목록</a>
					<a class="item" href="/sy/construct.yh">내가 쓴 게시글</a> 
				</div>
			</div>
			
			<div class="item">
				<div class="header">사용자 관리</div>
				<div class="menu">
					<a class="item" href="/sy/construct.yh">계정 설정</a>
					<a class="item" href="/sy/construct.yh">쪽지함</a>
					<a class="item" href="/sy/construct.yh">이벤트</a> 
				</div>
			</div>
			
			<div class="item">
				<div class="header">워크 비즈니스</div>
				<div class="menu">
					<a class="item" href="/sy/construct.yh">비즈니스 관리 생성</a>
					<a class="item" href="/sy/construct.yh">나의 회사는</a>
					<a class="item" href="/sy/construct.yh">메일함</a>
					<a class="item" href="/sy/construct.yh">사내 공지사항</a>
					<a class="item" href="/sy/construct.yh">일정보기</a>
					<a class="item" href="/sy/construct.yh">부재일정</a>
				</div>
			</div>
			
			<div class="item">
				<div class="header">시스템 가이드</div>
				<div class="menu">
					<a class="item" href="/sy/construct.yh">여긴 어디?</a>
					<a class="item" href="/sy/construct.yh">계정 가이드</a>
					<a class="item" href="/sy/construct.yh">채널 가이드</a>
					<a class="item" href="/sy/construct.yh">비즈니스 가이드</a>
					<a class="item" href="/sy/construct.yh">이벤트 가이드</a>
					<a class="item" href="/sy/construct.yh">광고 가이드</a>
				</div>
			</div>
			
		</c:if>
		<!-- 사용자 영역  -->
	</div>
	<!-- side menu -->
	
</body>
</html>