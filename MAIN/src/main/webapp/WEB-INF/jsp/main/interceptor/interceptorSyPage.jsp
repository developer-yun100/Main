<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c"         uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form"      uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring"    uri="http://www.springframework.org/tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>
	<jsp:include page="/common/include.jsp" flush="false"/>
<title>접속 금지</title>
</head>
<body>
	
	<div class="ui text container">
		<img style="width:550px; height:550px;" src="<c:url value='/images/egovframework/commonImage/urlinterceptor.png'/>" />
		<button class="ui pink button" onclick="location.href='../../index.jsp'" style="width:550px; height:100px;"><b>홈 화면으로 가기!!</b></button>
	</div>

	<div class="ui three column doubling grid">
		<div class="column"></div>
		<div class="column">
		</div>
		<div class="column"></div>
	</div>
	
</body>
</html>