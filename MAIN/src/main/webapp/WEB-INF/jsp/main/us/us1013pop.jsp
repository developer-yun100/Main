<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c"         uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form"      uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring"    uri="http://www.springframework.org/tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>
	<jsp:include page="/common/include.jsp" flush="false"/>
	<!-- 웹소켓 통신  -->
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/sockjs-client/1.4.0/sockjs.js"></script>
<script type="text/javascript">
	
var websocket;
	
$(document).ready(function() {
	chatConnect();
});
	
	
function chatConnect(){
    // 소켓 객체 생성
    
    var url = "ws://" + location.host + "/chatting.yh";
    
    websocket = new WebSocket(url);
    websocket.onmessage = onMessage;
    
}

function send(){
	
	var nickName = $("#nickName").val();
	var sendText = $("#sendText").val();
	var userId = $("#userId").val();
	var proFileImg = $("#proFileImg").val();
	
	var msg = { nickName: nickName, sendText: sendText, userId: userId, proFileImg: proFileImg };
	
	websocket.send(JSON.stringify(msg)); // var -> json
    $("#sendText").val("");
    
}

function onMessage(result){
	var data = result.data;
	var jsonData = JSON.parse(data); // json -> var
	
	var nickName = jsonData.nickName;
	var proFileImg = jsonData.proFileImg;
	var sendText = jsonData.sendText;
	
	var reqUserId = jsonData.userId; // req
	var sessionUserId = $("#userId").val(); // session
	
	// $("#textArea").append('');
	
	var str = ' '; // 초기값 undefined 방지
	
	// 상대방
	if(reqUserId != sessionUserId){
		
		str += '<div class="ui grid">';
		str += '<div class="left floated six wide column">';
		str += '<div class="comment">';
		str += '<a class="avatar"> <img style="width:30px; height:30px;" src="'+proFileImg+'" /> </a>';
		str += '<div class="content">';
		str += '<a class="author">' + nickName + '</a>';
		str += '<div class="metadata">';
		str += '<span class="date">' + "" + '</span>';
		str += '</div>';
		str += '<div class="text">'+ sendText +'</div>';
		str += '</div>';
		str += '</div>';
		str += '</div>';
		str += '</div>';
		
		$("#textArea").append(str);
		
	} else { // 나
		
		str += '<div class="ui grid">';
		str += '<div class="right floated six wide column">';
		str += '<div class="comment">';
		str += '<div class="content">';
		str += '<a class="author">' + nickName+"(나)" + '</a>';
		str += '<div class="metadata">';
		str += '<span class="date">' + "" + '</span>';
		str += '</div>';
		str += '<div class="text">'+ sendText +'</div>';
		str += '</div>';
		str += '</div>';
		str += '</div>';
		str += '</div>';
		
		$("#textArea").append(str);
		
	}
}


</script>	
<title>채팅하기</title>
</head>
<body>
<input type="hidden" id="nickName" name="nickName" value="${sessionScope.S_USERINFO.nickName}" />
<input type="hidden" id="userId" name="userId" value="${sessionScope.S_USERINFO.userId}" />
<input type="hidden" id="proFileImg" name="proFileImg" value="${sessionScope.S_USERINFO.proFileImg}" />
	<div class="pusher">
		<div class="ui text container">
			<br />
			<div class="ui one column grid">
				<div class="column">
					<h3 class="ui header">
						채팅하기
					</h3>
				</div>
			</div>
			<div class="ui minimal comments" id="textArea" style="width:618px; height:600px; overflow-x:hidden;">
			</div>
			<!-- 아래 입력  -->
			<div class="two column row">
          		<div class="column">
          			<div class="ui input">
					  <input type="text" id="sendText" style="width:520px;" />
					  	&nbsp;&nbsp;
					  <button class="ui inverted orange button" onClick="send();">보내기</button>
					</div>
          		</div>
        	</div>
		</div>
	</div>
</body>
</html>