<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c"         uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form"      uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring"    uri="http://www.springframework.org/tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>
<jsp:include page="/common/include.jsp" flush="false"/>
<script type="text/javascript">

$(document).ready(function() {
	
});

function signUp(){

	window.open("/sy/sy1010pop.yh", "회원가입", op1);
	
}

function loginpop(){
	window.open("/sy/sy1011pop.yh", "로그인", op3);
}

</script>
<title>메인</title>
</head>
<body>

<jsp:include page="/common/pageInclude/mainUpPage.jsp" flush="false"/>

<div class="pusher">
	<!-- 중단 소개 글  -->
	<div class="ui vertical stripe segment">
		<div class="ui middle aligned stackable grid container">
			<div class="row">
				<div class="eight wide column">
					<h3 class="ui header">처음 사용하시는 분들께</h3>
					<p>안녕하십니까? 저희는 커뮤니티 기반의 통합 솔루션 CWM 서비스를 지원하고 있는 developer "Team YH"입니다.</p>
					<p>CWM 서비스란, community, work, main의 줄임말로 "공동체에서 가장 중요한 일"이라는 의미로 만들었습니다.</p>
					<p>공동체에서 가장 중요한 것들은 무엇일까요? 바로 소통이라고 생각합니다~</p>
					<p>지금 바로 서비스 신청하세요~ 당신의 하루가 즐겁게 변해갈 것 입니다.</p>
					<h3 class="ui header">직접 만드는 완성형 커뮤니티</h3>
					<p>직접 해당 채널을 개설하여, 당신만의 커뮤니티를 만드십시오! 채널 구독시 해당 채널의 구독자들과 다양한 정보 공유를 진행할 수 있습니다.</p>
					<h3 class="ui header">직접 만드는 워크 비즈니스</h3>
					<p>직접 만드는 회사 업무 협업 도구 메시지, 홈, 캘린더, 주소록, 할 일, 설문, 메일, 드라이브 까지 모두 직접 만들어 서비스를 이용할 수 있습니다.</p>
					<h3 class="ui header">도입 사례</h3>
					<p>@@씨 : 취미 관련 채널을 개설하여, 좀 더 즐겁게 취미를 즐길 수 있게 되었어요!!</p>
					<p>@@회사 : 내가 사용하는 화면을 각각 맞춰, 조정 할 수 있어 금방 금방 익히고 업무 효율까지 증가했습니다. 감사합니다.</p>
				</div>
				<div class="six wide right floated column">
					<img src="<c:url value='/images/egovframework/indexImage/developer.png'/>" class="ui large bordered rounded image" />
				</div>
			</div>
			<div class="row">
				<div class="center aligned column">
					<button class="ui primary button" onclick="test();">
					  MVC 테스트
					</button>
				</div>
			</div>
		</div>
		<br />
		<br />
		<h3>&nbsp;&nbsp;커뮤니티 채널 알림</h3>
	</div>
	<!-- 중단 소개 글  -->
	<br />
	<br />

	<!-- 중단 채널 소개 글  -->
	<div class="ui vertical stripe quote segment">
		<div class="ui equal width stackable internally celled grid">
			<div class="center aligned row">
				<div class="column">
					<h3>메이플스토리 다시 살려내라 -_- </h3>
					<p>
						<img src="<c:url value=''/>" class="ui avatar image" /> 
						<b>메이플스토리 관리자 </b> 메이플스토리를 즐기는 여러분이 주인공 ㅎㅎ
					</p>
				</div>
				<div class="column">
					<h3>주튜브TV 채널 구독자 100만명 달성!!</h3>
					<p>
						<img src="<c:url value=''/>" class="ui avatar image" /> 
						<b>주튜브TV </b> 도움을 주신 여러분들 정말 감사합니다!~
					</p>
				</div>
			</div>
		</div>
	</div>
	<!-- 중단 채널 소개 글  -->
	<br />
	<br />

	<!-- 중단 채널 홍보 글  -->
	<div class="ui vertical stripe segment">
		<div class="ui text container">
			<h3 class="ui header">카운터사이드 채널</h3>
			<div id="player"></div>
			<p>
				갓겜 카운터사이드 미래의 사장님들을 모십니다.
				커뮤니티, 이벤트 정보, 공략, 가이드를 한번에 보고싶다고?! 
				그러면 바로!! 채널 구독!! 카운터사이드!!
			</p>
			<img class="ui avatar image" src="<c:url value=''/>" />
		    <span><b>뚜뚜와</b></span>
			
			<h4 class="ui horizontal header divider"> </h4> <!-- 라인 만들까 말까 -->
			
			<h3 class="ui header">유니티 게임 채널</h3>
			<p>
				유니티 개발 커뮤니티 당신을 초대합니다.
				개발 정보 공유 및 API, Script 가이드 라인 많습니다.
				많은 관심 부탁드려요 ㅎㅎ
			</p>
			<img class="ui avatar image" src="<c:url value=''/>" />
		    <span><b>빨간코</b></span>
		    
		    <h4 class="ui horizontal header divider"> </h4> <!-- 라인 만들까 말까 -->
		    
		    <h3 class="ui header">주튜브TV 채널</h3>
			<p>
				각종 게임 공략 및 메이플 블래스터 집중 케어
				가끔 음악 방송도 진행 합니다~~
			</p>
			<img class="ui avatar image" src="<c:url value=''/>" />
		    <span><b>주튜브TV</b></span>
		    
		</div>
		<br />
		<br />
	</div>
<!-- 중단 채널 홍보 글  -->
<script>
		
	var tag = document.createElement('script');
	tag.src = "https://www.youtube.com/iframe_api";
	
	var firstScriptTag = document.getElementsByTagName('script')[0];
	firstScriptTag.parentNode.insertBefore(tag, firstScriptTag);
	
	var player;
	var done = false;

	function onYouTubeIframeAPIReady() {
		player = new YT.Player('player', { // 유튜브 인스턴스 호출 div id=player
	             height: '250',
	          	 width: '700',
	          	 videoId: "6I19wdqajEU",
	          	 events: { 'onReady': onPlayerReady,
	            		   'onStateChange': onPlayerStateChange
	          			 }
	    });
	}
	
	function onPlayerReady(event) {
		event.target.playVideo(); // 자동 플레이 크롬 x
	}
	
	function onPlayerStateChange(event) {
		if (event.data == YT.PlayerState.PLAYING && !done) {
			//  setTimeout(stopVideo, 6000); //  6초
			done = true; 
		}
	}
	
	function stopVideo() {
		player.stopVideo();
	}

</script>
	<br />
	<br />
</div>
	<jsp:include page="/common/pageInclude/mainDownPage.jsp" flush="false"/>
</body>
</html>