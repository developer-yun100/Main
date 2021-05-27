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
  // fix menu when passed
  $('.masthead').visibility({
      once: false,
      onBottomPassed: function() {
    	  $('.fixed.menu').transition('fade in');
      },
      onBottomPassedReverse: function() {
        $('.fixed.menu').transition('fade out');
      }
    });

  // create sidebar and attach to menu open
  $('.ui.sidebar').sidebar('attach events', '.toc.item');

});

</script>
<title></title>
</head>
<body>
<!-- fade toolBar -->
	<div class="ui large top fixed hidden menu">
		<div class="ui container">
			<a class="active item" onclick="location.href='../index.jsp'">홈</a>
				<div class="right menu">
					<div class="item">
						<a class="ui button" onclick="">로그인</a>
					</div>
					<div class="item">
						<a class="ui primary button" onclick="">회원가입</a>
					</div>
				</div>
				<a class="item" onclick="">채널</a>
				<a class="item">채널 바로가기</a>
				<a class="item">계정 설정</a>
				<!-- <a class="item" onclick="logout();">로그아웃</a>
				&nbsp;&nbsp; <h3 style="margin-top: 10px;">로그인 계정 : </h3> -->
		</div>
	</div>
	<!-- fade toolBar -->
	
	<!-- 상단 메뉴와 타이틀 -->
	<div class="ui inverted vertical masthead center aligned segment">
	    <div class="ui container">
		    <div class="ui large secondary inverted pointing menu">
			    <a class="toc item">
			    	<i class="sidebar icon"></i>
			    </a>
			    <a class="active item" onclick="location.href='../index.jsp'">홈</a>
				<a class="item" onclick="">채널</a>
				<a class="item">가이드</a>
				<a class="item">문의</a>
				<div class="right item">
						    <a class="ui inverted button" onclick="">로그인</a>&nbsp;&nbsp;
						    <a class="ui inverted button" onclick="">회원가입</a>
						<!-- <h3 style="margin-top: 10px;">로그인 : </h3>
						&nbsp;&nbsp;&nbsp;&nbsp;<a class="ui inverted button" onclick="logout();">로그아웃</a> -->
			    </div>
		    </div>
	    </div>
	    <br />
	    <br />
		<img src="<c:url value=''/>" style="width:100px; height:120px"></img>
		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		<img src="<c:url value=''/>" style="width:820px; height:120px"></img>
	    <div class="ui text container">
		    <h1 class="ui inverted header">
		    </h1>
		    <h2></h2>
	    </div>
	</div>
	<br />
	<br />
    <!-- 상단 메뉴와 타이틀 -->
</body>
</html>